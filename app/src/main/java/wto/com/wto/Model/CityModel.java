package wto.com.wto.Model;

/**
 * Created by Bilardo on 9/7/2017.
 */

public class CityModel {

    private String id;
    private String name;
    private String icon;
    private String province;
    private String status;

    public CityModel(String id, String name, String icon, String province, String status)
    {
        setId(id);
        setName(name);
        setIcon(icon);
        setProvince(province);
        setStatus(status);
    }

    public CityModel()
    {
        setId("");
        setName("");
        setIcon("");
        setProvince("");
        setStatus("");
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
