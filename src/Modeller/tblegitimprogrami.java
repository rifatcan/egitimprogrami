/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeller;

import java.util.Date;

/**
 *
 * @author vektorel
 */
public class tblegitimprogrami {
 
    private long id;
    private Date tarih;
    private String gun;
    private long aletid;
    private int set;
    private int tekrar;
    private int siralama;
    private long egitimgrupid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public long getAletid() {
        return aletid;
    }

    public void setAletid(long aletid) {
        this.aletid = aletid;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getTekrar() {
        return tekrar;
    }

    public void setTekrar(int tekrar) {
        this.tekrar = tekrar;
    }

    public int getSiralama() {
        return siralama;
    }

    public void setSiralama(int siralama) {
        this.siralama = siralama;
    }

    public long getEgitimgrupid() {
        return egitimgrupid;
    }

    public void setEgitimgrupid(long egitimgrupid) {
        this.egitimgrupid = egitimgrupid;
    }
    
    
}
