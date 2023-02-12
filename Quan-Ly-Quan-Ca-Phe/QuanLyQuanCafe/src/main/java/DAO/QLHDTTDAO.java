/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TIMOON
 */
public class QLHDTTDAO {
    public static ArrayList<QLHDTTPJ> getDSQLHDTT(){
        ArrayList<QLHDTTPJ> dsql = new ArrayList<QLHDTTPJ>();
        try {
                String sql = "select SanPham.MaSP, TenSP,SoLuong, GiaTien, DVT, MaLSP from ChiTietHoaDon, SanPham, HoaDon, Ban where Ban.Maban = Hoadon.Maban and HoaDon.Mahd = Chitiethoadon.mahd and chitiethoadon.masp = sanpham.masp";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                QLHDTTPJ ql = new QLHDTTPJ(rs.getString("masp").trim(), rs.getString("tensp").trim(),rs.getInt("soluong"), rs.getInt("giatien"), rs.getString("dvt"), rs.getString("malsp").trim());
                dsql.add(ql);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu bàn");
        }
        return dsql;
    }
        public static ArrayList<QLHDTTPJ> HienthiDLHD(String Maban){
        ArrayList<QLHDTTPJ> dshd = new ArrayList<QLHDTTPJ>();
        try {
            String sql = "select SanPham.MaSP, TenSP, Soluong, GiaTien, DVT, MaLSP from ChiTietHoaDon, SanPham, HoaDon, Ban where Ban.Maban = Hoadon.Maban and HoaDon.Mahd = Chitiethoadon.mahd and chitiethoadon.masp = sanpham.masp and Hoadon.MaBan like '%"+Maban+"%' and hoadon.tinhtrang = N'Chưa thanh toán'";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                QLHDTTPJ sp = new QLHDTTPJ(rs.getString("masp").trim(), rs.getString("tensp").trim(), rs.getInt("soluong"), rs.getInt("giatien"),rs.getString("dvt").trim(),rs.getString("malsp").trim());
                dshd.add(sp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu bàn");
        }
        return dshd;
    }
        
        
    
}
