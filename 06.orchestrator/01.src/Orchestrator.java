import workflow.accessdb.*;
import workflow.registry.*;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.ejb.EJBException;
import java.util.*;
import workflow.accessdb.*;
import java.net.URL;
import javax.xml.namespace.QName;

import javax.swing.JOptionPane;



@Stateless                                                            
@WebService(name="Orchestrator", targetNamespace = "http://orchestrator.workflow", serviceName = "Service")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public class Orchestrator
{

	private List<BeanProcess> listprocess = null;
	private Integer id;

	public Orchestrator()
	{

	}


	@WebMethod
	public boolean startprocess(@WebParam(name="position") String position)
	{
		
		//String saisie = JOptionPane.showInputDialog("Quel est votre profil :");
		//saisie = JOptionPane.showInputDialog("Quel type de poste :");

		try
		{
			workflow.accessdb.Service service_accessdb = new workflow.accessdb.Service();
			Accessdb accessdb = service_accessdb.getAccessdbPort();

			workflow.registry.Service service_registry = new workflow.registry.Service();
			Registry registry = service_registry.getRegistryPort();


			//initialize process by DRH
			id = accessdb.initprocess(position);
			System.out.println("Position = " + id.toString());


			//get steps from the process
			listprocess = accessdb.getListstep();
			for (int i=0; i<listprocess.size(); i++)
			{	
				BeanProcess bean = listprocess.get(i);
				String url = registry.getService(bean.getIdregistry());
				System.out.println(url);
			}
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
}

/*********************************************************************************








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
			Registry reg = service1.getPort(Registry.class); 
			String s = reg.getService("initialiser");
			System.out.println(s);
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}	
}




*/

