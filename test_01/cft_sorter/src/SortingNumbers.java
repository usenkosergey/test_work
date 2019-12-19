import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

class SortingNumbers {
    void sortingNumbers(BufferedWriter outFile, BufferedReader br1, BufferedReader br2, int revers, String argOutFile) throws IOException {
        String inLine_1 = "";
        String inLine_2 = "";
        Integer inNumber_1 = null;
        Integer inNumber_2 = null;

        for (; ; ) {
            while (inNumber_1 == null && inLine_1 != null) {
                inLine_1 = br1.readLine();
                try {
                    inNumber_1 = Integer.parseInt(inLine_1);
                } catch (NumberFormatException e) {
                    inNumber_1 = null;
                }
            }
            while (inNumber_2 == null && inLine_2 != null) {
                inLine_2 = br2.readLine();
                try {
                    inNumber_2 = Integer.parseInt(inLine_2);
                } catch (NumberFormatException e) {
                    inNumber_2 = null;
                }
            }
            if (inLine_1 == null && inLine_2 == null) break;

            if (inNumber_1 == null && inNumber_2 != null) {
                outFile.write(inNumber_2 + "\n");
                inNumber_2 = null;
            } else if (inNumber_2 == null && inNumber_1 != null) {
                outFile.write(inNumber_1 + "\n");
                inNumber_1 = null;
            } else if ((inNumber_1 != null) && (inNumber_2 != null)) {
                if (inNumber_1 <= inNumber_2) {
                    outFile.write(inNumber_1 + "\n");
                    inNumber_1 = null;
                } else {
                    outFile.write(inNumber_2 + "\n");
                    inNumber_2 = null;
                }
            } else {
                inLine_1 = null;
                inLine_2 = null;
            }
        }
        outFile.flush();
        outFile.close();

        if (revers == 1) {
            Revers reversFile = new Revers(argOutFile);
        }
    }
}
