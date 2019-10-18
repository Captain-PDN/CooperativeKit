import java.util.Date;

public class CooperativeRoom {

    private String idCoopRoom;
    private String iduser;
    private String idWerehouse;
    private String name;
    private String status;
    private String type;
    private Date dateCreate;
    private int enteringCount;

    public CooperativeRoom(String idCoopRoom, String iduser, String idWerehouse, String name, String status, String type, Date dateCreate, int enteringCount) {
        this.idCoopRoom = idCoopRoom;
        this.iduser = iduser;
        this.idWerehouse = idWerehouse;
        this.name = name;
        this.status = status;
        this.type = type;
        this.dateCreate = dateCreate;
        this.enteringCount = enteringCount;
    }

    public String getIDCoopRoom() {
        return idCoopRoom;
    }

    public String getIDuser() {
        return iduser;
    }

    public String getIDWerehouse() {
        return idWerehouse;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public int getEnteringCount() {
        return enteringCount;
    }
}
