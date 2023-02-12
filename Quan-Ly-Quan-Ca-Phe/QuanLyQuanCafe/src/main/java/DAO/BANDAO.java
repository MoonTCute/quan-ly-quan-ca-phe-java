/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Ban;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TIMOON
 */
public class BANDAO {
    public static ArrayList<Ban> getDSB(){
        ArrayList<Ban> dsb = new ArrayList<Ban>();
        try {
            String sql = "select * from ban";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                Ban b = new Ban(rs.getString("maban").trim(), rs.getString("tenban").trim(), rs.getString("trangthai").trim());
                dsb.add(b);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu bàn");
        }
        return dsb;
    }
    
    public static void DeleteSQL(String Maban, String Tenban)
    {
        String sql = "delete from ban where maban = '"+Maban+"' and tenban = '"+Tenban+"' ";
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
    
    public static void UpdateSQL(Ban b)
    {
        String sql = "insert into ban values(?,?,default)";
        ConnectDB cnDB = new ConnectDB();
        cnDB.getCn();
        try 
        {
            PreparedStatement ps = cnDB.cn.prepareStatement(sql);
            ps.setString(1, b.getMaban());
            ps.setString(2, b.getTenban());
            ps.executeUpdate();
            System.out.println("Them thanh cong");
        } catch (SQLException e) 
        {
            System.out.println("Them khong thanh cong");
        }
        cnDB.close();
    }
    
    public static void FixSQL(Ban b)
    {
        String sql = "update ban set tenban = '"+b.getTenban()+"'where maban ='"+b.getMaban()+"'";
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
    
    public static void FixTT(Ban b)
    {
        String sql = "update ban set trangthai = N'Đang phục vụ' where tenban like '%"+b.getTenban()+"%'";
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
    
    public static void FixTTTWO(String maban)
    {
        String sql = "update ban set trangthai = N'Còn trống' where maban = '"+maban+"'";
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
    
    public static void FixTTTHREE(String maban)
    {
        String sql = "update ban set trangthai = N'Đang phục vụ' where maban like '%"+maban+"%'";
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
