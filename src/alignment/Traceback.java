package alignment;

public class Traceback {

    public static String[] traceback(char[][] pointerMatrix, String s1, String s2) {
        StringBuilder a1 = new StringBuilder();
        StringBuilder a2 = new StringBuilder();

        int i = s1.length();
        int j = s2.length();

        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && pointerMatrix[i][j] == 'D') {
                a1.append(s1.charAt(i - 1));
                a2.append(s2.charAt(j - 1));
                i--; j--;
            } else if (i > 0 && pointerMatrix[i][j] == 'U') {
                a1.append(s1.charAt(i - 1));
                a2.append('-');
                i--;
            } else {
                a1.append('-');
                a2.append(s2.charAt(j - 1));
                j--;
            }
        }

        return new String[]{
                a1.reverse().toString(),
                a2.reverse().toString()
        };
    }
}
