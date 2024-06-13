package lab_pratice_ad2;

import java.util.*;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class graph {
    private int vertices;
    private List<List<Edge>> adjList;
    private List<Edge> allEdges; 

    public graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        allEdges = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Edge(source, destination, weight));
        allEdges.add(new Edge(source, destination, weight)); // Add to allEdges for MST
    }

    public void displayGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Edge edge : adjList.get(i)) {
                System.out.print(" -> " + edge.destination + " (weight: " + edge.weight + ")");
            }
            System.out.println();
        }
    }

    public void dfs(int source) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        System.out.print("DFS: ");
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(vertex + " ");
                for (Edge edge : adjList.get(vertex)) {
                    if (!visited[edge.destination]) {
                        stack.push(edge.destination);
                    }
                }
            }
        }
        System.out.println();
    }

    public void bfs(int source) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (Edge edge : adjList.get(vertex)) {
                if (!visited[edge.destination]) {
                    visited[edge.destination] = true;
                    queue.add(edge.destination);
                }
            }
        }
        System.out.println();
    }

    public void Dijkstra(int startVertex) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        pq.add(new Edge(startVertex, startVertex, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int vertex = edge.destination;

            for (Edge neighbor : adjList.get(vertex)) {
                int newDist = distances[vertex] + neighbor.weight;

                if (newDist < distances[neighbor.destination]) {
                    distances[neighbor.destination] = newDist;
                    pq.add(new Edge(neighbor.source, neighbor.destination, newDist));
                }
            }
        }

        System.out.println("Shortest paths from vertex " + startVertex + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + " distance " + distances[i]);
        }
    }

  
    public void KruskalMST() {
        Collections.sort(allEdges, Comparator.comparingInt(o -> o.weight));

        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        List<Edge> mst = new ArrayList<>();
        int index = 0;
        while (mst.size() < vertices - 1) {
            Edge edge = allEdges.get(index++);
            int root1 = find(parent, edge.source);
            int root2 = find(parent, edge.destination);

            if (root1 != root2) {
                mst.add(edge);
                union(parent, root1, root2);
            }
        }

        System.out.println("Minimum Spanning Tree using Kruskal's Algorithm:");
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.source + " - " + edge.destination + " weight: " + edge.weight);
        }
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private void union(int[] parent, int root1, int root2) {
        int root1Root = find(parent, root1);
        int root2Root = find(parent, root2);
        parent[root2Root] = root1Root;
    }

    public static void main(String[] args) {
        graph graph = new graph(5);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 4, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 6);
        graph.addEdge(1, 4, 4);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 5);

        graph.displayGraph();
        graph.dfs(0);
        graph.bfs(0);
        graph.Dijkstra(0);
        graph.KruskalMST();
    }
}
