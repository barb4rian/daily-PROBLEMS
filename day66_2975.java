class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
   int mod=1000000007,ans=-1;
    Set<Integer>set=new HashSet<>();
        set.add(m-1);
    for(int h:hFences){
        set.add(h-1);
        set.add(m-h);
    }
    for(int i=0;i<hFences.length-1;i++)
    for(int j=i+1;j<hFences.length;j++){
 set.add(Math.abs(hFences[i]-hFences[j]));
     }
    if(set.contains(n-1)){
    ans=Math.max(ans,n-1);
    }
    for(int v:vFences){
    if(v-1>ans&&set.contains(v-1)){
        ans=v-1;
    }
    if(n-v>ans&&set.contains(n-v)){
        ans=n-v;
    }
    }
    for(int i=0;i<vFences.length-1;i++)
    for(int j=i+1;j<vFences.length;j++){
    int width=Math.abs(vFences[i]-vFences[j]);
    if(width>ans&&set.contains(width)){
    ans=width;
    }
        }
        return ans==-1?-1:(int)((long)ans*ans%mod);
        }
}