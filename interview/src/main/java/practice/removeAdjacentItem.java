package practice;

/**
 * @author badrikant.soni
 */
public class removeAdjacentItem {

    public static void main(String[] args) {

        String input = "zzazbaadee";
        // o/p = zazbade
        char[] chars1 = removeAdjacent(input.toCharArray());
        for(char ch : chars1){
            System.out.print(ch);
        }
    }

    // time complexity : O(n)
    // space complexity : O(1)
    private static char[] removeAdjacent(char[] chars) {

        StringBuilder stringBuilder = new StringBuilder(chars.length);
        System.out.println(chars.length);
        for(int i = 0; i < chars.length-1; i++) {
            if (chars[i] != chars[i+1]) {
                stringBuilder.append(chars[i]);
            }
        }
        // I added this because if last two elements are same, then above loop will not add last item.
        // last item loop se bahar ho ja rha hai kyuki last two element ko compare karne se woh if ke ander nahi jayega, isliye use add karna padega ending me
        stringBuilder.append(chars[chars.length-1]);
        return stringBuilder.toString().toCharArray();
    }
}
