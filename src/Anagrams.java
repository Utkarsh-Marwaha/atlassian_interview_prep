import java.util.Arrays;

public class Anagrams {

    /**
     *
     * @param input an array of strings
     * @return array of strings which features all strings barring the ones which are anagrams of the first element
     */
    public static String[] funWithAnagrams(String[] input){

        if (input.length <=1 ){
            return input;
        }


        // set the reference string at the first element of the array
        int ref = 0;
        String reference= null;

        // scan through all elements to the right of the reference string and check if they are an anagram to the reference string
        while (ref != input.length -1 ){

            if (input[ref]!=null)
                reference = input[ref];

            for (int i = ref+1; i < input.length; i++){
                if (input[i]!=null && areAnagram(reference, input[i])){
                    input[i] = null;
                }
            }
            ref++;
        }


        // remove the null values from the input array
        input = Arrays.stream(input)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);

        // sort the array in ascending order
        Arrays.sort(input);

        return input;
    }

    private static boolean areAnagram(String str1, String str2) {

        // idea is to sort both strings and the evaluate them for equality

        char [] charStr1 = str1.toCharArray();
        char [] charStr2 = str2.toCharArray();

        int l1= str1.length();
        int l2 = str2.length();

        // if the lengths of the two strings does not match then they cannot be anagrams of each other
        if (l1!=l2){
            return false;
        }

        // sort both strings
        Arrays.sort(charStr1);
        Arrays.sort(charStr2);

        // compare the two arrays
        return Arrays.equals(charStr1, charStr2);
    }

    public static void main(String[] args) {

//        String [] input = {"code", "doce", "ecod", "framer", "frame"};

        String [] input = {"code", "aaagmnrs", "anagrams", "doce"};

        input = funWithAnagrams(input);

        for (String s: input){
            System.out.println(s);
        }
    }
}
