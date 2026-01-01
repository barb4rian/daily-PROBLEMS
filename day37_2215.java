class Solution {
    public List<List<Integer>> findDifference(int[] a, int[] b) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        
        for (int n : a) s1.add(n);
        for (int n : b) s2.add(n);
        
        List<Integer> l1 = new ArrayList<>(s1);
        List<Integer> l2 = new ArrayList<>(s2);
        
        l1.removeAll(s2);
        l2.removeAll(s1);
        
        return Arrays.asList(l1, l2);
    }
}