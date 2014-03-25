import java.util.*;
import workflow.*;
import java.io.Console;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

<<<<<<< HEAD
=======


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(name="Registry", targetNamespace = "http://registry.workflow", serviceName = "Service")
interface Registry
{
	
	public String getService(String servicename);
 	
	public void addService(
		String servicename,
		String url);
}

>>>>>>> 835bf11978ce7cad39cb1db14ac35e8fa78409a3
public class Client 
{

	public static void main(String[] args) 
	{

<<<<<<< HEAD
	try
	{
	URL url = new URL("http://localhost:8080/ServiceRegistry/Service/Registry?wsdl");
        QName qname = new QName("http://registry.workflow","Service"); 

        javax.xml.ws.Service service1 = javax.xml.ws.Service.create(url, qname);
        Registry reg = service1.getPort(Registry.class); 
	String s = reg.getService("selectionner");
	System.out.println(s);
	} catch (Exception e)
	{
		System.out.println(e);
	}
	
		System.out.println("*****************************************");
=======
>>>>>>> 835bf11978ce7cad39cb1db14ac35e8fa78409a3

		workflow.orchestrator.Service service = new workflow.orchestrator.Service();
		Orchestrator orchestrator = service.getOrchestratorPort();

		String role;
		Console cons = System.console();
		if(cons!=null)
		{
			System.out.print("Veuillez-vous identifier :");
			role = cons.readLine();
			if (!role.equals("DRH"))
				return;
		}
	
		System.out.println("*****************************************");
		System.out.println("Start Process");
		System.out.println("*****************************************");


		System.out.print("Veuillez saisir le poste à pourvoir :");	
		String position = role = cons.readLine();	

		if (orchestrator.startprocess(position)) 
			System.out.println("ok");
		else
			System.out.println("Nok");

		System.out.println("*****************************************");
		System.out.println("end Process");
		System.out.println("*****************************************");


	}
}
