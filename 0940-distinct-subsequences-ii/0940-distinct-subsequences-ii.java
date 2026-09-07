class Solution {
    public int distinctSubseqII(String s) {
       int mod=1000000007;
       int n=s.length();
       int []dp=new int[n+1];
       dp[0]=1;
       int last[]=new int[26];
       Arrays.fill(last,-1);
       for(int i=1;i<=n;i++){
        char current=s.charAt(i-1);
        dp[i]=(2*dp[i-1])%mod;
        if(last[current-'a']!=-1){
            dp[i]=(dp[i]-dp[last[current-'a']-1])%mod;
        }
        if(dp[i]<0) dp[i]+=mod;
        last[current-'a']=i;
       } 
       dp[n]--;
       if(dp[n]<0) dp[n]+=mod;
       return dp[n];
    }
}