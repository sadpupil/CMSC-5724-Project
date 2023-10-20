package src.fileService;

import src.entity.DataSet;
import src.entity.Point;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataFileReader {

    // the path of data set files
    private String filePath;

    // store every point in the data set
    private DataSet dataSet = null;

    public DataFileReader(String filePath) {
        this.filePath = filePath;
    }

    public void readDataFromFile() throws IOException {
        int cnt = 0, len;
        try(BufferedReader bfr = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = bfr.readLine()) != null) {
                String[] seq = line.split(",");
                len = seq.length;
                // the first line of input file
                // create an object of DataSet
                if(cnt == 0 && len == 3) {
                    int d = Integer.parseInt(seq[0]);
                    int n = Integer.parseInt(seq[1]);
                    int r = Integer.parseInt(seq[2]);
                    dataSet = new DataSet(d, n, r);
                }
                else {
                    ArrayList<Double> cord = new ArrayList<>();
                    for(int i = 0; i < len - 1; i++) {
                        Double d = Double.parseDouble(seq[i]);
                        cord.add(d);
                    }
                    int l = Integer.parseInt(seq[len - 1]);
                    Point p = new Point(cord, l);
                    if(dataSet != null) {
                        dataSet.addPointToSet(p);
                    }
                }
                cnt++;
            }
        }
    }

    public DataSet getReadResult() {
        if(dataSet == null) {
            return null;
        }
        return dataSet;
    }

}
