package com.company;

import com.company.entity.BanDoc;
import com.company.entity.MuonSach;
import com.company.entity.Sach;
import com.company.logic.DichVuBanDoc;
import com.company.logic.DichVuChoMuon;
import com.company.logic.DichVuSach;

import java.util.Scanner;

public class RunMain {
    public static BanDoc [] bandocs = new BanDoc[100];
    public static Sach[] sachs = new Sach[100];
    public static MuonSach[] muonSachs = new MuonSach[100];

    public static void main(String[] args) {
        chucNangChon();
    }

    private static void hienThiChon() {
        System.out.println("============Menu=============");
        System.out.println("Chọn số từ 1 đến 8. ");
        System.out.println("1. Nhập đầu sách mới.");
        System.out.println("2. In ra danh sách sách trong thư viện.");
        System.out.println("3. Nhập bạn đọc mới.");
        System.out.println("4. In ra danh sách bạn đọc trong thư viện.");
        System.out.println("5. Thực hiện cho mượn sách.");
        System.out.println("6. Sắp xếp danh sách mượn sách .");
        System.out.println("7. Tìm kiếm trong danh sách mượn sách theo tên bạn đọc.");
        System.out.println("8.Thoát chương trình.");
        System.out.println("============================");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    private static void chucNangChon() {
        while (true) {
            int giatriChon = giaTriChon();
            switch (giatriChon) {
                case 1:
                    DichVuSach.nhapSach();
                    break;
                case 2:
                    DichVuSach.inSach();
                    break;
                case 3:
                    DichVuBanDoc.nhapBanDoc();
                    break;
                case 4:
                    DichVuBanDoc.inBanDoc();
                    break;
                case 5:
                    DichVuChoMuon.dichVuMuonSach();
                    break;
                case 6:
                    DichVuChoMuon.sapSep();
                    break;
                case 7:
                    DichVuChoMuon.timMuonSachBangTen();
                    break;
                case 8:
                    return;
            }
        }
    }

    //Lựa chọn
      public static int giaTriChon(){
          hienThiChon();
          int chon = 0;
          do {
              chon = new Scanner(System.in).nextInt();
              if (chon >= 1 && chon <= 8) {
                  break;
              }
              System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại chức năng từ 1 đến 8: ");
          } while (true);
          return chon;
      }

}
