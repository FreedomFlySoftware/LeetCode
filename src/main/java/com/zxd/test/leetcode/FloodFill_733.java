package com.zxd.test.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName FloodFill_733
 * @Description https://leetcode-cn.com/problems/flood-fill/
 * @Author xiaodong.zou
 * @Date 2020/8/16 20:43
 * @Version 1.0
 */
//733. 图像渲染
//        有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
//
//        给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
//
//        为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
//
//        最后返回经过上色渲染后的图像。
//
//        示例 1:
//
//        输入:
//        image = [[1,1,1],[1,1,0],[1,0,1]]
//        sr = 1, sc = 1, newColor = 2
//        输出: [[2,2,2],[2,2,0],[2,0,1]]
//        解析:
//        在图像的正中间，(坐标(sr,sc)=(1,1)),
//        在路径上所有符合条件的像素点的颜色都被更改成2。
//        注意，右下角的像素没有更改为2，
//        因为它不是在上下左右四个方向上与初始点相连的像素点。
//        注意:
//
//        image 和 image[0] 的长度在范围 [1, 50] 内。
//        给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
//        image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
public class FloodFill_733 {

    private Set<String> computedEleSet = new HashSet<>(16);

    public static void main(String[] args) {
        int[] a1 = new int[]{1,1,1};
        int[] a2 = new int[]{1,1,0};
        int[] a3 = new int[]{1,0,1};
        int[][] image = new int[][]{a1,a2,a3};
        FloodFill_733 floodFill = new FloodFill_733();
        floodFill.floodFill(image,1,1,2);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Set<String> colorEleSet = new HashSet<>(16);
        dfs(image,sr,sc,image[sr][sc],colorEleSet);
        if(!colorEleSet.isEmpty()){
            for(String ele:colorEleSet){
                String[] rc = ele.split("_");
                image[Integer.parseInt(rc[0])][Integer.parseInt(rc[1])] = newColor;
            }
        }
        return image;
    }

    private void dfs(int[][] image,int r,int c,int val,Set<String> colorEleSet){
        String ele = r+"_"+c;
        if(computedEleSet.contains(ele)){
            return;
        }
        computedEleSet.add(ele);
        if(image[r][c] == val){
            colorEleSet.add(ele);
            int row = image.length;
            int col = image[0].length;
            if(r-1>=0 && image[r-1][c] == val){
                dfs(image,r-1,c,val,colorEleSet);
            }
            if (c -1 >=0 && image[r][c-1] == val){
                dfs(image,r,c-1,val,colorEleSet);
            }
            if (c+1<col && image[r][c+1] == val){
                dfs(image,r,c+1,val,colorEleSet);
            }
            if(r+1<row && image[r+1][c] == val){
                dfs(image,r+1,c,val,colorEleSet);
            }
        }
    }
}
