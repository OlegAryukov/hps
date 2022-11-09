package secondpart;


import algosecon.bst.BST;
import algosecon.bst.BSTNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class BSTTreeTest {

    @Test
    public void findAllNodeByValues(){
       BST<Integer> testTree = new BST<>(new BSTNode<>(8, 8,null));
        testTree.AddKeyValue(4,4);
        testTree.AddKeyValue(2,2);
        testTree.AddKeyValue(3, 3);
        testTree.AddKeyValue(1, 1);
        testTree.AddKeyValue(6, 6);
        testTree.AddKeyValue(7, 7);
        testTree.AddKeyValue(5, 5);
        testTree.AddKeyValue(12, 12);
        testTree.AddKeyValue(10, 10);
        testTree.AddKeyValue(14, 14);
        testTree.AddKeyValue(9, 9);
        testTree.AddKeyValue(11, 11);
        testTree.AddKeyValue(13, 13);
        testTree.AddKeyValue(15, 15);

        Assert.assertEquals(4, testTree.FindNodeByKey(4).Node.NodeKey);
        Assert.assertEquals(Optional.of(4), Optional.ofNullable(testTree.FindNodeByKey(4).Node.NodeValue));
        Assert.assertEquals(Optional.of(8), Optional.ofNullable(testTree.FindNodeByKey(4).Node.Parent.NodeValue));
        Assert.assertEquals(Optional.of(2), Optional.ofNullable(testTree.FindNodeByKey(1).Node.Parent.NodeValue));
    }

    @Test
    public void findAllMinMax(){
        BST<Integer> testTree = new BST<>(new BSTNode<>(8, 8,null));
        testTree.AddKeyValue(4,4);
        testTree.AddKeyValue(2,2);
        testTree.AddKeyValue(3, 3);
        testTree.AddKeyValue(1, 1);
        testTree.AddKeyValue(6, 6);
        testTree.AddKeyValue(7, 7);
        testTree.AddKeyValue(5, 5);
        testTree.AddKeyValue(12, 12);
        testTree.AddKeyValue(10, 10);
        testTree.AddKeyValue(14, 14);
        testTree.AddKeyValue(9, 9);
        testTree.AddKeyValue(11, 11);
        testTree.AddKeyValue(13, 13);
        testTree.AddKeyValue(15, 15);

        Assert.assertEquals(Optional.of(15).get(), testTree.FinMinMax(testTree.FindNodeByKey(8).Node, true).NodeValue);
        Assert.assertEquals(Optional.of(1).get(), testTree.FinMinMax(testTree.FindNodeByKey(8).Node, false).NodeValue);
    }

    @Test
    public void nodeCountTest(){
        BST<Integer> testTree = new BST<>(new BSTNode<>(8, 8,null));
        testTree.AddKeyValue(4,4);
        testTree.AddKeyValue(2,2);
        testTree.AddKeyValue(3, 3);
        testTree.AddKeyValue(1, 1);
        testTree.AddKeyValue(6, 6);
        testTree.AddKeyValue(7, 7);
        testTree.AddKeyValue(5, 5);
        testTree.AddKeyValue(12, 12);
        testTree.AddKeyValue(10, 10);
        testTree.AddKeyValue(14, 14);
        testTree.AddKeyValue(9, 9);
        testTree.AddKeyValue(11, 11);
        testTree.AddKeyValue(13, 13);
        testTree.AddKeyValue(15, 15);

        Assert.assertEquals(15, testTree.Count());
    }

    @Test
    public void deleteTest(){
        BST<Integer> testTree = new BST<>(new BSTNode<>(8, 8,null));
        testTree.AddKeyValue(4,4);
        testTree.AddKeyValue(2,2);
        testTree.AddKeyValue(3, 3);
        testTree.AddKeyValue(1, 1);
        testTree.AddKeyValue(6, 6);
        testTree.AddKeyValue(7, 7);
        testTree.AddKeyValue(5, 5);
        testTree.AddKeyValue(12, 12);
        testTree.AddKeyValue(10, 10);
        testTree.AddKeyValue(14, 14);
        testTree.AddKeyValue(9, 9);
        testTree.AddKeyValue(11, 11);
        testTree.AddKeyValue(13, 13);
        testTree.AddKeyValue(15, 15);

        testTree.DeleteNodeByKey(1);
        Assert.assertEquals(null, testTree.FindNodeByKey(2).Node.LeftChild);
        Assert.assertFalse(testTree.FindNodeByKey(1).NodeHasKey);
        Assert.assertTrue(testTree.FindNodeByKey(1).ToLeft);
        Assert.assertEquals(14, testTree.Count());

        testTree.DeleteNodeByKey(4);
//        Assert.assertEquals();

        testTree.DeleteNodeByKey(6);
        Assert.assertEquals(null, testTree.FindNodeByKey(7).Node.LeftChild);
        Assert.assertEquals(12, testTree.Count());


        testTree.DeleteNodeByKey(5);
        Assert.assertEquals(7, testTree.FindNodeByKey(8).Node.LeftChild.NodeKey);
        Assert.assertEquals(2, testTree.FindNodeByKey(7).Node.LeftChild.NodeKey);
        Assert.assertEquals(null, testTree.FindNodeByKey(7).Node.RightChild);
        Assert.assertEquals(11,testTree.Count());

        testTree.DeleteNodeByKey(15);
        testTree.DeleteNodeByKey(13);
        Assert.assertEquals(9, testTree.Count());
    }
}
