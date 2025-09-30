// Brute Force
public class LC_85_Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int b = 1;
                    int right = j + 1;
                    while (right < matrix[0].length && matrix[i][right] == '1') {
                        b++;
                        right++;
                    }

                    for (int difb = 1; difb <= b; difb++) {
                        int h = 1;
                        int down = i + 1;

                        while (down < matrix.length) {
                            boolean flag = true;
                            for (int rightagain = j; rightagain < j + difb; rightagain++) {
                                if (matrix[down][rightagain] != '1') {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                h++;
                                down++;
                            } else {
                                break;
                            }
                        }

                        maxSize = Math.max(maxSize, h * difb);
                    }
                }
            }
        }
        return maxSize;
    }
}
