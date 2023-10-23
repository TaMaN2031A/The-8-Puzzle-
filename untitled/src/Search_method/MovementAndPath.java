package Search_method;

import java.util.ArrayList;
import java.util.HashMap;
//i want to call the class explorer
public class MovementAndPath {
    public ArrayList<String>get_neighbours(String st,int blank_position){
        ArrayList<String>states = new ArrayList<>();
        if(blank_position<6){
            states.add(move_zero_down(st));
        }
        if(blank_position>2){
            states.add(move_zero_up(st));
        }
        if(blank_position%3!=2){
            states.add(move_zero_right(st));
        }
        if(blank_position%3!=0){
            states.add(move_zero_left(st));
        }
        return states;
    }
    public String move_zero_left(String st) {
        String s = "";

        for(int i = 0; i < 9; ++i) {
            if (i != 8) {
                if (st.charAt(i + 1) == '0') {
                    s = s + "0";
                    s = s + st.charAt(i);
                    ++i;
                } else {
                    s = s + st.charAt(i);
                }
            } else {
                s = s + st.charAt(i);
            }
        }

        return s;
    }

    public String move_zero_right(String st) {
        String s = "";

        for(int i = 0; i < 9; ++i) {
            if (st.charAt(i) == '0') {
                s = s + st.charAt(i + 1);
                s = s + st.charAt(i);
                ++i;
            } else {
                s = s + st.charAt(i);
            }
        }

        return s;
    }

    public String move_zero_up(String st) {
        String s = "";

        for(int i = 0; i < 9; ++i) {
            if (i < 6) {
                if (st.charAt(i + 3) == '0') {
                    s = s + "0";
                    s = s + st.charAt(i + 1);
                    s = s + st.charAt(i + 2);
                    s = s + st.charAt(i);
                    i += 3;
                } else {
                    s = s + st.charAt(i);
                }
            } else {
                s = s + st.charAt(i);
            }
        }

        return s;

    }

    public String move_zero_down(String st) {
        String s = "";

        for(int i = 0; i < 9; ++i) {
            if (i < 6) {
                if (st.charAt(i) == '0') {
                    s = s + st.charAt(i + 3);
                    s = s + st.charAt(i + 1);
                    s = s + st.charAt(i + 2);
                    s = s + "0";
                    i += 3;
                } else {
                    s = s + st.charAt(i);
                }
            } else {
                s = s + st.charAt(i);
            }
        }
        return s;
//        int index_of_zero= st.indexOf('0');
//        st=st.replace('0','-');
//        char k = st.charAt(index_of_zero+3);
//        st=st.replace(st.charAt(index_of_zero+3),'0');
//        st=st.replace('-',k);
//        return st;

    }
    public ArrayList<String>create_path( HashMap<String, String> parent  ) {
        String goal = "012345678";
        ArrayList<String> path = new ArrayList();
        while(!((String)parent.get(goal)).equals("Stop!")) {
            path.add(goal);
            goal = (String)parent.get(goal);
        }
        path.add(goal);
        for(int i=0;i<path.size()/2;i++){
            String temp=path.get(i);
            path.set(i,path.get(path.size()-1-i));
            path.set(path.size()-i-1,temp);
        }
        return path;
    }


}
