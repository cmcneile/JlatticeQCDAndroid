package com.example.xyploteg.eclipse  ;
// package QCDlatticeconfig  ; 

import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

//
//  http://www.ibm.com/developerworks/library/x-javaxpathapi/index.html
//


public class readparam {

    public readparam ()
	throws ParserConfigurationException, SAXException, 
	       IOException, XPathExpressionException 
    {

	domFactory = DocumentBuilderFactory.newInstance();
	domFactory.setNamespaceAware(true); // never forget this!

	builder = domFactory.newDocumentBuilder();
	doc = builder.parse("input_param.xml");

	factory = XPathFactory.newInstance();
	xpath = factory.newXPath();

    }


    public  int read_int(String xpath_want)
	throws ParserConfigurationException, SAXException, 
	       IOException, XPathExpressionException 
    {
	int ans ; 


	XPathExpression expr = xpath.compile(xpath_want);
	Object result = expr.evaluate(doc, XPathConstants.NODESET);
	NodeList nodes = (NodeList) result;
	if( nodes.getLength() != 1 )
	    {
		System.out.println("Error parsing " + xpath_want);
		System.exit(0) ;
	    }


	String tmp = nodes.item(0).getNodeValue() ;
	Integer myInteger = new Integer(tmp);
	ans =  myInteger ; 
	
	return ans ; 
    }


    public  double read_double(String xpath_want)
	throws ParserConfigurationException, SAXException, 
	       IOException, XPathExpressionException 
    {
	double ans ; 


	XPathExpression expr = xpath.compile(xpath_want);
	Object result = expr.evaluate(doc, XPathConstants.NODESET);
	NodeList nodes = (NodeList) result;
	if( nodes.getLength() != 1 )
	    {
		System.out.println("Error parsing " + xpath_want);
		System.exit(0) ;
	    }


	String tmp = nodes.item(0).getNodeValue() ;
	Double xx = new Double(tmp);
	ans =  xx ; 
	
	return ans ; 
    }




    //
    // public variables
    // 


    private static DocumentBuilderFactory domFactory ;
    private static DocumentBuilder builder ;
    private static Document doc  ;
    private static XPathFactory factory ;
    private static XPath xpath ;

}

