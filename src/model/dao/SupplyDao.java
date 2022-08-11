/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import nmcnpm.helper.DatabaseUtil;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.Supply;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class SupplyDao {
    private final DatabaseUtil dbUtil = new DatabaseUtil();
    private PreparedStatement stmt = null;
    private ResultSet resuftSet = null; 
    
    // người xem bấm vào nút "Xóa" chương trình sẽ lấy idHK và idList ở cột đó và xóa ở trong database
    public boolean delete(int idHk, int idList){
        String query = "delete from 'Supply' where 'idHk'= ? and 'idList' = ?";
        try {
            stmt = dbUtil.getConnection().prepareStatement(query);
            stmt.setInt(1, idHk);
            stmt.setInt(2, idList);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    // lấy thông tin từ bảng Supply trả về 1 arrayList
    public ArrayList<Object> get(int id){
        System.out.println("idList: "+id);
      String query = "select * from Supply where idList = ?";
        try {
            stmt = dbUtil.getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            resuftSet = stmt.executeQuery();
            System.out.println(resuftSet);
            ArrayList<Object> list = new ArrayList<>();
            Supply temp = new Supply();
            int i = 1;
            while(resuftSet.next()){
                System.out.println(i++);
                temp.setIdHk(resuftSet.getInt("idHk"));
                temp.setIdList(resuftSet.getInt("idList"));
                temp.setNgayNop(resuftSet.getDate("NgayNop"));
                temp.setNguoiNop(resuftSet.getNString("NguoiNop"));
                temp.setNguoiThu(resuftSet.getNString("NguoiThu"));
                temp.setSoTien(resuftSet.getInt("SoTien"));
                temp.setStatus(resuftSet.getNString("status"));
                list.add(temp);
            }
            System.out.println(stmt);
            System.out.println("list size: "+list.size());
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("false");
            return null;
        }
    }
    
    // thêm 1 vào bảng supply
    public boolean add(Supply a){
        String query = "insert into Supply values (?,?,?,?,?,?,?)";
        try {
            stmt = dbUtil.getConnection().prepareStatement(query);
            stmt.setInt(1, a.getIdHk());
            stmt.setInt(2, a.getIdList());
            stmt.setDate(3, (Date) a.getNgayNop());
            stmt.setNString(4, a.getNguoiNop());
            stmt.setNString(5, a.getNguoiThu());
            stmt.setInt(6 , a.getSoTien());
            stmt.setNString(7, a.getStatus());
            stmt.executeUpdate();
            System.out.println(stmt);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    //lấy idHK bằng tên người nộp, ra -1 tức là không tìm thấy
    public int getIdHKBytNameOwner(String name){
        String query = "select distinct idHoKhau from Supply s, NhanKhau n where s.'NguoiNop' = n.'fullName' and s.'NguoiNop' = ?";
        try {
            stmt = dbUtil.getConnection().prepareStatement(query);
            stmt.setNString(1, name);
            resuftSet = stmt.executeQuery();
            return resuftSet.getInt("idHoKhau");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    // update bằng cách xóa dữ liệu cũ và thêm dữ liệu mới
    public boolean update(int idHk, int idList, String tenChuHo, Date ngayThu,int soTien, String trangThai){
        String query = "update Supply set NguoiNop = ?, NgayThu = ?, supply.SoTien = ?, supply.status = ? where supply.idHk = ? and supply.idList = ?; ";
        try {
            stmt = dbUtil.getConnection().prepareStatement(query);
            stmt.setNString(1, tenChuHo);
            stmt.setDate(2, ngayThu);
            stmt.setInt(3, soTien);
            stmt.setNString(4, trangThai);
            stmt.setInt(5, idHk);
            stmt.setInt(6, idList);
            stmt.executeUpdate();
            System.out.println("update success");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("update false");
            return false;
        }
    }
    
    //tìm thông tin trong bảng Supply qua idList và id HK 
    public Object getByIdHkIdList(int idHk, int idList){
        String query = "select * from Supply where idHk = ? and idList = ?;";
        try {
            stmt = dbUtil.getConnection().prepareStatement(query);
            stmt.setInt(1, idHk);
            stmt.setInt(2, idList);
            resuftSet = stmt.executeQuery();
            System.out.println(stmt);
            System.out.println(resuftSet!=null);
            // đoạn này code để tránh lỗi empty và before start resultSet
            resuftSet.next();
            Supply temp = new Supply();
            temp.setIdHk(resuftSet.getInt("idHk"));
            temp.setIdList(resuftSet.getInt("idList"));
            temp.setNgayNop(resuftSet.getDate("NgayNop"));
            temp.setNguoiThu(resuftSet.getNString("NguoiThu"));
            temp.setSoTien(resuftSet.getInt("soTien"));
            temp.setStatus(resuftSet.getNString("status"));
            System.out.println("search sucess");
            return resuftSet!=null?temp:null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("search fail");
            return null;
        }
    }
    
    //xac nhan Supply do da ton tai chua ban idHk va idList
    public boolean exist(int idHk, int idList){
        return getByIdHkIdList(idHk, idList)!=null;
    }
}   

