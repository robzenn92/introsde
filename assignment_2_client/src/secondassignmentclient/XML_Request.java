/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondassignmentclient;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.w3c.dom.NodeList;

/**
 * @author roberto
 */
public class XML_Request {

    public static int first, last;
    public static String auxj;
    public static String person_2;
    public static int id;
    public static int idreq7;
    public static ArrayList<String> measure_types = new ArrayList<String>();
    public static String mid,measureType;
    public static int countR9;
    public static String midR9;


    /**
     * Request #1: Lists all people stored in the database
     */
    public static void request1() throws IOException, JSONException, Exception {
    	
        Request r = new Request("/person", "GET", Settings.APP_XML);
        String xml = r.doRequest("");
        NodeList n = XPathEvaluator.getNodes(xml, "//person");
        if (n.getLength() > 2) {
            r.setResult("OK");
        } else {
            r.setResult("ERROR");
        }
        
        NodeList n1 = XPathEvaluator.getNodes(xml, "//person[1]/idp/text()");
        first = Integer.parseInt(n1.item(0).getNodeValue());
        NodeList n2 = XPathEvaluator.getNodes(xml, "//person[last()]/idp/text()");
        last = Integer.parseInt(n2.item(0).getNodeValue());
        r.printReq();
    }

    /**
     * Request #2: Gives all the personal information plus current measures of person identified by {id} 
     * (e.g., current measures means current health profile).
     */
    public static void request2() throws IOException, JSONException {
    	
        Request r = new Request("/person/" + first, "GET", Settings.APP_XML);
        person_2 = r.doRequest("");
        if (r.getRespCode() == 200 || r.getRespCode() == 202) {
            r.setResult("OK");
        } else {
            r.setResult("ERROR");
        }
        r.printReq();
    }

    /**
     * Request #3: Updates the personal information of the person identified by {id}
     * (e.g., only the person's information, not the measures of the health profile)
     */
    public static void request3() throws Exception {

        NodeList nl = XPathEvaluator.getNodes(person_2, "//firstname/text()");
        String name = nl.item(0).getNodeValue();
        
        // Debug
        System.out.println("Previous name: " + name);
        System.out.println("New name: " + "New " + name);
        
    	person_2 = person_2.replace(name, "New " + name);
        Request r = new Request("/person/" + first, "PUT", Settings.APP_XML);
        r.doRequest(person_2);
        if (r.getRespCode() == 202) {
            r.setResult("OK");
        } else {
            r.setResult("ERROR");
        }
        r.printReq();
    }

    /**
     * Request #4: Creates a new person and returns the newly created person with its assigned id
     * (if a health profile is included, create also those measurements for the new person).
     */
    public static void request4() throws IOException, JSONException, Exception {
    	
        Request r2 = new Request("/person", "POST", Settings.APP_XML);
        String ret = r2.doRequest(Settings.XML_POST_EXAMPLE);
        NodeList n1 = XPathEvaluator.getNodes(ret, "//idp/text()");
        id = Integer.parseInt(n1.item(0).getNodeValue());

        if (r2.getRespCode() == 200 || r2.getRespCode() == 201 || r2.getRespCode() == 202) {
            r2.setResult("OK");
        } else {
            r2.setResult("ERROR");
        }
        r2.printReq();
    }

    /**
     * Request #5: Deletes the person identified by {id} from the database
     */
    public static void request5() throws IOException, Exception {
    	
        Request r = new Request("/person/" + id, "DELETE", Settings.APP_XML);
        r.doRequest("");
        r.setResult("OK");
        r.printReq();

        Request r2 = new Request("/person/" + id, "GET", Settings.APP_XML);
        Request.setRequest_number(5);
        try {
            r2.doRequest("");
        } catch (Exception e) { }
        if (r2.getRespCode() == 404) {
            r2.setResult("OK");
        } else {
            r2.setResult("ERROR");
        }
        r2.printReq();
    }

    /**
     * Request #6: Returns the list of values (the history) of {measureType}
     * (e.g. weight) for person identified by {id}
     */
    public static void request6() throws IOException, Exception {
    	
        Request r = new Request("/measureTypes/", "GET", Settings.APP_XML);
        String x = r.doRequest("");

        NodeList n1 = XPathEvaluator.getNodes(x, "//MeasureType");
        if (n1.getLength() > 2) {
            r.setResult("OK");
        } else {
            r.setResult("ERROR");
        }

        NodeList n2 = XPathEvaluator.getNodes(x, "//MeasureType/text()");
        for (int i = 0; i < n1.getLength(); i++) {
            String aux = n2.item(i).getNodeValue();
            measure_types.add(aux);
        }

        r.printReq();
    }

    /**
     * Request #7: Returns the value of {measureType} (e.g. weight)
     * identified by {mid} for person identified by {id}
     */
    public static void request7() throws IOException, Exception {
    	
        boolean at_least_one = true;
        Request r = null;
        
        for (String mt : measure_types) {
            r = new Request("/person/" + first + "/" + mt, "GET", Settings.APP_XML);
            Request.setRequest_number(7);
            String x = r.doRequest("");

            NodeList n1 = XPathEvaluator.getNodes(x, "//measure");
            if(at_least_one && n1.getLength()>1){
                idreq7 = first;
                at_least_one = false;
                n1 = XPathEvaluator.getNodes(x, "//measure/mid/text()");
                mid = n1.item(0).getNodeValue();
                
                n1 = XPathEvaluator.getNodes(x, "//measure/measureType/text()");
                measureType = n1.item(0).getNodeValue();
                r.setResult("OK");
                r.printReq();
            }
        }
        if(at_least_one){
            r.setResult("ERROR");
            r.printReq();
        }
    }
    
    /**
     * Request #8: Saves a new value for the {measureType} (e.g. weight) of person identified by {id}
     * and archives the old value in the history
     */
    public static void request8() throws IOException, Exception {
        Request r = new Request("/person/" + idreq7 + "/"+ measureType+"/"+mid, "GET", Settings.APP_XML);
        String j = r.doRequest("");
        if(r.getRespCode() == 200)
            r.setResult("OK");
        else
            r.setResult("ERROR");
        
        r.printReq();
    }
    
    /**
     * Request #9: Returns the list of measures our model supports
     */
    public static void request9() throws IOException, Exception {
    	
        Request r = new Request("/person/" + idreq7 + "/"+ measure_types.get(0), "GET", Settings.APP_XML);
        String x = r.doRequest("");
        NodeList n1 = XPathEvaluator.getNodes(x, "//measure");
        countR9 = n1.getLength();
        r.setResult("OK");
        r.printReq();
        
        Request r2 = new Request("/person/" + idreq7 + "/"+ measure_types.get(0), "POST", Settings.APP_XML);
        Request.setRequest_number(9);
        x = r2.doRequest("<measure>\n" +
"            <value>72</value>\n" +
"            <created>2011-12-09</created>\n" +
"        </measure>");
        r2.setResult("OK");
        n1 = XPathEvaluator.getNodes(x, "//measure/mid/text()");
        midR9 = n1.item(0).getNodeValue();
        r2.printReq();
        
        r = new Request("/person/" + idreq7 + "/"+ measure_types.get(0), "GET", Settings.APP_XML);
        Request.setRequest_number(9);
        x = r.doRequest("");
        n1 = XPathEvaluator.getNodes(x, "//measure");
        if(n1.getLength() == countR9+1)
            r.setResult("OK");
        else
            r.setResult("ERROR");
        r.printReq();
    }
    
    /**
     * Request #10: Updates the value for the {measureType} (e.g., weight) identified by {mid},
     * related to the person identified by {id}
     */
    public static void request10() throws IOException, Exception {
    	
    	Request r = new Request("/person/" + idreq7 + "/" + measureType + "/" + midR9, "GET", Settings.APP_XML);
    	Request.setRequest_number(10);
        r.doRequest("");
        r.setResult("OK");
        r.printReq();
    	
        r = new Request("/person/" + idreq7 + "/" + measureType + "/" + midR9, "PUT", Settings.APP_XML);
        Request.setRequest_number(10);
        try {
            r.doRequest("<measure>\n<value>80</value>\n<created>2011-12-09</created>\n</measure>");
            r.setResult("OK");
            r.printReq();
        } catch (Exception e) {
            r.setResult("ERROR");
            r.printReq();
            return;
        }
        
        r = new Request("/person/" + idreq7 + "/" + measureType + "/" + midR9, "GET", Settings.APP_XML);
        Request.setRequest_number(10);
        String x = r.doRequest("");
        NodeList n1 = XPathEvaluator.getNodes(x, "//measure/value/text()");
        String val = n1.item(0).getNodeValue();
        if(val.equals("80"))
            r.setResult("OK");
        else
            r.setResult("ERROR");
        
        r.printReq();
    }

    /**
     * Request #11: Returns the history of {measureType} (e.g., weight) for person {id} in the specified range of date
     */
    public static void request11() throws IOException, Exception {
        Request r = new Request("/person/" + idreq7 + "/"+ measureType+"/?before=10-12-2012&after=21-12-2012", "GET", Settings.APP_XML);
        String x = r.doRequest("");
        NodeList n1 = XPathEvaluator.getNodes(x, "//measure");
        if (n1.getLength()>=1 && (r.getRespCode() == 200 || r.getRespCode() == 201 || r.getRespCode() == 202)) {
            r.setResult("OK");
        } else {
            r.setResult("ERROR");
        }
        r.printReq();
    }
    
    /**
     * Request #12: Retrieves people whose {measureType} (e.g., weight) value is in
     * the [{min},{max}] range (if only one for the query params is provided, use only that)
     */
    public static void request12() throws IOException, Exception {
    	
        Request r = new Request("/person?measureType=heigth&max=150&min=190", "GET", Settings.APP_XML);
        String x = r.doRequest("");
        NodeList n1 = XPathEvaluator.getNodes(x, "//person");
        if (n1.getLength()>=1 && (r.getRespCode() == 200 || r.getRespCode() == 201 || r.getRespCode() == 202)) {
            r.setResult("OK");
        } else {
            r.setResult("ERROR");
        }
        r.printReq();
    }
}