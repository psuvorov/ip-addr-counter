import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Program {

    private static final int byteSize = 256;

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Wrong number of arguments. Usage:\n" +
                    "java -jar ip-addr-counter.jar <full-path-to-file-with-the-list-of-ips>");
            return;
        }


        int[][][][] octs = new int[byteSize][][][];

        try (FileInputStream inputStream = new FileInputStream(args[0]);
             Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8)) {

            while (sc.hasNextLine()) {
                String ip = sc.nextLine();
                addIP(ip, octs);
            }

            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        }

        System.out.println(getNumberOfUniqueIps(octs));
    }

    private static int getNumberOfUniqueIps(int[][][][] octs) {
        int res = 0;

        for (int i = 0; i < byteSize; i++) {
            if (octs[i] == null)
                continue;

            for (int j = 0; j < byteSize; j++) {
                if (octs[i][j] == null)
                    continue;

                for (int k = 0; k < byteSize; k++) {
                    if (octs[i][j][k] == null)
                        continue;

                    for (int l = 0; l < byteSize; l++) {

                        if (octs[i][j][k][l] == 1)
                            res++;
                    }
                }
            }
        }

        return res;
    }

    private static void addIP(String ip, int[][][][] octs) {
        String[] split = ip.split("\\.");
        int oct1V = Integer.parseInt(split[0]);
        int oct2V = Integer.parseInt(split[1]);
        int oct3V = Integer.parseInt(split[2]);
        int oct4V = Integer.parseInt(split[3]);

        if (octs[oct1V] == null) {
            octs[oct1V] = new int[byteSize][][];
        }
        if (octs[oct1V][oct2V] == null) {
            octs[oct1V][oct2V] = new int[byteSize][];
        }
        if (octs[oct1V][oct2V][oct3V] == null) {
            octs[oct1V][oct2V][oct3V] = new int[byteSize];
        }

        octs[oct1V][oct2V][oct3V][oct4V]++;
    }


}
