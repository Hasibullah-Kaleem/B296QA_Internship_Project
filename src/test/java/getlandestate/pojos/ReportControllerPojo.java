package getlandestate.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportControllerPojo {

 /*
    "totalAdverts": 203,
            "totalUsers": 496,
            "totalAdvertTypes": 198,
            "totalTourRequests": 123,
            "totalCategories": 27

   */

    @JsonProperty("totalAdverts")
    private Integer totalAdverts;

    @JsonProperty("totalUsers")
    private Integer totalUsers;

    @JsonProperty("totalAdvertTypes")
    private Integer totalAdvertTypes;

    @JsonProperty("totalTourRequests")
    private Integer totalTourRequests;

    @JsonProperty("totalCategories")
    private Integer totalCategories;

    public ReportControllerPojo() {
    }

    public ReportControllerPojo(Integer totalAdverts, Integer totalUsers, Integer totalAdvertTypes, Integer totalTourRequests, Integer totalCategories) {
        this.totalAdverts = totalAdverts;
        this.totalUsers = totalUsers;
        this.totalAdvertTypes = totalAdvertTypes;
        this.totalTourRequests = totalTourRequests;
        this.totalCategories = totalCategories;
    }

    // Getter and Setter methods
    public Integer getTotalAdverts() {
        return totalAdverts;
    }

    public void setTotalAdverts(Integer totalAdverts) {
        this.totalAdverts = totalAdverts;
    }

    public Integer getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Integer totalUsers) {
        this.totalUsers = totalUsers;
    }

    public Integer getTotalAdvertTypes() {
        return totalAdvertTypes;
    }

    public void setTotalAdvertTypes(Integer totalAdvertTypes) {
        this.totalAdvertTypes = totalAdvertTypes;
    }

    public Integer getTotalTourRequests() {
        return totalTourRequests;
    }

    public void setTotalTourRequests(Integer totalTourRequests) {
        this.totalTourRequests = totalTourRequests;
    }

    public Integer getTotalCategories() {
        return totalCategories;
    }

    public void setTotalCategories(Integer totalCategories) {
        this.totalCategories = totalCategories;
    }

    @Override
    public String toString() {
        return "ReportControllerPojo{" +
                "totalAdverts=" + totalAdverts +
                ", totalUsers=" + totalUsers +
                ", totalAdvertTypes=" + totalAdvertTypes +
                ", totalTourRequests=" + totalTourRequests +
                ", totalCategories=" + totalCategories +
                '}';
    }
}
