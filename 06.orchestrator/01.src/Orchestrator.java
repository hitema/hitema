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
import org.tempuri.*;




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


	private workflow.CandidatOrchestrator step_Publish(workflow.CandidatOrchestrator bean, String role)
	{
		System.out.println("****************************");
		System.out.println("* PUBLISH ON GOING        **");
		System.out.println("****************************");
	
		try {

			org.tempuri.ServiceWebPublication srvRh = new org.tempuri.ServiceWebPublication();


			org.tempuri.IServiceWebPublication ws = srvRh.getBasicHttpBindingIServiceWebPublication();
			System.out.println(ws.execStep(role, bean.getId(), "bean.getPosition()", bean.getDescriptif()));


		} catch (Exception e)
		{
			bean.setDeroulement(e.toString());
		}
		return bean;
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


	private workflow.accessdb.Accessdb getAccessDB(String url_text)
	{
		workflow.accessdb.Accessdb accessdb = null;
		try
		{
			URL url = new URL(url_text);
			QName qname = new QName("http://accessdb.workflow","Service"); 
			javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);
			accessdb = service.getPort(workflow.accessdb.Accessdb.class); 
		} catch (Exception e)
		{
			System.out.println("accessDB :  " + e);
		}
		return accessdb;
	}



	@WebMethod
	public boolean startprocess(@WebParam(name="position") String position)
	{
		List<BeanProcess> listprocess = null;
		try
		{

			workflow.registry.Service service_registry = new workflow.registry.Service();
			Registry registry = service_registry.getRegistryPort();

			workflow.accessdb.Accessdb accessdb = getAccessDB(registry.getService("accessdb"));


			//initialize process by DRH
			int id = accessdb.initprocess(position);

			workflow.CandidatOrchestrator candidat = new workflow.CandidatOrchestrator();
			candidat.setId(id);
			System.out.println("ID : " + id);
	

			//get steps from the process
			listprocess = accessdb.getListstep();
	
			System.out.println(listprocess.size());

			for (int i=0; i<listprocess.size(); i++)
			{
				BeanProcess bean = listprocess.get(i);
	
				switch (bean.getProcessorder())
				{
					case 2:
						if (candidat.getDeroulement().equals(""))
						{
							candidat = step_rediger(candidat, registry.getService("rediger"), bean.getRole());
							accessdb.setCandidat(candidat.getCandidatDB());
						}
						break;
					case 3:
						if (candidat.getDeroulement().equals(""))
						{
							candidat = step_Publish(candidat, bean.getRole());
							accessdb.setCandidat(candidat.getCandidatDB());
						}
						break;
					case 4:
						if (candidat.getDeroulement().equals(""))	
						{					
							candidat = step_selectionner(candidat, registry.getService("selectionner"), bean.getRole());
							accessdb.setCandidat(candidat.getCandidatDB());
						}
						break;
					case 5:
						if (candidat.getDeroulement().equals(""))		
						{				
							candidat = step_InterviewRH(candidat, registry.getService("interviewer RH"), bean.getRole());
							accessdb.setCandidat(candidat.getCandidatDB());
						}
						break;
					case 6:
						if (candidat.getDeroulement().equals(""))
						{
							candidat = step_InterviewDOP(candidat, registry.getService("interviewer OP"), bean.getRole());
							accessdb.setCandidat(candidat.getCandidatDB());
						}
						break;
					case 7:
						if (candidat.getDeroulement().equals(""))	
						{					
							candidat = step_Validation(candidat, registry.getService("valider"), bean.getRole());
							accessdb.setCandidat(candidat.getCandidatDB());
						}
						break;
				}
			}
			if (candidat.getDeroulement().equals(""))
			{
				accessdb.setCandidat(candidat.getCandidatDB());
				return true;
			}
			else
			{
				System.out.println(candidat.getDeroulement());
				return false;
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
}



