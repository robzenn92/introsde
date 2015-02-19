/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondassignement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author roberto
 */
public class Settings {
    
    public static final String BASE_URL = "http://localhost:8000/sdelab/";

    public static String convDate(String date) {
        long d = Long.parseLong(date);
        String date_s = "";
        try{
            date_s = new SimpleDateFormat("dd-MM-yyyy").format(d);
            
        } catch(Exception e){
        	e.printStackTrace();
        }
        return date_s;
    }
    
    public static String convDateHour(String date) {
        long d = Long.parseLong(date);
        String date_s = "";
        try{
        	date_s = new SimpleDateFormat("dd-MM-yyyyHH:mm:ss").format(d);
            
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        return date_s;
    }
    
    public static String convertFromDateToTimestamp(String date){
        Date result = null;
        try{
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.ITALIAN);
            result =  df.parse(date); 
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return result.getTime() + "";
    }
}