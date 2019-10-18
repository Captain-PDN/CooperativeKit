import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class JDBC {
    private JdbcTemplate jdbcTemplate;

    public JDBC(JdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate;}

    public void userRegister(User user){
        String query = "INSERT INTO user (IDuser, Username, Password, FirstName, LastName, Tel, Address, Email, CitizenID, Photo, Birthday, Host, Type, Sex) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Object[] data = new Object[]
                { user.getIduser(), user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getTel(), user.getAddress(), user.getEmail(), user.getCitizenID(), user.getPhoto(), user.getBirthday(), user.getHost(), user.getType(), user.getSex() };
        jdbcTemplate.update(query, data);
    }

    public List<User> getAllUser(){
        String query = "SELECT * FROM `user`";
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    public void updateUserProfile(User user, String id){
        String query = "UPDATE user SET IDuser = '"+ user.getIduser() + "', Username = '" + user.getUsername() + "', Password = '" + user.getPassword()+ "', FirstName = '" + user.getFirstName() + "', LastName = '" + user.getLastName() + "', Tel = '" + user.getTel() + "', Address = '" + user.getAddress()+ "', Email = '" + user.getEmail() + "', CitizenID = '" + user.getCitizenID() + "', Photo = '" + user.getPhoto() + "', Birthday = " + user.getBirthday()+ ", Host = " + user.getHost() + ", Type = '" + user.getType() + "', Sex = '" + user.getSex()  + "' WHERE IDuser = '" + id + "'";
        jdbcTemplate.update(query);
    }

    public boolean signIn(String username, String password){
        String query = "SELECT * FROM `user`";
        List<User> users = jdbcTemplate.query(query, new UserRowMapper());
        for (User user:users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true; //for success login
            }
        }
        return false; //for fail login
    }

    public void createHistoryLog(String idUser ,String log){
        String query = "INSERT INTO history (IDuser, Date, Time, LOG) VALUES ((SELECT IDuser FROM `user` WHERE IDuser = ?), ?, ?, ?)";
        jdbcTemplate.update(query, idUser,  LocalDate.now(), LocalTime.now(), log);
    }

    public List<History> getUserHistory(String idUser){
        String query = "SELECT * FROM `history` WHERE IDuser = (SELECT IDuser FROM `user` WHERE IDuser = '" + idUser + "')";
        return jdbcTemplate.query(query, new HistoryRowMapper());
    }

    public void createChatLog(String idUser, String idUserOther ,String chatLog){
        String query = "INSERT INTO chat (IDuser, IDuserOther, Date, Time, ChatLog) VALUES ((SELECT IDuser FROM `user` WHERE IDuser = ?), (SELECT IDuser FROM `user` WHERE IDuser = ?), ?, ?, ?)";
        jdbcTemplate.update(query, idUser, idUserOther,  LocalDate.now(), LocalTime.now(), chatLog);
    }

    public void deleteChat(String idUser, String idUserOther, String chat){
        String query = "DELETE FROM chat WHERE (SELECT IDuser FROM `user` WHERE IDuser = '" + idUser + "') AND (SELECT IDuser FROM `user` WHERE IDuser = '" + idUserOther + "') AND ChatLog = '" + chat + "'";
        jdbcTemplate.update(query);
    }

    public List<Chat> getUserChat(String idUser, String idUserOther){
        String query = "SELECT * FROM `chat` WHERE IDuser = (SELECT IDuser FROM `user` WHERE IDuser = '" + idUser + "') AND IDuserOther = (SELECT IDuser FROM `user` WHERE IDuser = '" + idUserOther + "')";
        return jdbcTemplate.query(query, new ChatRowMapper());
    }

    public void createCooperativeRoom(String idCoopRoom, String idUser, String idWerehouse, String name, String status, String type){
        String query = "INSERT INTO cooperativeroom (IDCoopRoom, IDuser, Name, Status, Type, DateCreate, EnteringCount) VALUES (?, (SELECT IDuser FROM `user` WHERE IDuser = ?), ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, idCoopRoom, idUser, idWerehouse, name, 0.0, status, type, LocalDate.now(), 0);
        String query2 = "UPDATE user SET Host = " + true + "WHERE IDuser = '" + idUser + "'";
        jdbcTemplate.update(query2);
    }

    public void addCooperativeRoomMember(String idCoopRoom, String idUser){
        String query = "INSERT INTO cooperativeroommember (IDCoopRoom, IDuserMember) VALUES ((SELECT IDCoopRoom FROM `cooperativeroom` WHERE IDCoopRoom = ?), (SELECT IDuser FROM `user` WHERE IDuser = ?))";
        jdbcTemplate.update(query, idCoopRoom, idUser);
    }

    public void removeCooperativeRoomMember(String idCoopRoom, String idUser){
        String query = "DELETE FROM cooperativeroommember WHERE (SELECT IDCoopRoom FROM `cooperativeroom` WHERE IDCoopRoom = '" + idCoopRoom + "') AND (SELECT IDuser FROM `user` WHERE IDuser = '" + idUser + "')";
        jdbcTemplate.update(query);
    }

    public void updateCooperativeRoom(CooperativeRoom cooperativeRoom){
        String query = "UPDATE cooperativeroom SET EnteringCount = " + cooperativeRoom.getEnteringCount() + " WHERE IDCoopRoom = '" + cooperativeRoom.getIDCoopRoom() + "'";
        jdbcTemplate.update(query);
    }

    public List<CooperativeRoom> searchRoomByName(String name){
        String query = "SELECT * FROM `cooperativeroom` WHERE Name Like " + name;
        return jdbcTemplate.query(query, new CooperativeRoomRowMapper());
    }

    public void createGoods(String idGoods, String photo, Double price, String name, String type){
        String query = "INSERT INTO goods (IDGoods, Photo, Price, Name, Type) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, idGoods, photo, price, name, type);
    }

    public void removeGoods(String idGoods){
        String query = "DELETE FROM goods WHERE IDGoods = '" + idGoods + "'";
        jdbcTemplate.update(query);
    }

    public List<Goods> searchGoodsbyName(String name){
        String query = "SELECT * FROM `goods` WHERE Name Like " + name;
        return jdbcTemplate.query(query, new GoodsRowMapper());
    }

    public void insertGoodsToWerehouse(String idWerehouse, String idGoods, int quantity){
        String query = "INSERT INTO werehouse (IDGoods, Quantity) VALUES (?, (SELECT IDGoods FROM `goods` WHERE IDGoods = ?), ?)";
        jdbcTemplate.update(query, idWerehouse, idGoods, quantity);
    }

    public void removeGoodsFromWerehouse(String idWerehouse){
        String query = "DELETE FROM werehouse WHERE IDWerehouse = '" + idWerehouse + "'";
        jdbcTemplate.update(query);
    }

    public List<Werehouse> getAllWerehouse(){
        String query = "SELECT * FROM `werehouse`";
        return jdbcTemplate.query(query, new WerehouseRowMapper());
    }

    public void createAudit(String idAudit,String idUser,String idGoods, String name,int quantity,Double price,Double total){
        String query = "INSERT INTO audit (IDaudit, IDuser, IDGoods, Name, Quantity, Price, Total) VALUES (?, (SELECT IDuser FROM `user` WHERE IDuser = ?), (SELECT IDGoods FROM `goods` WHERE IDGoods = ?), ?, ?, ?, ?)";
        jdbcTemplate.update(query, idAudit, idUser, idGoods, name,  quantity, price, total);
    }

    class ChatRowMapper implements RowMapper<Chat> {
        public Chat mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Chat(rs.getString("IDuser"),
                    rs.getString("IDuserOther"),
                    rs.getDate("Date"),
                    rs.getTime("Time"),
                    rs.getString("ChatLog"));
        }
    }

    class HistoryRowMapper implements RowMapper<History> {
        public History mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new History(rs.getString("IDuser"),
                    rs.getDate("Date"),
                    rs.getTime("Time"),
                    rs.getString("Log"));
        }
    }

    class GoodsRowMapper implements RowMapper<Goods> {
        public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Goods(rs.getString("IDGoods"),
                    rs.getString("Photo"),
                    rs.getDouble("Price"),
                    rs.getString("Name"),
                    rs.getString("Type"));
        }
    }

    class WerehouseRowMapper implements RowMapper<Werehouse> {
        public Werehouse mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Werehouse(rs.getString("IDWerehouse"),
                    rs.getString("IDGoods"),
                    rs.getInt("Quantity"));
        }
    }

    class CooperativeRoomRowMapper implements RowMapper<CooperativeRoom> {
        public CooperativeRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new CooperativeRoom(rs.getString("IDCoopRoom"),
                    rs.getString("IDuser"),
                    rs.getString("IDWerehouse"),
                    rs.getString("Name"),
                    rs.getString("Status"),
                    rs.getString("Type"),
                    rs.getDate("DateCreate"),
                    rs.getInt("EnteringCount"));
        }
    }

    class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getString("IDuser"),
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("Tel"),
                    rs.getString("Address"),
                    rs.getString("Email"),
                    rs.getString("CitizenID"),
                    rs.getString("Photo"),
                    rs.getDate("Birthday"),
                    rs.getBoolean("Host"),
                    rs.getString("Type"),
                    rs.getString("Sex"));
        }
    }
}
