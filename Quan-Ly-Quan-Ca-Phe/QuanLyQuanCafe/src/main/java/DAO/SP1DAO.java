/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Sanpham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TIMOON
 */
public class SP1DAO {
    public static ArrayList<Sanpham> getDSSP(){
        ArrayList<Sanpham> dssp = new ArrayList<Sanpham>();
        try {
            String sql = "select * from sanpham";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                Sanpham sp = new Sanpham(rs.getString("masp").trim(), rs.getString("tensp").trim(), rs.getInt("giatien"),rs.getString("dvt").trim(),rs.getString("malsp").trim());
                dssp.add(sp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu bàn");
        }
        return dssp;
    }
    
    public static void DeleteSQL(String Masp)
    {
        String sql = "delete from sanpham where masp = '"+Masp+"'";
        ConnectDB cnDB = new ConnectDB();
        cnDB.getCn();
        try 
        {
            PreparedStatement ps = cnDB.cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Xoa thanh cong");
        } catch (SQLException e) 
        {
            System.out.println("Xoa khong thanh cong");
        }
        cnDB.close();
    }
    
    public static void UpdateSQL(Sanpham sp)
    {
        String sql = "insert into sanpham values(?,?,?,?,?)";
        ConnectDB cnDB = new ConnectDB();
        cnDB.getCn();
        try 
        {
            PreparedStatement ps = cnDB.cn.prepareStatement(sql);
            ps.setString(1, sp.getMasp());
            ps.setString(2, sp.getTensp());
            ps.setInt(3, sp.getGiatien());
            ps.setString(4, sp.getDvt());
            ps.setString(5, sp.getMalsp());
            ps.executeUpdate();
            System.out.println("Them thanh cong");
        } catch (SQLException e) 
        {
            System.out.println("Them khong thanh cong");
        }
        cnDB.close();
    }
    
    public static void FixSQL(String Masp, String Tensp, int Giatien, String Dvt)
    {
        String sql = "update sanpham set tensp = N'"+Tensp+"', giatien = '"+Giatien+"', dvt = '"+Dvt+"' where masp ='"+Masp+"'";
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
    
    public static ArrayList<Sanpham> HienthiDLHD(String Maban){
        ArrayList<Sanpham> dssp1 = new ArrayList<Sanpham>();
        try {
            String sql = "select SanPham.MaSP, TenSP, GiaTien, DVT, MaLSP from ChiTietHoaDon, SanPham, HoaDon, Ban where Ban.Maban = Hoadon.Maban and HoaDon.Mahd = Chitiethoadon.mahd and chitiethoadon.masp = sanpham.masp and Hoadon.MaBan like '%"+Maban+"%'";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                Sanpham sp = new Sanpham(rs.getString("masp").trim(), rs.getString("tensp").trim(), rs.getInt("giatien"),rs.getString("dvt").trim(),rs.getString("malsp").trim());
                dssp1.add(sp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu bàn");
        }
        return dssp1;
    }
}
