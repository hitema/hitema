import java.util.*;
import workflow.accessdb.*;
import workflow.*;

public class Client 
{

	public static void main(String[] args) 
	{
		Service service = new Service();
		Accessdb access = service.getAccessdbPort();


		Beancandidat c = new Beancandidat();
		c = access.getCandidat(1);
		System.out.println(c.getNom());
	}
}
