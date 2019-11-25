package cz.cvut.k36.omo.hw.hw04;

public class Homework4 extends MessageVisitor {
    public Homework4(Peer peer) {
        super(peer);
    }
 
    // zde doplnte svuj kod

    @Override
    public boolean visitHaveMessage(HaveMessage message)
    {
        boolean reti = false;
        message.getSender().have(peer, message.getBlockIndex());
        return reti;
    }

    @Override
    public boolean visitRequestMessage(RequestMessage message)
    {
        boolean reti = false;
        Peer p = (Peer)message.getSender();
        
        if (p.messageQueue.contains(message))
        {
            
        }
        return reti;
    }

    @Override
    public boolean visitPieceMessage(PieceMessage message)
    {
        boolean reti = false;
        
        return reti;
    }

    @Override
    public boolean visitIdleMessage(IdleMessage message)
    {
        boolean reti = false;
        
        return reti;
        
    }
}