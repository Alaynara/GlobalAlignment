package alignment;

public class ScoreMatrixBuilder {

    public static int[][] initializeScoreMatrix(String s1, String s2, int gapScore) {
        int rows = s1.length() + 1;
        int cols = s2.length() + 1;

        int[][] matrix = new int[rows][cols];

        for (int i = 1; i < rows; i++) {
            matrix[i][0] = matrix[i - 1][0] + gapScore;
        }
        for (int j = 1; j < cols; j++) {
            matrix[0][j] = matrix[0][j - 1] + gapScore;
        }

        return matrix;
    }

    public static void fillScoreMatrix(
            int[][] scoreMatrix,
            char[][] pointerMatrix,
            String s1,
            String s2,
            int matchScore,
            int mismatchScore,
            int gapScore
    ) {
        for (int i = 1; i < scoreMatrix.length; i++) {
            for (int j = 1; j < scoreMatrix[0].length; j++) {

                int diag = scoreMatrix[i - 1][j - 1] +
                        (s1.charAt(i - 1) == s2.charAt(j - 1) ? matchScore : mismatchScore);

                int up = scoreMatrix[i - 1][j] + gapScore;
                int left = scoreMatrix[i][j - 1] + gapScore;

                int max = Math.max(diag, Math.max(up, left));
                scoreMatrix[i][j] = max;

                if (max == diag) pointerMatrix[i][j] = 'D';
                else if (max == up) pointerMatrix[i][j] = 'U';
                else pointerMatrix[i][j] = 'L';
            }
        }
    }
}
