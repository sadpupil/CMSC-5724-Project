package main;

import algorithm.Incremental;
import entity.DataInstance;
import fileService.DataReader;
import tools.ResultVerify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] dataSetPath = {
                "DataSets/DataSet1.txt",
                "DataSets/DataSet2.txt",
                "DataSets/DataSet3.txt"
        };
        DataReader dataReader = new DataReader();
        Incremental incremental = new Incremental();
        ResultVerify resultVerify = new ResultVerify();
        int cnt = 1;

        // use DataSet1, DataSet2, DataSet3 as input respectively
        for(String path : dataSetPath) {
            dataReader.setFilePath(path);
            ArrayList<DataInstance> dataSet = dataReader.readData();
            double[] w = incremental.runIncremental(dataSet);
            System.out.println("** DataSet " + cnt + " **");
            System.out.print("linear classifier: W");
            printW(w);
            System.out.println("margin of the classifier: " + resultVerify.getMargin(dataSet, w));
            System.out.println("final gamma guess: " + incremental.getGamma());
            System.out.println("empirical error: " + resultVerify.getEmpiricalError(dataSet, w) + "%");
            System.out.println();
            cnt++;
        }
    }

    private static void printW(double[] w) {
        int len = w.length;
        System.out.print("(");
        for(int i = 0; i < len; i++) {
            System.out.print(w[i]);
            if(i < len - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }

}
