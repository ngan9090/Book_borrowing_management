package com.company.entity;

public class MuonSachChiTiet {
    protected Sach sach;
    protected int soLuong;

    public MuonSachChiTiet() {
    }

    public MuonSachChiTiet(Sach sach, int soLuong) {
        this.sach = sach;
        this.soLuong = soLuong;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "MuonSachChiTiet{" +
                "sach=" + sach +
                ", soLuong=" + soLuong +
                '}';
    }
}
