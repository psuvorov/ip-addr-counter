import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

//        int byteSize = 256;
        int byteSize = 16;

        int[][][][] octs = new int[byteSize][byteSize][byteSize][byteSize];

        addIP("1.1.1.1", octs);
        addIP("1.1.1.2", octs);
        addIP("1.1.1.3", octs);

        addIP("11.6.1.1", octs);
        addIP("11.6.1.1", octs);
        addIP("12.6.1.1", octs);
        addIP("13.6.1.1", octs);

        int res = 0;

        for (int i = 0; i < byteSize; i++) {
            for (int j = 0; j < byteSize; j++) {
                for (int k = 0; k < byteSize; k++) {
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

        octs[oct1V][oct2V][oct3V][oct4V]++;
    }


}
