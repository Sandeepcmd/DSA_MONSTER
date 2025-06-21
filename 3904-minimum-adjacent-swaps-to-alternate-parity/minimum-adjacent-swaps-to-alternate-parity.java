class Solution {
   public int minSwaps(int[] nums) {
        List<Integer> evenIdx = new ArrayList<>();
        List<Integer> oddIdx = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) evenIdx.add(i);
            else oddIdx.add(i);
        }

        int evenCount = evenIdx.size();
        int oddCount = oddIdx.size();

        if (Math.abs(evenCount - oddCount) > 1) return -1;

        int ans = Integer.MAX_VALUE;

        if (evenCount >= oddCount) {
            int swaps = 0;
            for (int i = 0; i < evenIdx.size(); i++) {
                swaps += Math.abs(evenIdx.get(i) - 2 * i);
            }
            ans = Math.min(ans, swaps);
        }

        if (oddCount >= evenCount) {
            int swaps = 0;
            for (int i = 0; i < oddIdx.size(); i++) {
                swaps += Math.abs(oddIdx.get(i) - 2 * i);
            }
            ans = Math.min(ans, swaps);
        }

        return ans;
    }
}