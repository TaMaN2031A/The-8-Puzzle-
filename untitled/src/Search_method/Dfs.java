package Search_method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Dfs implements search_method {
    MovementAndPath explorer = new MovementAndPath();
    private HashSet<String> explored = new HashSet<String>();
    private HashSet<String> frontierNoReptition = new HashSet<String>();
    private HashMap<String, String> parent = new HashMap<String, String>();
    private int max_depth;


     public int solve_puzzle(node nd){
        reset();
        Stack<node> frontier = new Stack<node>();
        frontier.push(nd);
        frontierNoReptition.add(nd.hashed_state);
        parent.put(nd.hashed_state, "Stop!");
        while(!frontier.isEmpty()){
            node cur = frontier.pop();
            explored.add(cur.hashed_state);
            frontierNoReptition.remove(cur.hashed_state);
            max_depth = Math.max(max_depth, cur.depth);
            if(cur.hashed_state.equals("012345678")){
                //* Form the path here
                explorer.create_path(parent);
                return 1;
            }
            ArrayList<String>neighbors = explorer.get_neighbours(cur.hashed_state,cur.blank_location);
            for(int i=0;i<neighbors.size();i++){
                String new_state=neighbors.get(i);
                if(!explored.contains(new_state) && !frontierNoReptition.contains(new_state))
                {
                    node new_node = new node(new_state, cur.depth+1);
                    frontier.push(new_node);
                    frontierNoReptition.add(new_node.hashed_state);
                    parent.put(new_node.hashed_state, cur.hashed_state);
                }
            }
        }
        return 0;
    }
    public ArrayList<String>Path_to_goal(){
            if (parent.containsKey("012345678")) {
                return explorer.create_path(parent);
            } else {
                return new ArrayList<>();
            }


    }
    public int get_no_of_expanded_nodes() {
        return explored.size();
    }


    public int getMax_depth() {
        return max_depth;
    }
    public void reset(){
        parent.clear();
        explored.clear();
        frontierNoReptition.clear();
    }
}
