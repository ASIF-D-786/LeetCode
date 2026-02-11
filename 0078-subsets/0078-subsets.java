class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); 
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newSubset = new ArrayList<>(result.get(j));
                newSubset.add(num);
                result.add(newSubset);
            }
        }
        return result;
    }
}