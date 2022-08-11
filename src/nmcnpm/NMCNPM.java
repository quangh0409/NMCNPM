/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nmcnpm;

import java.util.ArrayList;
import model.dao.NhanKhauDao;
import model.dao.QLTC;
import model.dto.NhanKhau;
import nmcnpm.helper.DatabaseUtil;

/**
 *
 * @author Admin
 */
public class NMCNPM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       NhanKhauDao NK = new NhanKhauDao();
//       ArrayList<Object> list = NK.get();
//       for (int i = 0; i < list.size() ; i++){
//           NhanKhau temp = (NhanKhau) list.get(i);
//           System.out.println(temp.toString());
//       }
        QLTC  qltc = new QLTC();
        System.out.println(qltc.Count(1, 1));
        
       
    }
    
}
