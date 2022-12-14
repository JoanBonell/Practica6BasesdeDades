
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sergiosayago
 */
public class Query extends javax.swing.JDialog {

    /**
     * Creates new form Query
     */
    Connection con;
    private QueryHandler qhand = null;
    //public static Statement stmt = null;
    public static ResultSet rs = null;
    
    public Query(java.awt.Frame parent, Connection c, boolean modal) {
        super(parent, modal);
        initComponents();
        con = c;
        qhand = new QueryHandler();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_branches = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_branches = new javax.swing.JList<>();
        btn_clients = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_clients = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_branches.setText("Query Branches");
        btn_branches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_branchesActionPerformed(evt);
            }
        });

        list_branches.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "branch 1", "branch 2", "branch 3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list_branches);

        btn_clients.setText("Query Clients");
        btn_clients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientsActionPerformed(evt);
            }
        });

        list_clients.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(list_clients);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_clients, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_branches, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btn_branches)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_clients)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_branchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_branchesActionPerformed
        
        //ResultSet result = executeQuery(con, "SELECT * from branch;");   
        //ResultSet result;
        try {
            rs = qhand.executeQuery(con, "SELECT * from branch;");
            loadBranches();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Status", JOptionPane.INFORMATION_MESSAGE);
        }
                
        
    }//GEN-LAST:event_btn_branchesActionPerformed

    private void btn_clientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientsActionPerformed
        
        // Write your code here
        
    }//GEN-LAST:event_btn_clientsActionPerformed

    private void loadBranches(){
        
        DefaultListModel model = new DefaultListModel();
        
        model.clear();
        
        try {
            
            while ( rs.next() ) {            
            
                String branch_id = rs.getString(1);
                String street = rs.getString(2);
                String city = rs.getString(3);
                String postcode = rs.getString(4);
                               
                String result = branch_id + " - " + street + " - " + city + " - " + postcode;
                
                model.addElement(result);                        
               
            }
            
        } catch (SQLException e){
            
             JOptionPane.showMessageDialog(this, e.getMessage(), "Status", JOptionPane.INFORMATION_MESSAGE);
        }
        
        this.list_branches.setModel(model);
    }
    /*private ResultSet executeQuery (Connection con, String query){
        
        try {
        
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(query);           
            
            return rs;
        
        } catch (SQLException e){
          
            JOptionPane.showMessageDialog(this, e.getMessage(), "Status", JOptionPane.INFORMATION_MESSAGE);
            
            return null;
        }
    }*/
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_branches;
    private javax.swing.JButton btn_clients;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list_branches;
    private javax.swing.JList<String> list_clients;
    // End of variables declaration//GEN-END:variables
}
