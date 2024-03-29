package algosecon.graph;

import java.util.*;

public class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value) {
        // ваш код добавления новой вершины
        // с значением value
        // в незанятую позицию vertex
        int index = 0;
        while (index < vertex.length) {
            if (vertex[index] != null) {
                index++;
                continue;
            }
            vertex[index] = new Vertex(value);
            break;
        }
    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v) {
        for (int i = 0; i < max_vertex; i++) {
            m_adjacency[i][v] = 0;
            m_adjacency[v][i] = 0;
        }
        // ваш код удаления вершины со всеми её рёбрами
    }

    public boolean IsEdge(int v1, int v2) {
        // true если есть ребро между вершинами v1 и v2
        return m_adjacency[v1][v2] == 1 || m_adjacency[v2][v1] == 1;
    }

    public void AddEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 1;
        m_adjacency[v2][v1] = 1;
        // добавление ребра между вершинами v1 и v2
    }

    public void RemoveEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
        // удаление ребра между вершинами v1 и v2
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        for (int i = 0; i < vertex.length; i++) {
            vertex[i].Hit = false;
        }
        Stack<Vertex> stack = new Stack<>();
        return new ArrayList<>(getVerticesDfs(VFrom, VTo, stack));
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo)
    {
        for (int i = 0; i < vertex.length; i++) {
            vertex[i].Hit = false;
        }
        // Узлы задаются позициями в списке vertex.
        // Возвращается список узлов -- путь из VFrom в VTo.
        // Список пустой, если пути нету.
        return null;
    }

    private Stack<Vertex> getVerticesDfs(int VFrom, int VTo, Stack<Vertex> stack) {
        this.vertex[VFrom].Hit = true;
        stack.push(vertex[VFrom]);
        for (int j = 0; j < m_adjacency[VFrom].length; j++) {
            if (m_adjacency[VFrom][j] == 1 && j == VTo) {
                stack.push(vertex[VTo]);
                return stack;
            }
        }
        int stackSize = stack.size();
        for (int j = 0; j < m_adjacency[VFrom].length; j++) {
            if (m_adjacency[VFrom][j] == 1 && !vertex[j].Hit) {
                stack = getVerticesDfs(j, VTo, stack);
                if(stack.peek().equals(vertex[VTo]))
                    break;
            }
        }
        if (stackSize == stack.size())
            stack.pop();
        return stack;

    }

    private Stack<Vertex> getVertexBfs(int VFrom, int VTo)
    // Узлы задаются позициями в списке vertex.
    // Возвращается список узлов -- путь из VFrom в VTo.
    // Список пустой, если пути нету.

}