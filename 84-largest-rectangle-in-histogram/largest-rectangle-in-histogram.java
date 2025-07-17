class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = pse(heights);  
        int[] right = nse(heights); 
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public int[] nse(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? n : stack.peek(); 
            stack.push(i);
        }
        return res;
    }
    public int[] pse(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek(); 
            stack.push(i);
        }

        return res;
    }
}
