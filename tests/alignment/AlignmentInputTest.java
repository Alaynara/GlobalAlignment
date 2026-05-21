package alignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlignmentInputTest {

    @Test
    void testInputStoresValuesCorrectly() {
        AlignmentInput input = new AlignmentInput(
                "ACCGTATGCA",
                "ACGTCGTA",
                1,
                -1,
                -2
        );

        assertEquals("ACCGTATGCA", input.getSeq1());
        assertEquals("ACGTCGTA", input.getSeq2());
        assertEquals(1, input.getMatch());
        assertEquals(-1, input.getMismatch());
        assertEquals(-2, input.getGap());
    }
}
