/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author TIMOON
 */
public class Hoadon {

    String mahd, manv, maban, ngaylap,tinhtrang;
    int tongtien;
    
    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMaban() {
        return maban;
    }

    public void setMaban(String maban) {
        this.maban = maban;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public Hoadon(String mahd, String manv, String maban, String ngaylap, int tongtien, String tinhtrang) {
        this.mahd = mahd;
        this.manv = manv;
        this.maban = maban;
        this.ngaylap = ngaylap;
        this.tinhtrang = tinhtrang;
        this.tongtien = tongtien;
    }
    
}
