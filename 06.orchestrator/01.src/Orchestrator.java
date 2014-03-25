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
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import workflow.*;
import workflow.accessdb.*;
import workflow.rediger.*;
import workflow.selection.*;




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


	private workflow.Beancandidat step_rediger(workflow.Beancandidat bean, String url_text, String role)
	{
		System.out.println("***********************");
		System.out.println("* REDIGER ON GOING   **");
		System.out.println("***********************");
		workflow.Beancandidat result = null;
		try
		{
			URL url = new URL("http://localhost:8080/ServiceRediger/Service/rediger?wsdl");//url_text);
			QName qname = new QName("http://rediger.workflow","Service"); 
			javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);
			workflow.rediger.Rediger rediger = service.getPort(workflow.rediger.Rediger.class); 

			result.setRedigerCandidat(rediger.execstep(role, bean.getRedigerCandidat())); 
			result.setProcessorder(bean.getProcessorder()+1);

		} catch (Exception e)
		{
			System.out.println(e);
		}
		return result;
	}
/*
	private BeanProcess step_selectionner(workflow.Beancandidat bean, String url_text, String role)
	{
		System.out.println("****************************");
		System.out.println("* SELECTIONNER ON GOING   **");
		System.out.println("****************************");
		workflow.Beancandidat result = null;
		try
		{
			URL url = new URL("http://localhost:8080/ServiceSelection/Service/selection?wsdl");//url_text);
			QName qname = new QName("http://rediger.workflow","Service"); 

			javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);

			workflow.selection.Selection selection = service.getPort(workflow.selection.Selection.class); 
			result = selection.execstep(role, bean);
			//result.setProcessorder(bean.getProcessorder()+1);
		} catch (Exception e)
		{
			System.out.println(e);
		}
		return result;
	}
	*/


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
			workflow.Beancandidat candidat = new workflow.Beancandidat();
			candidat.setId(id);

			//get steps from the process
			listprocess = accessdb.getListstep();


			for (int i=0; i<listprocess.size(); i++)
			{
				BeanProcess bean = listprocess.get(i);
				int id = bean.getProcessorder();
				
				switch (id)
				{
					case 1:
						break;
					case 2:
						 candidat = step_rediger(candidat, registry.getService("rediger"), bean.getRole());
						break;
					case 3:
						break;
					case 4:
						//candidat = step_selectionner(candidat, registry.getService("selectionner"), bean.getRole());
						break;
				}
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

