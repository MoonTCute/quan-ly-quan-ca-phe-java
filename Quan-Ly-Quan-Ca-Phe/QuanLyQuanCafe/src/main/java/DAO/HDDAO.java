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
public class HDDAO {
    public static ArrayList<Hoadon> getDSHD(){
        ArrayList<Hoadon> dshd = new ArrayList<Hoadon>();
        try {
            String sql = "select * from hoadon";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                Hoadon sp = new Hoadon(rs.getString("mahd").trim(), rs.getString("manv").trim(), rs.getString("maban").trim(),rs.getString("ngaylap").trim(),rs.getInt("tongtien"),rs.getString("tinhtrang"));
                dshd.add(sp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu bàn ahihi");
        }
        return dshd;
    }
    
    public static void UpdateSQL(Hoadon hd)
    {
        String sql = "insert into hoadon values(?,?,?,?,?,default)";
        ConnectDB cnDB = new ConnectDB();
        cnDB.getCn();
        try 
        {
            PreparedStatement ps = cnDB.cn.prepareStatement(sql);
            ps.setString(1, hd.getMahd());
            ps.setString(2, hd.getManv());
            ps.setString(3, hd.getMaban());
            ps.setString(4, hd.getNgaylap());
            ps.setInt(5, hd.getTongtien());
            ps.executeUpdate();
            System.out.println("Them thanh cong");
        } catch (SQLException e) 
        {
            System.out.println("Them khong thanh cong");
        }
        cnDB.close();
    }

    public static ArrayList<Hoadon> HienthiNV(String maban){
        ArrayList<Hoadon> dshd = new ArrayList<Hoadon>();
        try {
            String sql = "select * from hoadon where maban like '%"+maban+"%'";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                Hoadon sp = new Hoadon(rs.getString("mahd").trim(), rs.getString("manv").trim(), rs.getString("maban").trim(),rs.getString("ngaylap").trim(),rs.getInt("tongtien"),rs.getString("tinhtrang"));
                dshd.add(sp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dshd;
    }
    
    public static void Hienthi(String maban)
    {
        String sql = "select * from hoadon where maban = ?";
        ConnectDB cnDB = new ConnectDB();
        cnDB.getCn();
        try 
        {
            PreparedStatement ps = cnDB.cn.prepareStatement(sql);
            ps.setString(1, maban);
            ps.executeUpdate();
            System.out.println("Them thanh cong");
        } catch (SQLException e) 
        {
            System.out.println("Them khong thanh cong");
            
        }
        cnDB.close();
    }
    
    
}

