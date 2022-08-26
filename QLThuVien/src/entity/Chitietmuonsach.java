package entity;

public class Chitietmuonsach {

    private Sach sach;

    private int quantity;
    private String tinhtrang;

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getQuantity() {
        return quantity;
    }



    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTinhtrang(String tinhtrang){
        this.tinhtrang=tinhtrang;
    }

    @Override
    public String toString() {
        return "Chitietmuonsach{" +
                "sach=" + sach +
                ", quantity=" + quantity +
                ", tinhTrang=" + tinhtrang +
                '}';
    }

}
