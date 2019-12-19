import java.io.*;

public class Loader {
    public static void main(String[] args) throws IOException {
        boolean run = true;
        int runInt = 0;
        int runStr = 0;
        int revers = 0;
        String outFileArg = "";
        BufferedWriter outFile = null;
        BufferedReader br1 = null;
        BufferedReader br2 = null;

        Info info = new Info();

        if (args.length == 0) {
            System.out.println("Не указаны параметры запуска, для справки -help");
        } else if (args.length < 4 & !args[0].equals("-help")) {
            System.out.println("Указаны не все параметры для запуска программы");
        } else if (args.length > 5) {
            System.out.println("Указано слишком много параметров");
        } else if (args[0].equals("-help")) {
            info.helpText();
        } else if (args[1].length() == 2) {

            if (args[0].equals("-d")) {
                revers = 0;
            } else if (args[0].equals("-r")) {
                revers = 1;
            } else {
                System.out.println("Не верно указан первый параметр. {" + args[0] + "}");
                System.out.println("Должно быть -d или -r");
                run = false;
            }

            if (args[1].equals("-i")) {
                runInt = 1;
            } else if (args[1].equals("-s")) {
                runStr = 1;
            } else {
                System.out.println("Не верно указан второй параметр. {" + args[1] + "}");
                System.out.println("Должно быть -i или -s");
                run = false;
            }

            if (args[2].length() >= 5) {
                try {
                    outFile = new BufferedWriter(new FileWriter(args[2]));
                    outFileArg = args[2];
                } catch (IOException e) {
                    System.out.println("Не удается создать файл: " + args[2]);
                    run = false;
                }
            }
            try {
                br1 = new BufferedReader(new FileReader(args[3]));
            } catch (FileNotFoundException e) {
                System.out.println("Не удается прочитать файл: " + args[3]);
                run = false;
            }
            try {
                br2 = new BufferedReader(new FileReader(args[4]));
            } catch (FileNotFoundException e) {
                System.out.println("Не удается прочитать файл: " + args[4]);
                run = false;
            }

        } else if (args[1].length() > 2) {

            if (args[0].equals("-i")) {
                runInt = 1;
            } else if (args[0].equals("-s")) {
                runStr = 1;
            } else {
                System.out.println("Не верно указан параметр входных файлов. {" + args[0] + "}");
                System.out.println("Должно быть -i или -s");
                run = false;
            }

            if (args[1].length() >= 5) {
                try {
                    outFile = new BufferedWriter(new FileWriter(args[1]));
                    outFileArg = args[1];
                } catch (IOException e) {
                    System.out.println("Не удается создать файл: " + args[1]);
                    run = false;
                }
            }
            try {
                br1 = new BufferedReader(new FileReader(args[2]));
            } catch (FileNotFoundException e) {
                System.out.println("Не удается прочитать файл: " + args[2]);
                run = false;
            }
            try {
                br2 = new BufferedReader(new FileReader(args[3]));
            } catch (FileNotFoundException e) {
                System.out.println("Не удается прочитать файл: " + args[3]);
                run = false;
            }
        }

        if (run && runInt == 1) {
            SortingNumbers sortingNumbers = new SortingNumbers();
            sortingNumbers.sortingNumbers(outFile, br1, br2, revers, outFileArg);
        } else if (run && runStr == 1) {
            SortingString sortingString = new SortingString();
            sortingString.sortingString(outFile, br1, br2, revers, outFileArg);
        }

    }
}
