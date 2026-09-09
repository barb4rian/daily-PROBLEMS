class Solution:
    def rearrangeSticks(self, n, k, mod=10**9 + 7):
        
        prev_k = [0] * (n + 1) # initialize j = 0 state set
        
        for j in range(1, k + 1):
            curr_k = [0] * (n + 1) # initialize j state set
            
            for i in range(1, n + 1):
                
                if i == j:  # handle edge case i = j
                    curr_k[i] = 1
                    continue
                
                # recurrence relation:
                curr_k[i] = (prev_k[i-1] + curr_k[i-1] * (i - 1)) % mod

            prev_k = curr_k  # roll the arrays, updating j - 1 state set 

        return curr_k[n]