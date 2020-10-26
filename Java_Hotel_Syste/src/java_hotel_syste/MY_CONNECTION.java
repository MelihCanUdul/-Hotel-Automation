
package java_hotel_syste;

;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MY_CONNECTION {
//Bağlantı classının kodları aşağıda verilmiştir.Bağlantı işlemi yapıldıktan sonra MYSQL DRİVERI KURULUR VE
    //VERİTABANI İŞLEMLERİİN YAPILMASINA BAŞLANIR.
    public Connection createConnection()
    {
        Connection connection=null;
        MysqlDataSource mds=new MysqlDataSource();
        mds.setServerName("localhost");
        mds.setPortNumber(3306);
        mds.setUser("root");
        mds.setPassword("rahmi.123");
        mds.setDatabaseName("java_hotel_db");
       
        try
        {
            connection=mds.getConnection();
        }catch(SQLException ex)
        {
            Logger.getLogger(MY_CONNECTION.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    return connection;
    }
}
