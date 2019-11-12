package cz.cvut.fel.omo.cv8;

public interface ListExpressionVisitor {
    void visitIntList(IntList v);

    void visitVarlist(VarList v);
    
    void visitUnique(Unique v);
    
    void visitRemove(Remove v);
    
    public void visitConcatenate(Concatenate v);
    // TODO: more visit methods
}
