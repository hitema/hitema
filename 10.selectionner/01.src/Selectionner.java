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
   name="selectionner",
   targetNamespace = "http://selectionner.workflow",
   serviceName = "Service")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public class Selectionner
{
	public Selectionner()
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
				while(saisie.equals(""))
				{saisie = JOptionPane.showInputDialog("Le nom ne peut etre vide");}
				beancandidat.setNom(saisie);
				
								
				saisie = JOptionPane.showInputDialog("Saisir le prenom du candidat");
				while(saisie.equals(""))
				{saisie = JOptionPane.showInputDialog("Le prenom ne peut etre vide");}
				beancandidat.setPrenom(saisie);

				saisie = JOptionPane.showInputDialog("Saisir le CV du candidat");
				while(saisie.equals(""))
				{saisie = JOptionPane.showInputDialog("Le CV ne peut etre vide");}
				beancandidat.setCv(saisie);
			}
			else
			{
				beancandidat.setDeroulement("Erreur d'utilisateur à l'étape Selectionner");
			}
		}
		catch ( Exception e ) 
		{
			System.out.println(e);
		}
		return beancandidat;
	}
}
