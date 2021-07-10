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

*********************

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
        for (int i=start;i<nums.length && nums[i]<=target;i++) {
            arr.add(nums[i]);
            ans+=backtrack(nums, target-nums[i],arr,start,ans);
            //arr.remove(arr.size()-1);
        }
        map.put(target,ans);
        return ans;
    }
}

*************************

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
        for (int i=start;i<nums.length && nums[i]<=target;i++) {
            arr.add(nums[i]);
            ans+=backtrack(nums, target-nums[i],arr,start,ans);
            //arr.remove(arr.size()-1);
        }
        map.put(target,ans);
        return ans;
    }
}

***********************

class Solution {
    int[] counts;
    public int combinationSum4(int[] nums, int target) {
        counts=new int[target+1];
        Arrays.fill(counts,-1);
        counts[0]=1;
        return helper(nums,target);
    }
    public int helper(int[] nums, int target) {
        if (counts[target]>-1) return counts[target];
        int ans=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]<=target) ans+=helper(nums, target-nums[i]);
        }
        counts[target]=ans;
        return ans;
    }
}
