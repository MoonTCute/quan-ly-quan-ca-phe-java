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
public class Loaisanpham {
    String malsp, tenlsp;

    public Loaisanpham(String malsp, String tenlsp) {
        this.malsp = malsp;
        this.tenlsp = tenlsp;
    }

    public String getMalsp() {
        return malsp;
    }

    public void setMalsp(String malsp) {
        this.malsp = malsp;
    }

    public String getTenlsp() {
        return tenlsp;
    }

    public void setTenlsp(String tenlsp) {
        this.tenlsp = tenlsp;
    }
}
