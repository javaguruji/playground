package grep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author badrikant.soni
 * Java Program to Implement the Program Used in grep/egrep/fgrep
 * refer : https://www.sanfoundry.com/java-program-implement-program-used-grepegrepfgrep/
 * tutorial : https://www.javatpoint.com/java-regex
 *
 * */
public class GrepCommandImplementation {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to match from file");
        Pattern pattern = Pattern.compile(scanner.next());
        Matcher matcher = pattern.matcher("");
        String property = System.getProperty("user.dir");
        String file = property + "/interview/src/main/java/grep/GrepCommandImplementation.java";
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot read '" + file + "': " + e.getMessage());
        }

        assert br != null;
        while ((line = br.readLine()) != null) {
            matcher.reset(line);
            if (matcher.find()) {
                System.out.println(file + ":" + line);
            }
        }
        br.close();
        scanner.close();
    }
}
