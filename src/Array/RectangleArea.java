package Array;

public class RectangleArea {

        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int leftCol = Math.max(A, E);
            int rightCol = Math.max(leftCol, Math.min(C, G));
            int bottomRow = Math.max(B, F);
            int topRow = Math.max(Math.min(D, H), bottomRow);


            return (C - A) * (D - B) + (G - E) * (H - F) - (rightCol - leftCol) * (topRow - bottomRow);
        }

}
