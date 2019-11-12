package cz.cvut.fel.omo.cv8;

public class SimplifyListExpressionVisitor implements ListExpressionVisitor {

    private ListExpression value;

    public ListExpression getValue() {
        return value;
    }

    @Override
    public void visitIntList(IntList v) {
        value = v;
    }

    @Override
    public void visitVarlist(VarList v)
    {
        
    }

    @Override
    public void visitUnique(Unique v)
    {
        v.sub.accept(this);
        ListExpression simplified = new Unique(getValue());
        if (getValue() instanceof IntList)
        {
            value = IntList.of(simplified.evaluate(null));
        }
        else
        {
            value = simplified;
        }
    }

    @Override
    public void visitRemove(Remove v)
    {
        v.sub.accept(this);
        ListExpression simplified = new Remove(getValue(), v.element);
        if (getValue() instanceof IntList)
        {
            value = IntList.of(simplified.evaluate(null));
        }
        else
        {
            value = simplified;
        }
    }

    @Override
    public void visitConcatenate(Concatenate v)
    {
        v.left.accept(this);
        v.right.accept(this);
        ListExpression simplified = new Concatenate(v.left, v.right);
        if (getValue() instanceof IntList)
        {
            value = IntList.of(simplified.evaluate(null));
        }
        else
        {
            value = simplified;
        }
    }
    
}
