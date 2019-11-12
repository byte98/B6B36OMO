package cz.cvut.fel.omo.cv8;

public class PrintListExpressionVisitor implements ListExpressionVisitor {

    @Override
    public void visitIntList(IntList v) {
        System.out.print(v.list);
    }

    @Override
    public void visitVarlist(VarList v) {
        
    }
    
    @Override
    public void visitRemove(Remove v)
    {
        System.out.print("R(" + v.element + ",");        
        v.sub.accept(this);
        System.out.print(")");
    }
    
    @Override
    public void visitUnique(Unique v)
    {
        System.out.print("U(");
        v.sub.accept(this);
        System.out.print(")");
    }
    
    @Override
    public void visitConcatenate(Concatenate v)
    {
        System.out.print("C(");
        v.left.accept(this);
        v.right.accept(this);
        System.out.print(")");
        
    }
}