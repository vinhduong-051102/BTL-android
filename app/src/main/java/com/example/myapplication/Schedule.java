package com.example.myapplication;

import java.util.List;

public class Schedule {
    String buoi;
    String tiet;
    String monHoc;
    String giaoVien;
    String diaDiem;
    public String getBuoi(){return buoi;}
    public String getMonHoc(){return monHoc;}
    public String getTiet(){return tiet;}
    public String getGiaoVien(){return giaoVien;}
    public String getDiaDiem(){return diaDiem;}
    public void setBuoi(String buoi) {
        this.buoi = buoi;
    }
    public void setTiet(String tiet) {
        this.tiet = tiet;
    }
    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }
    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }
    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    @Override
    public String toString() {
        return "Buổi "+buoi+"-"+tiet+"\n"+monHoc+"\n"+giaoVien+"\n"+diaDiem;
    }

}
