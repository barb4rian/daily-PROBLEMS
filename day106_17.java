import java.util.*;

class Solution 
{
    public List<String> letterCombinations(String d) 
    {
        List<String> res = new ArrayList<>();
        if (d.isEmpty()) return res;
        
        String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        

        backtrack(res, d, map, 0, new StringBuilder());
        return res;
    }
    
    void backtrack(List<String> res, String d, String[] map, int i, StringBuilder sb) 
    {
        if (i == d.length()) 
        {
            res.add(sb.toString());
            return;
        }
        
        String letters = map[d.charAt(i) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(res, d, map, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1); }
    }
}
