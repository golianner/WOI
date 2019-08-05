package wto.com.wto.Model;

/**
 * Created by Bilardo on 8/16/2017.
 */

public class NotificationModel {

    private int id;
    private String imgProfile;
    private String notificationName;
    private String notificationDetail;
    private String notificationTime;
    private int notificationIcon;

    public NotificationModel(int _id, String _imgProfile, String _notificationName, String _notificationDetail, String _notificationTime, int _notificationIcon)
    {
        setId(_id);
        setImgProfile(_imgProfile);
        setNotificationName(_notificationName);
        setNotificationDetail(_notificationDetail);
        setNotificationTime(_notificationTime);
        setNotificationIcon(_notificationIcon);
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setImgProfile(String imgProfile)
    {
        this.imgProfile = imgProfile;
    }

    public String getImgProfile()
    {
        return this.imgProfile;
    }

    public void setNotificationName(String notificationName)
    {
        this.notificationName = notificationName;
    }

    public String getNotificationName()
    {
        return notificationName;
    }

    public void setNotificationDetail(String notificationDetail)
    {
        this.notificationDetail = notificationDetail;
    }

    public String getNotificationDetail()
    {
        return notificationDetail;
    }

    public void setNotificationTime(String notificationTime)
    {
        this.notificationTime = notificationTime;
    }

    public String getNotificationTime()
    {
        return notificationTime;
    }

    public void setNotificationIcon(int notificationIcon)
    {
        this.notificationIcon = notificationIcon;
    }

    public int getNotificationIcon()
    {
        return notificationIcon;
    }
}
