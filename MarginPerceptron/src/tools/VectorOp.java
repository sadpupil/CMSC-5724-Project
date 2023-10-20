package tools;

public class VectorOp {

    public VectorOp() {}

    // vector add operation
    public void vectorAdd(double[] w, double[] p) {
        int lenW = w.length, lenP = p.length;
        // lenW is always equal to lenP
        for(int i = 0; i < lenW; i++) {
            w[i] += p[i];
        }
    }

    // vector subtraction operation
    public void vectorSub(double[] w, double[] p) {
        int lenW = w.length, lenP = p.length;
        // lenW is always equal to lenP
        for(int i = 0; i < lenW; i++) {
            w[i] -= p[i];
        }
    }

    // vector dot product
    public double vectorDotProduct(double[] w, double[] p) {
        int lenW = w.length, lenP = p.length;
        double res = 0;
        for(int i = 0; i < lenW; i++) {
            res += w[i] * p[i];
        }
        return res;
    }

    // vector magnitude
    public double vectorMagnitude(double[] v) {
        int len = v.length;
        double res = 0;
        for(int i = 0; i < len; i++) {
            res += v[i] * v[i];
        }
        return Math.sqrt(res);
    }

}
