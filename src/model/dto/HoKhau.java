/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author Admin
 */
public class HoKhau {
    //    so ho khau
    private int id;
//    ho ten chu ho
    private String nameOwner;
//    so nha
    private int houseNumber;
//    duong pho
    private String street;
//    phuong
    private String ward;
//    quan
    private String district;
//    thong tin ve cac nhan khau nhan khau
   

    public HoKhau() {
    }

    public HoKhau(int id, String nameOwner, int houseNumber, String street, String ward, String district) {
        this.id = id;
        this.nameOwner = nameOwner;
        this.houseNumber = houseNumber;
        this.street = street;
        this.ward = ward;
        this.district = district;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

   

    

    @Override
    public String toString() {
        return "HoKhau{" + "id=" + id + ", nameOwner=" + nameOwner + ", houseNumber=" + houseNumber + ", street=" + street + ", ward=" + ward + ", district=" + district  + '}';
    }
    
}
