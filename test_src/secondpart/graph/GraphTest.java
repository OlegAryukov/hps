//package secondpart.graph;
//
//import algosecon.push.SimpleGraph;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class GraphTest {
//
//    @Test
//    public void genTest() {
//        SimpleGraph graph = new SimpleGraph(4);
//        graph.AddVertex(1);
//        graph.AddVertex(2);
//        graph.AddVertex(3);
//        graph.AddVertex(4);
//        graph.AddEdge(0, 1);
//        graph.AddEdge(0, 2);
//        graph.AddEdge(0, 3);
//        graph.AddEdge(3, 1);
//        Assert.assertTrue(graph.IsEdge(0,3));
//        Assert.assertTrue(graph.IsEdge(0,2));
//        Assert.assertTrue(graph.IsEdge(0,1));
//        Assert.assertTrue(graph.IsEdge(1,3));
//
//        graph.RemoveEdge(1, 3);
//        Assert.assertFalse(graph.IsEdge(3,1));
//
//        graph.RemoveVertex(0);
//        Assert.assertFalse(graph.IsEdge(0,1));
//        Assert.assertFalse(graph.IsEdge(0,2));
//        Assert.assertFalse(graph.IsEdge(3,0));
//
//    }
//
//    @Test
//    public void findPathTest() {
//        SimpleGraph graph = new SimpleGraph(6);
//        graph.AddVertex(1);
//        graph.AddVertex(2);
//        graph.AddVertex(3);
//        graph.AddVertex(4);
//        graph.AddVertex(5);
//        graph.AddVertex(6);
//        graph.AddEdge(0, 2);
//        graph.AddEdge(0, 3);
//        graph.AddEdge(2, 1);
//        graph.AddEdge(3,4);
//        graph.AddEdge(1,5);
//
//        Assert.assertEquals(3, graph.DepthFirstSearch(0, 4).size());
//        Assert.assertEquals(4, graph.DepthFirstSearch(0, 5).size());
//        Assert.assertEquals(5, graph.DepthFirstSearch(1, 4).size());
//
//        graph.RemoveEdge(0,3);
//        Assert.assertEquals(0, graph.DepthFirstSearch(0, 4).size());
//
//    }
//
//    @Test
//    public void getEmptyPathTest() {
//        SimpleGraph graph = new SimpleGraph(6);
//        graph.AddVertex(1);
//        graph.AddVertex(2);
//        graph.AddVertex(3);
//        graph.AddVertex(4);
//        graph.AddVertex(5);
//        graph.AddVertex(6);
//
//        graph.AddEdge(0, 2);
//        graph.AddEdge(2, 1);
//        graph.AddEdge(3,4);
//        graph.AddEdge(1,5);
//
//        Assert.assertEquals(0, graph.DepthFirstSearch(0, 4).size());
//    }
//}
