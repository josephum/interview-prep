import java.util.HashMap;
import java.util.Map;

public class Algo_1 {

//    Question # 1
//    Description :
//    Generate Document
//    Difficulty: Easy Category: Strings
//    You're given a string of available characters and a string representing a document
//    that you need to generate. Write a function that determines if you can generate the
//    document using the available characters. If you can generate the document, your function
//    should return true; otherwise, it should return false. You're only able to generate the
//    document if the frequency of unique characters in the characters string is greater than or
//    equal to the frequency of unique characters in the document string.
//    For example, if you're given characters = "abcabc" and document = "aabbccc" you
//    cannot generate the document because you're missing one c . The document that you need
//    to create may contain any characters, including special characters, capital letters, numbers,
//    and spaces. Note: you can always generate the empty string ( "" ).
//    Sample Input :
//    characters = "!veDJaCyd vaeo perelo xw"
//    document = "Cydeo Java Developer!"
//    Sample Output :
//            true

    public static void main(String[] args) {
        System.out.println("HEllo");

        char[] characters = "!veDJaCyd vaeo perelo xw".toCharArray();
//        String document = "Cydeo Java Developer!";
        String document = "Cydeo Java Developer!";

        System.out.println(histogram(characters).toString());
        System.out.println(histogram(document.toCharArray()).toString());

        System.out.println(canGenerateDocument(characters,document));
    }

    public static boolean canGenerateDocument(char[] chars, String document){

        // The restriction will be the chars in the document parameter, so the best will be to create a histogram
        // of chars as a map, char as key and frequency as value
        // Then make another histogram from characters.
        // At last make a comparison between the two histograms for every value in document
        // if freq(value) in chars is lower than freq(value) in document, then false
        // Other case, then true

        Map<Character,Integer> histogramDocument = histogram(document.toCharArray()); // O(n)
        Map<Character,Integer> histogramChars = histogram(chars); // O(n)
        
        // Comparison
        for (Map.Entry<Character,Integer> entry : histogramDocument.entrySet()) { // O(n)
           Character character = entry.getKey();
           Integer frequency = entry.getValue();

           if (histogramChars.containsKey(character)){
               if (histogramChars.get(character)< frequency){
                   return false;
               }
           } else {
               return false;
           }
        }
        return true;
    }


     public static Map<Character,Integer> histogram(char[] chars){

        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            Character ch = chars[i];
            if (map.containsKey(ch)) {
                Integer freq = map.get(ch);
                map.put(ch, freq+1);
            } else {
                map.put(ch,1); // Initialize the freq
            }
        }
        return map;
    }

}
