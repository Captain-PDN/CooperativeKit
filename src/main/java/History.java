import java.sql.Time;
import java.util.Date;

public class History {

    private String idUser;
    private Date date;
    private Time time;
    private String log;

    public History(String idUser, Date date, Time time, String log) {
        this.idUser = idUser;
        this.date = date;
        this.time = time;
        this.log = log;
    }

    public String getIdUser() {
        return idUser;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getLog() {
        return log;
    }
}
