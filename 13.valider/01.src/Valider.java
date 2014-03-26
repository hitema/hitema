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
   name="valider",
   targetNamespace = "http://valider.workflow",
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
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			String saisie = JOptionPane.showInputDialog("Quel est votre profil :");
			if ( saisie.equals(role) )
			{
				saisie = JOptionPane.showInputDialog("Embauchons-nous ce candidat ? Oui/Non");
				while ( !saisie.equals("oui") && !saisie.equals("non") )
				{
					saisie = JOptionPane.showInputDialog("Erreur,veuillez saisir oui ou non");
				}
				beancandidat.setValidation(saisie);
			}
			else
			{
				beancandidat.setDeroulement("Erreur d'utilisateur à l'étape de validation de l'embauche");
			}
		}
		catch ( Exception e ) 
		{
			System.out.println(e);
		}
		return beancandidat;
	}
}
