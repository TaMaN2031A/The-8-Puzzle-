package Search_method;

public class AStar_node {
    private String state;

    private int zero_position;
    private Number fn;

    private String parent;

    public String getParent() {
        return parent;
    }

    private int depth;
    public AStar_node(Number fn, int depth, String state,String parent){
        this.depth = depth;
        this.fn = fn;
        this.state = state;
        this.parent = parent;
        for(int i = 0; i < 9; ++i) {
            if (state.charAt(i) == '0') {
                this.zero_position = i;
            }
        }
    }
    public String getState() {
        return state;
    }

    public int getDepth() {
        return depth;
    }

    public int getZero_position() {
        return zero_position;
    }

    public Number getFn() {
        return fn;
    }}
