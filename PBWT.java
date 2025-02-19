import java.util.*;

public class PBWT {
    
    // Algorithm 1: Build Prefix Array
    public static void buildPrefixArray(int[][] sequences, int[][] prefixArray) {
        int M = sequences.length;
        int N = sequences[0].length;

        for (int k = 0; k < N; k++) {
            Integer[] indices = new Integer[M];
            for (int i = 0; i < M; i++) {
                indices[i] = i;
            }
            final int currentK = k;
            System.out.println(sequences);
            Arrays.sort(indices, (a, b) -> {
                for (int j = currentK; j >= 0; j--) {
                    if (sequences[a][j] != sequences[b][j]) {
                        return sequences[a][j] - sequences[b][j];
                    }
                }
                return 0;
            });
            System.out.println(sequences);
            for (int i = 0; i < M; i++) {
                prefixArray[k][i] = indices[i];
            }
        }
    }



    public static void main(String[] args) {
        int[][] sequences = {
            {0, 1, 0, 1, 1},
            {1, 0, 1, 1, 0},
            {0, 0, 1, 0, 1},
            {1, 1, 0, 0, 0}
        };
        int M = sequences.length;
        int N = sequences[0].length;
        int[][] prefixArray = new int[N][M];
        buildPrefixArray(sequences, prefixArray);

    }
}
