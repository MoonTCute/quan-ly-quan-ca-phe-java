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
public class CTHDDAO {
    public static ArrayList<Chitiethoadon> getDSCTHD(){
        ArrayList<Chitiethoadon> dscthd = new ArrayList<Chitiethoadon>();
        try {
            String sql = "select * from chitiethoadon";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                Chitiethoadon b = new Chitiethoadon(rs.getString("mahd").trim(), rs.getString("masp").trim(), rs.getInt("soluong"), rs.getInt("thanhtien"));
                dscthd.add(b);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dscthd;
    }
    public static ArrayList<Chitiethoadon> HienthiDLCTHD(String Maban){
        ArrayList<Chitiethoadon> dscthd = new ArrayList<Chitiethoadon>();
        try {
            String sql = "select SanPham.MaSP, TenSP, soluong from ChiTietHoaDon, SanPham, HoaDon, Ban where Ban.Maban = Hoadon.Maban and HoaDon.Mahd = Chitiethoadon.mahd and chitiethoadon.masp = sanpham.masp and Hoadon.MaBan like '%"+Maban+"%'";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                Chitiethoadon b = new Chitiethoadon(rs.getString("mahd").trim(), rs.getString("masp").trim(), rs.getInt("soluong"), rs.getInt("thanhtien"));
                dscthd.add(b);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dscthd;
    }
    
    public static void UpdateSQL(Chitiethoadon hd)
    {
        String sql = "insert into chitiethoadon values(?,?,?,?)";
        ConnectDB cnDB = new ConnectDB();
        cnDB.getCn();
        try 
        {
            PreparedStatement ps = cnDB.cn.prepareStatement(sql);
            ps.setString(1, hd.getMahd());
            ps.setString(2, hd.getMasp());
            ps.setInt(3, hd.getSoluong());
            ps.setInt(4, hd.getThanhtien());
            ps.executeUpdate();
            System.out.println("Them thanh cong");
        } catch (SQLException e) 
        {
            System.out.println("Them khong thanh cong");
        }
        cnDB.close();
    }
    
    public static void FixSLCTHD(String mahd, String masp, int soluong)
    {
        String sql = "update chitiethoadon set soluong = '"+soluong+"' where mahd ='"+mahd+"' and masp = '"+masp+"'";
        ConnectDB cnDB = new ConnectDB();
        cnDB.getCn();
        try 
        {
            PreparedStatement ps = cnDB.cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Sua thanh cong");
        } catch (SQLException e) 
        {
            System.out.println("Sua khong thanh cong");
        }
        cnDB.close(); 
    }
    
    public static void FixTHEMSL(String mahd, String masp, int soluong)
    {
        String sql = "update chitiethoadon set soluong = soluong + '"+soluong+"' where mahd ='"+mahd+"' and masp = '"+masp+"'";
        ConnectDB cnDB = new ConnectDB();
        cnDB.getCn();
        try 
        {
            PreparedStatement ps = cnDB.cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Sua thanh cong");
        } catch (SQLException e) 
        {
            System.out.println("Sua khong thanh cong");
        }
        cnDB.close(); 
    }
    
    public static void SUMHD(String mahd)
    {
  
        String sql = "select sum(ThanhTien*SoLuong) tongtien from ChiTietHoaDon where MaHD = '"+mahd+"'";
        ConnectDB cnDB = new ConnectDB();
        cnDB.getCn();
        try 
        {
            PreparedStatement ps = cnDB.cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Sua thanh cong");
        } catch (SQLException e) 
        {
            System.out.println("Sua khong thanh cong");
        }
     
        cnDB.close(); 
    }
}
