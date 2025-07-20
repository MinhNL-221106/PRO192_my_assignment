/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myassignment;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AAA
 */
public class Dictionary {

    private Map<String, Word> wordMap;

    public Dictionary() {
        this.wordMap = new HashMap<>();
    }

    public void addWord(Word word) {
        wordMap.put(word.getWord().toLowerCase(), word);
    }

    public String lookupWord(String word) {
        Word found = wordMap.get(word.toLowerCase());
        return found != null ? found.getMeaning() : "Từ không tồn tại trong từ điển.";
    }

    public Map<String, Word> getWordMap() {
        return wordMap;
    }

}
