class Solution {
    Map<Integer,Integer> map;
    public int combinationSum4(int[] nums, int target) {
        map=new HashMap<>();
        Arrays.sort(nums);
        return backtrack(nums, target,new ArrayList<Integer>(), 0,0);
    }
    public int backtrack(int[] nums, int target,ArrayList<Integer> arr, int start, int ans) {
        ans=0;
        if (target<0) return 0;
        if (target==0) return 1;
        if (map.containsKey(target)) return map.get(target);
        for (int i=start;i<nums.length;i++) {
            arr.add(nums[i]);
            ans+=backtrack(nums, target-nums[i],arr,start,ans);
            arr.remove(arr.size()-1);
        }
        map.put(target,ans);
        return ans;
    }
}
