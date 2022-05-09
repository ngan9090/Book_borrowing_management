package com.company.logic;

import com.company.RunMain;
import com.company.entity.Sach;

import java.util.Scanner;

public class DichVuSach {
    //=========================================
    //Book
    public static void nhapSach() {
        System.out.print("Nhập n sách : ");
        int bookNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < bookNumber; i++) {
            System.out.print("Nhập sách số " + (i + 1));
            Sach sach = new Sach();
            //Thêm bạn đọc
            sach.nhapThongTin();
            //Lưu bạn đọc
            luuSach(sach);
        }
    }

    public static void inSach() {
        for (int i = 0; i < RunMain.sachs.length; i++) {
            if (RunMain.sachs[i] == null) {
                continue;
            }
            System.out.println(RunMain.sachs[i]);
        }
    }

    public static void luuSach(Sach sach) {
        for (int i = 0; i < RunMain.sachs.length; i++) {
            if (RunMain.sachs[i] == null) {
                RunMain.sachs[i] = sach;
                break;
            }
        }
    }

    public static boolean isSachRong() {
        for (int i = 0; i < RunMain.sachs.length; i++) {
            if (RunMain.sachs[i] != null) {
                return false;
            }
        }
        return true;
    }
    //===========================================
}
