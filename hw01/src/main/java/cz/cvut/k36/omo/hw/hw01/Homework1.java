/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw01;

/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class Homework1
{
    private int h_calls;
    static int i_calls = 0;
    
    public Homework1()
    {
        this.h_calls = 0;
    }
    
    public final boolean f()
    {
        return true;
    }
    
    static final boolean g()
    {
        return false;
    }
    
    public int h()
    {
        this.h_calls ++;
        return this.h_calls;
    }
    
    public int i()
    {
        Homework1.i_calls++;
        return Homework1.i_calls;
    }
    
    
}
