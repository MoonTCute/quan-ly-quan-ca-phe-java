/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Loaisanpham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TIMOON
 */
public class SP2DAO {
    public static ArrayList<Loaisanpham> getDSLSP(){
        ArrayList<Loaisanpham> dslsp = new ArrayList<Loaisanpham>();
        try {
            String sql = "select * from loaisanpham";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                Loaisanpham lsp = new Loaisanpham(rs.getString("malsp").trim(), rs.getString("tenlsp").trim());
                dslsp.add(lsp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu bàn");
        }
        return dslsp;
    }
    
    public static void DeleteSQL(String Malsp)
    {
        String sql = "delete from loaisanpham where malsp = '"+Malsp+"'";
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
    
    public static void UpdateSQL(Loaisanpham sp)
    {
        String sql = "insert into loaisanpham values(?,?)";
        ConnectDB cnDB = new ConnectDB();
        cnDB.getCn();
        try 
        {
            PreparedStatement ps = cnDB.cn.prepareStatement(sql);
            ps.setString(1, sp.getMalsp());
            ps.setString(2, sp.getTenlsp());
            ps.executeUpdate();
            System.out.println("Them thanh cong");
        } catch (SQLException e) 
        {
            System.out.println("Them khong thanh cong");
        }
        cnDB.close();
    }
    
    public static void FixSQL(String Malsp, String Tenlsp)
    {
        String sql = "update loaisanpham set tenlsp = N'"+Tenlsp+"' where malsp ='"+Malsp+"'";
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
