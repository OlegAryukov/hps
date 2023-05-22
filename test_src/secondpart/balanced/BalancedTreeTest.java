package secondpart.balanced;

import algosecon.balanced.BalancedBST;
import org.junit.Assert;
import org.junit.Test;

public class BalancedTreeTest {

    @Test
    public void makeTreeTest(){
        int[] source = new int[]{1, 3, 6, 9, 2, 4, 5, 7, 15, 13, 14, 12, 10, 11, 8};
        BalancedBST tree = new BalancedBST();
        tree.GenerateTree(source);
        Assert.assertTrue(tree.IsBalanced(tree.Root));
    }
}
