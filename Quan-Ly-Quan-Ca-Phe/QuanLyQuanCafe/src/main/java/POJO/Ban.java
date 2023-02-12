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
public class Ban {
    String maban, tenban, trangthai;

    public Ban(String maban, String tenban, String trangthai) {
        this.maban = maban;
        this.tenban = tenban;
        this.trangthai = trangthai;
    }

    public void setMaban(String maban) {
        this.maban = maban;
    }

    public void setTenban(String tenban) {
        this.tenban = tenban;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getMaban() {
        return maban;
    }

    public String getTenban() {
        return tenban;
    }

    public String getTrangthai() {
        return trangthai;
    }
}
