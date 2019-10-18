public class Goods {

    private String idGood;
    private String photo;
    private Double price;
    private String name;
    private String type;

    public Goods(String idGood, String photo, Double price, String name, String type) {
        this.idGood = idGood;
        this.photo = photo;
        this.price = price;
        this.name = name;
        this.type = type;
    }

    public String getIdGood() {
        return idGood;
    }

    public String getPhoto() {
        return photo;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
