package org.example.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.Model.TravelRecord;

public class CSVToObjectBuilder {

    String filePath = "src/main/java/org/example/resources/library_data.csv";

    public List<TravelRecord> csvObjectBuilder(){

        List<TravelRecord> travelRecords = new ArrayList<>();
        try(FileReader fileReader = new FileReader(filePath)) {
            CsvToBean<TravelRecord> csvToBeanBuilder = new CsvToBeanBuilder<TravelRecord>(fileReader)
                    .withType(TravelRecord.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            travelRecords = csvToBeanBuilder.parse();
            for (TravelRecord travelRecord : travelRecords) {
                System.out.println(travelRecord.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return travelRecords;


    }





}
