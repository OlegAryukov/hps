package secondpart.graph;

import algosecon.graph.SimpleGraph;
import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

    @Test
    public void genTest() {
        SimpleGraph graph = new SimpleGraph(4);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(3, 1);
        Assert.assertTrue(graph.IsEdge(0,3));
        Assert.assertTrue(graph.IsEdge(0,2));
        Assert.assertTrue(graph.IsEdge(0,1));
        Assert.assertTrue(graph.IsEdge(1,3));

        graph.RemoveEdge(1, 3);
        Assert.assertFalse(graph.IsEdge(3,1));

        graph.RemoveVertex(0);
        Assert.assertFalse(graph.IsEdge(0,1));
        Assert.assertFalse(graph.IsEdge(0,2));
        Assert.assertFalse(graph.IsEdge(3,0));

    }
}
