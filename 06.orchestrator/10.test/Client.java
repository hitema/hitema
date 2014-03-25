import java.util.*;
import workflow.*;
import java.io.Console;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client 
{

	public static void main(String[] args) 
	{

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

/*
		Service service = new Service();
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
*/

	}
}
