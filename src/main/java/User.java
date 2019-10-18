import java.util.Date;

public class User {
    private String iduser;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String tel;
    private String address;
    private String email;
    private String citizenID;
    private String photo;
    private Date birthday;
    private Boolean host;
    private String type;
    private String sex;

    public User(String iduser, String username, String password, String firstName, String lastName, String tel, String address, String email, String citizenID, String photo, Date birthday, Boolean host, String type, String sex) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.address = address;
        this.email = email;
        this.citizenID = citizenID;
        this.photo = photo;
        this.birthday = birthday;
        this.host = host;
        this.type = type;
        this.sex = sex;
    }

    public String getIduser() {
        return iduser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getCitizenID() {
        return citizenID;
    }

    public String getPhoto() {
        return photo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Boolean getHost() {
        return host;
    }

    public String getType() {
        return type;
    }

    public String getSex() {
        return sex;
    }
}
