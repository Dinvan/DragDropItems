package com.example.dragdropitems.model;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class CustomListResponse {
    public String userId;
    public String email;
    public List<CustomList> customList = new ArrayList<>();
    public List<CustomList> previousDayCustomList = new ArrayList<>();
    public int errorCode;
    public String errorMessage;

    public CustomListResponse() {
    }

    /**
     * @param errorMessage
     * @param customList
     * @param email
     * @param userId
     * @param errorCode
     */
    public CustomListResponse(String userId, String email, List<CustomList> customList,
                              List<CustomList> previousDayCustomList,
                              int errorCode, String errorMessage) {
        this.userId = userId;
        this.email = email;
        this.customList = customList;
        this.previousDayCustomList = previousDayCustomList;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static CustomListResponse getDummyResponseObject() {
        CustomListResponse response = new Gson().fromJson(getDummyJsonString(), CustomListResponse.class);
        return response;
    }

    public static String getDummyJsonString() {
        return "{\n" +
                "\"userId\":\"ABC-101\",\n" +
                "\"email\":\"stallone@gmail.com\",\n" +
                "\"customList\":[\n" +
                "{\n" +
                "\"id\":\"DR-012\",\n" +
                "\"name\":\"Dr. A\",\n" +
                "\"address\":\"Address: Sector-1, Four Bunglows, Kandivli East\",\n" +
                "\"mobile\":\"9878678987\",\n" +
                "\"lat\":19.876564,\n" +
                "\"lng\":81.637363,\n" +
                "\"estimatedTime\":\"30\"\n" +
                "},\n" +
                "{\n" +
                "\"id\":\"DR-015\",\n" +
                "\"name\":\"Dr. B\",\n" +
                "\"address\":\"Address: Sector-1, Four Bunglows, Malad East\",\n" +
                "\"mobile\":\"9878678987\",\n" +
                "\"lat\":19.876564,\n" +
                "\"lng\":81.637363,\n" +
                "\"estimatedTime\":\"50\"\n" +
                "},\n" +
                "{\n" +
                "\"id\":\"DR-016\",\n" +
                "\"name\":\"Dr. C\",\n" +
                "\"address\":\"Address: Sector-1, Four Bunglows, Goregaon East\",\n" +
                "\"mobile\":\"9878678987\",\n" +
                "\"lat\":19.876564,\n" +
                "\"lng\":81.637363,\n" +
                "\"estimatedTime\":\"120\"\n" +
                "},\n" +
                "{\n" +
                "\"id\":\"DR-017\",\n" +
                "\"name\":\"Dr. D\",\n" +
                "\"address\":\"Address: Sector-1, Four Bunglows, Juhu East\",\n" +
                "\"mobile\":\"9878678987\",\n" +
                "\"lat\":19.876564,\n" +
                "\"lng\":81.637363,\n" +
                "\"estimatedTime\":\"220\"\n" +
                "},\n" +
                "{\n" +
                "\"id\":\"DR-018\",\n" +
                "\"name\":\"Dr. E\",\n" +
                "\"address\":\"Address: Sector-1, Four Bunglows, Bandra East\",\n" +
                "\"mobile\":\"9878678987\",\n" +
                "\"lat\":19.876564,\n" +
                "\"lng\":81.637363,\n" +
                "\"estimatedTime\":\"320\"\n" +
                "}\n" +
                "],\n" +
                "\"previousDayCustomList\":[\n" +
                "{\n" +
                "\"id\":\"DR-116\",\n" +
                "\"name\":\"Dr. AB\",\n" +
                "\"address\":\"Address: Sector-1, Four Bunglows, Dadar East\",\n" +
                "\"mobile\":\"9878678987\",\n" +
                "\"lat\":19.876564,\n" +
                "\"lng\":81.637363,\n" +
                "\"estimatedTime\":\"30\"\n" +
                "},\n" +
                "{\n" +
                "\"id\":\"DR-118\",\n" +
                "\"name\":\"Dr. BD\",\n" +
                "\"address\":\"Address: Sector-1, Four Bunglows, Parle East\",\n" +
                "\"mobile\":\"9878678987\",\n" +
                "\"lat\":19.876564,\n" +
                "\"lng\":81.637363,\n" +
                "\"estimatedTime\":\"50\"\n" +
                "},\n" +
                "{\n" +
                "\"id\":\"DR-119\",\n" +
                "\"name\":\"Dr. DB\",\n" +
                "\"address\":\"Address: Sector-1, Four Bunglows, Churchgate\",\n" +
                "\"mobile\":\"9878678987\",\n" +
                "\"lat\":19.876564,\n" +
                "\"lng\":81.637363,\n" +
                "\"estimatedTime\":\"70\"\n" +
                "}\n" +
                "],\n" +
                "\"errorCode\":0,\n" +
                "\"errorMessage\":\"success\"\n" +
                "}";
    }

}
