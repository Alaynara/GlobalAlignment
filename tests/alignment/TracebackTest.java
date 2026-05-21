package alignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TracebackTest {

    @Test
    void testTracebackProducesCorrectAlignment() {
        String s1 = "ACCGTATGCA";
        String s2 = "ACGTCGTA";

        int[][] matrix = ScoreMatrixBuilder.initializeScoreMatrix(s1, s2, -2);
        char[][] pointers = new char[s1.length() + 1][s2.length() + 1];

        ScoreMatrixBuilder.fillScoreMatrix(matrix, pointers, s1, s2, 1, -1, -2);

        String[] aligned = Traceback.traceback(pointers, s1, s2);

        assertEquals("ACCGTATGCA", aligned[0]);
        assertEquals("A-CGT-CGTA", aligned[1]);
    }
}
