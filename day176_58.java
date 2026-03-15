class Solution
 {
    public int lengthOfLastWord(String s)
     {
        int i = s.length() - 1;
         //didn't used TRIM so lamba ho gya bhai ya huuuuuuuuuuuuuuuuuuuuuuuuuuuu
        int len = 0;

        
        while (i >= 0 && s.charAt(i) == ' ') 
        {
            i--;
        }

        
        while (i >= 0 && s.charAt(i) != ' ') 
        {
            len++;
            i--;
        }

        return len;
    }
}