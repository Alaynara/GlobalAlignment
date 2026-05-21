package alignment;

import java.io.*;

public class GlobalAlignment {

    private static int readScoreLine(BufferedReader reader) throws IOException {
        String[] parts = reader.readLine().split(" ");
        return Integer.parseInt(parts[1]);
    }

    private static AlignmentInput readInputStrings(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        AlignmentInput input = new AlignmentInput();

        try {
            input.s1 = reader.readLine();
            input.s2 = reader.readLine();
            input.matchScore = readScoreLine(reader);
            input.mismatchScore = readScoreLine(reader);
            input.gapScore = readScoreLine(reader);
            return input;
        } finally {
            reader.close();
        }
    }

    private static void writeOutput(String filename, int score, String a1, String a2) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(score);
            out.println(a1);
            out.println(a2);
        } catch (IOException e) {
            System.out.println("Error writing output: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            AlignmentInput input = readInputStrings("data/input.txt");

            if (input.s1.isEmpty() || input.s2.isEmpty()) {
                int[][] matrix = ScoreMatrixBuilder.initializeScoreMatrix(
                        input.s1, input.s2, input.gapScore
                );

                int score = matrix[input.s1.length()][input.s2.length()];
                String a1 = input.s1.isEmpty() ? "-".repeat(input.s2.length()) : input.s1;
                String a2 = input.s2.isEmpty() ? "-".repeat(input.s1.length()) : input.s2;

                writeOutput("data/output.txt", score, a1, a2);
                return;
            }

            int[][] scoreMatrix = ScoreMatrixBuilder.initializeScoreMatrix(
                    input.s1, input.s2, input.gapScore
            );

            char[][] pointerMatrix = new char[input.s1.length() + 1][input.s2.length() + 1];

            ScoreMatrixBuilder.fillScoreMatrix(
                    scoreMatrix, pointerMatrix,
                    input.s1, input.s2,
                    input.matchScore, input.mismatchScore, input.gapScore
            );

            String[] aligned = Traceback.traceback(pointerMatrix, input.s1, input.s2);
            int optimalScore = scoreMatrix[input.s1.length()][input.s2.length()];

            writeOutput("data/output.txt", optimalScore, aligned[0], aligned[1]);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
