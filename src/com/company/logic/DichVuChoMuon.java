package com.company.logic;

import com.company.RunMain;
import com.company.entity.BanDoc;
import com.company.entity.MuonSach;
import com.company.entity.MuonSachChiTiet;
import com.company.entity.Sach;
import java.util.Locale;
import java.util.Scanner;

public class DichVuChoMuon {

    public static void borrowBook() {
    }

    public static void hienThiMuonSach() {
        for (int i = 0; i < RunMain.muonSachs.length; i++) {
            if (RunMain.muonSachs[i] != null) {
                System.out.println(RunMain.muonSachs[i]);
            }
        }
    }

    public static void luuMuonSach(MuonSach muonSach) {
        for (int j = 0; j < RunMain.muonSachs.length; j++) {
            if (RunMain.muonSachs[j] == null) {
                RunMain.muonSachs[j] = muonSach;
                break;
            }
        }
    }

    public static BanDoc nhapThongtinBanDoc(int donHang) {
        System.out.print("Nhập vào mã bạn đọc thứ " + (donHang + 1) + " muốn mượn sách: ");
        BanDoc banDoc = null;
        do {
            int maBanDoc = new Scanner(System.in).nextInt();
            for (int i = 0; i < RunMain.bandocs.length; i++) {
                if (RunMain.bandocs[i] != null && RunMain.bandocs[i].getMaBanDoc() == maBanDoc) {
                    banDoc = RunMain.bandocs[i];
                    break;
                }
            }
            if (banDoc != null) {
                break;
            }
            System.out.print("Không tìm thấy bạn đọc, vui lòng nhập lại: ");
        } while (true);
        return banDoc;
    }

    public static MuonSachChiTiet[] nhapMuonSachChiTiet() {
        System.out.print("Nhập số lượng đầu sách mà bạn này muốn mượn (dưới 5 đầu sách): ");
        int soLuongSach = -1;
        do {
            soLuongSach = new Scanner(System.in).nextInt();
            if (soLuongSach > 0 && soLuongSach <= 5) {
                break;
            }
            System.out.print("Bạn chỉ có thể mượn trong 5 đầu sách. Xin vui lòng nhập lại số lượng đầu sách bạn muốn mượn: ");
        } while (true);

        //Nhập sách và số lượng muốn mượn tương ứng
        MuonSachChiTiet[] muonSachChiTiets = new MuonSachChiTiet[soLuongSach];
        for (int h = 0; h < soLuongSach; h++) {
            System.out.print("Nhập mã đầu sách thứ " + (h + 1) + " mà bạn đọc này muốn mượn: ");
            Sach sach = null;
            do {
                int maSach = new Scanner(System.in).nextInt();
                for (int i = 0; i < RunMain.sachs.length; i++) {
                    if (RunMain.sachs[i] != null && RunMain.sachs[i].getMaSach() == maSach) {
                        sach = RunMain.sachs[i];
                        break;
                    }
                }
                if (sach != null) {
                    break;
                }
                System.out.print("Không tìm thấy sách với mã vừa nhập, vui lòng nhập lại mã: ");

            } while (true);
            System.out.print("Đầu sách này bạn muốn mượn bao nhiêu cuốn: ");
            int soLuongCuonSach = -1;
            do {
                soLuongCuonSach = new Scanner(System.in).nextInt();
                if (soLuongCuonSach > 0 && soLuongCuonSach <= 3) {
                    break;
                }
                System.out.print("Mỗi đầu sách bạn chỉ được nhập tối đa 3 cuốn. Xin vui lòng nhập lại số lượng: ");
            } while (true);

            MuonSachChiTiet muonSachChiTiet = new MuonSachChiTiet(sach, soLuongCuonSach);
            for (int j = 0; j < muonSachChiTiets.length; j++) {
                if (muonSachChiTiets[j] == null) {
                    muonSachChiTiets[j] = muonSachChiTiet;
                    break;
                }
            }
        }
        return muonSachChiTiets;
    }

    //Mượn sách
    public static void dichVuMuonSach() {
        if (DichVuSach.isSachRong() || DichVuBanDoc.isBanDocRong()) {
            System.out.print("Bạn cần nhập dữ liệu sách và bạn đọc trước khi cho mượn sách. ");
            return;
        }
        System.out.print("Nhập vào số lượng bạn đọc muốn mượn sách: ");
        int soLuongSach = new Scanner(System.in).nextInt();
        for (int i = 0; i < soLuongSach; i++) {
            //Nhập bạn đọc muốn mượn sách
            BanDoc banDoc = nhapThongtinBanDoc(i);

            //Nhập danh sách mà bạn đọc muốn mượn
            MuonSachChiTiet[] muonSachChiTiets = nhapMuonSachChiTiet();

            MuonSach muonSach = new MuonSach(banDoc, muonSachChiTiets); // 1 lượt mượn sách
            luuMuonSach(muonSach);
        }
    }

    //Tiềm kiếm mượn sách bằng tên bạn đọc
    public static void timMuonSachBangTen() {
        System.out.print("Nhập tên bạn đọc mà bạn muốn tìm kiếm: ");
        String tuKhoa = new Scanner(System.in).nextLine();
        for (int i = 0; i < RunMain.muonSachs.length; i++) {
            if (RunMain.muonSachs[i] != null && RunMain.muonSachs[i].getBanDoc().getHoTen().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))) {
                System.out.println(RunMain.muonSachs[i]);
            }
        }
    }

    //Sắp sếp
    public static void sapSep() {
        int chon = 0;
        System.out.println("Chọn loại sắp sếp danh sách sách cho mượn: ");
        System.out.println("     1.Theo tên bạn đọc");
        System.out.println("     2.Theo số lượng sách (giảm dần)");
        System.out.print("Nhập lựa chọn của bạn: ");
        do {
            chon = new Scanner(System.in).nextInt();
            if (chon >= 1 && chon < 3) {
                break;
            }
            System.out.print("Chọn giá trị 1 hoặc 2. Xin vui lòng chọn lại: ");
        } while (true);
        switch (chon) {
            case 1:
                sapSepDanhSachTheoTen();
                break;
            case 2:
                sapSepDanhSachTheoSoLuong();
                break;
        }
    }

    //Sắp sếp danh sách quản lý mượn sách theo tên bạn đọc
    public static void sapSepDanhSachTheoTen() {
        for (int i = 0; i < RunMain.muonSachs.length - 1; i++) {
            if (RunMain.muonSachs[i] == null) {
                continue;
            }
            for (int j = 0; j < RunMain.muonSachs.length; j++) {
                if (RunMain.muonSachs[j] == null) {
                    continue;
                }
                if (RunMain.muonSachs[i].getBanDoc().getHoTen().toLowerCase(Locale.ROOT).compareTo(RunMain.muonSachs[j].getBanDoc().getHoTen().toLowerCase(Locale.ROOT)) < 0) {
                    MuonSach tamThoi = RunMain.muonSachs[i];
                    RunMain.muonSachs[i] = RunMain.muonSachs[j];
                    RunMain.muonSachs[j] = tamThoi;
                }
            }
        }

        hienThiMuonSach();
    }

    //Sắp sếp danh sách quản lý mượn sách theo số lượng cuốn sách được mượn (giảm dần)
    public static void sapSepDanhSachTheoSoLuong() {
        for (int i = 0; i < RunMain.muonSachs.length - 1; i++) {
            if (RunMain.muonSachs[i] == null) {
                continue;
            }
            for (int j = 0; j < RunMain.muonSachs.length; j++) {
                if (RunMain.muonSachs[j] != null) {
                    if (RunMain.muonSachs[i].compareTo(RunMain.muonSachs[j]) > 0) {
                        MuonSach tamThoi = RunMain.muonSachs[i];
                        RunMain.muonSachs[i] = RunMain.muonSachs[j];
                        RunMain.muonSachs[j] = tamThoi;
                    }
                }
            }
        }
        hienThiMuonSach();
    }
}