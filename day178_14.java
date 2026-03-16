class Solution {
    public String longestCommonPrefix(String[] a) 
    {
        if (a == null || a.length == 0) return "";

        StringBuilder p = new StringBuilder();
        String f = a[0];

        for (int i = 0; i < f.length(); i++)
         {
            char c = f.charAt(i);
            for (int j = 1; j < a.length; j++)
             {
                if (i >= a[j].length() || a[j].charAt(i) != c) 
                {
                    return p.toString();
                }
            }
            p.append(c);
        }
        return p.toString();
    }
}
