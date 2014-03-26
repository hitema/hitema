import java.util.*;
import workflow.accessdb.*;
import workflow.*;

public class Client 
{

	public static void main(String[] args) 
	{
		Service service = new Service();
		Accessdb access = service.getAccessdbPort();


		BeancandidatDB c = new BeancandidatDB();
		//c = access.getCandidat(1);
		//System.out.println(c.getNom());
		
		c.setId(1);		
		c.setPrenom("Roger");
		c.setNom("Rabbit");
		System.out.println(access.setCandidat(c));
		
		
		
	}
}
