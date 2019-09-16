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

        // grab the first string in the array
        String reference = input[0];

        // cycle through all elements of the array starting from the second one
        // and check if they are anagrams of the first element a.k.a the reference string

        for (int i = 1; i < input.length; i++){
            if (areAnagram(reference, input[i])){
                input[i] = null;
            }
        }

        input = Arrays.stream(input)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);

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

    }

}
