import java.io.*;
import java.util.ArrayList;

class Revers {

    Revers(String outFileArg) throws IOException {
        int count = 0;
        final int MAXLINETOTEMPFILE = 100_000;
        int numberTempFile = 0;
        String inTempLine;
        BufferedReader inTempFile = null;
        String tempLine;
        BufferedWriter outTempFile = null;
        BufferedReader br1 = new BufferedReader(new FileReader(outFileArg));
        while ((tempLine = br1.readLine()) != null) {
            if (count++ % MAXLINETOTEMPFILE == 0) {
                numberTempFile++;
                try {
                    outTempFile.flush();
                    outTempFile.close();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                outTempFile = new BufferedWriter(new FileWriter("outTempFile-" + numberTempFile + ".txt"));
            }
            outTempFile.write(tempLine + "\n");
        }

        outTempFile.flush();
        outTempFile.close();
        br1.close();
        BufferedWriter outFile = new BufferedWriter(new FileWriter(outFileArg));
        for (int i = numberTempFile; i >= 1; i--) {
            File file = new File("outTempFile-" + i + ".txt");
            inTempFile = new BufferedReader(new FileReader(file));
            ArrayList<String> revers = new ArrayList<>();
            while ((inTempLine = inTempFile.readLine()) != null) {
                revers.add(inTempLine);
            }
            for (int jj = revers.size() - 1; jj >= 0; jj--) {
                outFile.write(revers.get(jj) + "\n");
            }
            inTempFile.close();
            file.delete();
        }
        outFile.flush();
        outFile.close();
    }
}
