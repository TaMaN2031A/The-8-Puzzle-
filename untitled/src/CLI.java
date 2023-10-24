import Search_method.AStar;
import Search_method.Bfs;
import Search_method.Dfs;
import Search_method.node;

import java.util.ArrayList;
import java.util.Scanner;

public class CLI {
    void take_input(){
        try{
            EightPuzzleGUI eightPuzzleGUI=new EightPuzzleGUI();
            String in;
            Dfs dfs = new Dfs();
            AStar astar = new AStar();
            Bfs bfs = new Bfs();

            int solved = 0;
            System.out.println("Hello, please insert the array from left to right\n" +
                    "from up to down in one line in this way: 1 2 3 4 0 8 6 5 7");
            Scanner scanner = new Scanner(System.in);
            in = scanner.nextLine();
            String[] values = in.split(" ");
            while(values.length!=9){
                System.out.println("wrong input try again:");
               in = scanner.nextLine();
               values = in.split(" ");

            }

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
            if(choice!=1&&choice!=2&&choice!=3) {
                while (true) {
                    System.out.println("Enter a valid choice\n");
                    in = scanner.nextLine();
                    choice = Integer.parseInt(in);
                    if (choice == 1 || choice == 2 || choice == 3) {
                        break;
                    }
                }
            }
            if(choice == 1){
                System.out.println("DFS Selected");
                String s = "";
                for(int i = 0; i < 3; i ++){
                    for(int j = 0; j < 3; j++){
                        s += (char)('0'+array2D[i][j]);
                    }
                }
                node init = new node(s,0);
                long start = System.nanoTime();
                solved = (dfs.solve_puzzle(init));
                long end = System.nanoTime();
                System.out.println(end-start);
                if(solved==1)
                    System.out.println("Found!");
                else
                    System.out.println("Notfound!");
            }
            else if(choice == 2){
                System.out.println("BFS Selected");
                String s = "";
                for(int i = 0; i < 3; i ++){
                    for(int j = 0; j < 3; j++){
                        s += (char)('0'+array2D[i][j]);
                    }
                }
                node init = new node(s,0);
                long start = System.nanoTime();
                solved = (bfs.solve_puzzle(init));
                long end = System.nanoTime();
                System.out.println(end-start);
                if(solved==1)
                    System.out.println("Found!");
                else
                    System.out.println("Not Found!");

            }else{
                System.out.println("A* Selected");
                System.out.println("Choose Heuristic:\n 1.Manhattan distance\t2.Euclidean distance");

                int heuristic=Integer.parseInt(scanner.nextLine());
                String s = "";
                for(int i = 0; i < 3; i ++){
                    for(int j = 0; j < 3; j++){
                        s += (char)('0'+array2D[i][j]);
                    }
                }

                long start = System.nanoTime();
                solved = astar.solve_puzzle(s,heuristic);
                long end = System.nanoTime();
                System.out.println(end-start);
                if(solved==1)
                    System.out.println("Found!");
                else
                    System.out.println("NotFound");
            }
            //* Now we'll take whether he wants the nodes generated
            System.out.println("Do you want to know how many nodes where generated? \n"+
                    "Yes: 1, No: 0");
            in = scanner.nextLine();
            if(in.equals("1")){
                if(choice == 1){
                    System.out.println("There were total number of: " + dfs.get_no_of_expanded_nodes()+  " generated.");
                }else if(choice == 2){
                    System.out.println("There were total number of: " + bfs.get_no_of_expanded_nodes()+  " generated.");

                }else{
                    System.out.println("There were total number of: " + astar.get_no_of_expanded_nodes()+  " generated.");
                }
            }
            //* Now we'll ask him if he wants path and path cost
            if(solved == 1){
                System.out.println("Do you want to know the path of the search? \n"+
                        "Yes: 1, No: 0");
                in = scanner.nextLine();
                if(in.equals("1")){
                    if(choice == 1){
                        ArrayList<String>path=dfs.Path_to_goal();
                        System.out.println("Path cost is: " + (path.size()-1)+  ".");

                        System.out.println(path);
                       eightPuzzleGUI.showPath(path);

                    }else if(choice == 2){
                        ArrayList<String>path=bfs.Path_to_goal();
                        System.out.println("Path cost is: " + (path.size()-1)+  ".");
                        System.out.println(path);
                        eightPuzzleGUI.showPath(path);
                    }
                    else{
                        ArrayList<String>path=astar.Path_to_goal();
                        System.out.println("Path cost is: " + (path.size()-1)+  ".");
                        System.out.println(path);
                        eightPuzzleGUI.showPath(path);
                    }
                }
            }

            //* Now we'll ask him if he wants the max depth of the search
            System.out.println("Do you want to know the max depth of the search? \n"+
                    "Yes: 1, No: 0");
            in = scanner.nextLine();
            if(in.equals("1")){
                if(choice == 1){
                    System.out.println("Max depth is: " + dfs.getMax_depth()+  ".");
                }else if(choice == 2){
                    System.out.println("Max depth is: " + bfs.getMax_depth()+  ".");

                }else{
                    System.out.println("Max depth is: " + astar.getMax_depth()+  ".");
                }
            }
            eightPuzzleGUI.setVisible(false);


        }catch(Exception e){
            System.out.println("Something wrong");
        }

    }
}
