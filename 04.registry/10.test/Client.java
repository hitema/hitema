import workflow.*;

public class Client 
{

	public static void main(String[] args) 
	{
		Service service = new Service();
		Registry registry = service.getRegistryPort();

		//registry.addService("test", "http://test");

		String url = registry.getService("test");

		System.out.println(url);	
	}
}
