import java.sql.Time;
import java.util.Date;

public class Chat {

    private String idUser;
    private String iduserOther;
    private Date date;
    private Time time;
    private String chatlog;

    public Chat(String idUser, String iduserOther, Date date, Time time, String chatlog) {
        this.idUser = idUser;
        this.iduserOther = iduserOther;
        this.date = date;
        this.time = time;
        this.chatlog = chatlog;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getIduserOther() {
        return iduserOther;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getChatlog() {
        return chatlog;
    }
}
