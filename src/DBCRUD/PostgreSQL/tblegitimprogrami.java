/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCRUD.PostgreSQL;

import DBConnections.allConnections;
import DBFramework.ICRUD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vektorel
 */
public class tblegitimprogrami implements ICRUD
{
    allConnections baglanti = new allConnections();
    @Override
    public void Kaydet(Object o) {
        Modeller.tblegitimprogrami egitim;
        egitim = (Modeller.tblegitimprogrami) o;
        
        try 
        {
            PreparedStatement ifade = baglanti.baglan().prepareCall("insert into tblegitimprogrami set (tarih , gun , alet_id , set , tekrar , siralama , egitimgrubu_id) values (?,?,?,?,?,?,?)");
            ifade.setDate(1, (Date) egitim.getTarih());
            ifade.setString(2, egitim.getGun());
            ifade.setInt(3, (int) egitim.getAletid());
            ifade.setInt(4, egitim.getSet());
            ifade.setInt(5, egitim.getTekrar());
            ifade.setInt(6, egitim.getSiralama());
            ifade.setInt(7, (int) egitim.getEgitimgrupid());
            ifade.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public void Duzenle(Object o) {
        Modeller.tblegitimprogrami egitim;
        egitim = (Modeller.tblegitimprogrami) o;
        
        try {
            PreparedStatement ifade = baglanti.baglan().prepareCall("update tblegitimprogrami set tarih=? , gun=? , alet_id=? , set=? , tekrar=? ,");
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(tblegitimprogrami.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(tblegitimprogrami.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Sil(long id) {
        try {
            PreparedStatement ifade = baglanti.baglan().prepareCall("delete from tblegitimprogrami where id=?");
                    ifade.setInt(1, (int) id);
                    ifade.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tblegitimprogrami.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(tblegitimprogrami.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Object> Listele() {
        ArrayList<Object> egitimprogramilistesi = new ArrayList<>();
        ResultSet rs;
        Modeller.tblegitimprogrami item;
        
        try {
            PreparedStatement ifade = baglanti.baglan().prepareCall("select * from egitimprogrami");
            rs = ifade.executeQuery();
            while(rs.next())
            {
                item = new Modeller.tblegitimprogrami();
                item.setId(rs.getInt("id"));
                item.setTarih(rs.getDate("tarih"));
                item.setGun(rs.getString("gun"));
                item.setAletid(rs.getInt("alet_id"));
                item.setSet(rs.getInt("set"));
                item.setTekrar(rs.getInt("tekrar"));
                item.setSiralama(rs.getInt("siralama"));
                item.setEgitimgrupid(rs.getInt("egitimgrubu_id"));
                egitimprogramilistesi.add(item);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tblegitimprogrami.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(tblegitimprogrami.class.getName()).log(Level.SEVERE, null, ex);
        }
        return egitimprogramilistesi;
    }

    @Override
    public Object Bul(long id) {
        Modeller.tblegitimprogrami egitimbul = new Modeller.tblegitimprogrami();
        ResultSet rs;
        
        try {
            PreparedStatement ifade = baglanti.baglan().prepareCall("select * from tblegitimprogrami where id=?");
            ifade.setInt(1, (int)id);
            rs = ifade.executeQuery();
            while(rs.next())
            {
                egitimbul.setId(rs.getInt("id"));
                egitimbul.setTarih(rs.getDate("tarih"));
                egitimbul.setGun(rs.getString("gun"));
                egitimbul.setAletid(rs.getInt("alet_id"));
                egitimbul.setSet(rs.getInt("set"));
                egitimbul.setTekrar(rs.getInt("tekrar"));
                egitimbul.setSiralama(rs.getInt("siralama"));
                egitimbul.setEgitimgrupid(rs.getInt("egitimgrubu_id"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tblegitimprogrami.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(tblegitimprogrami.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return egitimbul;
    }
    
     public List<Modeller.tblegitimprogrami> Arama(String ad,String soyad,String telefon,String cinsiyet){
    
        ArrayList<Modeller.tblegitimprogrami> egitimprograimlistesi= new ArrayList<>();
        ResultSet rs;
        Modeller.tblegitimprogrami item;
        String AnaSQL = "select * from tblegitimprograim";
        
//        if(ad!=null) AnaSQL+="ad like '%"+ad+"%' and "; else AnaSQL+="1=1 and ";
//        if(soyad!=null) AnaSQL+="soyad like '%"+soyad+"%' and ";else AnaSQL+="1=1 and ";
//        if(telefon!=null) AnaSQL+="ceptel like '%"+telefon+"%' and ";else AnaSQL+="1=1 and ";
//        if(cinsiyet!=null) AnaSQL+="cinsiyet like '%"+cinsiyet+"%'";else AnaSQL+="1=1 ";
//        System.out.println("SQL koşulu....:"+ AnaSQL);
//        
        if(tarih!=null && gun!=null && alet_id!=null && set!=null && tekrar!=null && siralama!=null && egitimgrubu_id!=null) AnaSQL+=" where ";

          int durum=0;
          if(tarih!=null)
          {
              AnaSQL+="tarih like '%"+tarih+"%' ";
              durum=1;
          } 
          if(gun!=null)
          {
              AnaSQL+= ((durum==1?" and ": "") + "gun like '%"+gun+"%'");
                durum=1;
          }
          if(alet_id!=null)
          {
              AnaSQL+= ((durum==1?" and ": "") +"alet_id like '%"+alet_id+"%'");
                durum=1;
          }
          if(set!=null)
          {
              AnaSQL+= ((durum==1?" and ": "") +"set like '%"+set+"%'");
          }
          if(tekrar!=null)
          {
              AnaSQL+= ((durum==1?" and ": "") +"tekrar like '%"+tekrar+"%'");
          }
          if(siralama!=null)
          {
              AnaSQL+= ((durum==1?" and ": "") +"siralama like '%"+siralama+"%'");
          }
          if(egitimgrubu_id!=null)
          {
              AnaSQL+= ((durum==1?" and ": "") +"egitimgrubu_id like '%"+egitimgrubu_id+"%'");
          }
          System.out.println("SQL koşulu....:"+ AnaSQL);

        try {
            String SQL=AnaSQL;
             PreparedStatement  ifade = baglanti.baglan().prepareCall(SQL);
             rs= ifade.executeQuery();
             while(rs.next()){
             item = new Modeller.tblegitimprogrami();
             item.setId(rs.getInt("id"));
             item.setTarih(rs.getDate("tarih"));
             item.setGun(rs.getString("gun"));
             item.setAletid(rs.getInt("alet_id"));
             item.setSet(rs.getInt("set"));
             item.setTekrar(rs.getInt("tekrar"));
             item.setSiralama(rs.getInt("siralama"));
             item.setEgitimgrupid(rs.getInt("egitimgrubu_id"));
             egitimprograimlistesi.add(item);
             }
             
       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tblegitimprogrami.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(tblegitimprogrami.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return egitimprogramilistesi;      
    }
    
    public List<Modeller.tblegitimprogrami> YasArama(int yasilk,int yasson) throws SQLException, ClassNotFoundException{
        ArrayList<Modeller.tblegitimprogrami> elist = new ArrayList<>();
        Modeller.tblegitimprogrami egt;
        ResultSet rs;

        LocalDate gununTarihi = LocalDate.now();
        
       LocalDate ilkyas = gununTarihi.minusYears(yasilk);
       LocalDate sonyas = gununTarihi.minusYears(yasson);
        
        
        String SQL = "select * from tblegitimprogrami where dogumtarihi between '"+sonyas+"' and '"+ilkyas+"' order by dogumtarihi";
        PreparedStatement ifade = baglanti.baglan().prepareCall(SQL);
        rs = ifade.executeQuery();
        while(rs.next()){
        egt = new Modeller.tblegitimprogrami();
        egt.setAd(rs.getString("ad"));
        egt.setSoyad(rs.getString("soyad"));
        egt.setId(rs.getInt("id"));
        egt.setTckimlik(rs.getString("tckimlik"));
        egt.setDogumtarihi(rs.getDate("dogumtarihi"));
        elist.add(egt);            
        }
       return elist;
        
        
    }
    
}
