

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BHieu
 */
import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement {

    public void showAllWords() {
        dictionary.printList();
    }

    public void dictionaryBasic() {
        System.out.println("-----Nhập lựa chọn của bạn-----");
        System.out.print("1: Thêm từ mới"
                + "\n2: Hiện tất cả từ"
                + "\n3: Thoát\n");
        Scanner scan = new Scanner(System.in);
        String sl = scan.nextLine();
        switch (sl) {
            case "1":
                insertFromCommandline();
                dictionaryBasic();
                break;
            case "2":
                showAllWords();
                dictionaryBasic();
                break;
            case "3":
                System.exit(0);
            default:
                dictionaryBasic();
                break;
        }
        scan.close();
    }

    public void dictionaryAdvanced() {
        insertFromFile();
        boolean isquit = false;
        while (!isquit) {
            System.out.println("-----Nhập lựa chọn của bạn-----");
            System.out.print("1: Hiển thị tất cả "
                    + "\n2: Tra cứu từ điển"
                    + "\n3: Thêm từ "
                    + "\n4: Xóa từ "
                    + "\n5: Sửa từ "
                    + "\n6: Tìm kiếm từ "
                    + "\n7: Xuất dữ liệu ra file "
                    + "\n8: Thoát\n");
            Scanner scan = new Scanner(System.in);
            String sl = scan.nextLine();
            switch (sl) {
                case "1":
                    showAllWords();
                    break;
                case "2":
                    dictionaryLookup();
                    break;
                case "3":
                    insertFromCommandline();
                    break;
                case "4":
                    deleteWord();
                    break;
                case "5":
                    changeWord();
                    break;
                case "6":
                    dictionarySearcher();
                    break;
                case "7":
                    dictionaryExportToFile();
                    break;
                case "8":
                    isquit = true;
                    System.exit(0);

            }
        }
    }


    public void dictionarySearcher() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập từ cần tìm kiếm: ");
        String WordSearch = scan.nextLine();
        for(int i = 0; i < dic.size(); i++){
            dic.get(i).getWord_target().toLowerCase();
            if(dic.get(i).getWord_target().toLowerCase().indexOf(WordSearch) == 0){
                System.out.printf("%-5d", i + 1);
                System.out.printf("|%-20s|%-20s\n", dic.get(i).getWord_target(), dic.get(i).getWord_explain());
            }
        }
    }

    public static void main(String[] args) {
        new DictionaryCommandline().dictionaryAdvanced();
    }
}

