import java.util.*;
import workflow.selectionner.*;
import java.io.*;

public class Client 
{

	public static void main(String[] args) throws Exception
	{

		Beancandidat beancandidat= new Beancandidat();
		//beancandidat.setId(1);
		
		Service service = new Service();
		Selectionner selec = service.getSelectionnerPort();

		Beancandidat bean = selec.execstep("ARH", beancandidat);
		String s1 = bean.getNom();
		String s2 = bean.getPrenom();
		String s3 = bean.getCv();
		if (s1!= null && s2!=null && s3!=null)
		{
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		}
		else
		{
			System.out.println(bean.getDeroulement());
		}

	}
}
