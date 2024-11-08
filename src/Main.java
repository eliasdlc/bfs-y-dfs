import java.util.*;


public class Main {

    public static void main(String[] args) {

        int[][] adjMatrix = {
                {0, 1, 0, 0, 1, 0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1, 0, 0}
        };

        // Convertir la matriz de adyacencia a lista de adyacencia
        Map<Character, List<Character>> adjList = matrizAListaAdyacencia(adjMatrix);
        System.out.println("Lista de adyacencia: " + adjList);

        // Realizar los recorridos BFS y DFS
        char inicio = 'A';
        System.out.println("Recorrido BFS desde el nodo " + inicio + ": " + bfs(adjList, inicio));
        System.out.println("Recorrido DFS desde el nodo " + inicio + ": " + dfs(adjList, inicio));
    }

        // Convertir la matriz de adyacencia en una lista de adyacencia
        public static Map<Character, List<Character>> matrizAListaAdyacencia(int[][] matrix) {
            Map<Character, List<Character>> adjList = new HashMap<>();
            char[] nodes = "ABCDEFGHIJ".toCharArray();

            for (int i = 0; i < matrix.length; i++) {
                adjList.putIfAbsent(nodes[i], new ArrayList<>());
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 1) {
                        adjList.get(nodes[i]).add(nodes[j]);
                    }
                }
            }
            return adjList;
        }

        // Implementación de BFS
        public static List<Character> bfs(Map<Character, List<Character>> graph, char start) {
            List<Character> path = new ArrayList<>();
            Set<Character> visited = new HashSet<>();
            Queue<Character> queue = new LinkedList<>();

            queue.add(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                char node = queue.poll();
                path.add(node);

                for (char neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            return path;
        }

        // Implementación de DFS
        public static List<Character> dfs(Map<Character, List<Character>> graph, char start) {
            List<Character> path = new ArrayList<>();
            Set<Character> visited = new HashSet<>();

            dfsHelper(graph, start, visited, path);
            
            return path;
        }

        private static void dfsHelper(Map<Character, List<Character>> graph, char node, Set<Character> visited, List<Character> path) {
            visited.add(node);
            path.add(node);

            for (char neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    dfsHelper(graph, neighbor, visited, path);
                }
            }
        }




}