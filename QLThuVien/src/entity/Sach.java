package entity;

import java.util.Scanner;

public class Sach {

    public static final String KHTN = "Khoa học tự nhiên";
    public static final String VH_NT = "Văn học nghệ thuật";
    public static final String DTVT = "Điện tử viễn thông";
    public static final String CNTT = "Công nghệ thông tin";

    private static int AUTO_ID=-1;
    private int maSach;
    private String tenSach;
    private String tacGia;
    private String chuyenNganh;


    public Sach(){
        if(AUTO_ID==-1){
            AUTO_ID=10000;
            this.maSach=AUTO_ID;
            return;
        }
        this.maSach=++AUTO_ID;

    }

    public Sach( String tenSach, String tacGia, String chuyenNganh) {
        AUTO_ID=10000;
        this.maSach =  AUTO_ID++;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
    }

    public int getMasach(){
        return maSach;
    }

    public String getTensach(){
        return tenSach;
    }

    public void setTensach(String tenSach){
        this.tenSach=tenSach;
    }

    public String getTacgia(){
        return tacGia;
    }
    public void setTacgia(String tacGia){
        this.tacGia=tacGia;
    }

    public String getChuyennganh(){
        return chuyenNganh;
    }

    public void setChuyennganh(String chuyennganh){
        this.chuyenNganh=chuyennganh;
    }


    @Override
    public String toString(){
        return "entity.Sach{" +
                "maSach"+maSach+
                ", tenSach='"+tenSach+'\''+
                ", tacGia='"+tacGia+'\''+
                ", chuyenNganh='"+chuyenNganh+'\''+
                '}';
    }

    public void nhapThongtinSach(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập tên sách: ");
        this.tenSach=sc.nextLine();
        System.out.println("Nhập tên tác giả: ");
        this.tacGia=sc.nextLine();
        System.out.println("Nhập chuyên ngành là 1 trong các lựa chọn dưới đây: ");
        System.out.println("1. Khoa học tự nhiên");
        System.out.println("2. Văn học nghệ thuật");
        System.out.println("3. Điện tử viễn thông");
        System.out.println("4. Công nghệ thông tin");
        System.out.print("Xin mời nhập lựa chọn: ");
        int choice=-1;
        do {
            choice=sc.nextInt();
            if(choice<4&&choice>=1){
                break;
            }

        }while (choice>4||choice<1);
        switch (choice){
            case 1:
                this.chuyenNganh=Sach.KHTN;
                break;
            case 2:
                this.chuyenNganh=Sach.VH_NT;
                break;
            case 3:
                this.chuyenNganh=Sach.DTVT;
                break;
            case 4:
                this.chuyenNganh=Sach.CNTT;

        }

    }



}
