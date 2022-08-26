package entity;

public class QLMuonSach {
    private Bandoc bandoc;
    private Sach sach;

    private  Chitietmuonsach ctms;
    private Chitietmuonsach[] chitietmuonsach;


    public Chitietmuonsach getChiTietMuonSach(){
        return ctms;
    }

    public   Sach getSach(){
        return sach;
    }

    public Bandoc getBandoc(){
        return bandoc;
    }


    public void setBandoc(Bandoc bandoc){
        this.bandoc=bandoc;
    }

    public Chitietmuonsach[] getChitietmuonsach(){
        return chitietmuonsach;
    }
    public void setChitietmuonsach(Chitietmuonsach[] chitietmuonsach){
        this.chitietmuonsach=chitietmuonsach;
    }
}
