/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.dao.HoKhauDao;
import model.dao.SupplyDao;
import model.dto.HoKhau;
import model.dto.Supply;

/**
 *
 * @author Admin
 */
public class XemChiTiet extends javax.swing.JPanel {

    /**
     * Creates new form XemChiTiet
     */
    XemChiTietMoiHo xctmh = new XemChiTietMoiHo();
    Suachitiet s = new Suachitiet ();
    private int idList;
    private String name;
    SupplyDao sa = new SupplyDao();
    ArrayList<Object> supply = new ArrayList<>();
    DefaultTableModel modle = new DefaultTableModel();
    
    public XemChiTiet() {
        initComponents();
        get();
        jBxemchitiet.addActionListener((e) -> {
        jBXemChiTietMoiHo();
        });
        jBchinhsua.addActionListener((e) -> {
        jBsuaAction();
        });
        jBthem.addActionListener((e) -> {
        jBthemAction();
        });
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
        supply = sa.get(this.idList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    public XemChiTiet(int idList, String name) {
        initComponents();
        this.idList = idList;
        this.name = name;
        System.out.println(supply.size());
        get();
        jBxemchitiet.addActionListener((e) -> {
        jBXemChiTietMoiHo();
        });
        jBchinhsua.addActionListener((e) -> {
        jBsuaAction();
        });
        jBthem.addActionListener((e) -> {
        jBthemAction();
        });
    }

    public JButton getjBxemchitiet() {
        return jBxemchitiet;
    }

    public JButton getjBback() {
        return jBBack;
    }

    public XemChiTietMoiHo getXctmh() {
        return xctmh;
    }

    public JButton getjBchinhsua() {
        return jBchinhsua;
    }

    public Suachitiet getS() {
        return s;
    }

    public JButton getjBthem() {
        return jBthem;
    }
    
    
    
public void get(){
    System.out.println("get");
    supply = sa.get(this.idList);
    Object colunm[] = new Object[]{"Người nộp tiền", "ngày thu", "số tiền", "trạng thái"};
    list.setModel(modle);
    modle.setColumnIdentifiers(colunm);
    modle.setRowCount(0);
    Supply s;
    String data[] = new String[4];
    for (Object temp : supply){
        s = (Supply) temp;
        data[0] = s.getNguoiNop();
        data[1] = s.getNgayNop().toString();
        data[2] = Double.toString(s.getSoTien());
        data[3] = s.getStatus();
        modle.addRow(data);
    }
    System.out.println("success");
}

//Hàm này Khánh đã sửa
public void jBXemChiTietMoiHo(){
    xctmh.setBounds(0, 0,500,500);
    JFrame jf = new JFrame();
    jf.setTitle("xemchitiet/xemchitietmoiho");
    jf.setBounds(50, 50, 500, 500);
    jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    // phần này t thêm vào nhé
    int i = list.getSelectedColumn();
    if(i!=-1){
        Supply temp = (Supply) supply.get(i);
        xctmh.getjTextFieldNgayNop().setText(temp.getNgayNop().toString());
        xctmh.getjTextFieldNguoiNop().setText(temp.getNguoiNop());
        xctmh.getjTextFieldNguoiThu().setText(temp.getNguoiThu());
        xctmh.getjTextFieldSoTien().setText(temp.getSoTien()+"");
        xctmh.getjTextFieldTenChuHo().setText(((HoKhau) (new HoKhauDao()).getById(temp.getIdHk())).getNameOwner());
        xctmh.getjTextFieldTrangThai().setText(temp.getStatus());
        xctmh.setIdList(temp.getIdList()); 
    }
    //
    jf.add(xctmh);
    jf.setVisible(true);
    xctmh.getjBback().addActionListener((e) -> {
        jf.setVisible(false);
    });
}
public void jBsuaAction(){
     int i = list.getSelectedRow();
    if(i!=-1){
     Supply temp = (Supply) supply.get(i);
     s.setBounds(0, 0, 400, 300);
     JFrame jf = new JFrame();
     jf.setTitle("xemchitiet/sua");
     jf.setBounds(50, 50, 400, 300);
     jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    
     s.getjTextFieldTrangThai().setText(temp.getStatus());
     s.getjTextFieldNgayThu().setText(temp.getNgayNop().toString());
     s.getjTextFieldSoTien().setText(temp.getSoTien()+"");
     s.getjTextFieldTenChuHo().setText(temp.getNguoiNop());
     s.setSupply(temp);
     
     jf.add(s);
     jf.setVisible(true);
     s.getjBback().addActionListener((e) -> {
         this.get();
         jf.setVisible(false);
     });
    }
}
public void jBthemAction(){
    
    xctmh.setBounds(0, 0,500,500);
    JFrame jf = new JFrame();
    jf.setTitle("xemchitiet/them");
    jf.setBounds(50, 50, 500, 500);
    jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    jf.add(xctmh);
    jf.setVisible(true);
    xctmh.getjBback().addActionListener((e) -> {
        jf.setVisible(false);
    });
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jBchinhsua = new javax.swing.JButton();
        jBxemchitiet = new javax.swing.JButton();
        jBthem = new javax.swing.JButton();
        jBXóa = new javax.swing.JButton();
        jBBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên chủ hộ", "Ngày thu", "số tiền", "trạng thái"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jSplitPane1.setRightComponent(jScrollPane1);

        jBchinhsua.setText("Chỉnh sửa");

        jBxemchitiet.setText("xem chi tiết");

        jBthem.setText("Thêm");

        jBXóa.setText("Xóa");

        jBBack.setText("Quay lại");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBXóa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBthem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBchinhsua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBxemchitiet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBchinhsua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBxemchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBthem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBXóa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel3);

        list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên chủ hộ", "Ngày thu", "số tiền", "trạng thái"
            }
        ));
        jScrollPane2.setViewportView(list);

        jSplitPane1.setRightComponent(jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBXóa;
    private javax.swing.JButton jBchinhsua;
    private javax.swing.JButton jBthem;
    private javax.swing.JButton jBxemchitiet;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable list;
    // End of variables declaration//GEN-END:variables
}
