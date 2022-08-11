/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nmcnpm.helper.DatabaseUtil;

/**
 *
 * @author Admin
 */
public class QLTC {
    private final DatabaseUtil databaseUtil = new DatabaseUtil();
    private PreparedStatement stmt = null;
    private ResultSet resultset = null;
public int Count(int idlist,int idhk){
    try {
        String query = "SELECT COUNT(*) FROM `Supply` , `NhanKhau` WHERE  `Supply`.idList = ? and `NhanKhau`.IdHoKhau = `Supply`.idHk and `Supply`.idHk = ?;";
        stmt = databaseUtil.getConnection().prepareStatement(query);
        stmt.setInt(1, idlist);
        stmt.setInt(2, idhk);
        resultset = stmt.executeQuery();
        System.out.println(stmt);
        resultset.next();
        return resultset.getInt(1);
    } catch (SQLException e) {
        e.printStackTrace();
        return 0;
    }
    //select count(*) from`Supply`, `NhanKhau`  where `Supply`.idList = 1 and `NhanKhau`.IdHoKhau = `Supply`.idHk and `Supply`.idHk  = 1 ;

}
}
