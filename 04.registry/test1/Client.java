import java.util.*;
import java.io.Console;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import workflow.registry.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;


public class Client 
{

	public static void main(String[] args) 
	{

		try
		{
			URL url = new URL("http://localhost:8080/ServiceRegistry/Service/Registry?wsdl");
			QName qname = new QName("http://registry.workflow","Service"); 

			javax.xml.ws.Service service1 = javax.xml.ws.Service.create(url, qname);

			String s ="Registry";
string classe = s+".class";

			Registry reg = service1.getPort(Registry.class); 
			String s = reg.getService("initialiser");
			System.out.println(s);
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}	
}
