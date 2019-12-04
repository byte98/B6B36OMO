package cz.cvut.k36.omo.hw.hw04;

import java.util.ArrayList;
import java.util.List;

public class Homework4 extends MessageVisitor {
    public Homework4(Peer peer) {
        super(peer);
    }
    // zde doplnte svuj kod

    @Override
    public boolean visitHaveMessage(HaveMessage message)
    {
        boolean reti = false;
        
        //Create new array, where will be marked availability of block
        
        //Setting appropriate size of new array
        int msg_idx = message.getBlockIndex();
        int new_map_len = msg_idx + 2;
        boolean[] actual_map = this.peer.peers2BlocksMap.get(message.getSender());
        boolean[] new_map = new boolean[new_map_len];
        //Set availability of each block
        for (int idx = 0; idx < new_map.length; idx++)
        {
            if (idx < actual_map.length)            //Block availability has been marked in previous array
            {
                new_map[idx] = actual_map[idx];
            }
            if (idx == message.getBlockIndex())     //Actual block which is available
            {
                new_map[idx] = true;
            }
            else
            {
                new_map[idx] = false;               //Default for any other block
            }
        }        
        //Replace availability in map
        this.peer.peers2BlocksMap.remove(message.getSender());
        this.peer.peers2BlocksMap.put(message.getSender(), new_map);
        return reti;
    }

    @Override
    public boolean visitRequestMessage(RequestMessage message)
    {
        boolean reti = false;
        
        //Checks, if i have requested block
        boolean[] map = this.peer.peers2BlocksMap.get(message.getSender());
        if (map.length > message.getBlockIndex() && map[message.getBlockIndex()] == true)
        {
            //If i have requested block, send it to sender of request
            message.getSender().piece(this.peer, message.getBlockIndex(), this.peer.data[message.getBlockIndex()]);
        } 
        return reti;
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