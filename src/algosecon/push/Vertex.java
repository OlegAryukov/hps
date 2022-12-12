package algosecon.push;

class Vertex {
    public int Value;

    public Vertex(int val) {
        Value = val;
    }
}

class SimpleGraph {
    algosecon.graph.Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new algosecon.graph.Vertex[size];
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
            vertex[index] = new algosecon.graph.Vertex(value);
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
}