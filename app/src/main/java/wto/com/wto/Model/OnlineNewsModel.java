package wto.com.wto.Model;

/**
 * Created by Bilardo on 8/10/2017.
 */

public class OnlineNewsModel {

    private int idNews;
    private int imgNews;
    private String titleNews;
    private String sourceNews;

    public OnlineNewsModel(int idNews, int imgNews, String titleNews, String sourceNews)
    {
        setIdNews(idNews);
        setImgNews(imgNews);
        setTitleNews(titleNews);
        setSourceNews(sourceNews);
    }

    public void setIdNews(int idNews)
    {
        this.idNews = idNews;
    }

    public int getIdNews()
    {
        return idNews;
    }

    public void setImgNews(int imgNews)
    {
        this.imgNews = imgNews;
    }

    public int getImgNews()
    {
        return imgNews;
    }

    public void setTitleNews(String titleNews)
    {
        this.titleNews = titleNews;
    }

    public String getTitleNews()
    {
        return titleNews;
    }

    public void setSourceNews(String sourceNews)
    {
        this.sourceNews = sourceNews;
    }

    public String getSourceNews()
    {
        return sourceNews;
    }
}
