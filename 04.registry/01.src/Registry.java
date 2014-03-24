package workflow;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.ejb.EJBException;
import java.util.*;
import java.sql.*;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//@WebParam(name="qte") int qte)
//@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)

@Stateless                                                            
@WebService(                                                         
   name="Registry",
   targetNamespace = "http://workflow",
   serviceName = "Service")
public class Registry
{

	private Connection createConnection()
	{
		Connection connection = null;
		try
		{
			Properties props = new Properties();
        		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        		props.setProperty("java.naming.provider.url", "localhost:1099");

			InitialContext ctx = new InitialContext(props);
            		DataSource ds = (DataSource) ctx.lookup("java:/sqlconnection");
            		connection = ds.getConnection();
		}
	 	catch (Exception e)
		{
			System.out.println(e);
		}
		return connection;
	}


	public Registry()
	{

	}

 	@WebMethod
	public String getService(@WebParam(name="servicename") String servicename)
	{
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String url = "";
		try
		{
			connect = createConnection();

			statement = connect.createStatement();
			resultSet = statement.executeQuery("select url from registry where service_name = '" + servicename + "'");
			if (resultSet.next())
				url = resultSet.getString("url");
				
		} catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try {
			if (connect != null)
				connect.close();
			} catch (Exception e)
			{
				System.out.println(e);
			}
		}
		return url;
	}

 	@WebMethod
	public void addService(
		@WebParam(name="servicename") String servicename,
		@WebParam(name="url") String url)
	{
		Connection connect = null;
		Statement statement = null;
		try
		{
			connect = createConnection();
			statement = connect.createStatement();
			statement.executeUpdate("Insert into registry (service_name, url) values ('" + servicename + "', '" + url + "')");
				
		} catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try {
			if (connect != null)
				connect.close();
			} catch (Exception e)
			{
				System.out.println(e);
			}
		}

	}


}

