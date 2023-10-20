package algorithm;

import entity.DataInstance;

import java.util.ArrayList;

public class Incremental {

    public Incremental(){}

    private double gamma = 0.0;

    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    public double getGamma() {
        return gamma;
    }

    public double[] runIncremental(ArrayList<DataInstance> dataSet) {
        // get the necessary parameters
        DataInstance firstInstance = dataSet.get(0);
        Perceptron perceptron = new Perceptron();
        int d = firstInstance.getDimension();
        double radius = firstInstance.getRadius(), gammaGuess = radius;
        double[] w = new double[d];
        boolean flag = false;
        while(!flag) {
            flag = perceptron.runPerceptron(dataSet, w, gammaGuess, radius);
            gammaGuess /= 2;
        }
        setGamma(gammaGuess * 2);
        return w;
    }

}
