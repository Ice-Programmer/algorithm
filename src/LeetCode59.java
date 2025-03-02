/**
 * LeetCode：59.螺旋矩阵II
 *
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2025/3/2 17:08
 */
public class LeetCode59 {

    public int[][] generateMatrix(int n) {
        int startX = 0, startY = 0;
        int offset = 1;
        int count = 1;
        int[][] matrix = new int[n][n];
        for (int times = 0; times < n / 2; times++) {
            // 第一条边(顺时针)
            for (int i = startY; i < n - offset; i++) {
                matrix[startX][i] = count++;
            }
            // 第二条边
            for (int j = startX; j < n - offset; j++) {
                matrix[j][n - offset] = count++;
            }
            // 第三条边
            for (int i = n - offset; i > startY; i--) {
                matrix[n - offset][i] = count++;
            }
            // 第四题条边
            for (int j = n - offset; j > startX; j--) {
                matrix[j][startY] = count++;
            }
            offset++;
            startY++;
            startX++;
        }
        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = count;
        }
        return matrix;
    }

    public static void main(String[] args) {
        LeetCode59 leetCode59 = new LeetCode59();
        int[][] matrix = leetCode59.generateMatrix(4);
    }
}
