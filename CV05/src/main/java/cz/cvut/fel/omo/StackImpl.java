package cz.cvut.fel.omo;

import java.util.EmptyStackException;
import java.util.List;

public class StackImpl implements Stack {

    private static int STACK_SIZE = 1000;
    private int [] content = new int [STACK_SIZE];
    private int size = 0;

    public void push(int toInsert){
        if (size < STACK_SIZE)
            content[size++] = toInsert;
    }

    public int pop(){
        if (size > 0)
            return content[--size];
        else
            throw new EmptyStackException();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }
}
