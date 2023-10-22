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
            System.out.println("linear classifier: w" + Arrays.toString(w));
            System.out.println("margin of the classifier: " + resultVerify.getMargin(dataSet, w));
            System.out.println("final gamma guess: " + incremental.getGamma());
            System.out.println("empirical error: " + resultVerify.getEmpiricalError(dataSet, w) + "%");
            System.out.println();
            cnt++;
        }
    }

}
