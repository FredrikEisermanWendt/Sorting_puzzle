package org.example;

import org.example.Model.TravelRecord;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class FastestTravelSorter {

    private final List<TravelRecord> originalTravelRecord;
    private List<List<TravelRecord>> travelsEndingInEcuador = new ArrayList<>();

    public FastestTravelSorter(List<TravelRecord> originalTravelRecord) {
        this.originalTravelRecord = originalTravelRecord;
    }

    public List<List<TravelRecord>> getSwedenToEcuador() {
        /*
         * algoritm:
         * Resor från sverige
         * lägg dessa i en lista (arrivalsList?)
         * ta sedan de departures som är större än arrivals in arrivals list och lägg i en templista
         * if arrival = ecuadorLista, upprepa tills inget körs
         * */
        List<List<TravelRecord>> swedenToEcuadorRecords = new ArrayList<>();

        swedenToEcuadorRecords = getFirstLeg();

        for (List<TravelRecord> travelRecords : swedenToEcuadorRecords) {
            travelRecords.add(addLeg(travelRecords));
            System.out.println(travelRecords);
        }


        return swedenToEcuadorRecords;
    }


    private TravelRecord addLeg(List<TravelRecord> travelRecords) {


            for (TravelRecord travelFromRecord : travelRecords) {

                for (TravelRecord travelToRecord : originalTravelRecord) {


                    if (travelFromRecord.getTravelTo().equals(travelToRecord.getTravelFrom()) && travelFromRecord.getArivalLDT().isBefore(travelToRecord.getDepartureLDT())) {
                        System.out.println(travelFromRecord);
                        if (travelToRecord.getTravelTo().equals("Ecuador")) {
                            travelsEndingInEcuador.add(travelRecords);
                        }
                        travelsEndingInEcuador.add(travelRecords);
                        return travelFromRecord;
                    }
                }
            }


        return null;
    }

    private List<TravelRecord> getTravelRecordList(List<List<TravelRecord>> swedenToEcuadorRecords, int counter) {
        if (counter < swedenToEcuadorRecords.size()) {
            return swedenToEcuadorRecords.get(counter);
        }else {
            return new ArrayList<>();
        }
    }

    private List<List<TravelRecord>> getFirstLeg() {

        List<List<TravelRecord>> firstLeg = new ArrayList<>();
        for (TravelRecord travelRecord : originalTravelRecord) {
            if (travelRecord.getTravelFrom().equals("Sverige")) {
                List<TravelRecord> route = new ArrayList<>();
                route.add(travelRecord);
                firstLeg.add(route);
            }
        }

        return firstLeg;
    }


}
