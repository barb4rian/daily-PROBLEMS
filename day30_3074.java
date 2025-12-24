class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // Calculate total apples
        int totalApples = 0;
        for (int apples : apple) {
            totalApples += apples;
        }
        
        // Sort capacity in descending order
        Arrays.sort(capacity);
        
        // Use boxes from largest to smallest until we can hold all apples
        int boxesUsed = 0;
        int currentCapacity = 0;
        
        for (int i = capacity.length - 1; i >= 0; i--) {
            currentCapacity += capacity[i];
            boxesUsed++;
            
            if (currentCapacity >= totalApples) {
                return boxesUsed;
            }
        }
        
        return boxesUsed;
    }
}