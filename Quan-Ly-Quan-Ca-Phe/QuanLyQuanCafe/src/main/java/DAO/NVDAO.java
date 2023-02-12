/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import POJO.NHANVIEN;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author TIMOON
 */
public class NVDAO {
    public static ArrayList<NHANVIEN> getDSNV(){
        ArrayList<NHANVIEN> dsnv = new ArrayList<NHANVIEN>();
        try {
            String sql = "select * from nhanvien";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NHANVIEN nv = new NHANVIEN(rs.getString("Manv").trim(), rs.getString("Tennv").trim(), rs.getString("Chucvu").trim(), rs.getString("Ngaysinh").trim(), rs.getString("Gioitinh").trim(), rs.getString("Diachi").trim(), rs.getString("Sdt").trim(), rs.getString("Email").trim(), rs.getString("Taikhoan").trim(), rs.getString("Matkhau").trim() );
                dsnv.add(nv);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsnv;
    }
    
    public static void DeleteSQL(String Manv)
    {
        String sql = "delete from nhanvien where manv = '"+Manv+"'";
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
    
    public static void UpdateSQL(NHANVIEN nv)
    {
        String sql = "insert into nhanvien values(?,?,?,?,?,?,?,?,?,?)";
        ConnectDB cnDB = new ConnectDB();
        cnDB.getCn();
        try 
        {
            PreparedStatement ps = cnDB.cn.prepareStatement(sql);
            ps.setString(1, nv.getManv());
            ps.setString(2, nv.getTennv());
            ps.setString(3, nv.getChucvu());
            ps.setString(4, nv.getNgaysinh());
            ps.setString(5, nv.getGioitinh());
            ps.setString(6, nv.getDiachi());
            ps.setString(7, nv.getSdt());
            ps.setString(8, nv.getEmail());
            ps.setString(9, nv.getTaikhoan());
            ps.setString(10, nv.getMatkhau());
            ps.executeUpdate();
            System.out.println("Them thanh cong");
        } catch (SQLException e) 
        {
            System.out.println("Them khong thanh cong");
        }
        cnDB.close();
    }
    
    public static void FixSQL(String Manv, String Tennv, String Chucvu, String Ngaysinh, String Gioitinh, String Diachi, String Sdt, String Email, String Taikhoan, String Matkhau)
    {
        String sql = "update nhanvien set tennv = N'"+Tennv+"', chucvu = N'"+Chucvu+"', Ngaysinh = '"+Ngaysinh+"', gioitinh = N'"+Gioitinh+"', Diachi = '"+Diachi+"', sdt = '"+Sdt+"', email = '"+Email+"', taikhoan = '"+Taikhoan+"', matkhau = '"+Matkhau+"' where manv ='"+Manv+"'";
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
    
    public static void FixSQLMK(String Taikhoan, String Matkhau)
    {
        String sql = "update nhanvien set matkhau = '"+Matkhau+"' where taikhoan ='"+Taikhoan+"'";
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
    
    public static ArrayList<NHANVIEN> HienthiNV(String taikhoan){
        ArrayList<NHANVIEN> dsnv = new ArrayList<NHANVIEN>();
        try {
            String sql = "select * from NhanVien where TaiKhoan like '%"+taikhoan+"%'";
            ConnectDB cn = new ConnectDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NHANVIEN nv = new NHANVIEN(rs.getString("Manv").trim(), rs.getString("Tennv").trim(), rs.getString("Chucvu").trim(), rs.getString("Ngaysinh").trim(), rs.getString("Gioitinh").trim(), rs.getString("Diachi").trim(), rs.getString("Sdt").trim(), rs.getString("Email").trim(), rs.getString("Taikhoan").trim(), rs.getString("Matkhau").trim() );
                dsnv.add(nv);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu bàn");
        }
        return dsnv;
    }
}
