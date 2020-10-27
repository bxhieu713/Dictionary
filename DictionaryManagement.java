import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();
    ArrayList<Word> dic = new ArrayList<Word>();

    public void insertFromCommandline() {
        Scanner scan = new Scanner(System.in);
        Word word = new Word();
        System.out.println("Nhập từ: ");
        String newTarget = scan.nextLine();

        System.out.println("Nhập nghĩa: ");
        String newExplain = scan.nextLine();

        word.setWord_target(newTarget);
        word.setWord_explain(newExplain);

        dic.add(word);
        dictionary.getList(dic);
    }

    /**
     * @param
     */
    public void insertFromFile() {

        try {
            File file = new File("D:\\Hoc\\Java\\BTL1\\src\\dictionaries.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] str = line.split("\t");
                String target = str[0].trim();
                String explain = str[1].trim();
                Word word = new Word(target, explain);
                dic.add(word);
            }
            dictionary.getList(dic);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dictionaryLookup() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập từ cần tra cứu: ");
        String wordLookup = scan.nextLine();
        boolean check = true;
        for (int i = 0; i < dic.size(); i++) {
            if (wordLookup.equals(dic.get(i).getWord_target())) {
                System.out.printf("%-5d", i + 1);
                System.out.printf("|%-20s|%-20s\n", dic.get(i).getWord_target(), dic.get(i).getWord_explain());
                check = false;
            }
        }
        if (check) {
            System.out.println("Not found in dictionary");
        }
    }

    public void deleteWord() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập từ cần xóa: ");
        String WordDelete = scan.nextLine();
        for (int i = 0; i < dic.size(); i++) {
            if (WordDelete.equals(dic.get(i).getWord_target())) {
                dictionary.removeWord(i);
            }
        }
    }

    public void changeWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập từ cần sửa");
        String WordChange = scan.nextLine();
        System.out.println("Thay bằng: ");
        String WordChangeTarget = scan.nextLine();
        System.out.println("Thay thế nghĩa bằng: ");
        String WordChangeExplain = scan.nextLine();
        Word word = new Word(WordChangeTarget, WordChangeExplain);
        for (int i = 0; i < dic.size(); i++) {
            if (WordChange.equals(dic.get(i).getWord_target())) {
                dictionary.changeWord(i, word);
            }
        }
    }

    public void dictionaryExportToFile() {
        try {
            FileWriter fw = new FileWriter("D:\\Hoc\\Java\\BTL1\\src\\dictionary.txt");
            for (int i = 0; i < dic.size(); i++) {
                fw.write('\n' + dic.get(i).getWord_target() + '\t' + dic.get(i).getWord_explain());
            }
            fw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


}
