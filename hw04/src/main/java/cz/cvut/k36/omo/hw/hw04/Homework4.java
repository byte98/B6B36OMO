package cz.cvut.k36.omo.hw.hw04;

import java.util.ArrayList;
import java.util.List;

public class Homework4 extends MessageVisitor {
    public Homework4(Peer peer) {
        super(peer);
    }
    // zde doplnte svuj kod

    @Override
        public boolean visitHaveMessage(HaveMessage message) {
    this.peer.peers2BlocksMap.get(message.getSender())[message.blockIndex] = true;
            return false;
        }

    @Override
    public boolean visitRequestMessage(RequestMessage message) {
        if (this.peer.data[message.getBlockIndex()] != null) {
            message.getSender().piece(this.peer, message.getBlockIndex(), this.peer.data[message.getBlockIndex()]);
        }
        return false;
    }

    @Override
    public boolean visitPieceMessage(PieceMessage message)
    {
        boolean reti = false;
        this.peer.downloadedBlocksCount++;
        
        //Checks, if all blocks were downloaded
        if (this.peer.downloadedBlocksCount == this.peer.totalBlocksCount)
        {
            reti = true;
        }
        this.peer.data[message.getBlockIndex()] = message.getData();           
        
        //Inform all peers about my availability of block
        for (PeerInterface pI : this.peer.peers2BlocksMap.keySet())
        {
            pI.have(this.peer, message.getBlockIndex());
        }
        return reti;
    }

    @Override
    public boolean visitIdleMessage(IdleMessage message)
    {
        boolean reti = false;
        
        //Initialise array of lists
        List<PeerInterface>[] blocks_availability;
        blocks_availability = new ArrayList[this.peer.totalBlocksCount];
        for (int i = 0; i < this.peer.totalBlocksCount; i++)
        {
            blocks_availability[i] = new ArrayList<>();
        }
        
        //Load available blocks
        for (PeerInterface pI : this.peer.peers2BlocksMap.keySet())
        {
            for (int i = 0; i < this.peer.totalBlocksCount; i++)
            {
                if (this.peer.peers2BlocksMap.get(pI).length > i && this.peer.peers2BlocksMap.get(pI)[i] == true)
                {
                    blocks_availability[i].add(pI);
                }
            }
        }
        
        //Select minimum
        int min_available = Integer.MAX_VALUE;
        int min_block  = Integer.MAX_VALUE;
        PeerInterface min_iface = null;
        for (int i = 0; i < blocks_availability.length; i++)
        {
            if (
                 this.peer.data[i].length == 0 &&                   //It is not downloaded yet
                 blocks_availability[i].size() < min_available &&   //Its more "unique"
                 blocks_availability[i].size() > 0                  //At least one peer has that block   
               )
            {
                min_iface = blocks_availability[i].get(0);      //Gets interface with most unique available block
                min_available = blocks_availability[i].size();  //Counts interfaces with most unique available block
                min_block = i;                                  //Sets most unique block index
            }
        }
        
        //Request block
        if (min_iface != null)
        {
            min_iface.request(this.peer, min_block);
        }
        
        return reti;
        
    }
}