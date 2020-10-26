
package java_hotel_syste;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ROOMS extends MY_CONNECTION {
    MY_CONNECTION my_connection=new MY_CONNECTION();
    //Type tablosunun değişkenleri classa aktarılmıştır.
     public void fillRooms_TYPE_JTable(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String  selectQuery="SELECT * FROM `type` ";
        try {
            ps=my_connection.createConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
            Object[] row;
            while(rs.next())
            {
                row=new Object[3];
                row[0]=rs.getInt(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
              
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public void fillRoomsJTable(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String  selectQuery="SELECT * FROM `rooms` ";
        try {
            ps=my_connection.createConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
            Object[] row;
            while(rs.next())
            {
                row=new Object[4];
                row[0]=rs.getInt(1);
                row[1]=rs.getInt(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     //Type tablosunun depişkenleriid olarak combobox içerisine atılması gerçekleştirilmiştir.
    public void fillRooms_TYPE_JComboBox(JComboBox combobox)
    {
        PreparedStatement ps;
        ResultSet rs;
        String  selectQuery="SELECT * FROM `type` ";
        try {
            ps=my_connection.createConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            
            while(rs.next())
            {
              
              
                combobox.addItem(rs.getInt(1));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Oda ekleme işlemi gerçekleştirilmiştir.
     public boolean addRoom(int number,int type,String phone)
    {
        PreparedStatement st;
        
        String addQuery="INSERT INTO `rooms`(`r_number`, `type`, `phone`, `reserved`) VALUES (?,?,?,?)";
        try {
            st=my_connection.createConnection().prepareStatement(addQuery);
            st.setInt(1, number);
            st.setInt(2, type);
            st.setString(3, phone);
             st.setString(4, "No");
            
            return (st.executeUpdate()>0);
            
           
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
              return false;
        } 
    }
      //Oda güncelleme işlemi gerçekleştirilmiştir.
      public boolean editRoom(int number,int type,String phone,String isReserved)
    {
           PreparedStatement st;
      
        String editQuery="UPDATE `rooms` SET `r_number`=?,`type`=?,`phone`=?,`reserved`=? WHERE `r_number`=?";
        try {
            st=my_connection.createConnection().prepareStatement(editQuery);
            st.setInt(1,number);
            st.setInt(2, type);
            st.setString(3,phone);
            st.setString(4,isReserved);
           
           
  
            
                
            return (st.executeUpdate()>0);
           
            }
        catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
              return false;
        } 
        
    }
      //Oda silme işlemi gerçekleştirilmiştir.
    public boolean removeRoom(int roomNumber )
    {
         PreparedStatement st;
      
        String deleteQuery="DELETE FROM `rooms` WHERE `r_number`=?";
        try {
            st=my_connection.createConnection().prepareStatement(deleteQuery);
          
            st.setInt(1, roomNumber);
            
                
                return (st.executeUpdate()>0);
           
            }
        catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
              return false;
        } 
    }
    //Rezervason güncelleme işlemi gerçekleşirilmiştir.
     public boolean setRoomToReserved(int number,String isReserved)
    {
           PreparedStatement st;
      
        String editQuery="UPDATE `rooms` SET `reserved`=? WHERE `r_number`=?";
        try {
            st=my_connection.createConnection().prepareStatement(editQuery);
           
            st.setString(1, isReserved);
            st.setInt(2, number);
  
            
                
                return (st.executeUpdate()>0);
           
            }
        catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
              return false;
        } 
        
    }
     //Rezerve durumu işlemi gerçekleştirilmiştir.
    public String isRoomReserved(int number)
    {
         PreparedStatement st;
         ResultSet rs;
      
        String editQuery="SELECT  `reserved` FROM `rooms` WHERE `r_number`=?";
        try {
            st=my_connection.createConnection().prepareStatement(editQuery);
           
           
            st.setInt(1, number);
            rs=st.executeQuery();
            if(rs.next())
            {
                return rs.getString(1);
            }
            else
            {
                return "";
            }
            
            }
        catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
              return "";
        } 
        
    }
     
     
     
     
}