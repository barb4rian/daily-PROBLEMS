class Solution {
    public int numOfWays(int n) {
        long MOD = 1000000007;
        
        
        long aba = 6;  // RYR, RGR, YRY, YGY, GRG, GYG
        long abc = 6;  // RYG, RGY, YRG, YGR, GRY, GYR
        
        for (int i = 2; i <= n; i++) {
            long newAba = (aba * 3 + abc * 2) % MOD;
            long newAbc = (aba * 2 + abc * 2) % MOD;
            aba = newAba;
            abc = newAbc;
        }
        
        return (int)((aba + abc) % MOD);
    }
}