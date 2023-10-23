package Search_method;

import Search_method.AStar_node;

import java.util.Comparator;
public class AStar_node_Comparator implements Comparator<AStar_node> {
    @Override
    public int compare(AStar_node pair1, AStar_node pair2) {
        return Integer.compare(pair1.getFn(), pair2.getFn());
    }
}
