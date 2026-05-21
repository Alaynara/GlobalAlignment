package alignment;

public class AlignmentInput {
    public String s1;
    public String s2;
    public int matchScore;
    public int mismatchScore;
    public int gapScore;

    public AlignmentInput() {}

    public AlignmentInput(String s1, String s2, int matchScore, int mismatchScore, int gapScore) {
        this.s1 = s1;
        this.s2 = s2;
        this.matchScore = matchScore;
        this.mismatchScore = mismatchScore;
        this.gapScore = gapScore;
    }

    public String getSeq1() { return s1; }
    public String getSeq2() { return s2; }
    public int getMatch() { return matchScore; }
    public int getMismatch() { return mismatchScore; }
    public int getGap() { return gapScore; }
}
