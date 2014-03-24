import java.util.*;
import workflow.orchestrator.*;
import java.io.Console;

public class Client 
{

	public static void main(String[] args) 
	{
		Service service = new Service();
		Orchestrator orchestrator = service.getOrchestratorPort();

		String role;
		Console cons = System.console();
		if(cons!=null)
		{
			System.out.print("Veuillez-vous identifier :");
			role = cons.readLine();
			if (!role.equals("DRH"))
				return;
		}
	
		System.out.println("*****************************************");
		System.out.println("Start Process");
		System.out.println("*****************************************");


		System.out.print("Veuillez saisir le poste à pourvoir :");	
		String position = role = cons.readLine();	

		if (orchestrator.startprocess(position)) 
			System.out.println("ok");
		else
			System.out.println("Nok");

		System.out.println("*****************************************");
		System.out.println("end Process");
		System.out.println("*****************************************");

	}
}
