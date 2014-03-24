package workflow;

public class BeanProcess implements java.io.Serializable
{


	private int idprocess;
	private int processorder;
	private String role;
	private String name;
	private int idregistry;
	private String url;

	public BeanProcess()
	{
	}
	
	public int getIdprocess() { return idprocess;}
	public void setIdprocess(int value) { idprocess = value; }

	public int getProcessorder() { return processorder;}
	public void setProcessorder(int value) { processorder = value; }

	public String getRole() { return role;}
	public void setRole(String value) { role = value; }

	public String getName() { return name;}
	public void setName(String value) { name = value; }	

	public int getIdregistry() { return idregistry;}
	public void setIdregistry(int value) { idregistry = value; }

	public String getUrl() { return url;}
	public void setUrl(String value) { url = value; }

	
}
