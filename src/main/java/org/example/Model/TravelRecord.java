package org.example.Model;

import com.opencsv.bean.CsvBindByName;
import com.sun.source.doctree.EscapeTree;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TravelRecord {
    //"669e2f3be1a63c1a80ebe016","Dokument","Flyg","2024-09-03T11:43:00","Marocko","Venezuela","1243","09:50:00","B30","TT5HF","22:30:00","","true"
    @CsvBindByName
    private String id;

    @CsvBindByName
    private String documentType;

    @CsvBindByName
    private String travelType;

    @CsvBindByName
    private String departureDateTime;

    @CsvBindByName
    private String travelFrom;

    @CsvBindByName
    private String travelTo;

    @CsvBindByName
    private int price;

    @CsvBindByName
    private String travelTime;

    @CsvBindByName
    private String information;

    @CsvBindByName
    private String vehicleNumber;

    @CsvBindByName
    private String hoursDelayed;

    @CsvBindByName
    private String arrivalDateTime;

    @CsvBindByName
    private boolean delayed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getDepartureLDT() {
        return LocalDateTime.parse(departureDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

    }

    public String getTravelFrom() {
        return travelFrom;
    }

    public void setTravelFrom(String travelFrom) {
        this.travelFrom = travelFrom;
    }

    public String getTravelTo() {
        return travelTo;
    }

    public void setTravelTo(String travelTo) {
        this.travelTo = travelTo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getHoursDelayed() {
        return hoursDelayed;
    }

    public void setHoursDelayed(String hoursDelayed) {
        this.hoursDelayed = hoursDelayed;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }


    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public LocalDateTime getArivalLDT() {
        return calculateArrivalLocalDateTime();
    }

    public boolean isDelayed() {
        return delayed;
    }

    public void setDelayed(boolean delayed) {
        this.delayed = delayed;
    }


    private LocalDateTime calculateArrivalLocalDateTime() {
        LocalDateTime departure = getDepartureLDT();

        String[] timeParts = travelTime.split(":");
        Duration duration = Duration.ofHours(Long.parseLong(timeParts[0]))
                .plusMinutes(Long.parseLong(timeParts[1]))
                .plusSeconds(Long.parseLong(timeParts[2]));

        return departure.plus(duration);
    }

    @Override
    public String toString() {
        return "TravelRecord{" +
                "id='" + id + '\'' +
                ", documentType='" + documentType + '\'' +
                ", travelType='" + travelType + '\'' +
                ", departureDateTime=" + departureDateTime +
                ", travelFrom='" + travelFrom + '\'' +
                ", travelTo='" + travelTo + '\'' +
                ", price=" + price +
                ", travelTime='" + travelTime + '\'' +
                ", information='" + information + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", hoursDelayed='" + hoursDelayed + '\'' +
                ", arrivalDateTime=" + arrivalDateTime +
                ", delayed=" + delayed +
                '}';
    }

}
