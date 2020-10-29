
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BHieu
 */
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    public ArrayList<Word> dictionary = new ArrayList<Word>();

    public Dictionary() {
    }

    public void addWord(Word word) {
        this.dictionary.add(word);
    }

    public void addWord(int index, Word word) {
        this.dictionary.add(index, word);
    }

    public Word getWord(int i) {
        return dictionary.get(i);
    }

    public void removeWord(int i) {
        this.dictionary.remove(i);
    }

    public void changeWord(int i, Word word) {
        this.dictionary.remove(i);
        this.addWord(i, word);
    }

    public void getList(ArrayList<Word> _list) {
        this.dictionary = _list;
    }

    public void printList() {
        System.out.printf("%-5s|%-20s|%-20s\n", "No", "English", "Vietnamese");
        for (int i = 0; i < dictionary.size(); i++) {
            System.out.printf("%-5d", i + 1);
            dictionary.get(i).printWord();
        }
    }

    
}

