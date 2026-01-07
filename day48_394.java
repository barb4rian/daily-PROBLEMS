class Solution {
    private int index = 0;
    
    public String decodeString(String s) {
        return decode(s);
    }
    
    private String decode(String s) {
        StringBuilder result = new StringBuilder();
        
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index))) {
                // Regular chactr
                result.append(s.charAt(index));
                index++;
            } else {
                // Get the numbr
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                
                // Skip the bracss [
                index++;
                
                // Decode the substringggg recursively
                String decodedString = decode(s);
                
                // Skip ']'
                index++;
                
                // Append decoded string nummm times
                for (int i = 0; i < num; i++) {
                    result.append(decodedString);
                }
            }
        }
        
        return result.toString();
    }
}