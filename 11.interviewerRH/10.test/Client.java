import java.util.*;
import workflow.interviewerrh.*;
import java.io.*;

public class Client 
{

	public static void main(String[] args) throws Exception
	{

		Beancandidat beancandidat= new Beancandidat();
		//beancandidat.setId(1);
		
		Service service = new Service();
		InterviewerRH irh = service.getInterviewerRHPort();

		Beancandidat bean = irh.execstep("ARH", beancandidat);
		String s = bean.getRh();
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
