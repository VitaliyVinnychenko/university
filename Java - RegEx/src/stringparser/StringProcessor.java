/**
 * Created 02/25/2017 by Vitaliy Vinnichenko (v1.0)
 */

package stringparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    public void pushWord(String word){
        this.map.put(word.toLowerCase(), 0);
    }

    public HashMap<String, Integer> getHashMap(){
        return this.map;
    }

    /**
     * read input string method
     * @return
     * @throws IOException
     */
    public String readInputText() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter text:");
        return bufferedReader.readLine();
    }

    /**
     * find equal words number method
     * @param inputText
     */
    public void processText(String inputText){
        this.map.forEach((key, value) -> {
            Pattern requestedWord = Pattern.compile(key);
            Matcher matcher = requestedWord.matcher(inputText);

            while(matcher.find()){
                this.map.put(key, this.map.get(key) + 1);
            }
        });
    }

    /**
     * decrease sort words by mention number
     */
    public void showSortedMap(){
        ValueComparator vc = new ValueComparator(this.map);
        TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(vc);

        sortedMap.putAll(this.map);
        System.out.println(sortedMap);
    }

    public static void main(String[] args){

        StringProcessor stringProcessor = new StringProcessor();
        String[] wordsArray = {"sAy", "Hello", "world"};
        String text = null;

        for(String word: wordsArray){
            stringProcessor.pushWord(word);
        }

        try {
            text = stringProcessor.readInputText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        text = text.toLowerCase();

        stringProcessor.processText(text);
        stringProcessor.showSortedMap();
    }
}
