/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.Lists;
import nmcnpm.helper.DatabaseUtil;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ListDao implements CRUDInterface {

    private DatabaseUtil databaseUtil = new DatabaseUtil();
    private PreparedStatement stmt = null;
    private ResultSet resultset = null;

    @Override
    public ArrayList<Object> get() {
        try {
            ArrayList<Object> list = new ArrayList<>();
            String query = "SELECT * FROM Lists ;";
            stmt = databaseUtil.getConnection().prepareStatement(query);
            resultset = stmt.executeQuery();
            while (resultset.next()) {
                Lists temp = new Lists();
                temp.setId(resultset.getInt("id"));
                temp.setNames(resultset.getString("names"));
                temp.setMoney(resultset.getInt("money"));
                temp.setType(resultset.getString("type"));
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
            String query = "SELECT * FROM Lists WHERE id = ?;";
            stmt = databaseUtil.getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            resultset = stmt.executeQuery();
            resultset.next();
            Lists temp = new Lists();
            temp.setId(resultset.getInt("id"));
            temp.setNames(resultset.getString("names"));
            temp.setMoney(resultset.getInt("money"));
            temp.setType(resultset.getString("type"));
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
            Lists temp = (Lists) obj;
            String query = "INSERT INTO Lists VALUES (?,?,?,?);";
            stmt = databaseUtil.getConnection().prepareStatement(query);
            stmt.setInt(1,temp.getId());
            stmt.setString(2, temp.getNames());
            stmt.setInt(3,temp.getMoney());
            stmt.setString(4,temp.getType());
            stmt.executeUpdate();
            System.out.println(stmt);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(int id) {
        try {
            String query = "DELETE Lists WHERE id = ? ;";
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
            Lists temp = (Lists) obj;
            String query = "UPDATE Lists SET names = ? , money = ? ,type = ? WHERE id = ? ;";
            stmt = databaseUtil.getConnection().prepareStatement(query);
            stmt.setString(1, temp.getNames());
            stmt.setInt(2, temp.getMoney());
            stmt.setString(3,temp.getType());
            stmt.setInt(4,temp.getId());
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
