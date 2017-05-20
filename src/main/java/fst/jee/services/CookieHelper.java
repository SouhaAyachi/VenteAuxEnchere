/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
/**
 *
 * @author souha
 */
public class CookieHelper {
   public void setCookie(String name, String value, int expiry) {

    FacesContext facesContext = FacesContext.getCurrentInstance();

    HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    Cookie cookie = null;

    Cookie[] userCookies = request.getCookies();
    if (userCookies != null && userCookies.length > 0 ) {
        for (int i = 0; i < userCookies.length; i++) {
            if (userCookies[i].getName().equals(name)) {
                cookie = userCookies[i];
                break;
            }
        }
    }

    if (cookie != null) {
        cookie.setValue(value);
    } else {
        cookie = new Cookie(name, value);
        cookie.setPath(request.getContextPath());
    }

    cookie.setMaxAge(expiry);

    HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
    response.addCookie(cookie);
  }
   
  /*public Cookie getCookie(String name) {

    FacesContext facesContext = FacesContext.getCurrentInstance();

    HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    Cookie cookie = null;

    Cookie[] userCookies = request.getCookies();
    if (userCookies != null && userCookies.length > 0 ) {
        for (int i = 0; i < userCookies.length; i++) {
            if (userCookies[i].getName().equals(name)) {
                cookie = userCookies[i];
                return cookie;
            }
        }
    }
    return null;
  }  */
 
  public static void main(String[ ] args){
      System.out.println("******************************");
     
      //CookieHelper myCookie=new CookieHelper();
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date = new Date();
       System.out.println(dateFormat.format(date));
       System.out.println("******************************");
      //myCookie.setCookie("myCookie", date.toString(), 2);
      //System.out.println("insertion dans la cookie .......");
      // System.out.println("le contenu du cookie est :"+myCookie.getCookie("myCookie"));
         
         
  }   
}