package entity;

import java.util.Scanner;

public class Bandoc {

    public static final String SINH_VIEN = "Sinh viên";
    public static final String HOC_VIEN_CAO_HOC = "Học viên cao học";
    public static final String GIAO_VIEN = "Giáo viên";
    private static int AUTO_ID=-1;

    private int id;
    private int maBandoc;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String loaiBandoc;

    public  Bandoc(){
        if(AUTO_ID==-1){
            AUTO_ID=10000;
            this.maBandoc=AUTO_ID;
            return;
        }
        this.maBandoc=++AUTO_ID;
    }


    public int getMaBandoc(){
        return maBandoc;
    }
    public String getHoten(){
        return hoTen;
    }

    public void setHoten(String hoTen){
        this.hoTen=hoTen;
    }

    public String getDiachi(){
        return diaChi;
    }
    public void setDiachi(String diaChi){
        this.diaChi=diaChi;
    }
    public String getSDT(){
        return sdt;
    }
    public void setSDT(String sdt){
        this.sdt=sdt;
    }

    public String getLoaibandoc(){
        return loaiBandoc;
    }
    public void setLoaibandoc(String loaiBandoc){
        this.loaiBandoc=loaiBandoc;
    }

    @Override
    public String toString(){
        return "entity.Bandoc{" +
                "maBandoc"+maBandoc+
                ", hoTen='"+hoTen+'\''+
                ", diaChi='"+diaChi+'\''+
                ", sdt='"+sdt+'\''+
                ",loaiBandoc='"+loaiBandoc+'\''+
                '}';
    }

    public void nhapThongtinBandoc(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập tên bạn đọc: ");
        this.hoTen=sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.diaChi=sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.sdt=sc.nextLine();
        System.out.println("Nhập loại bạn đọc là 1 trong các lựa chọn dưới đây: ");
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giáo viên");
        System.out.print("Xin mời nhập lựa chọn: ");
        int choice=-1;
        do {
            choice=sc.nextInt();
            if(choice>=1&&choice<=3){
                break;
            }
        }while (choice>3||choice<1);

        switch (choice){
            case 1:
                this.loaiBandoc=Bandoc.SINH_VIEN;
                break;
            case 2:
                this.loaiBandoc=Bandoc.HOC_VIEN_CAO_HOC;
                break;
            case 3:
                this.loaiBandoc=Bandoc.GIAO_VIEN;
                break;
        }
    }
}
