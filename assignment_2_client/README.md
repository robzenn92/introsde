# Assignment 2 - Client

Please, to compile the client project execute the following command.
```
ant compile
```

Assignment 2 Client is composed by 2 important classes:
- *XmlClient.java* which makes XML requests to a remote server
- *JsonClient.java* which makes JSON requests to a remote server

The number of request made by both clients are 12 each.
A Request is a class composed by:
```
private String result;	// Result Status
private String path;	// Request path e.g. /person
private String method;	// Request method e.g. GET, POST, PUT, ..
private String type;	// Request type could be xml or json
private String body;	// Response
private int ret;		// Result
```

And public methods, the most important are the following two.
```
public String doRequest(String data) throws IOException, JSONException

public void printReq() throws IOException
```


## XML CLIENT

```
ant execute-xml-client -Durl="http://localhost:8000/sdelab"
```

And example of output should be
```
[echo] Executing Assignment 2 - XML Client
[java] REQUEST #1 : GET /person
[java] Accept application/xml
[java] Content-Type application/xml
[java] => Result: ERROR
[java] => HTTP Status: 200
[java] <?xml version="1.0" encoding="UTF-8" standalone="yes"?><people><person><idp>6953</idp><lastname>Zen</lastname><firstname>Roberto</firstname><birthdate>23-03-2044</birthdate></person><person><idp>7004</idp><lastname>Baudo</lastname><firstname>Pippo</firstname><birthdate>25-09-1971</birthdate><healthProfile><measure><mid>3460</mid><value>172.4</value><created>1424202617771</created><measureType>heigth</measureType></measure><measure><mid>3509</mid><value>78.9</value><created>1424202768734</created><measureType>weigth</measureType></measure><measure><mid>3510</mid><value>172.4</value><created>1424202768757</created><measureType>heigth</measureType></measure><measure><mid>3559</mid><value>78.9</value><created>1424203037726</created><measureType>weigth</measureType></measure><measure><mid>3560</mid><value>172.4</value><created>1424203037755</created><measureType>heigth</measureType></measure><measure><mid>3609</mid><value>78.9</value><created>1424203115203</created><measureType>weigth</measureType></measure><measure><mid>3610</mid><value>172.4</value><created>1424203115229</created><measureType>heigth</measureType></measure></healthProfile></person></people>
```

## JSON CLIENT

```
ant execute-json-client -Durl="http://localhost:8000/sdelab"
```

And example of output should be
```
[echo] Executing Assignment 2 - JSON Client
[java] REQUEST #1 : GET /person
[java] Accept application/json
[java] Content-Type application/json
[java] => Result: ERROR
[java] => HTTP Status: 200
[java] {"person":[{"idp":6953,"lastname":"Zen","firstname":"Roberto","birthdate":"23-03-2044"},{"idp":7004,"lastname":"Baudo","firstname":"Pippo","birthdate":"25-09-1971","healthProfile":{"measure":[{"mid":3609,"value":78.9,"created":"1424203115203","measureType":"weigth"},{"mid":3610,"value":172.4,"created":"1424203115229","measureType":"heigth"}]}}]}
```
