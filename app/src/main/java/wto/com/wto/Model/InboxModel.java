package wto.com.wto.Model;

/**
 * Created by Bilardo on 8/14/2017.
 */

public class InboxModel {

    private int id;
    private String name;
    private String subject;
    private String detail;
    private String img;
    private String logs;

    public InboxModel(int _id, String _name, String _subject, String _detail, String _img, String _logs)
    {
        setId(_id);
        setName(_name);
        setSubject(_subject);
        setDetail(_detail);
        setImg(_img);
        setLogs(_logs);
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
    }

    public void setLogs(String logs)
    {
        this.logs = logs;
    }

    public String getLogs()
    {
        return this.logs;
    }
}
