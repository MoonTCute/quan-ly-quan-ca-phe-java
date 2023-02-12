/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
/**
 *
 * @author Parents
 */
public class ConnectDB 
{
    public Connection cn;

    public void getCn() {
        try {
            SQLServerDataSource ds=new SQLServerDataSource();        
            ds.setServerName("localhost");
            ds.setPortNumber(1433);
            ds.setUser("sa");
            ds.setPassword("201001");
            ds.setDatabaseName("QL_QuanCafe");
            cn = ds.getConnection();
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            System.out.println("Kết nối không thành công");
        } 
    }

    public void close(){
        try {
            this.cn.close();
        } catch (SQLException e) {
        }
    }
    
    public ResultSet executeQuery(String sql){
        ResultSet rs = null;
        try {
            Statement stm = cn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
        }
        return rs;
    }
    
    public int executeUpdate(String sql){
        int i = -1;
        try {
            Statement stm = cn.createStatement();
            i = stm.executeUpdate(sql);
        } catch (SQLException e) {
        }
        return i;
    }
    
    
}
