import java.util.*;
import workflow.accessdb.*;

public class Client 
{

	public static void main(String[] args) 
	{
		Service service = new Service();
		Accessdb access = service.getAccessdbPort();


		List<BeanProcess> list = access.getListstep();

		for (int i=0; i<list.size(); i++)
		{
			BeanProcess bean = (BeanProcess)list.get(i);
			System.out.println(bean.getProcessorder() +"*"+ bean.getName());
		}



	}
}
