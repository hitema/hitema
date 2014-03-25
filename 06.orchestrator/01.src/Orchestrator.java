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
import workflow.interviewerdop.*;
import workflow.interviewerrh.*;
import workflow.selectionner.*;
import workflow.valider.*;




@Stateless                                                            
@WebService(name="Orchestrator", targetNamespace = "http://orchestrator.workflow", serviceName = "Service")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public class Orchestrator
{
	public Orchestrator()
	{

	}


	private workflow.CandidatOrchestrator step_rediger(workflow.CandidatOrchestrator bean, String url_text, String role)
	{
		System.out.println("***********************");
		System.out.println("* REDIGER ON GOING   **");
		System.out.println("***********************");
		workflow.CandidatOrchestrator result = new workflow.CandidatOrchestrator();
		try
		{
			System.out.println(url_text);
			URL url = new URL(url_text);
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

	private workflow.CandidatOrchestrator step_selectionner(workflow.CandidatOrchestrator bean, String url_text, String role)
	{
		System.out.println("****************************");
		System.out.println("* SELECTIONNER ON GOING   **");
		System.out.println("****************************");
		workflow.CandidatOrchestrator result = new workflow.CandidatOrchestrator();
		try
		{
			System.out.println(url_text);
			URL url = new URL(url_text);
			QName qname = new QName("http://selectionner.workflow","Service"); 
			javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);
			workflow.selectionner.Selectionner ws = service.getPort(workflow.selectionner.Selectionner.class); 

			result.setSelectionCandidat(ws.execstep(role, bean.getSelectionCandidat())); 
			result.setProcessorder(bean.getProcessorder()+1);

		} catch (Exception e)
		{
			System.out.println(e);
		}
		return result;
	}

	private workflow.CandidatOrchestrator step_InterviewRH(workflow.CandidatOrchestrator bean, String url_text, String role)
	{
		System.out.println("****************************");
		System.out.println("* INTERVIEW RH ON GOING   **");
		System.out.println("****************************");
		workflow.CandidatOrchestrator result = new workflow.CandidatOrchestrator();
		try
		{
			System.out.println(url_text);
			URL url = new URL(url_text);
			QName qname = new QName("http://interviewerRH.workflow","Service"); 
			javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);
			workflow.interviewerrh.InterviewerRH ws = service.getPort(workflow.interviewerrh.InterviewerRH.class); 

			result.setInterviewerRhCandidat(ws.execstep(role, bean.getInterviewerRhCandidat())); 
			result.setProcessorder(bean.getProcessorder()+1);

		} catch (Exception e)
		{
			System.out.println(e);
		}
		return result;
	}

	private workflow.CandidatOrchestrator step_InterviewDOP(workflow.CandidatOrchestrator bean, String url_text, String role)
	{
		System.out.println("**************************************");
		System.out.println("* INTERVIEW OPERATIONNEL ON GOING   **");
		System.out.println("**************************************");
		workflow.CandidatOrchestrator result = new workflow.CandidatOrchestrator();
		try
		{
			System.out.println(url_text);
			URL url = new URL(url_text);
			QName qname = new QName("http://interviewerDOP.workflow","Service"); 
			javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);
			workflow.interviewerdop.InterviewerDOP ws = service.getPort(workflow.interviewerdop.InterviewerDOP.class); 

			result.setInterviewerDopCandidat(ws.execstep(role, bean.getInterviewerDopCandidat())); 
			result.setProcessorder(bean.getProcessorder()+1);

		} catch (Exception e)
		{
			System.out.println(e);
		}
		return result;
	}


	private workflow.CandidatOrchestrator step_Validation(workflow.CandidatOrchestrator bean, String url_text, String role)
	{
		System.out.println("**************************");
		System.out.println("* VALIDATION ON GOING   **");
		System.out.println("**************************");
		workflow.CandidatOrchestrator result = new workflow.CandidatOrchestrator();
		try
		{
			System.out.println(url_text);
			URL url = new URL(url_text);
			QName qname = new QName("http://valider.workflow","Service"); 
			javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);
			workflow.valider.Valider ws = service.getPort(workflow.valider.Valider.class); 

			result.setValiderCandidat(ws.execstep(role, bean.getValiderCandidat())); 
			result.setProcessorder(bean.getProcessorder()+1);

		} catch (Exception e)
		{
			System.out.println(e);
		}
		return result;
	}


	@WebMethod
	public boolean startprocess(@WebParam(name="position") String position)
	{
		List<BeanProcess> listprocess = null;
		try
		{
			workflow.accessdb.Service service_accessdb = new workflow.accessdb.Service();
			Accessdb accessdb = service_accessdb.getAccessdbPort();

			workflow.registry.Service service_registry = new workflow.registry.Service();
			Registry registry = service_registry.getRegistryPort();


			//initialize process by DRH
			int id = accessdb.initprocess(position);
			workflow.CandidatOrchestrator candidat = new workflow.CandidatOrchestrator();
			candidat.setId(id);

			//get steps from the process
			listprocess = accessdb.getListstep();

			for (int i=0; i<listprocess.size(); i++)
			{
				BeanProcess bean = listprocess.get(i);
				switch (bean.getProcessorder())
				{
					case 2:
						 candidat = step_rediger(candidat, registry.getService("rediger"), bean.getRole());
						break;
					case 3:
						break;
					case 4:
						candidat = step_selectionner(candidat, registry.getService("selectionner"), bean.getRole());
						break;
					case 5:
						candidat = step_InterviewRH(candidat, registry.getService("interviewer RH"), bean.getRole());
						break;
					case 6:
						candidat = step_InterviewDOP(candidat, registry.getService("interviewer OP"), bean.getRole());
						break;
					case 7:
						candidat = step_Validation(candidat, registry.getService("valider"), bean.getRole());
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

