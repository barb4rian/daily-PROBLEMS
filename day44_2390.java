class Solution {
    public String removeStars(String s) {
        char[] abc=s.toCharArray();
        int n=abc.length-1;
        int k=n;
        int skip=0;
        while(n>=0){
            if(abc[n]=='*'){
               n--;
               skip++; 
            }else if(skip>0){
                skip--;
                n--;
            }else{
            abc[k]=abc[n];
            k--;
            n--;
            }
        }
        return new String(abc,k+1,abc.length-k-1);
    }
}