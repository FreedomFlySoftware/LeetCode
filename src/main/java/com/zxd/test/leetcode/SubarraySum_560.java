package com.zxd.test.leetcode;

/**
 * @Title: SubarraySum_560
 * @Description: https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @Author xiaodong.zou
 * @Date 2020/5/15 10:03
 */
//560. 和为K的子数组
//		给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
//		示例 1 :
//
//		输入:nums = [1,1,1], k = 2
//		输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
//		说明 :
//
//		数组的长度为 [1, 20,000]。
//		数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
public class SubarraySum_560 {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[]{1,2,3,4,5,6,7,1,23,21,3,1,2,1,1,1,1,1,12,2,3,2,3,2,2},6));
	}

	public static int subarraySum(int[] nums, int k) {
		int result = 0;
		int temp = k;
		int length = nums.length;
		for(int i=0;i<length;i++){
			temp = k;
			for (int j=i;j<length;j++){
				temp -= nums[j];
				if(temp == 0){
					result++;
					System.out.println("i="+i+",j="+j);
				}
			}
		}
		return result;
	}

	//    回溯算法的框架：
	//
	//    result = []
	//    def backtrack(路径, 选择列表):
	//        if 满足结束条件:
	//            result.add(路径)
	//            return
	//
	//        for 选择 in 选择列表:
	//            做选择
	//            backtrack(路径, 选择列表)
	//            撤销选择
}