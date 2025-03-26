package getlandestate.pojos.daily_report_controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class DailyReportPojo {

    @JsonProperty("ContactMessages")
    private Map<String, Integer> contactMessages;

    @JsonProperty("Favorites")
    private Map<String, Integer> favorites;

    @JsonProperty("RentAdverts")
    private Map<String, Integer> rentAdverts;

    @JsonProperty("SaleAdverts")
    private Map<String, Integer> saleAdverts;

    @JsonProperty("TourRequests")
    private Map<String, Integer> tourRequests;

    @JsonProperty("Users")
    private Map<String, Integer> users;

    public DailyReportPojo() {}

    public DailyReportPojo(Map<String, Integer> contactMessages, Map<String, Integer> favorites, Map<String, Integer> rentAdverts,
                           Map<String, Integer> saleAdverts, Map<String, Integer> tourRequests, Map<String, Integer> users) {
        this.contactMessages = contactMessages;
        this.favorites = favorites;
        this.rentAdverts = rentAdverts;
        this.saleAdverts = saleAdverts;
        this.tourRequests = tourRequests;
        this.users = users;
    }

    // Getters and Setters
    public Map<String, Integer> getContactMessages() {
        return contactMessages;
    }

    public void setContactMessages(Map<String, Integer> contactMessages) {
        this.contactMessages = contactMessages;
    }

    public Map<String, Integer> getFavorites() {
        return favorites;
    }

    public void setFavorites(Map<String, Integer> favorites) {
        this.favorites = favorites;
    }

    public Map<String, Integer> getRentAdverts() {
        return rentAdverts;
    }

    public void setRentAdverts(Map<String, Integer> rentAdverts) {
        this.rentAdverts = rentAdverts;
    }

    public Map<String, Integer> getSaleAdverts() {
        return saleAdverts;
    }

    public void setSaleAdverts(Map<String, Integer> saleAdverts) {
        this.saleAdverts = saleAdverts;
    }

    public Map<String, Integer> getTourRequests() {
        return tourRequests;
    }

    public void setTourRequests(Map<String, Integer> tourRequests) {
        this.tourRequests = tourRequests;
    }

    public Map<String, Integer> getUsers() {
        return users;
    }

    public void setUsers(Map<String, Integer> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "DailyReportPojo{" +
                "contactMessages=" + contactMessages +
                ", favorites=" + favorites +
                ", rentAdverts=" + rentAdverts +
                ", saleAdverts=" + saleAdverts +
                ", tourRequests=" + tourRequests +
                ", users=" + users +
                '}';
    }
}
