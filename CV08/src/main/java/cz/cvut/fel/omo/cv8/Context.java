package cz.cvut.fel.omo.cv8;

import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;

public class Context {
    
    // TODO: implement put and get methods for storing/retrieving variables
    private Map<String, ImmutableList<Integer>> data;
    
    public Context()
    {
        this.data = new HashMap<>();
    }
    
    public ImmutableList<Integer> get(String name)
    {
        return this.data.get(name);
    }
    
    public void put(String name, ImmutableList<Integer> data)
    {
        this.data.put(name, data);
    }
}
