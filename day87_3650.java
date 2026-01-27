class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] g = new ArrayList[n];
        List<int[]>[] rev = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }
        
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[]{v, w});      // forward edge
            rev[v].add(new int[]{u, w});    // reverse edge
        }
        
        
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); 
        dist[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], u = cur[1], used = cur[2];
            
            if (u == n - 1) return cost;
            if (cost > dist[u][used]) continue;
            
            
            for (int[] edge : g[u]) {
                int v = edge[0], w = edge[1];
                int newCost = cost + w;
                
                if (newCost < dist[v][used]) {
                    dist[v][used] = newCost;
                    pq.offer(new int[]{newCost, v, used});
                }
            }
            
           
            if (used == 0) {
                for (int[] edge : rev[u]) {
                    int v = edge[0], w = edge[1];
                    int newCost = cost + 2 * w;
                    
                    if (newCost < dist[v][1]) {
                        dist[v][1] = newCost;
                        pq.offer(new int[]{newCost, v, 1});
                    }
                }
            }
        }
        
        return Math.min(dist[n - 1][0], dist[n - 1][1]) == Integer.MAX_VALUE 
               ? -1 
               : Math.min(dist[n - 1][0], dist[n - 1][1]);
    }
}