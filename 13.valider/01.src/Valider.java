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
   name="valider",
   targetNamespace = "http://workflow",
   serviceName = "Service")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public class Valider
{
	public Valider()
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
			String ligne;
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			System.out.println(" Qui etes vous ? " );
			
			droit = "ARH"; //br.readLine();
			if ( droit.equals(role) )
			{

				System.out.println(" Embauchons-nous ce candidat ?");
				ligne = "Oui"; //br.readLine();
				beancandidat.setValidation(ligne);
			
				
				/*if (beancandidat == null)
					System.out.println("***********************************************************" );
				if ( !ligne.equals("") )
				{
					beancandidat.setDescriptif(ligne);
				}
				else 
					beancandidat.setDescriptif(" Voici l'offre ");*/

			}
		}
		catch ( Exception e ) 
		{
			System.out.println(e);
		}
		return beancandidat;
	}
}
