import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(String.join(",", intupNumber(input)));
    }

    private static TreeSet intupNumber(String number) {
        TreeSet<String> answer = new TreeSet<String>();
        String emptyList = "";
        char[] arrayOne = number.toCharArray();
        for (int i = arrayOne.length - 1; i >= 0; i--) {
            char[] chars = charOne(arrayOne[i]);
            ArrayList<String> arrayList = new ArrayList<>(answer);
            answer.clear();
            for (char aChar : chars) {
                int iii = 0;
                do {
                    if (!arrayList.isEmpty()) emptyList = arrayList.get(iii);
                    answer.add(aChar + emptyList);
                    iii++;
                } while (iii < arrayList.size());
            }
        }
        return answer;
    }
    private static char[] charOne(char inputChar) {
        ArrayList<char[]> listChar = new ArrayList<>();
        listChar.add(new char[]{'0', '8'});
        listChar.add(new char[]{'1', '2', '4'});
        listChar.add(new char[]{'2', '1', '3', '5'});
        listChar.add(new char[]{'3', '2', '6'});
        listChar.add(new char[]{'4', '1', '5', '7'});
        listChar.add(new char[]{'5', '2', '4', '6', '8'});
        listChar.add(new char[]{'6', '3', '5', '9'});
        listChar.add(new char[]{'7', '4', '8'});
        listChar.add(new char[]{'8', '5', '7', '9', '0'});
        listChar.add(new char[]{'9', '6', '8'});
        return listChar.get(Integer.parseInt(String.valueOf(inputChar)));
    }
}
