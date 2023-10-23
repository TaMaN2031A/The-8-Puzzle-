package Search_method;

import java.util.*;

public class AStar {
    final private MovementAndPath explorer = new MovementAndPath();
    private HashSet<String> explored = new HashSet<>();
    private HashSet<String> InFrontier = new HashSet<>();
    private HashMap<String, String> parent = new HashMap();
    private int max_depth = 0;
    public int solve_puzzle(String initialState){
        reset();
        PriorityQueue<AStar_node>frontier = new PriorityQueue<>(new AStar_node_Comparator());
        frontier.add(new AStar_node(0,0,initialState,"Stop!"));
        this.parent.put(initialState,"Stop!");
        while(!frontier.isEmpty()){
            AStar_node curr_node = frontier.poll();
            String currentState = curr_node.getState();
            if(this.explored.contains(currentState))continue;
            this.InFrontier.remove(currentState);
            this.explored.add(currentState);
            this.parent.put(currentState,curr_node.getParent());
            max_depth=Math.max(max_depth,curr_node.getDepth());
            if(curr_node.getState().equals("012345678")){
                return 1;
            }
            ArrayList<String>neighbours=explorer.get_neighbours(curr_node.getState(),curr_node.getZero_position());
            for(int i=0;i<neighbours.size();i++){
                String st = neighbours.get(i);
                if(!this.explored.contains(st)&&!this.InFrontier.contains(st)){
                    frontier.add(new AStar_node(manhattan_distance(st)+curr_node.getDepth()+1, curr_node.getDepth()+1, st,curr_node.getState()));
                }
                else if(this.InFrontier.contains(st)){
                    frontier.add(new AStar_node(manhattan_distance(st)+curr_node.getDepth()+1, curr_node.getDepth()+1, st,curr_node.getState()));
                }
            }
        }
        return 0;
    }
    public int manhattan_distance(String state){
        int total_dist = 0;
        for(int i=0;i<state.length();i++){
            if(state.charAt(i)=='0')continue;
            int row=i/3,col=i%3;
            int no=Character.getNumericValue(state.charAt(i));
            int no_row=no/3,no_col=no%3;
            total_dist+=(Math.abs(row-no_row)+Math.abs(col-no_col));
        }
        return total_dist;
    }
    public ArrayList<String>Path_to_goal(){
        if(parent.containsKey("012345678")){
           return explorer.create_path(parent);
        }
        else {
            return new ArrayList<>();
        }
    }


    public int get_no_of_expanded_nodes() {
        return explored.size();
    }

    public int getMax_depth() {
        return max_depth;
    }
    private void reset(){
        parent.clear();
        explored.clear();
        InFrontier.clear();
    }
}
