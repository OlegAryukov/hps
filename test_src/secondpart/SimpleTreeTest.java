package secondpart;


import algosecon.SimpleTree;
import algosecon.SimpleTreeNode;
import org.junit.Assert;
import org.junit.Test;

public class SimpleTreeTest {
    @Test
    public void findAllNodeByValues(){
        SimpleTree<Integer> testTree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> four = new SimpleTreeNode<>(4, null);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<>(3, null);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<>(5, null);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<>(6, null);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<>(7, null);
        SimpleTreeNode<Integer> sevenTeen = new SimpleTreeNode<>(17, null);
        SimpleTreeNode<Integer> twentyTwo = new SimpleTreeNode<>(22, null);
        SimpleTreeNode<Integer> twenty = new SimpleTreeNode<>(20, null);
        SimpleTreeNode<Integer> fourSecond = new SimpleTreeNode<>(4, null);

        testTree.AddChild(testTree.Root, four);
        testTree.AddChild(four, three);
        testTree.AddChild(four, six);
        testTree.AddChild(six, seven);
        testTree.AddChild(six, five);
        testTree.AddChild(testTree.Root, sevenTeen);
        testTree.AddChild(sevenTeen, twentyTwo);
        testTree.AddChild(twentyTwo, twenty);
        testTree.AddChild(sevenTeen, fourSecond);

        Assert.assertEquals(2, testTree.FindNodesByValue(4).size());
    }

    @Test
    public void findAllNodes(){
        SimpleTree<Integer> testTree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> four = new SimpleTreeNode<>(4, null);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<>(3, null);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<>(5, null);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<>(6, null);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<>(7, null);
        SimpleTreeNode<Integer> sevenTeen = new SimpleTreeNode<>(17, null);
        SimpleTreeNode<Integer> twentyTwo = new SimpleTreeNode<>(22, null);
        SimpleTreeNode<Integer> twenty = new SimpleTreeNode<>(20, null);
        SimpleTreeNode<Integer> fourSecond = new SimpleTreeNode<>(4, null);

        testTree.AddChild(testTree.Root, four);
        testTree.AddChild(four, three);
        testTree.AddChild(four, six);
        testTree.AddChild(six, seven);
        testTree.AddChild(six, five);
        testTree.AddChild(testTree.Root, sevenTeen);
        testTree.AddChild(sevenTeen, twentyTwo);
        testTree.AddChild(twentyTwo, twenty);
        testTree.AddChild(sevenTeen, fourSecond);

        Assert.assertEquals(10, testTree.GetAllNodes().size());
        Assert.assertTrue(testTree.GetAllNodes().contains(four));
        Assert.assertTrue(testTree.GetAllNodes().contains(three));
        Assert.assertTrue(testTree.GetAllNodes().contains(five));
        Assert.assertTrue(testTree.GetAllNodes().contains(six));
        Assert.assertTrue(testTree.GetAllNodes().contains(seven));
        Assert.assertTrue(testTree.GetAllNodes().contains(sevenTeen));
        Assert.assertTrue(testTree.GetAllNodes().contains(twentyTwo));
        Assert.assertTrue(testTree.GetAllNodes().contains(twenty));
        Assert.assertTrue(testTree.GetAllNodes().contains(fourSecond));
    }

    @Test
    public void moveNode(){
        SimpleTree<Integer> testTree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> four = new SimpleTreeNode<>(4, null);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<>(3, null);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<>(5, null);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<>(6, null);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<>(7, null);
        SimpleTreeNode<Integer> sevenTeen = new SimpleTreeNode<>(17, null);
        SimpleTreeNode<Integer> twentyTwo = new SimpleTreeNode<>(22, null);
        SimpleTreeNode<Integer> twenty = new SimpleTreeNode<>(20, null);
        SimpleTreeNode<Integer> fourSecond = new SimpleTreeNode<>(4, null);

        testTree.AddChild(testTree.Root, four);
        testTree.AddChild(four, three);
        testTree.AddChild(four, six);
        testTree.AddChild(six, seven);
        testTree.AddChild(six, five);
        testTree.AddChild(testTree.Root, sevenTeen);
        testTree.AddChild(sevenTeen, twentyTwo);
        testTree.AddChild(twentyTwo, twenty);
        testTree.AddChild(sevenTeen, fourSecond);

        testTree.MoveNode(six, sevenTeen);

        Assert.assertEquals(1, four.Children.size());
        Assert.assertEquals(3, sevenTeen.Children.size());
        Assert.assertEquals(10, testTree.GetAllNodes().size());
    }

    @Test
    public void removeNode(){
        SimpleTree<Integer> testTree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> four = new SimpleTreeNode<>(4, null);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<>(3, null);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<>(5, null);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<>(6, null);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<>(7, null);
        SimpleTreeNode<Integer> sevenTeen = new SimpleTreeNode<>(17, null);
        SimpleTreeNode<Integer> twentyTwo = new SimpleTreeNode<>(22, null);
        SimpleTreeNode<Integer> twenty = new SimpleTreeNode<>(20, null);
        SimpleTreeNode<Integer> fourSecond = new SimpleTreeNode<>(4, null);

        testTree.AddChild(testTree.Root, four);
        testTree.AddChild(four, three);
        testTree.AddChild(four, six);
        testTree.AddChild(six, seven);
        testTree.AddChild(six, five);
        testTree.AddChild(testTree.Root, sevenTeen);
        testTree.AddChild(sevenTeen, twentyTwo);
        testTree.AddChild(twentyTwo, twenty);
        testTree.AddChild(sevenTeen, fourSecond);

        testTree.DeleteNode(sevenTeen);

        Assert.assertEquals(1, testTree.Root.Children.size());
        Assert.assertEquals(6, testTree.GetAllNodes().size());
    }

    @Test
    public void countLeaf(){
        SimpleTree<Integer> testTree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> four = new SimpleTreeNode<>(4, null);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<>(3, null);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<>(5, null);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<>(6, null);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<>(7, null);
        SimpleTreeNode<Integer> sevenTeen = new SimpleTreeNode<>(17, null);
        SimpleTreeNode<Integer> twentyTwo = new SimpleTreeNode<>(22, null);
        SimpleTreeNode<Integer> twenty = new SimpleTreeNode<>(20, null);
        SimpleTreeNode<Integer> fourSecond = new SimpleTreeNode<>(4, null);

        testTree.AddChild(testTree.Root, four);
        testTree.AddChild(four, three);
        testTree.AddChild(four, six);
        testTree.AddChild(six, seven);
        testTree.AddChild(six, five);
        testTree.AddChild(testTree.Root, sevenTeen);
        testTree.AddChild(sevenTeen, twentyTwo);
        testTree.AddChild(twentyTwo, twenty);
        testTree.AddChild(sevenTeen, fourSecond);

        Assert.assertEquals(5, testTree.LeafCount());
        testTree.DeleteNode(twenty);
        Assert.assertEquals(5, testTree.LeafCount());
        testTree.MoveNode(six, sevenTeen);
        Assert.assertEquals(5, testTree.LeafCount());
    }

    @Test
    public void countNode(){
        SimpleTree<Integer> testTree = new SimpleTree<>(new SimpleTreeNode<>(9, null));
        SimpleTreeNode<Integer> four = new SimpleTreeNode<>(4, null);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<>(3, null);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<>(5, null);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<>(6, null);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<>(7, null);
        SimpleTreeNode<Integer> sevenTeen = new SimpleTreeNode<>(17, null);
        SimpleTreeNode<Integer> twentyTwo = new SimpleTreeNode<>(22, null);
        SimpleTreeNode<Integer> twenty = new SimpleTreeNode<>(20, null);


        testTree.AddChild(testTree.Root, four);
        testTree.AddChild(four, three);
        testTree.AddChild(four, six);
        testTree.AddChild(six, seven);
        testTree.AddChild(six, five);
        testTree.AddChild(testTree.Root, sevenTeen);
        testTree.AddChild(sevenTeen, twentyTwo);
        testTree.AddChild(twentyTwo, twenty);


        Assert.assertEquals(9, testTree.Count());
        testTree.DeleteNode(twenty);
        Assert.assertEquals(8, testTree.Count());
        testTree.MoveNode(six, sevenTeen);
        Assert.assertEquals(8, testTree.Count());
    }

    @Test
    public void findAllPairForForest(){
        SimpleTree<Integer> testTree = new SimpleTree<>(new SimpleTreeNode<>(1, null));
        SimpleTreeNode<Integer> four = new SimpleTreeNode<>(4, null);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<>(3, null);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<>(5, null);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<>(6, null);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<>(7, null);
        SimpleTreeNode<Integer> eight = new SimpleTreeNode<>(8, null);
        SimpleTreeNode<Integer> nine = new SimpleTreeNode<>(9, null);
        SimpleTreeNode<Integer> ten = new SimpleTreeNode<>(10, null);
        SimpleTreeNode<Integer> two = new SimpleTreeNode<>(2, null);

        testTree.AddChild(testTree.Root, two);
        testTree.AddChild(testTree.Root, three);
        testTree.AddChild(testTree.Root, six);
        testTree.AddChild(two, seven);
        testTree.AddChild(two, five);
        testTree.AddChild(three, four);
        testTree.AddChild(six, eight);
        testTree.AddChild(eight, nine);
        testTree.AddChild(eight, ten);

        Assert.assertEquals(4, testTree.EvenTrees().size());
    }
}
