package cz.cvut.fel.omo.cv8;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Remove implements ListExpression {
    protected final ListExpression sub;
    protected int element;

    public Remove(ListExpression sub, int element) {
        this.sub = sub;
        this.element = element;
    }

    @Override
    public ImmutableList<Integer> evaluate(Context c)
    {
        List<Integer> reti = new ArrayList<>(sub.evaluate(c));
        reti.removeAll(Collections.singleton(this.element));
        return ImmutableList.copyOf(reti);
    }

    @Override
    public void accept(ListExpressionVisitor v)
    {
        v.visitRemove(this);
    }

}
