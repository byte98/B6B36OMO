package cz.cvut.fel.omo.cv8;

import com.google.common.collect.ImmutableList;
import java.util.HashSet;

public class Unique implements ListExpression{
    protected final ListExpression sub;

    public Unique(ListExpression sub) {
        this.sub = sub;
    }

    @Override
    public ImmutableList<Integer> evaluate(Context c)
    {
       HashSet set = new HashSet(sub.evaluate(c));
       return ImmutableList.copyOf(set);
    }

    @Override
    public void accept(ListExpressionVisitor v)
    {
        v.visitUnique(this);
    }
    
}