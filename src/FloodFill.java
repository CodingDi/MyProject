public class FloodFill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if(image == null) return image;

            int n = image.length;
            int m = image[0].length;
            int old = image[sr][sc];

            if(image[sr][sc] != newColor){
                dfs(image, sr,sc, old, newColor);
            }


            return image;
        }

        private void dfs(int[][] image, int i, int j, int old, int newColor){
            int n = image.length;
            int m = image[0].length;

            if(i < 0 || i >= n || j < 0 || j >= m || image[i][j] != old){
                return;
            }
            image[i][j] = newColor;
            dfs(image, i + 1, j, old, newColor);
            dfs(image, i - 1, j, old, newColor);
            dfs(image, i, j + 1, old, newColor);
            dfs(image, i, j - 1, old, newColor);
        }
    }
}
