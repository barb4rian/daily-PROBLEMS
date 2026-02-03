import java.util.*;
class Solution 
{
    public int[] successfulPairs(int[] spell, int[] potion, long k) 
    {
        int n = spell.length;int m = potion.length;int ans[]=new int[n];
        Arrays.sort(potion);
        for(int i =0;i<n;i++)
        {
            int s = spell[i];int l =0,r=m-1;int idx =m;
            while(l<=r)
            {
                int mid = l+(r-l)/2;
                long val =(long)s*potion[mid];
                if(val>=k)
                {
                    idx = mid;
                    r = mid-1;
                }
                else
                {
                    l=mid+1;

                }
            }
            ans[i]=m-idx;
        }
        return ans ;
        
    }
}