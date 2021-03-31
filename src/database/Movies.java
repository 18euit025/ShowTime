
package database;

import java.sql.Date;

public class Movies 
{
    private int sid;
    private String Movie;
    private String Language;
    private Date Release_Date;
    private Date End_Date;
    private float Rating;
    public Movies(int sid,String Language,String Movie,float Rating,Date Release_Date,Date End_Date)
    {
        this.sid=sid;
        this.Movie=Movie;
        this.Language=Language;
        this.Rating=Rating;
        
        this.Release_Date=Release_Date;
        this.End_Date=End_Date;
    }
    public int getId()
    {
        return sid;
    }
    public String getMovie()
    {
        return Movie;
    }
    public String getLanguage()
    {
        return Language;
    }
    public float getRating()
    {
        return Rating;
    }
    public Date getRelease()
    {
        return Release_Date;
    }
    public Date getEnd()
    {
        return End_Date;
    }
}
