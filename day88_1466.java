import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] conn : connections) {
            int u = conn[0], v = conn[1];
        
            graph[u].add(new int[]{v, 1});
            
            graph[v].add(new int[]{u, 0});
        }
        
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int changes = 0;
        
  
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        while (!queue.isEmpty()) {
            int city = queue.poll();
            
            for (int[] neighbor : graph[city]) {
                int next = neighbor[0];
                int direction = neighbor[1];
                
                if (!visited[next]) {
                    visited[next] = true;
                
                    if (direction == 1) {
                        changes++;
                    }
                    queue.offer(next);
                }
            }
        }
        
        return changes;
    }
}