package com.zxd.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: TwoSum_1
 * @Description: 两数之和
 * @Author xiaodong.zou
 * @Date 2019/11/8 10:38
 */
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//		你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
//		示例:
//
//		给定 nums = [2, 7, 11, 15], target = 9
//
//		因为 nums[0] + nums[1] = 2 + 7 = 9
//		所以返回 [0, 1]
//
//		来源：力扣（LeetCode）
//		链接：https://leetcode-cn.com/problems/two-sum
//		著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class TwoSum_1 {

//	方法1：暴露查找
//	复杂度分析：
//
//	时间复杂度：O(n^2)，
//	对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)O(n) 的时间。因此时间复杂度为 O(n^2)。
//
//	空间复杂度：O(1)。
	public static int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		for(int i =0;i<length-1;i++){
			for(int j=i+1;j<length;j++){
				if(nums[i] + nums[j] == target){
					System.out.println(i);
					System.out.println(j);
					return new int[]{i,j};
				}
			}
		}
		return null;
	}

//	方法2：一遍哈希表
//	事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
//
//	复杂度分析：
//
//	时间复杂度：O(n)O(n)，
//	我们只遍历了包含有 nn 个元素的列表一次。在表中进行的每次查找只花费 O(1)O(1) 的时间。
//
//	空间复杂度：O(n)O(n)，
//	所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 nn 个元素。

	public static int[] twoSumMap(int[] nums, int target) {
		Map<Integer,Integer> cacheMap = new HashMap<>(16);
		for(int i=0;i<nums.length;i++){
			int num = target - nums[i];
			if(cacheMap.containsKey(num)){
				return new int[]{cacheMap.get(num),i};
			}
			cacheMap.put(nums[i],i);
		}
		return null;
	}
	public static void main(String[] args) {

	}
}
