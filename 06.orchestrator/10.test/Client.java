import java.util.*;
import workflow.orchestrator.*;
import java.io.Console;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


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
