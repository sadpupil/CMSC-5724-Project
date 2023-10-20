package src.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Point implements Serializable {

    private final ArrayList<Double> Cordinates;

    private final int Label;

    public Point(ArrayList<Double> cordinates, int label) {
        this.Cordinates = cordinates;
        this.Label = label;
    }

    // calculate the R of each point
    public double getDistanceFromOrigin() {
        double res = 0.0;
        Iterator<Double> itr = this.Cordinates.iterator();
        while(!itr.hasNext()) {
            res += Math.pow(itr.next(), 2);
        }
        return Math.sqrt(res);
    }

    public ArrayList<Double> getCordinates() {
        return Cordinates;
    }

    public int getLabel() {
        return Label;
    }
}
