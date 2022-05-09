package com.company.entity;

import java.util.Arrays;

public class MuonSach implements Comparable<MuonSach>{
    private BanDoc banDoc;
    protected MuonSachChiTiet[] muonSachChiTiets;

    public MuonSach() {
    }

    public MuonSach(BanDoc banDoc, MuonSachChiTiet[] muonSachChiTiets) {
        this.banDoc = banDoc;
        this.muonSachChiTiets = muonSachChiTiets;
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public MuonSachChiTiet[] getMuonSachChiTiets() {
        return muonSachChiTiets;
    }

    public void setMuonSachChiTiets(MuonSachChiTiet[] muonSachChiTiets) {
        this.muonSachChiTiets = muonSachChiTiets;
    }

    @Override
    public String toString() {
        return "MuonSach{" +
                "banDoc=" + banDoc +
                ", muonSachChiTiets=" + Arrays.toString(muonSachChiTiets) +
                '}';
    }

    @Override
    public int compareTo(MuonSach muonSach){
       int soluong1 = 0;
       int soluong2 = 0;
        for (int i = 0; i < this.muonSachChiTiets.length; i++) {
            soluong1 += this.muonSachChiTiets[i].getSoLuong();
        }
        for (int i = 0; i < muonSach.muonSachChiTiets.length; i++) {
            soluong2 += muonSach.muonSachChiTiets[i].getSoLuong();
        }
       return soluong1 - soluong2;
    }
}
