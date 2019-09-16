public class MaxDifference {

    /**
     * Given an array of integers, return the maximum difference of any pair of numbers such that the
     * larger integer in the pair occurs at a higher index (in the array) than the smaller integer. Return
     * -1 if there is not a pair that satisfies the condition.
     */
    private static int maxDifference(int [] input){

        // initialize the max difference between the integer pair as -1
        int maxDiff = -1;

        // cycle through all the elements of the array
        for (int i = 0; i < input.length; i++){

            int first = input[i];

            // for each element, look through all elements to it right
            for (int j = i+1; j < input.length; j++){

                int second = input[j];

                if (second > first && second - first >= maxDiff){

                    // update the max difference in case we find a larger difference between two integers
                    maxDiff = second - first;
                }
            }
        }

        // this shall -1 if no update was made
        return maxDiff;
    }

    public static void main(String[] args) {

//        int [] input = {7, 1, 2, 5}; // output 4
        int [] input = {2, 3, 10, 2, 4, 8, 1}; // output 8

        System.out.println(maxDifference(input));
    }
}
