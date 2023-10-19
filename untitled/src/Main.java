/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        CLI cli = new CLI();
        //  while (true){
        cli.take_input();
        //}
    }
}

class CLI {
    void take_input(){
        try{
            String in;
            Dfs dfs = new Dfs();
            int solved = 0;
            System.out.println("Hello, please insert the array from left to right\n" +
                    "from up to down in one line in this way: 1 2 3 4 0 8 6 5 7");
            Scanner scanner = new Scanner(System.in);
            in = scanner.nextLine();
            String[] values = in.split(" ");
            int[][] array2D = new int[3][3];
            int index = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int number = Integer.parseInt(values[index]);
                    if(number > 8 || number < 0){
                        System.out.println("Something wrong");
                        return;
                    }
                    array2D[i][j] = number;
                    index++;
                }
            }
            //* Now We'll take what method he wants
            System.out.println("How do you want to solve your problem? \n" +
                    "DFS: 1, BFS: 2, A*: 3");
            in = scanner.nextLine();
            int choice = Integer.parseInt(in);
            if(choice == 1){
                System.out.println("DFS Selected");
                String s = "";
                for(int i = 0; i < 3; i ++){
                    for(int j = 0; j < 3; j++){
                        s += (char)('0'+array2D[i][j]);
                    }
                }
                node init = new node(s,0);
                solved = (dfs.rec(init));
                if(solved==1)
                    System.out.println("Found!");
                else
                    System.out.println("Notfound!");
            }else if(choice == 2){
                System.out.println("BFS Selected");

            }else{
                System.out.println("DFS Selected");

            }
            //* Now we'll take whether he wants the nodes generated
            System.out.println("Do you want to know how many nodes where generated? \n"+
                    "Yes: 1, No: 0");
            in = scanner.nextLine();
            if(in.equals("1")){
                if(choice == 1){
                    System.out.println("There were total number of: " + dfs.explored.size()+  " generated.");
                }else if(choice == 2){

                }else{

                }
            }
            //* Now we'll ask him if he wants path and path cost
            if(solved == 1){
                System.out.println("Do you want to know the path of the search? \n"+
                        "Yes: 1, No: 0");
                in = scanner.nextLine();
                if(in.equals("1")){
                    if(choice == 1){
                        System.out.println("Path cost is: " + dfs.path.size()+  ".");
                        for(int i = dfs.path.size()-1; i > -1; i--){
                            System.out.print(dfs.path.get(i) + " ");
                        }
                        System.out.println();
                    }else if(choice == 2){
                    }else{

                    }
                }

            }

            //* Now we'll ask him if he wants the max depth of the search
            System.out.println("Do you want to know the max depth of the search? \n"+
                    "Yes: 1, No: 0");
            in = scanner.nextLine();
            if(in.equals("1")){
                if(choice == 1){
                    System.out.println("Max depth is: " + dfs.max_depth+  ".");
                }else if(choice == 2){

                }else{

                }
            }
        }catch(Exception e){
            System.out.println("Something wrong");
        }



    }
}
class node{
    public int depth;
    public int blank_location;
    public String hashed_state;
    public node(String state, int depth){
        this.depth = depth;
        hashed_state = state;
        for(int i = 0; i < 9; i++) {
            if(state.charAt(i) == '0')
                blank_location = i;
        }
    }

}
class Dfs{
    public ArrayList<node> generated_nodes = new ArrayList<node>(); // I feel that explored could replace it
    public ArrayList<String> path = new ArrayList<String>();
    HashSet<String> explored = new HashSet<String>();
    HashSet<String> frontierNoReptition = new HashSet<String>();
    HashMap<String, String> parent = new HashMap<String, String>();
    public int max_depth;
    private String move_left(String st){
        String s = "";
        for(int i = 0; i < 9; i++){
            if(i != 8){
                if(st.charAt(i+1) == '0'){
                    s+='0';
                    s+=st.charAt(i);
                    i++;
                }else
                    s+=st.charAt(i);
            }else
                s+=st.charAt(i);
        }
        return s;
    }
    private String move_right(String st){
        String s = "";
        for(int i = 0; i < 9; i++){
            if(st.charAt(i) == '0'){
                s+=st.charAt(i+1);
                s+=st.charAt(i);
                i++;
            }else
                s+=st.charAt(i);
        }
        return s;
    }
    private String move_up(String st){
        String s = "";
        for(int i = 0; i < 9; i++){
            if(i < 6){
                if(st.charAt(i+3) == '0'){
                    s+='0';
                    s+=st.charAt(i+1);
                    s+=st.charAt(i+2);
                    s+=st.charAt(i);
                    i+=3;
                } else
                    s+=st.charAt(i);
            }
            else
                s+=st.charAt(i);
        }
        return s;
    }
    private String move_down(String st){
        String s = "";
        for(int i = 0; i < 9; i++){
            if(i < 6){
                if(st.charAt(i) == '0'){
                    s+=st.charAt(i+3);
                    s+=st.charAt(i+1);
                    s+=st.charAt(i+2);
                    s+='0';
                    i+=3;
                } else
                    s+=st.charAt(i);
            }
            else
                s+=st.charAt(i);
        }
        return s;
    }
    private void create_path(String goal){
        while(!parent.get(goal).equals("Stop!")){
            path.add(goal);
            goal = parent.get(goal);
        }
        path.add(goal);
    }
    int rec(node nd){
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
                create_path(cur.hashed_state);
                return 1;
            }
            //* Move Left
            if(cur.blank_location%3 != 0){
                String new_state = move_left(cur.hashed_state);
                if(!explored.contains(new_state) && !frontierNoReptition.contains(new_state))
                {
                    node new_node = new node(new_state, cur.depth+1);
                    frontier.push(new_node);
                    frontierNoReptition.add(new_node.hashed_state);
                    parent.put(new_node.hashed_state, cur.hashed_state);
                    // If use generated_nodes use here
                }
            }
            //* Move right
            if((cur.blank_location+1)%3 != 0){
                String new_state = move_right(cur.hashed_state);
                if(!explored.contains(new_state) && !frontierNoReptition.contains(new_state))
                {
                    node new_node = new node(new_state, cur.depth+1);
                    frontier.push(new_node);
                    frontierNoReptition.add(new_node.hashed_state);
                    parent.put(new_node.hashed_state, cur.hashed_state);
                    // If use generated_nodes use here
                }
            }
            //* Move up
            if(cur.blank_location > 2){
                String new_state = move_up(cur.hashed_state);
                if(!explored.contains(new_state) && !frontierNoReptition.contains(new_state))
                {
                    node new_node = new node(new_state, cur.depth+1);
                    frontier.push(new_node);
                    frontierNoReptition.add(new_node.hashed_state);
                    parent.put(new_node.hashed_state, cur.hashed_state);
                    // If use generated_nodes use here
                }
            }
            //* Move down
            if(cur.blank_location < 6){
                String new_state = move_down(cur.hashed_state);
                if(!explored.contains(new_state) && !frontierNoReptition.contains(new_state))
                {
                    node new_node = new node(new_state, cur.depth+1);
                    frontier.push(new_node);
                    frontierNoReptition.add(new_node.hashed_state);
                    parent.put(new_node.hashed_state, cur.hashed_state);
                    // If use generated_nodes use here
                }
            }
        }
        return 0;
    }

}