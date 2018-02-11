/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBFramework;

import java.util.List;

/**
 *
 * @author vektorel
 */
public interface ICRUD 
{
    public void Kaydet(Object o);
    public void Duzenle(Object o);
    public void Sil(long id);
    public List<Object> Listele();
    public Object Bul(long id);
}
