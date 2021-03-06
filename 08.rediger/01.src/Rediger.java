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

import javax.swing.JOptionPane;




@Stateless                                                            
@WebService(                                                         
   name="rediger",
   targetNamespace = "http://rediger.workflow",
   serviceName = "Service")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public class Rediger
{

	//String saisie = JOptionPane.showInputDialog("Quel est votre profil :");
	//saisie = JOptionPane.showInputDialog("Quel type de poste :");
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
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

			String saisie = JOptionPane.showInputDialog("Quel est votre profil :");
			if ( saisie.equals(role) )
			{

				saisie = JOptionPane.showInputDialog("Saisissez le descriptif du poste :");
				if ( !saisie.equals("") )
				{
					beancandidat.setDescriptif(saisie);
				}
				else 
					beancandidat.setDescriptif(" Voici l'offre ");

			}
			else
			{
				beancandidat.setDeroulement("Erreur d'utilisateur à l'étape Rediger l'offre");
			}
		}
		catch ( Exception e ) 
		{
			System.out.println(e);
		}
		return beancandidat;
	}
}
