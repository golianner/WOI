package wto.com.wto.Model;

/**
 * Created by Bilardo on 9/7/2017.
 */

public class StoreModel {

    private String id;
    private String name;
    private String address;
    private String geoLocation;
    private String image;
    private String phone;
    private String openHour;
    private String closeHour;
    private String cityId;
    private String userId;
    private String insertDate;
    private String status;
    private String username;
    private String cityName;

    public StoreModel(String id, String name, String address, String geoLocation, String image, String phone, String openHour, String closeHour,
                      String cityId, String userId, String insertDate, String status, String username, String cityName)
    {
        setId(id);
        setName(name);
        setAddress(address);
        setGeoLocation(geoLocation);
        setImage(image);
        setPhone(phone);
        setOpenHour(openHour);
        setCloseHour(closeHour);
        setCityId(cityId);
        setUserId(userId);
        setInsertDate(insertDate);
        setStatus(status);
        setUsername(username);
        setCityName(cityName);
    }

    public StoreModel()
    {
        setId("");
        setName("");
        setAddress("");
        setGeoLocation("");
        setImage("");
        setPhone("");
        setOpenHour("");
        setCloseHour("");
        setCityId("");
        setUserId("");
        setInsertDate("");
        setStatus("");
        setUsername("");
        setCityName("");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
