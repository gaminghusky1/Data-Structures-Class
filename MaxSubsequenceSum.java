public class MaxSubsequenceSum {
    public static void main(String[] args) {
        int[] arr = {2, 1, -4, 10, 15, -2, 22, -8, 5};
        int currSum = arr[0];
        int largestSum = currSum;
        for (int i = 1; i < arr.length; i++) {
            currSum += arr[i];
            largestSum = Math.max(largestSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println(largestSum);
    }
}
