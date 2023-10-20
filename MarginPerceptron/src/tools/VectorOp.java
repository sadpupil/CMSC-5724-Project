package tools;

public class VectorOp {

    public VectorOp() {}

    // vector add operation
    public void vectorAdd(double[] w, double[] p) {
        int lenW = w.length;
        // the length of w and p is always the same
        for(int i = 0; i < lenW; i++) {
            w[i] += p[i];
        }
    }

    // vector subtraction operation
    public void vectorSub(double[] w, double[] p) {
        int lenW = w.length;
        // lenW is always equal to lenP
        for(int i = 0; i < lenW; i++) {
            w[i] -= p[i];
        }
    }

    // vector dot product
    public double vectorDotProduct(double[] w, double[] p) {
        int lenW = w.length;
        double res = 0;
        for(int i = 0; i < lenW; i++) {
            res += w[i] * p[i];
        }
        return res;
    }

    // vector magnitude
    public double vectorMagnitude(double[] v) {
        double res = 0;
        for (double value : v) {
            res += value * value;
        }
        return Math.sqrt(res);
    }

}
