import workflow.registry.*;

public class Client 
{

	public static void main(String[] args) 
	{
		Service service = new Service();
		Registry registry = service.getRegistryPort();

		//registry.addService("test", "http://test");

		String url = registry.getService(1);

		System.out.println(url);	
	}
}
