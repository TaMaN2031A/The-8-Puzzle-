package Search_method;

import Search_method.AStar_node;

import java.util.Comparator;
public class AStar_node_Comparator implements Comparator<AStar_node> {
    @Override
    public int compare(AStar_node node1, AStar_node node2) {
        if (node1.getFn() instanceof Integer && node2.getFn() instanceof Integer) {
            int fn1 = node1.getFn().intValue();
            int fn2 = node2.getFn().intValue();
            return Integer.compare(fn1, fn2);
        } else if (node1.getFn() instanceof Double && node2.getFn() instanceof Double) {
            double fn1 = node1.getFn().doubleValue();
            double fn2 = node2.getFn().doubleValue();
            return Double.compare(fn1, fn2);
        } else {
            // Handle cases where fn1 and fn2 have different types
            throw new IllegalArgumentException("Incompatible types for fn");
        }
    }
}