import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/21 12:17
 */
public class LeetCode51 {

    List<String> path = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    boolean[][] chessboard;

    // 判断当前位置是否合法
    private boolean isValid(int row, int index, int n) {
        // 列没有
        for (int i = 0; i < row; i++) {
            if (chessboard[i][index]) {
                return false;
            }
        }

        // 斜着
        int count = 1;
        for (int i = row - 1; i >= 0; i--) {
            if (index + count <= n - 1) {
                // 右上角
                if (chessboard[i][index + count]) {
                    return false;
                }
            }
            if (index - count >= 0) {
                if (chessboard[i][index - count]) {
                    return false;
                }
            }
            count++;
        }
        return true;
    }

    private String generatePath(int position, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == position) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private void backtrace(int n, int row) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, n)) {
                path.add(generatePath(i, n));
                chessboard[row][i] = true;
                backtrace(n, row + 1);
                path.remove(path.size() - 1);
                chessboard[row][i] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        chessboard = new boolean[n][n];
        backtrace(n, 0);
        return result;
    }
}
