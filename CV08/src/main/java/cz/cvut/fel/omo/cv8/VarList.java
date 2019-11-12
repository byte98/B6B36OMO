package cz.cvut.fel.omo.cv8;

import com.google.common.collect.ImmutableList;

public class VarList implements ListExpression {
    protected final String name;

    public VarList(String name)
    {
        this.name = name;
    }

    @Override
    public ImmutableList<Integer> evaluate(Context c)
    {
        return c.get(this.name);
    }

    @Override
    public void accept(ListExpressionVisitor v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
