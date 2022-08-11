/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanKhau {
    //        ho va ten
//        bi danh
    private String fullName, biDanh, name, midName, surName;
//        ngay sinh
    private Date birthday;
//        noi sinh
    private String placeOfBirth;
//        nguyen quan
    private String domicile;
//        dan toc 
    private String minority;
//        nghe nghiep
    private String job;
//        noi lam
    private String workingPlace;
//        cccd
    private int cccd;
//        ngay cap 
    private Date dayForIdCard;
//        noi cap
    private String placeForIdCard;
//        ngay dang ky lam so
    private Date dateOfRegistration;
//        quan he voi chu ho
    private String relationship;
//        so ho khau
    private int IdHoKhau;
    
    public String getFullName() {
        return fullName;
    }

    public NhanKhau(){
    }

    public NhanKhau(String fullName, String biDanh, Date birthday, String placeOfBirth, String domicile, String minority, String job, String workingPlace, int cccd, Date dayForIdCard, String placeForIdCard, Date dateOfRegistration, String relationship, int IdHoKhau) {
        this.fullName = fullName;
        this.biDanh = biDanh;
        this.birthday = birthday;
        this.placeOfBirth = placeOfBirth;
        this.domicile = domicile;
        this.minority = minority;
        this.job = job;
        this.workingPlace = workingPlace;
        this.cccd = cccd;
        this.dayForIdCard = dayForIdCard;
        this.placeForIdCard = placeForIdCard;
        this.dateOfRegistration = dateOfRegistration;
        this.relationship = relationship;
        this.IdHoKhau = IdHoKhau;
    }
    
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBiDanh() {
        return biDanh;
    }

    public void setBiDanh(String biDanh) {
        this.biDanh = biDanh;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public String getMinority() {
        return minority;
    }

    public void setMinority(String minority) {
        this.minority = minority;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
    }

    public int getCccd() {
        return cccd;
    }

    public void setId(int cccd) {
        this.cccd = cccd;
    }

    public Date getDayForIdCard() {
        return dayForIdCard;
    }

    public void setDayForIdCard(Date dayForIdCard) {
        this.dayForIdCard = dayForIdCard;
    }

    public String getPlaceForIdCard() {
        return placeForIdCard;
    }

    public void setPlaceForIdCard(String placeForIdCard) {
        this.placeForIdCard = placeForIdCard;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public int getIdHoKhau() {
        return IdHoKhau;
    }

    public void setIdHoKhau(int IdHoKhau) {
        this.IdHoKhau = IdHoKhau;
    }
    
    public String getName(){
        String array[]= fullName.split(" ");
        return array[array.length-1];
    }
    
    public String getMidName(){
        String array[]= fullName.split(" ");
        String re = "";
        int count = array.length;
        for(int i = 1; i<count-1; i++){
            re+= array[i]+' ';
        }
        return re;
    }
    
    public String getSurName(){
        String array[]= fullName.split(" ");
        return array[0];
    }

    @Override
    public String toString() {
        return "NhanKhau{" + "fullName=" + fullName + ", biDanh=" + biDanh + ", name=" + name + ", midName=" + midName + ", surName=" + surName + ", birthday=" + birthday + ", placeOfBirth=" + placeOfBirth + ", domicile=" + domicile + ", minority=" + minority + ", job=" + job + ", workingPlace=" + workingPlace + ", cccd=" + cccd + ", dayForIdCard=" + dayForIdCard + ", placeForIdCard=" + placeForIdCard + ", dateOfRegistration=" + dateOfRegistration + ", relationship=" + relationship + ", IdHoKhau=" + IdHoKhau + '}';
    }
    
}
