import java.util.ArrayList;
import java.util.List;

public class Program {

    private static final int byteSize = 256;

    public static void main(String[] args) {

        int[][][][] octs = new int[byteSize][][][];

        addIP("1.1.1.1", octs);
        addIP("1.1.1.2", octs);
        addIP("1.1.1.3", octs);

        addIP("11.6.1.1", octs);
        addIP("11.6.1.1", octs);
        addIP("12.6.1.1", octs);
        addIP("13.6.1.1", octs);

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

        System.out.println(res);
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
