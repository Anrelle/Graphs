import java.util.*;

class Graph {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addVertex(String vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String v1, String v2) {
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }

    public List<String> dfs(String start) {
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        dfsHelper(start, visited, result);
        return result;
    }

    private void dfsHelper(String v, Set<String> visited, List<String> result) {
        visited.add(v);
        result.add(v);
        for (String neighbor : adjList.get(v)) {
            if (!visited.contains(neighbor)) dfsHelper(neighbor, visited, result);
        }
    }

    public List<String> bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            result.add(current);
            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        for (String v : new String[]{"A", "B", "C", "D", "E"}) g.addVertex(v);
        g.addEdge("A", "B"); g.addEdge("A", "C"); g.addEdge("B", "D"); g.addEdge("C", "E"); g.addEdge("D", "E");
        System.out.println("DFS: " + g.dfs("A"));
        System.out.println("BFS: " + g.bfs("A"));
    }
}
