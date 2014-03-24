package workflow.orchestrator.*;
package workflow.registry.*;
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
			workflow.orchestrator.Service service_orchestrator = new Service();
			Accessdb accessdb = service_orchestrator.getAccessdbPort();

			workflow.registry.Service service_registry = new Service();
			Registry registry = service_registry.getRegistryPort();

			id = accessdb.initprocess(position);
			System.out.println("Position = " + id.toString());

			listprocess = accessdb.getListstep();
			for (int i=0; i<listprocess.size(); i++)
			{	
				BeanProcess bean = listprocess.get(i);
				string url = service.getService("");
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

