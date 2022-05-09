package com.company.entity;

import com.company.contant.GiaTri_BanDoc;

import java.util.Scanner;

public class BanDoc extends  ConNguoi implements Comparable<BanDoc>{

    private static int MA_BAN_DOC = 10000;
    private GiaTri_BanDoc loai;

    private GiaTri_BanDoc getLoai() {
        return loai;
    }

    public void setLoai(GiaTri_BanDoc giaTri_banDoc) {
        this.loai = loai;
    }

    @Override
    public String toString() {
        return "BanDoc{" +
                "ma='" + maBanDoc + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", loai='" + loai + '\'' +
                '}';
    }

    //Nhập thông tin
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        this.maBanDoc = BanDoc.MA_BAN_DOC++;
        this.nhapLoaiBanDoc();
    }


    //Nhập mã sinh viên
    public void nhapLoaiBanDoc() {
        System.out.println("Nhập loại bạn đọc là một trong những loại dưới đây : ");
        System.out.println("1. " + GiaTri_BanDoc.SINH_VIEN);
        System.out.println("2. " + GiaTri_BanDoc.HOC_VIEN);
        System.out.println("3. " + GiaTri_BanDoc.GIAO_VIEN);
        System.out.print("Nhập lựa chọn của bạn: ");
        int chon = 0;
        do {
            chon = new Scanner(System.in).nextInt();
            if(chon < 1 || chon > 3){
                System.out.print("Xin vui lòng nhập lại loại bạn đọc từ 1 đến 3: ");
            }
        } while (chon < 1 || chon > 3);
        switch (chon){
            case 1:
                this.loai = GiaTri_BanDoc.SINH_VIEN;
                break;
            case 2:
                this.loai = GiaTri_BanDoc.HOC_VIEN;
                break;
            case 3:
                this.loai = GiaTri_BanDoc.GIAO_VIEN;
                break;
        }
    }


    @Override
    public int compareTo(BanDoc bandoc) {
            if (this.maBanDoc > bandoc.getMaBanDoc()) {
                return 1;
            } else if (this.maBanDoc < bandoc.getMaBanDoc()) {
                return -1;
            }
            return 0;
        }
}
