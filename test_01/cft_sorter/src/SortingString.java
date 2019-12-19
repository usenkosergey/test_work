import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class SortingString {
    void sortingString(BufferedWriter outFile, BufferedReader br1, BufferedReader br2, int revers, String argOutFile) throws IOException {
        String inLine_1 = null;
        String inLine_2 = null;

        for (; ; ) {
            if (inLine_1 == null) inLine_1 = br1.readLine();
            if (inLine_2 == null) inLine_2 = br2.readLine();
            if (inLine_1 == null && inLine_2 == null) break;

            if (inLine_1 == null && inLine_2 != null) {
                outFile.write(inLine_2 + "\n");
                inLine_2 = null;
            } else if (inLine_1 != null && inLine_2 == null) {
                outFile.write(inLine_1 + "\n");
                inLine_1 = null;
            } else if (inLine_1 != null && inLine_2 != null) {
                if (inLine_1.compareTo(inLine_2) == 0) {
                    outFile.write(inLine_1 + "\n");
                    inLine_1 = null;
                } else if (inLine_1.compareTo(inLine_2) < 0) {
                    outFile.write(inLine_1 + "\n");
                    inLine_1 = null;
                } else {
                    outFile.write(inLine_2 + "\n");
                    inLine_2 = null;
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
