/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.dto.HoKhau;
import nmcnpm.helper.DatabaseUtil;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class HoKhauDao implements CRUDInterface {

    private DatabaseUtil databaseUtil = new DatabaseUtil();
    private PreparedStatement stmt = null;
    private ResultSet resultset = null;

    @Override
    public ArrayList<Object> get() {
        try {
            String query = "SELECT * FROM HoKhau ;";
            stmt = databaseUtil.getConnection().prepareStatement(query);
            resultset = stmt.executeQuery();
            ArrayList<Object> list = new ArrayList<>();
            while (resultset.next()) {
                HoKhau temp = new HoKhau();
                temp.setId(resultset.getInt("id"));
                temp.setNameOwner(resultset.getString("nameOwner"));
                temp.setHouseNumber(Integer.parseInt(resultset.getString("houseNumber")));
                temp.setStreet(resultset.getString("street"));
                temp.setWard(resultset.getString("ward"));
                temp.setDistrict(resultset.getString("district"));
                list.add(temp);
            }
            System.out.println(stmt);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object getById(int id) {
        try {
            String query = "SELECT * FROM HoKhau WHERE id = ?;";
            stmt = databaseUtil.getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            resultset = stmt.executeQuery();
            resultset.next();
            HoKhau temp = new HoKhau();
            temp.setId(resultset.getInt("id"));
            temp.setNameOwner(resultset.getString("nameOwner"));
            temp.setHouseNumber(Integer.parseInt(resultset.getString("houseNumber")));
            temp.setStreet(resultset.getString("street"));
            temp.setWard(resultset.getString("ward"));
            temp.setDistrict(resultset.getString("district"));
            System.out.println(stmt);
            return temp; 
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Object getByName(String tenChuHo) {
        try {
            String query = "SELECT distinct * FROM HoKhau WHERE nameOwner = ?;";
            stmt = databaseUtil.getConnection().prepareStatement(query);
            stmt.setNString(1, tenChuHo);
            resultset = stmt.executeQuery();
            resultset.next();
            HoKhau temp = new HoKhau();
            temp.setId(resultset.getInt("id"));
            temp.setNameOwner(resultset.getString("nameOwner"));
            temp.setHouseNumber(Integer.parseInt(resultset.getString("houseNumber")));
            temp.setStreet(resultset.getString("street"));
            temp.setWard(resultset.getString("ward"));
            temp.setDistrict(resultset.getString("district"));
            System.out.println(stmt);
            return temp; 
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean add(Object obj) {
        try {
            HoKhau temp = (HoKhau) obj;
            String query = "INSERT INTO HoKhau VALUES (?,?,?,?,?,?);";
            stmt = databaseUtil.getConnection().prepareStatement(query);
            stmt.setInt(1, temp.getId());
            stmt.setString(2, temp.getNameOwner());
            stmt.setInt(3, temp.getHouseNumber());
            stmt.setString(4, temp.getStreet());
            stmt.setString(5, temp.getWard());
            stmt.setString(6, temp.getDistrict());
            stmt.executeUpdate();
            System.out.println(stmt);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Boolean delete(int id) {
        try {
            String query = "DELETE FROM HoKhau WHERE id = ?;";
            stmt = databaseUtil.getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(Object obj) {
        try {
            HoKhau temp = (HoKhau) obj;
            String query = "UPDATE HoKhau SET nameOwner = ? , houseNumber = ? , street = ? , ward = ? , district = ? WHERE id = ? ;";
            stmt = databaseUtil.getConnection().prepareStatement(query);

            stmt.setString(1, temp.getNameOwner());
            stmt.setInt(2, temp.getHouseNumber());
            stmt.setString(3, temp.getStreet());
            stmt.setString(4, temp.getWard());
            stmt.setString(5, temp.getDistrict());
            stmt.setInt(6, temp.getId());
            stmt.executeUpdate();
            System.out.println(stmt);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
