/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.mybeans;

import fst.jee.entity.SousCat;
import fst.jee.services.SousCatService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author souha
 */
@Named(value = "sousCatManagedBean")
@RequestScoped
public class SousCatManagedBean {

   private List<SousCat> cats;
   private List<Integer> ids=new ArrayList();

    public List<Integer> getIds() {
        for(SousCat c: getCats()){
            ids.add(c.getId());
        }
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
    SousCatService cGerer=new SousCatService();
    public SousCatManagedBean() {
    }
    
    public List<SousCat> getCats() {
        //System.out.println("getSouCat");
        if(cats==null){
           // System.out.println("getSouCat");
		cats = cGerer.selectAll();
        }
        return cats;
    }
    
}
