package entity;

public class DataInstance {

    private final double[] coordinate;
    private final int label;
    private final double radius;
    private final int dimension;
    private final int numOfInstance;

    public DataInstance(double[] coordinate, int label, double radius, int dimension, int numOfInstance) {
        this.coordinate = coordinate;
        this.label = label;
        this.radius = radius;
        this.dimension = dimension;
        this.numOfInstance = numOfInstance;
    }

    public double[] getCoordinate() {
        return coordinate;
    }

    public double getRadius() {
        return radius;
    }

    public int getDimension() {
        return dimension;
    }

    public int getNumOfInstance() {
        return numOfInstance;
    }

    public int getLabel() {
        return label;
    }
}
