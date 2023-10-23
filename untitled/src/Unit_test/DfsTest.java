package Unit_test;

import Search_method.Dfs;
import Search_method.node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DfsTest {
    Dfs dfs=new Dfs();

    @Test
    public void test_1_easy() throws IOException, InterruptedException {
        node init_state=new node("012345678",0);
        Assertions.assertEquals(dfs.solve_puzzle(init_state),1);
        Assertions.assertEquals(dfs.getMax_depth(),0);
    }
    @Test

    public void test_2_medium() throws IOException, InterruptedException {
        node init_state=new node("123408657",0);
        Assertions.assertEquals(dfs.solve_puzzle(init_state),1);
    }
    @Test
    public void test_3_hard() throws IOException, InterruptedException {

        node init_state=new node("123456780",0);
        Assertions.assertEquals(dfs.solve_puzzle(init_state),1);
    }
    @Test
    public void test_5_hard() throws IOException, InterruptedException {
        node init_state=new node("567812340",0);
        Assertions.assertEquals(dfs.solve_puzzle(init_state),1);
    }
    @Test
    public void test_6_unsolvable() throws IOException, InterruptedException {
        node init_state=new node("213456780",0);
        Assertions.assertEquals(dfs.solve_puzzle(init_state),0);
        Assertions.assertEquals(dfs.get_no_of_expanded_nodes(),181440);
    }
    @Test
    public void test_7_unsolvable() throws IOException, InterruptedException {

        node init_state=new node("123456870",0);
        Assertions.assertEquals(dfs.solve_puzzle(init_state),0);
        Assertions.assertEquals(dfs.get_no_of_expanded_nodes(),181440);
    }

}