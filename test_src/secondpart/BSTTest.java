//package secondpart;
//
//import algosecon.BST;
//import algosecon.BSTNode;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//public class BSTTest {
//    @Test
//    public void findAllNodeByValues() {
//        BST<Integer> testTree = new BST<>(new BSTNode<>(8, 8, null));
//        testTree.AddKeyValue(4, 4);
//        testTree.AddKeyValue(2, 2);
//        testTree.AddKeyValue(3, 3);
//        testTree.AddKeyValue(1, 1);
//        testTree.AddKeyValue(6, 6);
//        testTree.AddKeyValue(7, 7);
//        testTree.AddKeyValue(5, 5);
//        testTree.AddKeyValue(12, 12);
//        testTree.AddKeyValue(10, 10);
//        testTree.AddKeyValue(14, 14);
//        testTree.AddKeyValue(9, 9);
//        testTree.AddKeyValue(11, 11);
//        testTree.AddKeyValue(13, 13);
//        testTree.AddKeyValue(15, 15);
//
//        Assert.assertEquals(4, testTree.FindNodeByKey(4).Node.NodeKey);
//        Assert.assertEquals(Optional.of(4), Optional.ofNullable(testTree.FindNodeByKey(4).Node.NodeValue));
//        Assert.assertEquals(Optional.of(8), Optional.ofNullable(testTree.FindNodeByKey(4).Node.Parent.NodeValue));
//        Assert.assertEquals(Optional.of(2), Optional.ofNullable(testTree.FindNodeByKey(1).Node.Parent.NodeValue));
//    }
//
//    @Test
//    public void addKeyValueEmpty() {
//        BST<Integer> testTree = new BST<>(null);
//        testTree.AddKeyValue(8,8);
//        Assert.assertEquals(1, testTree.Count());
//        Assert.assertEquals(Optional.of(8).get(), testTree.FindNodeByKey(8).Node.NodeValue);
//    }
//
//    @Test
//    public void findAllMinMax() {
//        BST<Integer> testTree = new BST<>(new BSTNode<>(8, 8, null));
//        testTree.AddKeyValue(4, 4);
//        testTree.AddKeyValue(2, 2);
//        testTree.AddKeyValue(3, 3);
//        testTree.AddKeyValue(1, 1);
//        testTree.AddKeyValue(6, 6);
//        testTree.AddKeyValue(7, 7);
//        testTree.AddKeyValue(5, 5);
//        testTree.AddKeyValue(12, 12);
//        testTree.AddKeyValue(10, 10);
//        testTree.AddKeyValue(14, 14);
//        testTree.AddKeyValue(9, 9);
//        testTree.AddKeyValue(11, 11);
//        testTree.AddKeyValue(13, 13);
//        testTree.AddKeyValue(15, 15);
//
//        Assert.assertEquals(Optional.of(15).get(), testTree.FinMinMax(testTree.FindNodeByKey(8).Node, true).NodeValue);
//        Assert.assertEquals(Optional.of(1).get(), testTree.FinMinMax(testTree.FindNodeByKey(8).Node, false).NodeValue);
//    }
//
//    @Test
//    public void nodeCountTest() {
//        BST<Integer> testTree = new BST<>(new BSTNode<>(8, 8, null));
//        testTree.AddKeyValue(4, 4);
//        testTree.AddKeyValue(2, 2);
//        testTree.AddKeyValue(3, 3);
//        testTree.AddKeyValue(1, 1);
//        testTree.AddKeyValue(6, 6);
//        testTree.AddKeyValue(7, 7);
//        testTree.AddKeyValue(5, 5);
//        testTree.AddKeyValue(12, 12);
//        testTree.AddKeyValue(10, 10);
//        testTree.AddKeyValue(14, 14);
//        testTree.AddKeyValue(9, 9);
//        testTree.AddKeyValue(11, 11);
//        testTree.AddKeyValue(13, 13);
//        testTree.AddKeyValue(15, 15);
//
//        Assert.assertEquals(15, testTree.Count());
//    }
//
//    @Test
//    public void deleteTest() {
//        BST<Integer> testTree = new BST<>(new BSTNode<>(8, 8, null));
//        testTree.AddKeyValue(4, 4);
//        testTree.AddKeyValue(2, 2);
//        testTree.AddKeyValue(3, 3);
//        testTree.AddKeyValue(1, 1);
//        testTree.AddKeyValue(6, 6);
//        testTree.AddKeyValue(7, 7);
//        testTree.AddKeyValue(5, 5);
//        testTree.AddKeyValue(12, 12);
//        testTree.AddKeyValue(10, 10);
//        testTree.AddKeyValue(14, 14);
//        testTree.AddKeyValue(9, 9);
//        testTree.AddKeyValue(11, 11);
//        testTree.AddKeyValue(13, 13);
//        testTree.AddKeyValue(15, 15);
//
//        testTree.DeleteNodeByKey(1);
//        Assert.assertEquals(null, testTree.FindNodeByKey(2).Node.LeftChild);
//        Assert.assertFalse(testTree.FindNodeByKey(1).NodeHasKey);
//        Assert.assertTrue(testTree.FindNodeByKey(1).ToLeft);
//        Assert.assertEquals(14, testTree.Count());
//
//        testTree.DeleteNodeByKey(4);
//
//        testTree.DeleteNodeByKey(6);
//        Assert.assertEquals(null, testTree.FindNodeByKey(7).Node.LeftChild);
//        Assert.assertEquals(12, testTree.Count());
//
//
//        testTree.DeleteNodeByKey(5);
//        Assert.assertEquals(7, testTree.FindNodeByKey(8).Node.LeftChild.NodeKey);
//        Assert.assertEquals(2, testTree.FindNodeByKey(7).Node.LeftChild.NodeKey);
//        Assert.assertEquals(null, testTree.FindNodeByKey(7).Node.RightChild);
//        Assert.assertEquals(11, testTree.Count());
//
//        testTree.DeleteNodeByKey(15);
//        testTree.DeleteNodeByKey(13);
//        Assert.assertEquals(9, testTree.Count());
//
//    }
//
//    @Test
//    public void deleteOneNodeTest() {
//        BST<Integer> testTree = new BST<>(new BSTNode<>(8, 8, null));
//        testTree.AddKeyValue(4, 4);
//        Assert.assertEquals(2, testTree.Count());
//
//        testTree.DeleteNodeByKey(4);
//        Assert.assertEquals(1, testTree.Count());
//        Assert.assertEquals(Optional.of(8).get(), testTree.FindNodeByKey(4).Node.NodeValue);
//
//        testTree.DeleteNodeByKey(8);
//
//    }
//
//    @Test
//    public void wideSearch() {
//        BST<Integer> testTree = new BST<>(new BSTNode<>(8, 8, null));
//        testTree.AddKeyValue(4, 4);
//        testTree.AddKeyValue(2, 2);
//        testTree.AddKeyValue(3, 3);
//        testTree.AddKeyValue(1, 1);
//        testTree.AddKeyValue(6, 6);
//        testTree.AddKeyValue(7, 7);
//        testTree.AddKeyValue(5, 5);
//        testTree.AddKeyValue(12, 12);
//        testTree.AddKeyValue(10, 10);
//        testTree.AddKeyValue(14, 14);
//        testTree.AddKeyValue(9, 9);
//        testTree.AddKeyValue(11, 11);
//        testTree.AddKeyValue(13, 13);
//        testTree.AddKeyValue(15, 15);
//
//
//        ArrayList<BSTNode> bstNodes = testTree.WideAllNodes();
//        Assert.assertEquals(15, bstNodes.size());
//        Assert.assertEquals(8, bstNodes.get(0).NodeKey);
//        Assert.assertEquals(4, bstNodes.get(1).NodeKey);
//        Assert.assertEquals(12, bstNodes.get(2).NodeKey);
//        Assert.assertEquals(2, bstNodes.get(3).NodeKey);
//        Assert.assertEquals(6, bstNodes.get(4).NodeKey);
//        Assert.assertEquals(10, bstNodes.get(5).NodeKey);
//        Assert.assertEquals(14, bstNodes.get(6).NodeKey);
//
//    }
//
//    @Test
//    public void inOrderSearchTest() {
//        BST<Integer> testTree = new BST<>(new BSTNode<>(0, 8, null));
//        testTree.AddKeyValue(4, 4);
//        testTree.AddKeyValue(2, 2);
//        testTree.AddKeyValue(3, 3);
//        testTree.AddKeyValue(1, 1);
//        testTree.AddKeyValue(6, 6);
//        testTree.AddKeyValue(7, 7);
//        testTree.AddKeyValue(5, 5);
//        testTree.AddKeyValue(12, 12);
//        testTree.AddKeyValue(10, 10);
//        testTree.AddKeyValue(14, 14);
//        testTree.AddKeyValue(9, 9);
//        testTree.AddKeyValue(11, 11);
//        testTree.AddKeyValue(13, 13);
//        testTree.AddKeyValue(15, 15);
//
//
//        ArrayList<BSTNode> bstNodesInOrder = testTree.DeepAllNodes();
//        Assert.assertEquals(15, bstNodesInOrder.size());
////        Assert.assertEquals(8, bstNodesInOrder.get(0).NodeKey);
////        Assert.assertEquals(4, bstNodesInOrder.get(1).NodeKey);
////        Assert.assertEquals(2, bstNodesInOrder.get(2).NodeKey);
////        Assert.assertEquals(1, bstNodesInOrder.get(3).NodeKey);
////        Assert.assertEquals(, bstNodesInOrder.get(4).NodeKey);
////        Assert.assertEquals(10, bstNodesInOrder.get(5).NodeKey);
////        Assert.assertEquals(14, bstNodesInOrder.get(6).NodeKey);
//
//
//    }
//
//    @Test
//    public void preOrderSearchTest() {
//        BST<Integer> testTree = new BST<>(new BSTNode<>(1, 8, null));
//        testTree.AddKeyValue(4, 4);
//        testTree.AddKeyValue(2, 2);
//        testTree.AddKeyValue(3, 3);
//        testTree.AddKeyValue(1, 1);
//        testTree.AddKeyValue(6, 6);
//        testTree.AddKeyValue(7, 7);
//        testTree.AddKeyValue(5, 5);
//        testTree.AddKeyValue(12, 12);
//        testTree.AddKeyValue(10, 10);
//        testTree.AddKeyValue(14, 14);
//        testTree.AddKeyValue(9, 9);
//        testTree.AddKeyValue(11, 11);
//        testTree.AddKeyValue(13, 13);
//        testTree.AddKeyValue(15, 15);
//
//
//        ArrayList<BSTNode> bstNodesInOrder = testTree.DeepAllNodes();
//        Assert.assertEquals(15, bstNodesInOrder.size());
////        Assert.assertEquals(8, bstNodesInOrder.get(0).NodeKey);
////        Assert.assertEquals(4, bstNodesInOrder.get(1).NodeKey);
////        Assert.assertEquals(2, bstNodesInOrder.get(2).NodeKey);
////        Assert.assertEquals(1, bstNodesInOrder.get(3).NodeKey);
////        Assert.assertEquals(, bstNodesInOrder.get(4).NodeKey);
////        Assert.assertEquals(10, bstNodesInOrder.get(5).NodeKey);
////        Assert.assertEquals(14, bstNodesInOrder.get(6).NodeKey);
//
//    }
//
//    @Test
//    public void postOrderSearchTest() {
//        BST<Integer> testTree = new BST<>(new BSTNode<>(2, 8, null));
//        testTree.AddKeyValue(4, 4);
//        testTree.AddKeyValue(2, 2);
//        testTree.AddKeyValue(3, 3);
//        testTree.AddKeyValue(1, 1);
//        testTree.AddKeyValue(6, 6);
//        testTree.AddKeyValue(7, 7);
//        testTree.AddKeyValue(5, 5);
//        testTree.AddKeyValue(12, 12);
//        testTree.AddKeyValue(10, 10);
//        testTree.AddKeyValue(14, 14);
//        testTree.AddKeyValue(9, 9);
//        testTree.AddKeyValue(11, 11);
//        testTree.AddKeyValue(13, 13);
//        testTree.AddKeyValue(15, 15);
//
//        ArrayList<BSTNode> bstNodesPostOrder = testTree.DeepAllNodes();
//        Assert.assertEquals(15, bstNodesPostOrder.size());
//
//    }
//}
