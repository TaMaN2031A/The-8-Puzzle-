package Unit_test;

import Search_method.AStar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AStarTest_eucledian {

    AStar astar=new AStar();
    @Test
    public void test_1_easy() throws IOException, InterruptedException {
         Assertions.assertEquals(astar.solve_puzzle("012345678",2),1);
        Assertions.assertEquals(astar.getMax_depth(),0);
    }
    @Test

    public void test_2_medium() throws IOException, InterruptedException {
         Assertions.assertEquals(astar.solve_puzzle("123408657",2),1);
    }
    @Test
    public void test_3_hard() throws IOException, InterruptedException {

        Assertions.assertEquals(astar.solve_puzzle("123456780",2),1);
    }
    @Test
    public void test_5_hard() throws IOException, InterruptedException {
         Assertions.assertEquals(astar.solve_puzzle("567812340",2),1);
    }
    @Test
    public void test_6_unsolvable() throws IOException, InterruptedException {
         Assertions.assertEquals(astar.solve_puzzle("213456780",2),0);
        Assertions.assertEquals(astar.get_no_of_expanded_nodes(),181440);
    }
    @Test
    public void test_7_unsolvable() throws IOException, InterruptedException {
        Assertions.assertEquals(astar.solve_puzzle("123456870",2),0);
        Assertions.assertEquals(astar.get_no_of_expanded_nodes(),181440);
    }
}