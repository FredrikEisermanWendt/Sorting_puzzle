package org.example;


/*#####################################################################################

                       VÄLKOMMEN TILL "SORTING THE LIBRARY"

som beskrivet på hemsidan ska ni nu sortera datat och ta fram hur ni tar er till Ecuador
Ni har helt fria tyglar med hur ni löser det här pusslet, ni väljer hur det ska utformas

    Ni ska ta er från Sverige till Ecuador och antagligen så finns det olika sätt
   Ni kommer behöva visa med koden, dvs det sorterade datat hur rutterna hänger ihop
                    Så en visuallisering kommer behövas.

                 Det finns lite QoL i det här projektet sen innan:
                    Dependencies och en redan uppsatt API-fetch

                        Kan ni hitta alla vägar att ta?
                                HAPPY CODING!!

##################################################################################### */

import org.example.HackathonController.HackathonConfiguration;
import org.example.Model.TravelRecord;
import org.example.Service.CSVToObjectBuilder;
import org.example.Service.RouteService;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;


public class Main {


    public static void main(String[] args)  {

        CSVToObjectBuilder objectBuilder = new CSVToObjectBuilder();
        List<TravelRecord> records = objectBuilder.csvObjectBuilder();
        FastestTravelSorter travelSorter = new FastestTravelSorter(records);

        objectBuilder.csvObjectBuilder();
//
//
//        System.out.println(records.getFirst());
//        System.out.println(records.getFirst().getDepartureLDT());
//        System.out.println(records.getFirst().getArivalLDT()+"Travel from: "+records.getFirst().getTravelFrom()+"Travel to: "+records.getFirst().getTravelTo());
//
//
//
//        TravelRecord firstRecord = records.get(0);
//        if (firstRecord.getArivalLDT().compareTo(firstRecord.getDepartureLDT()) <= 0){
//            System.out.println(firstRecord.getArivalLDT());
//        }else {
//            System.out.println(firstRecord.getDepartureLDT());
//        }


        System.out.println("Test sorter");
        System.out.println(travelSorter.getSwedenToEcuador());



    }

}