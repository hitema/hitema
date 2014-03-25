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
			if ( saisie.equals(role) )
			{

				saisie = JOptionPane.showInputDialog("Saisir le nom du candidat");
				beancandidat.setNom(saisie);
				saisie = JOptionPane.showInputDialog("Saisir le prenom du candidat");
				beancandidat.setPrenom(saisie);
				saisie = JOptionPane.showInputDialog("Saisir le cv du candidat");
				beancandidat.setCv(saisie);
			}
		}
		catch ( Exception e ) 
		{
			System.out.println(e);
		}
		return beancandidat;
	}
}
