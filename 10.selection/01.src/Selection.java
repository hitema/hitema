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
   name="selection",
   targetNamespace = "http://selection.workflow",
   serviceName = "Service")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public class Selection
{
	public Selection()
	{
	}
	
	@WebMethod
	public Beancandidat execstep(  
		@WebParam(name="role") String role,
		@WebParam(name="beancandidat") Beancandidat beancandidat)
	{
		try
		{
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			System.out.println(" Qui etes vous ? " );
			
			String saisie = JOptionPane.showInputDialog("Quel est votre profil :");
			if ( droit.equals(role) )
			{

				saisie = JOptionPane.showInputDialog("Saisir le nom du candidat");
				beancandidat.setNom(saisie);
				System.out.println(" Saisir le prenom du candidat");
				ligne = "Robert"; //br.readLine();
				beancandidat.setPrenom(ligne);
				System.out.println(" Saisir le CV du candidat");
				ligne = "/document/DRobertCV.pdf"; //br.readLine();
				beancandidat.setCv(ligne);
				
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
