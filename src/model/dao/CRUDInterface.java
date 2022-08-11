/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface CRUDInterface {
    public ArrayList<Object> get();
    public Object getById(int id);
    public Boolean add(Object obj);
    public Boolean delete(int id);
    public Boolean update (Object obj);
}
