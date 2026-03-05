class Solution {
    public boolean canJump(int[] nums) {
        int lastElementindex = nums.length-1;
        for(int i = nums.length-1;i>=0;i--){
            if(i+nums[i]>= lastElementindex){
                lastElementindex = i;
            }
        }
        return lastElementindex==0;
    }
}