package com.jhj.algorithm.leetcode;


import java.util.Stack;

public class Leetcode {

//     * Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param areas int整型一维数组
         * @return int整型
         */
        public int maxArea (int[] heights) {
            Stack<Integer> st = new Stack<Integer>();

            // 数组扩容，在头和尾各加入一个元素
            int [] newHeights = new int[heights.length + 2];
            newHeights[0] = 0;
            newHeights[newHeights.length - 1] = 0;
            for (int index = 0; index < heights.length; index++){
                newHeights[index + 1] = heights[index];
            }

            heights = newHeights;

            st.push(0);
            int result = 0;
            // 第一个元素已经入栈，从下标1开始
            for (int i = 1; i < heights.length; i++) {
                // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
                if (heights[i] > heights[st.peek()]) {
                    st.push(i);
                } else if (heights[i] == heights[st.peek()]) {
                    st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                    st.push(i);
                } else {
                    while (heights[i] < heights[st.peek()]) { // 注意是while
                        int mid = st.peek();
                        st.pop();
                        int left = st.peek();
                        int right = i;
                        int w = right - left - 1;
                        int h = heights[mid];
                        result = Math.max(result, w * h);
                    }
                    st.push(i);
                }
            }
            return result;
        }
    }

}
