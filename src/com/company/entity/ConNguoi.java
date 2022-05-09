package com.company.entity;

import java.util.Scanner;

public class ConNguoi implements Nhap {

    protected int maBanDoc;
    protected String hoTen;
    protected String diaChi;
    protected String soDienThoai;

    public ConNguoi() {
    }

    public int getMaBanDoc() {
        return maBanDoc;
    }

    public void setMaBanDoc(int maBanDoc) {
        this.maBanDoc = maBanDoc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public void nhapThongTin(){
        System.out.print("\nNhập tên bạn đọc: ");
        this.setHoTen(new Scanner(System.in).nextLine());
        System.out.print("Nhập địa chỉ bạn đọc: ");
        this.setDiaChi(new Scanner(System.in).nextLine());
        System.out.print("Nhập số điện thoại bạn đọc: ");
        this.setSoDienThoai(new Scanner(System.in).nextLine());
    };
}
