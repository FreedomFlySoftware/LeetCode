package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 * @Author zouxiaodong
 * @Date 2021/02/05 9:21
 */
//1208. 尽可能使字符串相等
//        给你两个长度相同的字符串，s 和 t。
//        将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
//        用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
//        如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
//        如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
//
//        示例 1：
//        输入：s = "abcd", t = "bcdf", cost = 3
//        输出：3
//        解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。

//        示例 2：
//        输入：s = "abcd", t = "cdef", cost = 3
//        输出：1
//        解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。

//        示例 3：
//        输入：s = "abcd", t = "acde", cost = 0
//        输出：1
//        解释：你无法作出任何改动，所以最大长度为 1。
//
//        提示：
//        1 <= s.length, t.length <= 10^5
//        0 <= maxCost <= 10^6
//        s 和 t 都只含小写英文字母
public class EqualSubstring_1208 {

    public static void main(String[] args) {
        EqualSubstring_1208 equalSubstring_1208 = new EqualSubstring_1208();
        System.out.println(equalSubstring_1208.equalSubstring("abcd","bcdf",3));
        System.out.println(equalSubstring_1208.equalSubstring("abcd","cdef",3));
        System.out.println(equalSubstring_1208.equalSubstring("abcd","acde",0));
        System.out.println(equalSubstring_1208.equalSubstring("krrgw","zjxss",19));
        System.out.println(equalSubstring_1208.equalSubstring("krpgjbjjznpzdfy","nxargkbydxmsgby",14));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int cost = 0;
        int result = 0;
        for(int i=0,j=0;i<len && j<len;){
            cost+=Math.abs(Math.abs(t.charAt(j)-s.charAt(j)));
            if(cost>maxCost){
                result = Math.max(result,j-i);
                cost -= Math.abs(Math.abs(t.charAt(i)-s.charAt(i)));
                i++;
            }else{
                result = Math.max(result,j-i+1);
            }
            j++;
        }
        return result;
    }
}
