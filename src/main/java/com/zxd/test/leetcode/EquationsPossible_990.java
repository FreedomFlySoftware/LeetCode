package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Title: EquationsPossible_990
 * @Description: https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 * @Author xiaodong.zou
 * @Date 2020/6/8 10:11
 */
//990. 等式方程的可满足性
//		给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
//
//		只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
//
//
//
//		示例 1：
//
//		输入：["a==b","b!=a"]
//		输出：false
//		解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
//		示例 2：
//
//		输出：["b==a","a==b"]
//		输入：true
//		解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
//		示例 3：
//
//		输入：["a==b","b==c","a==c"]
//		输出：true
//		示例 4：
//
//		输入：["a==b","b!=c","c==a"]
//		输出：false
//		示例 5：
//
//		输入：["c==c","b==d","x!=z"]
//		输出：true
//
//
//		提示：
//
//		1 <= equations.length <= 500
//		equations[i].length == 4
//		equations[i][0] 和 equations[i][3] 是小写字母
//		equations[i][1] 要么是 '='，要么是 '!'
//		equations[i][2] 是 '='
public class EquationsPossible_990 {

	public static void main(String[] args) {
//		System.out.println(equationsPossible(new String[]{"a==b","b!=a"}));
//		System.out.println(equationsPossible(new String[]{"b==a","a==b"}));
//		System.out.println(equationsPossible(new String[]{"a==b","b==c","a==c"}));
//		System.out.println(equationsPossible(new String[]{"a==b","b!=c","c==a"}));
//		System.out.println(equationsPossible(new String[]{"c==c","b==d","x!=z"}));
//		System.out.println(equationsPossible(new String[]{"a!=a"}));
//		System.out.println(equationsPossible(new String[]{"f==d","b!=e","d!=c","b==c","b!=a","b!=f"}));
//		System.out.println(equationsPossible(new String[]{"a!=i","g==k","k==j","k!=i","c!=e","a!=e","k!=a","a!=g","g!=c"}));
//		System.out.println(equationsPossible(new String[]{"a!=i","a==j","e==a","k==h","i==f","d==j","f==i","k==k","h==e"}));
//		System.out.println(equationsPossible(new String[]{"g==k","j==b","c!=e","i!=k","g==d","k!=j","k!=f","e!=d","d!=b","g==d"}));
//		System.out.println(equationsPossible(new String[]{"a!=i","g==k","k==j","k!=i","c!=e","a!=e","k!=a","a!=g","g!=c"}));
//		System.out.println(equationsPossible(new String[]{"a!=i", "g!=i","a!=e", "a!=g", "g==k","c!=e","g!=a", "g!=c"}));
//		System.out.println(equationsPossible(new String[]{"a!=i","g==k","k==j","k!=i","c!=e","a!=e","k!=a","a!=g","g!=c"}));
		System.out.println(equationsPossible(new String[]{"b==q","g==l","r==a","t==o","t==v","i==b","a==u","e!=j","d!=n","y!=f","h!=b","u!=t","o!=r","k!=m"}));
	}

//	方法一：并查集
//	我们可以将每一个变量看作图中的一个节点，把相等的关系 == 看作是连接两个节点的边，那么由于表示相等关系的等式方程具有传递性，即如果 a==b 和 b==c 成立，则 a==c 也成立。也就是说，所有相等的变量属于同一个连通分量。因此，我们可以使用并查集来维护这种连通分量的关系。
//
//	首先遍历所有的等式，构造并查集。同一个等式中的两个变量属于同一个连通分量，因此将两个变量进行合并。
//
//	然后遍历所有的不等式。同一个不等式中的两个变量不能属于同一个连通分量，因此对两个变量分别查找其所在的连通分量，如果两个变量在同一个连通分量中，则产生矛盾，返回 false。
//
//	如果遍历完所有的不等式没有发现矛盾，则返回 true。
//	具体实现方面，使用一个数组 parent 存储每个变量的连通分量信息，其中的每个元素表示当前变量所在的连通分量的父节点信息，如果父节点是自身，说明该变量为所在的连通分量的根节点。
//	一开始所有变量的父节点都是它们自身。对于合并操作，我们将第一个变量的根节点的父节点指向第二个变量的根节点；对于查找操作，我们沿着当前变量的父节点一路向上查找，直到找到根节点。

	public static boolean equationsPossible(String[] equations) {
		int[] parent = new int[26];
		for (int i = 0; i < 26; i++) {
			parent[i] = i;
		}
		for (String str : equations) {
			if (str.charAt(1) == '=') {
				int index1 = str.charAt(0) - 'a';
				int index2 = str.charAt(3) - 'a';
				union(parent, index1, index2);
			}
		}
		for (String str : equations) {
			if (str.charAt(1) == '!') {
				int index1 = str.charAt(0) - 'a';
				int index2 = str.charAt(3) - 'a';
				if (find(parent, index1) == find(parent, index2)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void union(int[] parent, int index1, int index2) {
		parent[find(parent, index1)] = find(parent, index2);
	}

	public static int find(int[] parent, int index) {
		while (parent[index] != index) {
			parent[index] = parent[parent[index]];
			index = parent[index];
		}
		return index;
	}
}
