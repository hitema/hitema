import java.util.*;
import workflow.*;
import java.io.*;

public class Client 
{

	public static void main(String[] args) throws Exception
	{

		Beancandidat beancandidat= new Beancandidat();
		//beancandidat.setId(1);
		
		Service service = new Service();
		Rediger rediger = service.getRedigerPort();

		Beancandidat bean = rediger.execstep("ARH", beancandidat);
		String s = bean.getDescriptif();
		System.out.println(s);

	}
}
