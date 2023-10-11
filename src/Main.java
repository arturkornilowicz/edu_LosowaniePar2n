class LosowaniePar2n {

    int[][] tab;

    LosowaniePar2n(int n) {
        tab = new int[n][];
        for (int i = 0; i < n; ++i) {
            tab[i] = new int[(int) Math.pow(2, i + 1)];
        }
        tab[0][0] = 1;
        tab[0][1] = 2;
        int suma;
        for (int w = 1; w < tab.length; ++w) {
            suma = 1 + (int) Math.pow(2, w + 1);
            for (int k = 0; k < tab[w - 1].length - 1; k += 2) {
                tab[w][2 * k] = tab[w - 1][k];
                tab[w][2 * k + 1] = suma - tab[w - 1][k];
                tab[w][2 * k + 2] = suma - tab[w - 1][k + 1];
                tab[w][2 * k + 3] = tab[w - 1][k + 1];
            }
        }
    }

    @Override
    public String toString() {
        String r = "";
        for (int w = 0; w < tab.length; ++w) {
            for (int k = 0; k < tab[w].length; k += 2) {
                r += + tab[w][k] + "-" + tab[w][k + 1] + "; ";
            }
            r += "\n";
        }
        return r;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new LosowaniePar2n(4));
    }
}
