package wto.com.wto.Model;

/**
 * Created by Bilardo on 8/10/2017.
 */

public class MyInterestModel {

    private int idInterest;
    private String titleInterest;
    private int iconInterest;

    public MyInterestModel(int idInterest, String titleInterest, int iconInterest)
    {
        setId(idInterest);
        setTitleInterest(titleInterest);
        setIconInterest(iconInterest);
    }

    public int getId(){
        return idInterest;
    }

    public void setId(int idInterest)
    {
        this.idInterest = idInterest;
    }

    public void setTitleInterest(String titleInterest)
    {
        this.titleInterest = titleInterest;
    }

    public String getTitleInterest()
    {
        return titleInterest;
    }

    public void setIconInterest(int iconInterest)
    {
        this.iconInterest = iconInterest;
    }

    public int getIconInterest()
    {
        return iconInterest;
    }
}
