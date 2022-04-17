import java.util.*;

public class Algo_2 {

//    Question # 2
//    Description:
//    Array of Products
//    Difficulty: Medium Category: Array
//    Write a function that takes in a non-empty array of integers and returns an array of the same length, where each element in the output array is equal to the product of every other number in the input array. In other words, the value at output[i] is equal to the product of every number in the input array other than input[i] . Note that you're expected to solve this problem without using division.
//    Sample Input array = [5, 1, 4, 2] Sample Output [8, 40, 10, 20]
//// 8 is equal to 1 x 4 x 2
//// 40 is equal to 5 x 4 x 2
//// 10 is equal to 5 x 1 x 2
//// 20 is equal to 5 x 1 x 4
//    Directions :
//             Solve the problem on your own.
//             No group effort.
//             If possible, provide more than one solution/strategy.
//             Different approaches will be great for discussion.
//             If you are stuck no problem. Student will experience the same.
//             Do not google it. Try to build your own solution. It might be ugly no worries.
//             We will discuss it on 27th October 2021 09:30 EST.

    public static void main(String[] args) {
        int[] input = {5, 1, 4, 2};
        System.out.println(Arrays.toString(input));
        System.out.println("Brute:");
        System.out.println();
        System.out.println(Arrays.toString(arrayOfProductsBrute(input)));
        System.out.println("Optimized:");
        System.out.println();
        System.out.println(Arrays.toString(arrayOfProductsOptimized(input)));




    }


    public static int[] arrayOfProductsBrute(int[] input){
        int[] output = new int[input.length];

        for (int i = 0; i < input.length; i++) { // O(n^2)
            output[i]=1;
            for (int j = 0; j < input.length; j++) {
                if (i!=j){
                    output[i] = output[i] * input[j];
                }
            }
        }
        return output;
    }

    public static int[] arrayOfProductsOptimized(int[] array){

        try{
            if (array.length<1||array==null){
                throw new IllegalArgumentException("Argument should have one element at least");
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            System.exit(-1);
        }

        int[] product = new int[array.length];

        int left = 1;

        for (int i = 0; i < array.length; i++) {
            product[i]=left;
            left*=array[i];
        }
//        System.out.println(Arrays.toString(array));

        int right = 1;
        for (int i = array.length-1; i >= 0; i--) {
            product[i] *= right;
            right*= array[i];
        }
//        System.out.println(Arrays.toString(product));

        return product; // O(n)+O(n)=O(n)
    }



}
