public class Werehouse {

    private String idWerehouse;
    private String idGoods;
    private int quantity;

    public Werehouse(String idWerehouse, String idGoods, int quantity) {
        this.idWerehouse = idWerehouse;
        this.idGoods = idGoods;
        this.quantity = quantity;
    }

    public String getIdWerehouse() {
        return idWerehouse;
    }

    public String getIdGoods() {
        return idGoods;
    }

    public int getQuantity() {
        return quantity;
    }
}
