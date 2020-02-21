package string;

/**
 * @author badrikant.soni
 */
public class CountVowelsAndConsonants {

    public static void main(String[] args) {

        String str = "This is a really simple sentence";
        int[] counts = findCounts(str);
        for(int count : counts){
            System.out.println(count);
        }

    }
    private static int[] findCounts(String input){

        // convert each character in the string to lower case to reduce the comparison
        // if any character in the string matches with vowels(a, e, i, o, u), increment the count by 1
        // if any character in the string lies between a & z except vowels, increment the count by 1;.
        // return both count.

        String lowerCaseString = input.toLowerCase();
        char[] chars = lowerCaseString.toCharArray();
        int vowelsCount = 0;
        int consonantsCount = 0;
        int[] result = new int[2];
        for(char ch : chars){
            if(ch == 'a' || ch == 'e' || ch =='i' || ch == 'o' || ch == 'u'){
                vowelsCount++;
            }else if(ch > 'a' && ch < 'z'){  // eliminate the space character
                consonantsCount++;
            }
        }
        result[0]=vowelsCount;
        result[1]=consonantsCount;
        return result;
    }
}
