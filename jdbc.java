import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class NewJFrame extends javax.swing.JFrame {   
    public NewJFrame() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/student","root","windows"); //3306 or 8306
        Statement stmt=con.createStatement();
         String t1,t3,t5;
         int t2,t4;
         t1=jTextField1.getText();
         t3=jTextField3.getText();
         t5=jTextField5.getText();
         t2=Integer.parseInt(jTextField2.getText());
         t4=Integer.parseInt(jTextField4.getText());
        
         String rs="insert into stud(name,id,email,mark,address)values('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"')";
         stmt.executeUpdate(rs);
        } 
        catch(Exception e)
        { 
            System.out.println(e);
        } 
   }                                        
     private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        DefaultTableModel tblModel1=(DefaultTableModel)jTable1.getModel();
        tblModel1.setRowCount(0);
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/student","root","windows"); //3306 or 8306
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from stud");
        while(rs.next())
        {
            String Name=rs.getString(1); 
            String Stud_Id=String.valueOf(rs.getInt(2));
            String Email=rs.getString(3);
            String Mark=String.valueOf(rs.getInt(4));
            String Address=rs.getString(5);

        String tbData[]={Name,Stud_Id,Email,Mark,Address};
        tblModel1.addRow(tbData);
        }
        }
        catch(Exception e)
        { 
            System.out.println(e);
      }     
    }                                        
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
  DefaultTableModel tblModel1=(DefaultTableModel)jTable1.getModel();
        tblModel1.setRowCount(0);
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/student","root","windows"); //3306 or 8306
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from stud");
        while(rs.next())
        {
            String Name=rs.getString(1); 
            String Stud_Id=String.valueOf(rs.getInt(2));
            String Email=rs.getString(3);
            String Mark=String.valueOf(rs.getInt(4));
            String Address=rs.getString(5);

        String tbData[]={Name,Stud_Id,Email,Mark,Address};
        tblModel1.addRow(tbData);
        }
        String s1="delete from stud where id="+jTextField2.getText()+";";
        stmt.executeUpdate(s1);
        con.close();
        }
        catch(Exception e)
        { 
            System.out.println(e);
      }   
    }                                        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/student","root","windows"); //3306 or 8306
        Statement stmt=con.createStatement();
        int t2,t4;
        String t1,t3,t5;
        t2=Integer.parseInt(jTextField2.getText());
        t1=jTextField1.getText();
         t3=jTextField3.getText();
         t5=jTextField5.getText();
         t2=Integer.parseInt(jTextField2.getText());
         t4=Integer.parseInt(jTextField4.getText());
        String s="update stud set name='"+t1+"',email='"+t3+"',mark='"+t4+"',address='"+t5+"' where id='"+t2+"'";
        stmt.executeUpdate(s);
        }
        catch(Exception e)
        { 
            System.out.println(e);
        }    
    }                                        
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        DefaultTableModel tblModel1=(DefaultTableModel)jTable1.getModel();
        tblModel1.setRowCount(0);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }                                        
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        DefaultTableModel tblModel1 =(DefaultTableModel)jTable1.getModel();
        int selectedRowIndex=jTable1.getSelectedRow();
jTextField1.setText(tblModel1.getValueAt(selectedRowIndex,0).toString());        
        jTextField2.setText(tblModel1.getValueAt(selectedRowIndex,1).toString());        
        jTextField3.setText(tblModel1.getValueAt(selectedRowIndex,2).toString());        
        jTextField4.setText(tblModel1.getValueAt(selectedRowIndex,3).toString());               jTextField5.setText(tblModel1.getValueAt(selectedRowIndex,4).toString());      
    }                                           
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration                   
}

