package fileService;

import entity.DataInstance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {

    String filePath;

    public DataReader() {}

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<DataInstance> readData() throws IOException {
        int cnt = 0, len, dimension = 0, numOfInstance = 0;
        double radius = 0.0;
        ArrayList<DataInstance> result = new ArrayList<>();
        try(BufferedReader bfr = new BufferedReader(new FileReader(filePath))) {
            String lineData;
            while((lineData = bfr.readLine()) != null) {
                String[] tmp = lineData.split(",");
                len = tmp.length;
                if(cnt == 0 && len == 3) {
                    dimension = Integer.parseInt(tmp[0]);
                    numOfInstance = Integer.parseInt(tmp[1]);
                    radius = Double.parseDouble(tmp[2]);
                }
                else {
                    double[] coord = new double[len - 1];
                    for(int i = 0; i < len - 1; i++) {
                        coord[i] = Double.parseDouble(tmp[i]);
                    }
                    DataInstance dataInstance = new DataInstance(
                            coord, Integer.parseInt(tmp[len - 1]),
                            radius, dimension, numOfInstance
                    );
                    result.add(dataInstance);
                }
                cnt++;
            }
        }
        return result;
    }

}
