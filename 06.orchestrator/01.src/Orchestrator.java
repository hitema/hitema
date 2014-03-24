package workflow.orchestrator;

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

	private void init()
	{
		
	}

	@WebMethod
	public boolean startprocess(@WebParam(name="position") String position)
	{
		
		//String saisie = JOptionPane.showInputDialog("Quel est votre profil :");
		//saisie = JOptionPane.showInputDialog("Quel type de poste :");

		try
		{
			Service service = new Service();
			Accessdb access = service.getAccessdbPort();

			id = access.initprocess(position);
			System.out.println("Position = " + id.toString());

			listprocess = access.getListstep();
			for (int i=0; i<listprocess.size(); i++)
			{	
				BeanProcess bean = listprocess.get(i);
				System.out.println(bean.getProcessorder() +"*"+ bean.getName());
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

