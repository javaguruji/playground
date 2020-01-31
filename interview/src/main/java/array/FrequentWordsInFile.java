package array;

import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author badrikant.soni
 * https://algorithmsandme.com/most-frequent-words-in-file/
 */
class FrequentWordsInFile {

    public static HashMap<String, Integer> readFile(String fileName)
            throws IOException {
        HashMap<String, Integer> wordMap = new HashMap<>();

        Path path = Paths.get(fileName);
        try (Scanner scanner =  new Scanner(path)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(wordMap.containsKey(line)) {
                    wordMap.put(line, wordMap.get(line) + 1);
                }
                else{
                    wordMap.put(line, 1);
                }
            }
        }
        return wordMap;
    }

    public static ArrayList<String> mostFrequentWords(String fileName, int n){
        ArrayList<String> topWords = new ArrayList<>();

        try {
            HashMap<String, Integer> wordMap = readFile(fileName);
            PriorityQueue<Pair<String, Integer>> pq =
                    new PriorityQueue<>(n, (x, y) -> x.getValue().compareTo(y.getValue()));

            int i = 0;
            Iterator it = wordMap.entrySet().iterator();
            /*
                Get first n words on heap
            */
            while(it.hasNext()){
                if(i == n) break;
                HashMap.Entry<String, Integer> entry =
                        (HashMap.Entry<String, Integer>)it.next();
                pq.add(new Pair<>(entry.getKey(), entry.getValue()));
                it.remove();
                i++;
            }

            /*
                Check all other words, if anyone more than least
                remove the least and add the new word.
            */
            for (String key : wordMap.keySet()){
                if(pq.peek().getValue() < wordMap.get(key)){
                    pq.poll();
                    pq.add(new Pair<>(key, wordMap.get(key)));
                }
            }
            while(!pq.isEmpty()){
                topWords.add(pq.poll().getKey());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return topWords;
    }

    public static void main(String[] args){
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + "/interview/src/main/java/array/frequentWords.txt";
        System.out.println(mostFrequentWords(filePath, 3));
    }
}
