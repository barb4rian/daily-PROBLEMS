class Solution {
    public int removeDuplicates(int a[])
     {
        if (a.length == 0) return 0;

        int k = 1; 
        for (int i = 1; i < a.length; i++)
         {
            if (a[i] != a[k - 1])
             {
                a[k] = a[i];
                k++;
            }
        }
        return k; 
    }
}
