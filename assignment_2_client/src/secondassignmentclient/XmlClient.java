/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondassignmentclient;


/**
 * Makes XML requests to a remote server
 * @author roberto
 */
public class XmlClient {

    public static void main(String[] args) throws Exception {
    	
    	if(args.length > 0) {
    		System.out.println("USAGE:");
    		System.out.println("Parameter 0: SERVER_BASE_URL (e.g. http://localhost:8000/sdelab).");
    		Request.setBaseUrl(args[0]);
    	}

        System.out.println("SERVER_BASE_URL set to " + Request.getBaseUrl());
        
    	Request.setRequest_number(0);
    	
    	try {
    		
	        XML_Request.request1();
	        XML_Request.request2();
	        XML_Request.request3();
	        XML_Request.request4();
	        XML_Request.request5();
	        XML_Request.request6();
	        XML_Request.request7();
	        XML_Request.request8();
	        XML_Request.request9();
//	        XML_Request.request10();
//	        XML_Request.request11();
//	        XML_Request.request12();
	        
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}