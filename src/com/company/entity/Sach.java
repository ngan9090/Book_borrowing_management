package com.company.entity;

import com.company.contant.GiaTri_Sach;

import java.util.Scanner;

public class Sach implements Nhap{

    private static int MA_SACH = 10000;
    private int maSach;
    private String tenSach;
    private String tacGia;
    private GiaTri_Sach chuyenNganh;
    private String namXuatBan;

    public int getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public GiaTri_Sach getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(GiaTri_Sach chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }


    @Override
    public String toString() {
        return "Sach{" +
                "maSach='" + maSach + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", chuyenNganh='" + chuyenNganh + '\'' +
                ", namXuatBan='" + namXuatBan + '\'' +
                '}';
    }

    //Input reader
    @Override
    public void nhapThongTin() {
        this.maSach = Sach.MA_SACH++;
        System.out.print("\nNhập tên sách : ");
        this.tenSach = new Scanner(System.in).nextLine();
        System.out.print("Nhập tên tác giả: ");
        this.tacGia = new Scanner(System.in).nextLine();
        this.nhapChuyenNganh();
        System.out.print("Nhập năm xuất bản: ");
        this.namXuatBan = new Scanner(System.in).nextLine();
    }

    public void nhapChuyenNganh(){
        System.out.println("Nhập chuyên ngành là một trong những loại dưới đây : ");
        System.out.println("1. " + GiaTri_Sach.KHOA_HOC);
        System.out.println("2. " + GiaTri_Sach.VAN_HOC);
        System.out.println("3. " + GiaTri_Sach.DIEN_TU);
        System.out.println("4. " + GiaTri_Sach.CONG_NGHE);
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice < 1 || choice > 4) {
                System.out.print("Xin vui lòng nhập lại loại chuyên ngành từ 1 đến 4.");
            }
        } while (choice < 1 || choice > 4);
        switch (choice) {
            case 1:
                this.chuyenNganh = GiaTri_Sach.KHOA_HOC;
                break;
            case 2:
                this.chuyenNganh = GiaTri_Sach.VAN_HOC;
                break;
            case 3:
                this.chuyenNganh = GiaTri_Sach.DIEN_TU;
                break;
            case 4:
                this.chuyenNganh = GiaTri_Sach.CONG_NGHE;
                break;
        }
    }
}
