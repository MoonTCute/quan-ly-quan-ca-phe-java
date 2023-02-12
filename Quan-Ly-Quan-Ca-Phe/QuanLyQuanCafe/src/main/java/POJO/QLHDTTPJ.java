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
public class QLHDTTPJ {
    String masp, tensp, dvt, malsp;
    int giatien, soluong;

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getMalsp() {
        return malsp;
    }

    public void setMalsp(String malsp) {
        this.malsp = malsp;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public QLHDTTPJ(String masp,  String tensp,int soluong, int giatien, String dvt, String malsp) {
        this.masp = masp;
        this.tensp = tensp;
        this.dvt = dvt;
        this.malsp = malsp;
        this.giatien = giatien;
        this.soluong = soluong;
    }
    
}
