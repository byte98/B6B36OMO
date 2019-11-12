package cz.cvut.fel.omo.cv8;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public class Concatenate implements ListExpression{
    protected final ListExpression left;
    protected final ListExpression right;

    public Concatenate(ListExpression left, ListExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public ImmutableList<Integer> evaluate(Context c)
    {
        List<Integer> reti = new ArrayList<>();
        this.left.evaluate(c).forEach((item)
        -> {
            reti.add(item);
        });        
        this.right.evaluate(c).forEach((item)
        -> {
            reti.add(item);
        });
        return ImmutableList.copyOf(reti);
    }

    @Override
    public void accept(ListExpressionVisitor v)
    {
        v.visitConcatenate(this);
    }

}
