package com.company.logic;

import com.company.RunMain;
import com.company.entity.BanDoc;

import java.util.Scanner;

public class DichVuBanDoc {
    //Bạn đọc
    public static void nhapBanDoc() {
        System.out.print("Nhập n bạn đọc : ");
        int studentNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < studentNumber; i++) {
            System.out.print("Nhập bạn đọc số " + (i + 1) + ": ");
            BanDoc banDoc = new BanDoc();
            //Thêm bạn đọc
            banDoc.nhapThongTin();
            //Lưu bạn đọc
            luuBanDoc(banDoc);
        }
    }

    public static void inBanDoc() {
        for (int i = 0; i < RunMain.bandocs.length; i++) {
            if (RunMain.bandocs[i] == null) {
                continue;
            }
            System.out.println(RunMain.bandocs[i]);
        }
    }

    public static void luuBanDoc(BanDoc banDoc) {
        for (int i = 0; i < RunMain.bandocs.length; i++) {
            if (RunMain.bandocs[i] == null) {
                RunMain.bandocs[i] = banDoc;
                break;
            }
        }
    }

    public static boolean isBanDocRong() {
        for (int i = 0; i < RunMain.bandocs.length; i++) {
            if (RunMain.bandocs[i] != null) {
                return false;
            }
        }
        return true;
    }
}
