import entity.Bandoc;
import entity.QLMuonSach;
import entity.Sach;
import  entity.Chitietmuonsach;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class MainRun {

    Scanner sc=new Scanner(System.in);
    private static Bandoc[] BANDOC=new Bandoc[100];// chứa dữ liệu bạn đọc
    private static Sach[] SACH=new Sach[100];//tập hợp chưa dữ liệu sách
    private static QLMuonSach[] QLMUONSACH=new QLMuonSach[100];//tập hợp chứa danh sách mượn sahsc
    private static Chitietmuonsach[] CHITIETMUONSACH=new Chitietmuonsach[100];






    public static void main(String[] args) {
        showMenu();
    }




    public static void showMenu(){
        themSach();
        while (true){
            int functionChoice=functionChoice();
            switch (functionChoice){
                case 1:
                    NhapBandoc();
                    break;
                case 2:
                    HienthiBandoc();
                    break;
                case 3:
                    NhapDausach();
                    break;
                case 4:
                    HienthiDausach();
                    break;
                case 5:
                    createQLMuonsach();
                    showQlmuonsach();
                    break;
                case 6:
                    showQlmuonsach();
                    break;
                case 7:
                    sapXepPhieuMuon();// theo tên
                    break;
                case 8:
                    sapXepPhieuMuonTheoSL();// theo số lượng sách mượn giảm dần
                    break;
                case 9:
                    timKiemTheoTen();
                    break;


                case 10:
                    System.out.println("Cảm ơn bạn đã xử dụng phần mềm của chúng tôi");
                    return;
            }

        }
    }
    private static  void themSach(){
        Sach sach0=new Sach("Van","van","Van hoc nghe thuat");
        SACH[0]=sach0;
//        Sach sach1=new Sach("Dien","dien","Dien tu");
//        SACH[1]=sach1;
    }
    private static void themBandoc(){
        Bandoc bandoc0=new Bandoc();
    }

    private static int functionChoice(){
        Scanner sc=new Scanner(System.in);
        System.out.println("============= Chương trình quản lý thư viện ==============");
        System.out.println("1.Nhập danh sách bạn đọc");
        System.out.println("2.Hiển thị danh sách bạn đọc");
        System.out.println("3.Nhập đầu sách");
        System.out.println("4.Hiển thị danh sách đầu sách");
        System.out.println("5.Lập phiếu mượn cho bạn đọc");
        System.out.println("6.Hiển thị danh sách phiếu mượn");
        System.out.println("7.Sắp xếp danh sách phiếu mượn theo tên");
        System.out.println("8.Sắp xếp danh sách phiếu mượn theo số lượng sách mượn");
        System.out.println("9.Tìm kiếm theo tên");
        System.out.println("10.Thoát");


        System.out.println("Xin mời nhập lựa chọn của bạn");
        int functionChoice=-1;
        do {
            functionChoice=sc.nextInt();
            if(functionChoice<10&&functionChoice>=1){
                break;
            }

        }while (functionChoice>10||functionChoice<1);
        return functionChoice;
    }

    private static void NhapBandoc(){
        //nhập khách hàng mới

        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số lượng bạn đọc muốn thêm:");
        int slbandoc=sc.nextInt();
        for (int i = 0; i < slbandoc; i++) {
            System.out.println("Nhập thông tin bạn đọc thứ "+(i+1));
            //nhập thông tin cho khách hàng
            Bandoc bd=new Bandoc();
            bd.nhapThongtinBandoc();
            //lưu thông tin khách hàng=> thêm vào mảng BANDOC
            LuuBandoc(bd);
        }

    }

    private static void LuuBandoc(Bandoc bandoc){
        for (int i = 0; i <BANDOC.length; i++) {
            if(BANDOC[i]==null){
                BANDOC[i]=bandoc;
                break;
            }
        }
    }

    private static void HienthiBandoc(){
        for (int i = 0; i < BANDOC.length; i++) {
            if(BANDOC[i]==null){
                continue;
            }
            System.out.println(BANDOC[i]);
        }
    }


    private static void NhapDausach(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng đầu sách muốn thêm:");
        int sldausach=sc.nextInt();
        for (int i = 0; i < sldausach; i++) {
            System.out.println("Nhập thông tin đầu sách thứ "+(i+1));
            Sach sach=new Sach();
            sach.nhapThongtinSach();
            LuuDausach(sach);
        }
    }

    private static void LuuDausach(Sach sach){
        for (int i = 0; i < SACH.length; i++) {
            if(SACH[i]==null){
                SACH[i]=sach;
                break;
            }
        }
    }

    private static void HienthiDausach(){
        for (int i = 0; i < SACH.length; i++) {
            if(SACH[i]==null){
                continue;
            }
            System.out.println(SACH[i]);
        }
    }


    private static void createQLMuonsach(){

        Scanner sc=new Scanner(System.in);
        if(!checkData()){
            System.out.println("Chưa có dữ liệu về người đọc hoặc đầu sách, vui lòng thêm dữ liệu.");
            return;
        }
        System.out.println("Nhập số lượng bạn đọc muốn mượn sách:");
        int slbandoc=sc.nextInt();
        for (int i = 0; i < slbandoc; i++) {
            QLMuonSach qlms=new QLMuonSach();
            Bandoc bandoc=nhapBandoc(i);

            qlms.setBandoc(bandoc);

            Chitietmuonsach[] chitietmuonsaches= createChitietmuonsach();
            qlms.setChitietmuonsach(chitietmuonsaches);
            //lưu luôn vào danh sách quản lý mượn sách của thư viện.


            saveQLMS(qlms);


        }
    }

    private static void saveQLMS(QLMuonSach qlms){
        for (int i = 0; i < QLMUONSACH.length; i++) {
            if(QLMUONSACH[i]==null){
                QLMUONSACH[i]=qlms;
                return;
            }
        }
    }



    private static boolean checkData(){
        boolean coDulieunguoidoc=false;
        for (int i = 0; i < BANDOC.length; i++) {
            if(BANDOC[i]!=null){
                coDulieunguoidoc=true;
                break;
            }
        }
        boolean coDulieuSach=false;
        for (int i = 0; i < SACH.length; i++) {
            if(SACH[i]!=null){
                coDulieuSach=true;
                break;
            }
        }
        return coDulieunguoidoc&&coDulieuSach;
    }



    private static Chitietmuonsach[] createChitietmuonsach(){
        System.out.println("Nhập số lượng đầu sách bạn đọc muốn mượn:");
        int sldausach;
        do {

            sldausach=new Scanner(System.in).nextInt();
            if(sldausach<5&&sldausach>=1){
                break;
            }
            System.out.println("Không được vượt quá 5 đầu sách");
        }while (true);
        Chitietmuonsach[] chitietmuonsaches=new Chitietmuonsach[sldausach];
        for (int i = 0; i < sldausach; i++) {
            Chitietmuonsach chitietmuon=new Chitietmuonsach();

            //xác định được xem bạn đọc muoons mượn sách nào
            //bắt bạn đọc nhập mã sách đầu sách muốn mượn
            Sach sach=nhapSach(i);
            //lưu đầu sách tìm được vào chi tiết đơn hàng(chi tiết mượn sách)
            chitietmuon.setSach(sach);

            System.out.println("Nhập số lượng sách muốn mượn:");
            int quantity;
            do {
                quantity=new Scanner(System.in).nextInt();
                if(quantity>0&&quantity<=3){
                    break;
                }
                System.out.println("Không được mượn quá 3 sách");
            }while (true);

            chitietmuon.setQuantity(quantity);

            System.out.print("Tình trạng hiện thời của sach: ");
            String tinhtrang=new Scanner(System.in).nextLine();
            chitietmuon.setTinhtrang(tinhtrang);

            //lưu chi tiết sách vừa nhập
            for (int j = 0; j < chitietmuonsaches.length; j++) {
                if (chitietmuonsaches[i]==null){
                    chitietmuonsaches[i]=chitietmuon;
                    break;
                }
            }

        }
        return chitietmuonsaches;
    }

    private static Sach nhapSach(int index){
        System.out.println("Xin mời nhập mã sách của đầu sách thứ "+(index+1)+"ma bạn đọc này muốn mượn:");
        int masach;
        Sach sach;
        do {
            masach=new Scanner(System.in).nextInt();
            sach=searchSachbyid(masach);
            if(sach!=null){
                break;

            }
            System.out.println("Không tồn tại mã sách có id là "+masach+",vui lòng nhập lại");
        }while (true);
        return sach;
    }

    private static Bandoc nhapBandoc(int index){
        System.out.println("Nhập mã bạn đọc thứ"+(index+1)+"muốn mượn sách:");
        int maBandoc;
        Bandoc bandoc;
        do{
            maBandoc=new Scanner(System.in).nextInt();


            bandoc=searchBandocbyid(maBandoc);
            if(bandoc!=null){
                break;
            }
            System.out.println("Không tồn tại bạn đọc có mã là "+maBandoc+",vui lòng nhập lại");
        }while (true);
        return bandoc;
    }


    private static Bandoc searchBandocbyid(int maBandoc){
        for (int i = 0; i < BANDOC.length; i++) {
            Bandoc bandoc=BANDOC[i];
            if(bandoc!=null&&bandoc.getMaBandoc()==maBandoc){
                return bandoc;
            }

        }
        return null;
    }
    private static Sach searchSachbyid(int maSach){
        for (int i = 0; i < SACH.length; i++) {
            Sach sach=SACH[i];
            if(sach!=null&&sach.getMasach()==maSach){
                return sach;
            }
        }
        return null;
    }




    private static void sapXepPhieuMuon(){
        boolean coDulieuPhieuMuon=false;
        for (int i = 0; i <QLMUONSACH.length ; i++) {
            if (QLMUONSACH[i]!=null){
                coDulieuPhieuMuon=true;
            }
        }
        if (!coDulieuPhieuMuon){
            System.out.println("Chưa có phiếu mượn nào trong hệ thống, vui lòng tạo phiếu mượn trước khi thực hiện.");
            return;
        }

        sapXepDSTheoTen();
        //sắp xepps xong mới show
        showQlmuonsach();
    }

    private static void sapXepPhieuMuonTheoSL(){
        boolean coDulieuPhieuMuon=false;
        for (int i = 0; i <QLMUONSACH.length ; i++) {
            if (QLMUONSACH[i]!=null){
                coDulieuPhieuMuon=true;
            }
        }
        if (!coDulieuPhieuMuon){
            System.out.println("Chưa có phiếu mượn nào trong hệ thống, vui lòng tạo phiếu mượn trước khi thực hiện.");
            return;
        }

        sapXepDSTheoSLSachMuon();
        //sắp xepps xong mới show
        showQlmuonsach();
    }

    public static void sapXepDSTheoTen(){

        int n = QLMUONSACH.length;

        for (int i = 0; i < n; i++) {
//            QLMuonSach qlms1=QLMUONSACH[i];
            for (int j = i +1; j < n; j++) {
                QLMuonSach qlms1=QLMUONSACH[i];
                 QLMuonSach qlms2=QLMUONSACH[j];
                 if(qlms1 == null || qlms2 == null){
                     return;
                 }
                if (qlms1.getBandoc().getHoten().compareTo(qlms2.getBandoc().getHoten())>0){
                    QLMuonSach temp = qlms1;
                    QLMUONSACH[i]= QLMUONSACH[j+1];
                    QLMUONSACH[j+1]= temp;
                }

            }

        }
    }

//    private static void sapXepDSTheoTen(){
//        for (int i=0;i<QLMUONSACH.length-1;i++){
//            QLMuonSach qlms1=QLMUONSACH[i];
//            for (int j = i+1; j <QLMUONSACH.length ; j++) {
//                QLMuonSach qlms2=QLMUONSACH[j];
//                if(qlms2!=null){
//                    if (qlms1.getBandoc().getHoten().compareTo(qlms2.getBandoc().getHoten())>0){
//                        QLMuonSach temp = qlms1;
//                        QLMUONSACH[i]= qlms2;
//                        QLMUONSACH[j]= temp;
//                    }
//                }else {
//                    break;
//                }
//
//            }
//        }
//    }
//

    private static void sapXepDSTheoSLSachMuon() {
        for (int i = 0; i < QLMUONSACH.length - 1; i++) {
            QLMuonSach order1 = QLMUONSACH[i];
            for (int j = i+1; j < QLMUONSACH.length; j++) {
                QLMuonSach order2 = QLMUONSACH[j];
                if(order2!=null){
                    if (order1.getChiTietMuonSach().getQuantity()<order2.getChiTietMuonSach().getQuantity()){
                        QLMuonSach temp = order1;
                        QLMUONSACH[i]= order2;
                        QLMUONSACH[j]= temp;
                    }
                }else {
                    break;
                }
            }
        }
    }





    private static void showQlmuonsach(){
        for (int i = 0; i < QLMUONSACH.length; i++) {
            QLMuonSach qlms=QLMUONSACH[i];
            if (qlms!=null){
                System.out.println("Bạn đọc "+qlms.getBandoc().getHoten()+" đã mượn các đầu sách sau:");
                for (int j = 0; j < qlms.getChitietmuonsach().length; j++) {
                    System.out.println(qlms.getChitietmuonsach()[j]);
                }
                System.out.println("--------------------------------");
            }
        }
    }

    private static void timKiemTheoTen(){
        System.out.println("Nhập tên bạn đọc mượn sách muốn tìm kiếm:");
        String name=new Scanner(System.in).nextLine();


        System.out.println("Danh sách bạn đọc mượn sách được tìm thấy:");

        for (int i = 0; i < QLMUONSACH.length; i++) {
            QLMuonSach qlms=QLMUONSACH[i];


            if (qlms!=null){
                if (QLMUONSACH[i].getBandoc().getHoten().toLowerCase().contains(name)==true){
                    System.out.println("Bạn đọc "+qlms.getBandoc().getHoten()+" đã mượn các đầu sách sau:");
                    for (int j = 0; j < qlms.getChitietmuonsach().length; j++) {
                        System.out.println(qlms.getChitietmuonsach()[j]);
                    }
                }

                System.out.println("--------------------------------");

//            if(QLMUONSACH[i]!=null){
//                if (QLMUONSACH[i].getBandoc().getHoten().toLowerCase().contains(name)==true){
//                    System.out.println(BANDOC[i]);
//                }
            }
        }
    }



}

