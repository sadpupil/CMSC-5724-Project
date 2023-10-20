package algorithm;

import entity.DataInstance;
import tools.VectorOp;

import java.util.ArrayList;

public class Perceptron {

    public Perceptron() {}

    public boolean runPerceptron(ArrayList<DataInstance> dataSet, double[] w, double gammaGuess, double radius) {
        VectorOp tool = new VectorOp();
        int mostItr = (int) (12 * Math.pow(radius, 2) / Math.pow(gammaGuess, 2));
        int rounds = 0, len = dataSet.size();
        while(rounds < mostItr) {
            int n = 0;
            for(int i = 0; i < len && n == 0; i++) {
                double[] p = dataSet.get(i).getCoordinate();
                int l = dataSet.get(i).getLabel();
                double dotProduct = tool.vectorDotProduct(w, p);
                double distance = Math.abs(dotProduct) / tool.vectorMagnitude(w);
                if((l == -1 && dotProduct >= 0) || (l == 1 && dotProduct <= 0) || (distance < gammaGuess / 2)) {
                    // p is a violation point
                    if(l == 1) {
                        // w = w + p
                        tool.vectorAdd(w, p);
                    }
                    else {
                        // w = w - p
                        tool.vectorSub(w, p);
                    }
                    n++;
                }
            }
            // no more violation point
            if(n == 0) {
                return true;
            }
            rounds++;
        }
        return false;
    }

}
