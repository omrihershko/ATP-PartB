package algorithms.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    private ArrayList<AState> path;

    public Solution() {
        this.path = new ArrayList<>();  // Initialize the path list
    }
    public void add_State(AState part_solution){
        if(part_solution==null)return;
        path.add(part_solution);
    }


    public ArrayList<AState> getPath() {
        return new ArrayList<>(path);  // Return a copy of the path to avoid external modifications
    }


}
