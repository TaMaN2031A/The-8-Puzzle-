public class node{
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
