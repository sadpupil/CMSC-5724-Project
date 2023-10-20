package helper;

import entity.DataInstance;

import java.util.ArrayList;

public class ResultVerify {

    public ResultVerify(){}

    public double getMargin(ArrayList<DataInstance> dataSet, double[] w) {
        VectorOp tool = new VectorOp();
        int len = dataSet.size();
        double margin = Double.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            double[] p = dataSet.get(i).getCoordinate();
            double tmp = Math.abs(tool.vectorDotProduct(p, w)) / tool.vectorMagnitude(w);
            margin = Math.min(tmp, margin);
        }
        return margin;
    }

    public double getEmpiricalError(ArrayList<DataInstance> dataSet, double[] w) {
        VectorOp tool = new VectorOp();
        int len = dataSet.size(), n = dataSet.get(0).getNumOfInstance();
        int correct = 0;
        for(int i = 0; i < len; i++) {
            DataInstance tmp = dataSet.get(i);
            double[] p = tmp.getCoordinate();
            int l = tmp.getLabel();
            double dotProduct = tool.vectorDotProduct(p, w);
            if((l == 1 && dotProduct > 0) || (l == -1 && dotProduct < 0)) {
                correct++;
            }
        }
        return (double) correct / n;
    }

}
