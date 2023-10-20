package main;

import algorithm.Incremental;
import entity.DataInstance;
import fileService.DataReader;
import helper.ResultVerify;

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
        DataReader dataReader = new DataReader(dataSetPath[2]);
        ArrayList<DataInstance> dataSet = dataReader.readData();
        Incremental incremental = new Incremental();
        double[] w = incremental.runIncremental(dataSet);
        System.out.println(Arrays.toString(w));
        System.out.println(incremental.getGamma());

        ResultVerify resultVerify = new ResultVerify();
        System.out.println(resultVerify.getEmpiricalError(dataSet, w));
        System.out.println(resultVerify.getMargin(dataSet, w));
    }

}
