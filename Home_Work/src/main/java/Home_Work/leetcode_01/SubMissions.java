package Home_Work.leetcode_01;

import java.util.HashMap;
import java.util.Map;

public class SubMissions {
    public int[] twoSum(int[] nums, int target) {
        //创建一个Hash
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        //循环遍历数组，看hash中是否有target-nums[i]，有输出
        for(int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        SubMissions subMissions = new SubMissions();
        System.out.println(subMissions.twoSum(new int[]{1,3,5,7,8,9},15));
    }
}
