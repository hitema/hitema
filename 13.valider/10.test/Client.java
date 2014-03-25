import java.util.*;
import workflow.valider.*;
import java.io.*;

public class Client 
{

	public static void main(String[] args) throws Exception
	{

		Beancandidat beancandidat= new Beancandidat();
		//beancandidat.setId(1);
		
		Service service = new Service();
		Valider valid = service.getValiderPort();

		Beancandidat bean = valid.execstep("ARH", beancandidat);
		String s = bean.getValidation();
		if (s!=null)
		{
			System.out.println(s);
		}
		else
		{
			System.out.println(bean.getDeroulement());
		}


	}
}
