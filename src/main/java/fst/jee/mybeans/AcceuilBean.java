/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.mybeans;


import fst.jee.entity.Produit;
import fst.jee.entity.SousCat;

import fst.jee.services.ProdService;
import fst.jee.services.ProdService;
import fst.jee.services.SousCatService;
import fst.jee.services.SousCatService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author souha
 */
@Named(value = "catSouList")
@RequestScoped
public class AcceuilBean implements Serializable {

    /**
     * Creates a new instance of CatSou
     */
    

    SousCatService sousCatService=new SousCatService();
    ProdService pservice=new ProdService();
    private List<Produit> p ;

    public List<Produit> getP() {
        return p;
    }

    public void setP(List<Produit> p) {
        this.p = p;
    }
    private HashMap<SousCat,List<Produit>>list=new HashMap();
    
    private List<Entry<SousCat,List<Produit>>> entries;

    public List<Entry<SousCat, List<Produit>>> getEntries() {
        //System.out.println("Entriiiiiiiiiiieeeees ");
        
        List<SousCat> cats=sousCatService.selectAll();
        //List<Produit> p ;
        for(SousCat c : cats){
           p =new ArrayList();
               p.addAll(pservice.findByCat(c.getId()));
            list.put(c, p);
            //  System.out.println("p inetrmediaire: ****"+p.size());
          //  System.out.println("list.get(c).size() avant: ****"+list.get(c).size());
            //p=new ArrayList();
            //p.clear();
            //System.out.println("list.get(c).size() apres: ****"+list.get(c).size());
          }
            entries = new ArrayList<>(list.entrySet());
        //Entry<Categorie, List<Produit>>E=entries.get(0);
        /*for(Entry<SousCat,List<Produit>> e: entries){
            System.out.println("e.key ==> "+((SousCat)e.getKey()).getDesignation());
           List<Produit> lp=e.getValue();
           System.out.println("Size: "+lp.size());
           System.out.println("lp.getClass: "+lp.getClass());
          Iterator iterator = lp.iterator();
		while (iterator.hasNext()) {
                    for(Produit prod : (ArrayList<Produit>)(iterator.next()) ){
                    //Produit prod=(Produit)iterator.next();
			System.out.println(prod.getDesignation());
                        //System.out.println("iterator.class: "+(iterator.next()).getClass());
                    }
		}
        for(Produit prod : lp){
            System.out.println(prod.getPrix());
        }
        }*/
       // System.out.println("keu set: "+list.keySet().size());
      //  System.out.println("hashMap.size: "+list.size());
        return entries;
    }

    public void setEntries(List<Entry<SousCat, List<Produit>>> entries) {
        this.entries = entries;
    }
    public AcceuilBean() {
        
        
    }

    public HashMap<SousCat, List<Produit>> getList() {
         List<SousCat> cats=sousCatService.selectAll();
        //List<Produit> p ;
        for(SousCat c : cats){
           p =new ArrayList();
               p.addAll(pservice.findByCat(c.getId()));
            list.put(c, p);
            //System.out.println("p inetrmediaire: ****"+p.size());
            // System.out.println("list.get(c).size() avant: ****"+list.get(c).size());
            //p=new ArrayList();
            //p.clear();
           // System.out.println("list.get(c).size() apres: ****"+list.get(c).size());
          }
        return list;
    }

    public void setList(HashMap<SousCat, List<Produit>> list) {
        this.list = list;
    }
    /*@PostConstruct
    public void init(){
        System.out.println("list :) ");
        List<Categorie> cats=catService.selectAll();
        for(Categorie c : cats){
            List<SousCat> sCats=sousCatService.findByCat(c.getId());
            list.put(c, sCats);
          }
            entries = new ArrayList<>(list.entrySet());
   System.out.println("list size "+entries.size());
           
        }*/
        
   
    
}
