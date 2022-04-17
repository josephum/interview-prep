import java.util.Arrays;

public class Algo_3 {
    public static void main(String[] args) {
//        JD A2 Batch Algo Question Description:
//        Median of Two Sorted Arrays Difficulty: Hard Category: Array
//        Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//        The overall run time complexity should be O(log (m+n)).
//                Example 1:
//        Input: nums1 = [1,3], nums2 = [2]
//        Output: 2.00000
//        Explanation: merged array = [1,2,3] and median is 2.
//        Example 2:
//        Input: nums1 = [1,2], nums2 = [3,4]
//        Output: 2.50000
//        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//                Example 3:
//        Input: nums1 = [0,0], nums2 = [0,0] Output: 0.00000
//        Example 4:
//        Input: nums1 = [], nums2 = [1] Output: 1.00000
//        Example 5:
//        Input: nums1 = [2], nums2 = [] Output: 2.00000
//        Constraints:
//        nums1.length == m nums2.length == n 0 <= m <= 1000
//        0 <= n <= 1000
//        1 <= m + n <= 2000
//                -106 <= nums1[i], nums2[i] <= 106

//        int[] nums1 = {1,7};
//        int[] nums2 = {2,5};

        int[] nums1 = {0,2,7};
        int[] nums2 = {1,3};

        System.out.println(medianOfTwoSortedArrays(nums1,nums2));

    }


    public static double medianOfTwoSortedArrays(int[] num1, int[] num2){
        int size = num1.length+num2.length;
        int[] mergedArray = new int[num1.length+num2.length];

        for (int i = 0; i < num1.length; i++) {
            mergedArray[i]=num1[i];
        }
        for (int i = 0; i < num2.length; i++) {
            mergedArray[num1.length+i]=num2[i];
        }

        Arrays.sort(mergedArray);

        System.out.println(Arrays.toString(mergedArray));

        return median(mergedArray);
    }

    public static double median(int[] sortedArray){

        if (sortedArray.length%2==0){
            int middle_low=sortedArray[sortedArray.length/2-1];
            int middle_high=sortedArray[sortedArray.length/2];
             return (middle_low+middle_high)/2.0;
        }
        else return sortedArray[sortedArray.length/2];

    }

}


