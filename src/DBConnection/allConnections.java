/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vektorel
 */
public class allConnections {
    
    Connection baglanti;
  
    public Connection baglan() throws ClassNotFoundException, SQLException{
    if(staticValues.isDB==0) return pgSQLBaglan();
    else if(staticValues.isDB==1) return OracleBaglan();
    else if(staticValues.isDB==2) return MySQLBaglan();
    else return msSQLBaglan();
    
    }
    
    public Connection baglantiKapat() throws ClassNotFoundException, SQLException
    {
        baglanti.close();
        return null;
    }
    
    
    private Connection pgSQLBaglan() throws ClassNotFoundException, SQLException{
    
        // İlgili sürücü tanımlanır.
        Class.forName(staticValues.getPgSQL().getDriverName());
             
        // ilgili veri tabanına bağlantı için bağlantıcümlesi yazılır.        
         baglanti=DriverManager.getConnection(
                "jdbc:postgresql://"+staticValues.getPgSQL().getIpAdress()+
                ":"+staticValues.getPgSQL().getPort()+"/"+staticValues.getPgSQL().getDateBase()+"", 
                staticValues.getPgSQL().getUserName(), 
                staticValues.getPgSQL().getPassword());
         
        return baglanti;
    }
    
    private Connection OracleBaglan(){
    return null;
    }
    
    private Connection MySQLBaglan(){
    return null;
    }
    
    private Connection msSQLBaglan(){
    return null;
    }
    
    
    
}
