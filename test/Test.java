package test;

import src.entity.DataSet;
import src.entity.Point;
import src.fileService.DataFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\CUHK MSc Computer Science\\Term1\\CMSC 5724\\project\\DataSets\\d2r16n10000.txt";
        DataFileReader dataFileReader = new DataFileReader(filePath);
        dataFileReader.readDataFromFile();
        DataSet dataSet = dataFileReader.getReadResult();
        System.out.println(dataSet.getDemension() + "," + dataSet.getNumOfPoints() + "," + dataSet.getR());
        Iterator<Point> itr = dataSet.getIterator();
        while(itr.hasNext()) {
            Point p = itr.next();
            ArrayList<Double> list = p.getCordinates();
            int label = p.getLabel();
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + ",");
            }
            System.out.print(label);
            System.out.println();
        }
    }
}
