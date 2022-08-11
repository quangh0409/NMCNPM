/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.NhanKhau;
import nmcnpm.helper.DatabaseUtil;

/**
 *
 * @author Admin
 */
public class NhanKhauDao implements CRUDInterface {

    private DatabaseUtil databaseUtil = new DatabaseUtil();
    private PreparedStatement stmt = null;
    private ResultSet resultset = null;

    @Override
    public ArrayList<Object> get() {
        String query = "SELECT * FROM NhanKhau ";
        try {
            stmt = databaseUtil.getConnection().prepareStatement(query);
            resultset = stmt.executeQuery();
            ArrayList<Object> list = new ArrayList<>();
            while (resultset.next()) {
                NhanKhau temp = new NhanKhau();
                temp.setFullName(resultset.getString("fullName"));
                temp.setBiDanh(resultset.getString("biDanh"));
                temp.setBirthday(resultset.getDate("birthday"));
                temp.setPlaceOfBirth(resultset.getString("placeOfBirth"));
                temp.setDomicile(resultset.getString("domicile"));
                temp.setJob(resultset.getString("job"));
                temp.setWorkingPlace(resultset.getString("workingPlace"));
                temp.setId(resultset.getInt("id"));
                temp.setDayForIdCard(resultset.getDate("dayForIdCard"));
                temp.setPlaceForIdCard(resultset.getString("placeForIdCard"));
                temp.setDateOfRegistration(resultset.getDate("dateOfRegistration"));
                temp.setRelationship(resultset.getString("relationShip"));
                temp.setIdHoKhau(resultset.getInt("idHoKhau"));
                list.add(temp);
            }
            System.out.println(stmt);
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Boolean add(Object obj) {
        NhanKhau temp = (NhanKhau) obj;
        String query = "INSERT INTO NhanKhau VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            stmt = databaseUtil.getConnection().prepareStatement(query);
            stmt.setInt(1, temp.getCccd());
            stmt.setString(2, temp.getFullName());
            stmt.setString(3, temp.getBiDanh());
            stmt.setDate(4, (Date) temp.getBirthday());
            stmt.setString(5, temp.getPlaceOfBirth());
            stmt.setString(6, temp.getDomicile());
            stmt.setString(7, temp.getJob());
            stmt.setString(8, temp.getWorkingPlace());
            stmt.setDate(9, (Date) temp.getDateOfRegistration());
            stmt.setString(10, temp.getPlaceForIdCard());
            stmt.setDate(11, (Date) temp.getDateOfRegistration());
            stmt.setString(12, temp.getRelationship());
            stmt.setInt(13, temp.getIdHoKhau());
            stmt.executeUpdate();
            stmt.executeQuery();
            System.out.println(stmt);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public Boolean delete(int id) {
        try {
            String query = "DELETE FROM NhanKhau Where id = ? ; ";
            stmt = databaseUtil.getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(stmt);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(Object obj) {
        try {
            NhanKhau temp = (NhanKhau) obj;
            String query = "UPDATE NhanKhau SET "
                    + "fullName = ? ,"
                    + " biDanh = ? ,"
                    + " birthday = ? ,"
                    + "placeOfBirth = ? , "
                    + "domicile = ? ,"
                    + "job = ? , "
                    + "workingPlace = ? ,"
                    + "dayForIdCard = ? ,"
                    + "placeForIdCard = ? ,"
                    + "dateOfRegistration = ? ,"
                    + "relationship = ? ,"
                    + "IdHoKhau = ? ,"
                    + "WHERE id = ? ;";
            stmt = databaseUtil.getConnection().prepareStatement(query);

            stmt.setString(1, temp.getFullName());
            stmt.setString(2, temp.getBiDanh());
            stmt.setDate(3, (Date) temp.getBirthday());
            stmt.setString(4, temp.getPlaceOfBirth());
            stmt.setString(5, temp.getDomicile());
            stmt.setString(6, temp.getJob());
            stmt.setString(7, temp.getWorkingPlace());
            stmt.setDate(8, (Date) temp.getDateOfRegistration());
            stmt.setString(9, temp.getPlaceForIdCard());
            stmt.setDate(10, (Date) temp.getDateOfRegistration());
            stmt.setString(11, temp.getRelationship());
            stmt.setInt(12, temp.getIdHoKhau());
            stmt.setInt(13, temp.getCccd());
            stmt.executeUpdate();
            System.out.println(stmt);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object getById(int id) {

        try {
            String query = "SELECT * FROM NhanKhau WHERE Id = ? ;";
            stmt = databaseUtil.getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            resultset = stmt.executeQuery();
            resultset.next();
            NhanKhau temp = new NhanKhau();
            temp.setFullName(resultset.getString("fullName"));
            temp.setBiDanh(resultset.getString("biDanh"));
            temp.setBirthday(resultset.getDate("birthday"));
            temp.setPlaceOfBirth(resultset.getString("placeOfBirth"));
            temp.setDomicile(resultset.getString("domicile"));
            temp.setJob(resultset.getString("job"));
            temp.setWorkingPlace(resultset.getString("workingPlace"));
            temp.setId(resultset.getInt("id"));
            temp.setDayForIdCard(resultset.getDate("dayForIdCard"));
            temp.setPlaceForIdCard(resultset.getString("placeForIdCard"));
            temp.setDateOfRegistration(resultset.getDate("dateOfRegistration"));
            temp.setRelationship(resultset.getString("relationShip"));
            temp.setIdHoKhau(resultset.getInt("idHoKhau"));
            System.out.println(stmt);
            return temp;
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
