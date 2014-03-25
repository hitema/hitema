import java.util.*;
import workflow.interviewerdop.*;
import java.io.*;

public class Client 
{

	public static void main(String[] args) throws Exception
	{

		Beancandidat beancandidat= new Beancandidat();
		//beancandidat.setId(1);
		
		Service service = new Service();
		InterviewerDOP idop = service.getInterviewerDOPPort();

		Beancandidat bean = idop.execstep("ARH", beancandidat);
		String s = bean.getDop();
		if ( s != null )
		{
			System.out.println(s);
		}
		else
		{
			System.out.println(bean.getDeroulement());
		}


	}
}
