package workflow;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.ejb.EJBException;
import java.util.*;
import java.sql.*;
import java.io.*;





@Stateless                                                            
@WebService(                                                         
   name="rediger",
   targetNamespace = "http://workflow",
   serviceName = "Service")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public class Rediger
{
	public Rediger()
	{
	}
	
	@WebMethod
	public Beancandidat execstep(  
		@WebParam(name="role") String role,
		@WebParam(name="beancandidat") Beancandidat beancandidat)
	{
		try
		{
			String droit = null;
			
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			System.out.println(" Qui etes vous ? " );
			System.out.println(role + "1***********************************************************" );
			droit = "ARH"; //br.readLine();
			System.out.println(role + "2***********************************************************" );
			if ( droit.equals(role) )
			{

				System.out.println("2***********************************************************" );
				System.out.println(" Saisir le descriptif de l'offre ");
				String ligne = "sdmflksdflk"; //br.readLine();
				if (beancandidat == null)
					System.out.println("***********************************************************" );
				if ( !ligne.equals("") )
				{
					beancandidat.setDescriptif(ligne);
				}
				else 
					beancandidat.setDescriptif(" Voici l'offre ");

			}
		}
		catch ( Exception e ) 
		{
			System.out.println(e);
		}
		return beancandidat;
	}
}
