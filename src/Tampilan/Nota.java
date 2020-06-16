package Tampilan;
import java.sql.*;
import Koneksi.Koneksi;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.sun.glass.events.KeyEvent;
import Tampilan.PopupPelanggan;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
public class Nota extends javax.swing.JFrame {
    private Connection conn = new Koneksi().configDB();
    public String id = "",nama = "", jenis = "", almt = "",telp = "";
    public String kdbrg = "",nmbrg = "",hb = "",hj = "",jnsbrg = "";
    private DefaultTableModel tabmode;
    public Nota() {
        initComponents();
        String KODE = Session.getId();
        lid.setText(KODE);
        kosong();
        nama();
        aktif();
        AutoNumber();
    }
    protected void nama(){
        String Query = "Select * from kasir where Id_Kasir='"+lid.getText()+"'";
        try{
            Statement st = conn.createStatement();
            ResultSet Res = st.executeQuery(Query);
            if(Res.next()){
                lnama.setText(Res.getString("Nama_Kasir"));
            }
        }catch(SQLException yusuf){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+yusuf);
        }
    }
    
   protected void aktif(){
        tqty.requestFocus();
        jtgl.setEditor(new JSpinner.DateEditor(jtgl, "yyyy/MM/dd"));
        Object[] Row = {"Kode Barang" ,"Nama", "Harga Beli", "Harga Jual", "QTY", "Total"};
        tabmode = new DefaultTableModel(null, Row);
        TabelTransaksi.setModel(tabmode);
    }
      
    protected void kosong(){
        //tidnota.setText("");
        talamat.setText("");
        tidplg.setText("");
        tnama_plg.setText("");
        tkd.setText("");
        tnama_brg.setText("");
        thb.setText("");
        thj.setText("");
        tqty.setText("");
        ttotal.setText("");
    }
    
    protected void AutoNumber(){
        try{
            String Query = "Select idnota from nota order by idnota asc";
            Statement st = conn.createStatement();
            ResultSet Res = st.executeQuery(Query);
            tidnota.setText("IN0001");
            while(Res.next()){
                String Id_Nota = Res.getString("idnota").substring(2);
                int AN = Integer.parseInt(Id_Nota)+1;
                String Nol = "";
                if (AN<10){Nol="000";
                } else if (AN<100){Nol="00";
                }else if (AN<1000){Nol="0";
                }else if (AN<10000){Nol="";
                }
                tidnota.setText("IN" + Nol + AN);
            }
        }catch(SQLException yusuf){
            JOptionPane.showMessageDialog(this, "Auto Number Gagal"+yusuf);
        }
    }
    public void ItemTerpilih(){
        PopupPelanggan objek = new PopupPelanggan();
        objek.plg = this;
        tidplg.setText(id);
        tnama_plg.setText(nama);
        talamat.setText(almt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popuppelanggan = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tidnota = new javax.swing.JTextField();
        tidplg = new javax.swing.JTextField();
        tnama_plg = new javax.swing.JTextField();
        tkd = new javax.swing.JTextField();
        tnama_brg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelTransaksi = new javax.swing.JTable();
        bcari_brg = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lid = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lnama = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bcariplg = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        talamat = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jtgl = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        thb = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        thj = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tqty = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tharga = new javax.swing.JTextField();
        btambah = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        bkeluar = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        ttotal = new javax.swing.JTextField();
        bhapus = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");
        popuppelanggan.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(228, 228, 253));
        jPanel1.setPreferredSize(new java.awt.Dimension(795, 687));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(240, 177));

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data Kasir");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));

        jLabel3.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data Barang");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel3)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Data Pelanggan");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel11)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel11)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nota");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel14)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 62, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 675));

        jLabel1.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nota");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 6, -1, -1));

        jLabel4.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("ID Nota");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, 24));

        jLabel5.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("ID Pelanggan");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Alamat");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 40, -1));

        jLabel7.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Kode Barang");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, -1, 20));

        jLabel8.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Nama");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, 20));

        jLabel9.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nama");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        tidnota.setBackground(new java.awt.Color(228, 228, 253));
        jPanel1.add(tidnota, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 170, 24));

        tidplg.setBackground(new java.awt.Color(228, 228, 253));
        jPanel1.add(tidplg, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 90, 24));

        tnama_plg.setBackground(new java.awt.Color(228, 228, 253));
        jPanel1.add(tnama_plg, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 180, 24));

        tkd.setBackground(new java.awt.Color(228, 228, 253));
        tkd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkdActionPerformed(evt);
            }
        });
        jPanel1.add(tkd, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 70, 24));

        tnama_brg.setBackground(new java.awt.Color(228, 228, 253));
        jPanel1.add(tnama_brg, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 140, 24));

        TabelTransaksi.setBackground(new java.awt.Color(228, 228, 253));
        TabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jenis Barang", "Harga Beli", "Harga Jual", "Stok Barang"
            }
        ));
        TabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelTransaksi);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, -1, 150));

        bcari_brg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcari_brg.setText("Cari");
        bcari_brg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bcari_brg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcari_brgActionPerformed(evt);
            }
        });
        jPanel1.add(bcari_brg, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 60, -1));

        jLabel12.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("ID Kasir");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 43, -1, 20));

        lid.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        lid.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(lid, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 170, 20));

        jLabel15.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Tgl Nota");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, 20));

        lnama.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        lnama.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(lnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 140, 20));

        jLabel13.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Data Barang");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, -1, 20));

        bcariplg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bcariplg.setText("Cari");
        bcariplg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bcariplg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariplgActionPerformed(evt);
            }
        });
        jPanel1.add(bcariplg, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 75, -1));

        talamat.setBackground(new java.awt.Color(228, 228, 253));
        talamat.setColumns(10);
        talamat.setRows(3);
        jScrollPane2.setViewportView(talamat);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 180, 70));

        jLabel16.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Nama Kasir");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, -1));

        jtgl.setModel(new javax.swing.SpinnerDateModel());
        jPanel1.add(jtgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, -1, -1));

        jLabel17.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Data Pelanggan");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, 20));

        jLabel10.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Harga Beli");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, -1, 20));

        thb.setBackground(new java.awt.Color(228, 228, 253));
        jPanel1.add(thb, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 140, 24));

        jLabel18.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Harga Jual");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, -1, 20));

        thj.setBackground(new java.awt.Color(228, 228, 253));
        jPanel1.add(thj, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 140, 24));

        jLabel19.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("QTY");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, -1, 20));

        tqty.setBackground(new java.awt.Color(228, 228, 253));
        tqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tqtyActionPerformed(evt);
            }
        });
        jPanel1.add(tqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 140, 24));

        jLabel20.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Transaksi");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, 20));

        tharga.setBackground(new java.awt.Color(228, 228, 253));
        jPanel1.add(tharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 590, 140, 24));

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });
        jPanel1.add(btambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 220, -1));

        jLabel21.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Total Harga");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 590, -1, 30));

        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });
        jPanel1.add(bkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 590, -1, -1));

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel1.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 590, -1, -1));

        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });
        jPanel1.add(bbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 590, 60, -1));

        ttotal.setBackground(new java.awt.Color(228, 228, 253));
        jPanel1.add(ttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 140, 24));

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel1.add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, -1, -1));

        jLabel22.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Total");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bcariplgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariplgActionPerformed
        PopupPelanggan pelanggan = new PopupPelanggan();
        pelanggan.plg = this;
        pelanggan.setVisible(true);
        pelanggan.setResizable(false);
    }//GEN-LAST:event_bcariplgActionPerformed

    public void ItemTerpilihBrg(){
        PopupBarang Brg = new PopupBarang();
        Brg.brg = this;
        tkd.setText(kdbrg);
        tnama_brg.setText(nmbrg);
        thb.setText(hb);
        thj.setText(hj);
        tqty.requestFocus();
    }
    public void print(){
        try{
            String File1 = "src/Tampilan/Nota.jasper";
            HashMap par = new HashMap();
            par.put("id_nota", tidnota.getText());
            JasperPrint Print = JasperFillManager.fillReport (File1, par, conn);
            JasperViewer.viewReport(Print, false);
            //JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch(Exception yusuf){
            JOptionPane.showMessageDialog(this, yusuf.getMessage());
        }
    }
    private void bcari_brgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcari_brgActionPerformed
        PopupBarang Barang = new PopupBarang();
        Barang.brg = this;
        Barang.setVisible(true);
        Barang.setResizable(false);
    }//GEN-LAST:event_bcari_brgActionPerformed

    
    private void TabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelTransaksiMouseClicked

    }//GEN-LAST:event_TabelTransaksiMouseClicked

    private void tkdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkdActionPerformed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        new Kasir().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new Kasir().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tqtyActionPerformed
        int hrj = Integer.parseInt(thj.getText());
        int qty = Integer.parseInt(tqty.getText());
        int jml = qty*hrj;
        ttotal.setText(String.valueOf(jml));
    }//GEN-LAST:event_tqtyActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        try{
            String Kode = tkd.getText();
            String Nama = tnama_brg.getText();
            int hrgb = Integer.parseInt(thb.getText());
            int hrgj = Integer.parseInt(thj.getText());
            int QTY = Integer.parseInt(tqty.getText());
            int total = Integer.parseInt(ttotal.getText());
            tabmode.addRow(new Object[]{Kode, Nama, hrgb, hrgj, QTY, total});
            TabelTransaksi.setModel(tabmode);
        }catch(Exception yusuf){
            JOptionPane.showMessageDialog(this, "Error: "+yusuf);
        }
        tkd.setText("");
        tnama_brg.setText("");
        thb.setText("");
        thj.setText("");
        tqty.setText("");
        ttotal.setText("");
        Hitung();
    }//GEN-LAST:event_btambahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int index = TabelTransaksi.getSelectedRow();
        tabmode.removeRow(index);
        TabelTransaksi.setModel(tabmode);
        Hitung();
    }//GEN-LAST:event_bhapusActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String FormDate = Date.format(jtgl.getValue());
        String Query = "insert into nota values (?,?,?,?)";
        String query = "insert into isi values (?,?,?,?,?)";
        try{
            PreparedStatement st = conn.prepareStatement(Query);
            st.setString(1, tidnota.getText());
            st.setString(2, FormDate);
            st.setString(3, tidplg.getText());
            st.setString(4, lid.getText());
            st.executeUpdate();
            
            int z = tabmode.getRowCount();
            for(int x=0; x<z; x++){
                String kd = TabelTransaksi.getValueAt(x, 0).toString();
                String hb = TabelTransaksi.getValueAt(x, 2).toString();
                String hj = TabelTransaksi.getValueAt(x, 3).toString();
                String quan = TabelTransaksi.getValueAt(x, 4).toString();
                PreparedStatement St = conn.prepareStatement(query);
                St.setString(1, tidnota.getText());
                St.setString(2, kd);
                St.setString(3, hb);
                St.setString(4, hj);
                St.setString(5, quan);
                St.executeUpdate();
            }JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
            print();
        }catch(SQLException yusuf){
            JOptionPane.showMessageDialog(this, "Error: "+yusuf);
        } kosong(); aktif(); AutoNumber();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        kosong(); aktif(); AutoNumber();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bkeluarActionPerformed
    
    public void Hitung(){
        int total =0;
        for(int x=0; x<TabelTransaksi.getRowCount(); x++){
            int amount = Integer.valueOf(TabelTransaksi.getValueAt(x, 5).toString());
            total+=amount;
        }ttotal.setText(Integer.toString(total));
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelTransaksi;
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcari_brg;
    private javax.swing.JButton bcariplg;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JLabel lid;
    private javax.swing.JLabel lnama;
    private javax.swing.JPopupMenu popuppelanggan;
    private javax.swing.JTextArea talamat;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField thb;
    private javax.swing.JTextField thj;
    private javax.swing.JTextField tidnota;
    private javax.swing.JTextField tidplg;
    private javax.swing.JTextField tkd;
    private javax.swing.JTextField tnama_brg;
    private javax.swing.JTextField tnama_plg;
    private javax.swing.JTextField tqty;
    private javax.swing.JTextField ttotal;
    // End of variables declaration//GEN-END:variables
}
