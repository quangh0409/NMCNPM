/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Supply {
    private int idHk, idList;
    private Date ngayNop;
    private String nguoiNop, nguoiThu;
    private int soTien;
    private String status;
    
    public Supply(){
        idHk = 0;
        idList = 0;
        ngayNop =  new Date();
        nguoiNop = nguoiThu = "";
        soTien = 0;
        status = "";
    }

    public Supply(int idHk, int idList, Date ngayNop, String nguoiNop, String nguoiThu, int soTien, String status) {
        this.idHk = idHk;
        this.idList = idList;
        this.ngayNop = ngayNop;
        this.nguoiNop = nguoiNop;
        this.nguoiThu = nguoiThu;
        this.soTien = soTien;
        this.status = status;
    }

    public int getIdHk() {
        return idHk;
    }

    public void setIdHk(int idHk) {
        this.idHk = idHk;
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }

    public Date getNgayNop() {
        return ngayNop;
    }

    public void setNgayNop(Date ngayNop) {
        this.ngayNop = ngayNop;
    }

    public String getNguoiNop() {
        return nguoiNop;
    }

    public void setNguoiNop(String nguoiNop) {
        this.nguoiNop = nguoiNop;
    }

    public String getNguoiThu() {
        return nguoiThu;
    }

    public void setNguoiThu(String nguoiThu) {
        this.nguoiThu = nguoiThu;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString(){
        return "Supply{"+"idHk=" + idHk + ", idList=" + idList 
                + ", ngayNop="+ ngayNop.toString() + ", nguoiNop="+ nguoiNop 
                + ", nguoiThu=" + nguoiThu + ", soTien="+soTien
                + ", status=" + status + "\n";
    } 
}
