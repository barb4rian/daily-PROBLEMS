class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                
                if (count == n) return count;
                
              
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;
                
                while (!queue.isEmpty()) {
                    int city = queue.poll();
                  
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && M[city][j] == 1) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}