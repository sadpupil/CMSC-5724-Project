package src.entity;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;

public class DataSet implements Serializable {

    private int demension;
    private int numOfPoints;
    private int R;

    private ArrayDeque<Point> dataSet = new ArrayDeque<>();

    public DataSet(int d, int n, int r) {
        this.demension = d;
        this.numOfPoints = n;
        this.R = r;
    }

    public void addPointToSet(Point point) {
        dataSet.addLast(point);
    }

    public Iterator<Point> getIterator() {
        return dataSet.iterator();
    }

    public int getDemension() {
        return demension;
    }

    public int getNumOfPoints() {
        return numOfPoints;
    }

    public int getR() {
        return R;
    }
}
