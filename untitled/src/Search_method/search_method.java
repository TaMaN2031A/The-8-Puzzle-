package Search_method;

import Search_method.node;

import java.util.ArrayList;

public interface search_method {

     int solve_puzzle(node nd);
      ArrayList<String> Path_to_goal();
     int get_no_of_expanded_nodes();
     int getMax_depth();
     void reset();
}
