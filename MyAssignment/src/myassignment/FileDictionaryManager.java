/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myassignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author AAA
 */
public abstract class FileDictionaryManager implements DictionaryManager {

    private Dictionary dictionary;
    private String filePath;

    public FileDictionaryManager(String filePath) {
        this.dictionary = new Dictionary();
        this.filePath = filePath;
        loadDictionaryFromFile();
    }

    @Override
    public void addWord(String word, String meaning) {
        dictionary.addWord(new Word(word, meaning));
        saveDictionaryToFile();
    }

    @Override
    public String lookupWord(String word) {
        return dictionary.lookupWord(word);
    }

    private void loadDictionaryFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    dictionary.addWord(new Word(parts[0].trim(), parts[1].trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc tệp từ điển: " + e.getMessage());
        }
    }

    private void saveDictionaryToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Word word : dictionary.getWordMap().values()) {
                writer.write(word.getWord() + ":" + word.getMeaning());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Không thể lưu tệp từ điển: " + e.getMessage());
        }
    }

}
