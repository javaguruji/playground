package grep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author badrikant.soni
 */
public class Solution {

    static List<Match> commentMatches = new ArrayList<Match>();
    public static void main(String args[] ) throws Exception {

        Pattern commentsPattern = Pattern.compile("(/\\\\*[^*]*\\\\*+(?:[^/*][^*]*\\\\*+)*/)", Pattern.MULTILINE | Pattern.DOTALL);
        Pattern stringsPattern = Pattern.compile("(\".*?(?<!\\\\)\")");

        //String text = getTextFromFile("src/my/test/CommentsFun.java");
        String property = System.getProperty("user.dir");
        String file = property + "/interview/src/main/java/grep/file.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String everything = null;
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }

        Matcher commentsMatcher = commentsPattern.matcher(everything);
        while (commentsMatcher.find()) {
            Match match = new Match();
            match.start = commentsMatcher.start();
            match.text = commentsMatcher.group();
            commentMatches.add(match);
        }

        List<Match> commentsToRemove = new ArrayList<Match>();

        Matcher stringsMatcher = stringsPattern.matcher(everything);
        while (stringsMatcher.find()) {
            for (Match comment : commentMatches) {
                if (comment.start > stringsMatcher.start() && comment.start < stringsMatcher.end())
                    commentsToRemove.add(comment);
            }
        }
        for (Match comment : commentsToRemove)
            commentMatches.remove(comment);

        for (Match comment : commentMatches)
            everything = everything.replace(comment.text, " ");

        System.out.println(everything);
    }


    //Single-line

    // "String? Nope"

    /*
     * "This  is not String either"
     */

    //Complex */
    ///More complex/

    /*Single line, but */

    String moreFun = " /* comment? doubt that */";

    String evenMoreFun = " // comment? doubt that ";

    static class Match {
        int start;
        String text;
    }
}
