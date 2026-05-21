package alignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScoreMatrixBuilderTest {

    @Test
    void testMatrixInitialization() {
        int[][] matrix = ScoreMatrixBuilder.initializeScoreMatrix("A", "A", -2);

        assertEquals(0, matrix[0][0]);
        assertEquals(-2, matrix[1][0]);
        assertEquals(-2, matrix[0][1]);
    }

    @Test
    void testDiagonalMatchScore() {
        int[][] matrix = ScoreMatrixBuilder.initializeScoreMatrix("A", "A", -2);
        char[][] pointers = new char[2][2];

        ScoreMatrixBuilder.fillScoreMatrix(matrix, pointers, "A", "A", 1, -1, -2);

        assertEquals(1, matrix[1][1]);
        assertEquals('D', pointers[1][1]);
    }
}
