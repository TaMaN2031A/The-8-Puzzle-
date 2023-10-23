package Unit_test;
import Search_method.AStar;
import Search_method.Bfs;
import Search_method.node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Astar_vs_BfsTest {
    Bfs bfs=new Bfs();
    AStar Astar=new AStar();
    @Test
    public void test_1_easy() throws IOException, InterruptedException {
        node init_state=new node("012345678",0);
        bfs.solve_puzzle(init_state);
        Astar.solve_puzzle("012345678");
        Assertions.assertEquals(bfs.Path_to_goal().size(),Astar.Path_to_goal().size());
    }
    @Test

    public void test_2_medium() throws IOException, InterruptedException {
        node init_state=new node("123408657",0);
        bfs.solve_puzzle(init_state);
        Astar.solve_puzzle("123408657");
        Assertions.assertEquals(bfs.Path_to_goal().size(),Astar.Path_to_goal().size());
    }
    @Test
    public void test_3_hard() throws IOException, InterruptedException {
        node init_state=new node("123456780",0);
        bfs.solve_puzzle(init_state);
        Astar.solve_puzzle("123456780");
        Assertions.assertEquals(bfs.Path_to_goal().size(),Astar.Path_to_goal().size());
    }
    @Test
    public void test_5_hard() throws IOException, InterruptedException {
        node init_state=new node("567812340",0);
        bfs.solve_puzzle(init_state);
        Astar.solve_puzzle("567812340");
        Assertions.assertEquals(bfs.Path_to_goal().size(),Astar.Path_to_goal().size());
    }
    @Test
    public void test_6_hard() throws IOException, InterruptedException {
        node init_state=new node("123456078",0);
        bfs.solve_puzzle(init_state);
        Astar.solve_puzzle("123456078");
        Assertions.assertEquals(bfs.Path_to_goal().size(),Astar.Path_to_goal().size());
    }
    @Test
    public void test_7_hard() throws IOException, InterruptedException {
        node init_state=new node("124356078",0);
        bfs.solve_puzzle(init_state);
        Astar.solve_puzzle("124356078");
        Assertions.assertEquals(bfs.Path_to_goal().size(),Astar.Path_to_goal().size());
    }


}
