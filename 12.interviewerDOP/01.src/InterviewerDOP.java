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
   name="interviewerDOP",
   targetNamespace = "http://interviewerDOP.workflow",
   serviceName = "Service")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public class InterviewerDOP
{
	public InterviewerDOP()
	{
	}
	
	@WebMethod
	public Beancandidat execstep(  
		@WebParam(name="role") String role,
		@WebParam(name="beancandidat") Beancandidat beancandidat)
	{
		try
		{
			String saisie = JOptionPane.showInputDialog("Quel est votre profil :");
			if ( saisie.equals(role) )
			{
				saisie = JOptionPane.showInputDialog("Directeur opérationnel, veuillez saisir le compte rendu de l'interview");
				beancandidat.setDop(saisie);
			}
			else
			{
				beancandidat.setDeroulement("Erreur d'utilisateur à l'étape InterviewerDOP");
			}
		}
		catch ( Exception e ) 
		{
			System.out.println(e);
		}
		return beancandidat;
	}
}
