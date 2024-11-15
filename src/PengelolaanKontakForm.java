/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class PengelolaanKontakForm extends javax.swing.JFrame {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    /**
     * Creates new form PengelolaanKontakForm
     */
    public PengelolaanKontakForm() {
        initComponents();
        initDatabase();

        // Menambahkan ItemListener untuk mendeteksi perubahan pada pilihan kategori
        cmbKategori.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Tindakan ketika kategori dipilih
                String kategoriTerpilih = (String) cmbKategori.getSelectedItem();
                System.out.println("Kategori yang dipilih: " + kategoriTerpilih);
            }
        });
    }
    
    // Inisialisasi koneksi ke SQLite database
    private void initDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:kontak.db");
            System.out.println("Koneksi ke database berhasil.");
            createTableIfNotExists();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi database gagal: " + e.getMessage());
        }
    }

    // Membuat tabel jika belum ada
    private void createTableIfNotExists() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS kontak (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "nama TEXT, " +
                         "telepon TEXT, " +
                         "kategori TEXT)";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal membuat tabel: " + e.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblTelepon = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        lblKategori = new javax.swing.JLabel();
        cmbKategori = new javax.swing.JComboBox<>();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnImpor = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKontak = new javax.swing.JTable();
        lblCari = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Pengelolaan Kontak");

        lblNama.setText("Nama:");

        txtNama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNamaFocusGained(evt);
            }
        });

        lblTelepon.setText("No. Telepon:");

        txtTelepon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTeleponFocusGained(evt);
            }
        });

        lblKategori.setText("Kategori:");

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Keluarga", "Teman", "Kerja", " " }));

        btnTambah.setBackground(new java.awt.Color(102, 102, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(51, 255, 51));
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 51, 51));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnCari.setBackground(new java.awt.Color(255, 255, 0));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        txtCari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCariFocusGained(evt);
            }
        });

        btnImpor.setBackground(new java.awt.Color(153, 153, 153));
        btnImpor.setText("Import CSV");
        btnImpor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImporActionPerformed(evt);
            }
        });

        btnExport.setBackground(new java.awt.Color(153, 153, 153));
        btnExport.setText("Export CSV");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        tblKontak.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nama", "No. Telepon", "Kategori"
            }
        ));
        jScrollPane1.setViewportView(tblKontak);

        lblCari.setText("Cari Kontak:");

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelepon)
                                    .addComponent(lblNama))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTelepon)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPanelLayout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(lblKategori))
                                        .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(JPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblCari)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addComponent(btnImpor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExport))
                            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        JPanelLayout.setVerticalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(lblNama)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTelepon))
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblKategori)
                        .addGap(1, 1, 1)
                        .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCari)
                        .addGap(1, 1, 1)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnImpor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String nama = txtNama.getText();
        String telepon = txtTelepon.getText();
        String kategori = (String) cmbKategori.getSelectedItem();
        
        if (nama.isEmpty() || telepon.isEmpty() || kategori == null) {
            JOptionPane.showMessageDialog(this, "Harap isi semua kolom.");
            return;
        }

        if (!telepon.matches("[0-9]+") || telepon.length() != 12) {
            JOptionPane.showMessageDialog(this, "Nomor telepon harus berisi 12 angka.");
            return;
        }

        try {
            String sql = "INSERT INTO kontak (nama, telepon, kategori) VALUES (?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, telepon);
            pst.setString(3, kategori);
            pst.executeUpdate();
            loadContacts();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menambah kontak: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
      int row = tblKontak.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih kontak yang akan diubah.");
            return;
        }

        String nama = txtNama.getText();
        String telepon = txtTelepon.getText();
        String kategori = (String) cmbKategori.getSelectedItem();
        int id = (int) tblKontak.getValueAt(row, 0);

        if (nama.isEmpty() || telepon.isEmpty() || kategori == null) {
            JOptionPane.showMessageDialog(this, "Harap isi semua kolom.");
            return;
        }

        // Validasi nomor telepon
        if (!telepon.matches("[0-9]+") || telepon.length() != 12) {
            JOptionPane.showMessageDialog(this, "Nomor telepon harus berisi 12 angka.");
            return;
        }

        try {
            String sql = "UPDATE kontak SET nama = ?, telepon = ?, kategori = ? WHERE id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, telepon);
            pst.setString(3, kategori);
            pst.setInt(4, id);
            pst.executeUpdate();
            loadContacts();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengubah kontak: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
      int row = tblKontak.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih kontak yang akan dihapus.");
            return;
        }

        int id = (int) tblKontak.getValueAt(row, 0);

        try {
            String sql = "DELETE FROM kontak WHERE id = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            loadContacts();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus kontak: " + e.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String query = txtCari.getText();
        if (query.isEmpty()) {
            loadContacts();
            return;
        }

        try {
            String sql = "SELECT * FROM kontak WHERE nama LIKE ? OR telepon LIKE ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + query + "%");
            pst.setString(2, "%" + query + "%");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tblKontak.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[] { rs.getInt("id"), rs.getString("nama"), rs.getString("telepon"), rs.getString("kategori") });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mencari kontak: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnImporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImporActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.trim().isEmpty()) { // Mengabaikan baris kosong
                        String[] data = line.split(",");
                        if (data.length == 3) {
                            String nama = data[0].trim();
                            String telepon = data[1].trim();
                            String kategori = data[2].trim();

                            if (telepon.matches("[0-9]+") && telepon.length() == 12) {
                                String sql = "INSERT INTO kontak (nama, telepon, kategori) VALUES (?, ?, ?)";
                                pst = conn.prepareStatement(sql);
                                pst.setString(1, nama);
                                pst.setString(2, telepon);
                                pst.setString(3, kategori);
                                pst.executeUpdate();
                            } else {
                                JOptionPane.showMessageDialog(this, "Nomor telepon tidak valid pada baris: " + line);
                            }
                        }
                    }
                }
                loadContacts();
            } catch (IOException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal mengimpor CSV: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnImporActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                String sql = "SELECT * FROM kontak";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                bw.write("Nama,Telepon,Kategori\n");

                while (rs.next()) {
                    bw.write(rs.getString("nama") + "," + rs.getString("telepon") + "," + rs.getString("kategori") + "\n");
                }
            } catch (IOException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal mengekspor CSV: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void txtNamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamaFocusGained
       txtNama.setText("");
    }//GEN-LAST:event_txtNamaFocusGained

    private void txtTeleponFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTeleponFocusGained
        txtTelepon.setText("");
    }//GEN-LAST:event_txtTeleponFocusGained

    private void txtCariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCariFocusGained
        txtCari.setText("");
    }//GEN-LAST:event_txtCariFocusGained

    private void loadContacts() {
        try {
            String sql = "SELECT * FROM kontak";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tblKontak.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[] { rs.getInt("id"), rs.getString("nama"), rs.getString("telepon"), rs.getString("kategori") });
            }

            // Mengatur ukuran kolom
            tblKontak.getColumnModel().getColumn(0).setPreferredWidth(50); // ID
            tblKontak.getColumnModel().getColumn(1).setPreferredWidth(150); // Nama
            tblKontak.getColumnModel().getColumn(2).setPreferredWidth(150); // Telepon
            tblKontak.getColumnModel().getColumn(3).setPreferredWidth(100); // Kategori
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data kontak: " + e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PengelolaanKontakForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PengelolaanKontakForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PengelolaanKontakForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PengelolaanKontakForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PengelolaanKontakForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnImpor;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblTelepon;
    private javax.swing.JTable tblKontak;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTelepon;
    // End of variables declaration//GEN-END:variables
}
