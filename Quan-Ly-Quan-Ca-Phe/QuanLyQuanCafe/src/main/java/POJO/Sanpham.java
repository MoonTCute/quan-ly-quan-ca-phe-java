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
public class Sanpham {
    String masp, tensp, dvt, malsp;
    int giatien;

    public Sanpham(String masp, String tensp, int giatien, String dvt, String malsp) {
        this.masp = masp;
        this.tensp = tensp;
        this.dvt = dvt;
        this.malsp = malsp;
        this.giatien = giatien;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public void setMalsp(String malsp) {
        this.malsp = malsp;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public String getMasp() {
        return masp;
    }

    public String getTensp() {
        return tensp;
    }

    public String getDvt() {
        return dvt;
    }

    public String getMalsp() {
        return malsp;
    }

    public int getGiatien() {
        return giatien;
    }
}
