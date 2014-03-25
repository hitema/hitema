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


@Stateless                                                            
@WebService(name="Accessdb", targetNamespace = "http://accessdb.workflow", serviceName = "Service")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public class Accessdb
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
			System.out.println("createConnection " + e);
		}
		return connection;
	}

	public Accessdb()
	{

	}

	@WebMethod
	public List<BeanProcess> getListstep()
	{
		List<BeanProcess> list = new ArrayList<BeanProcess>();
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
	/*	String sql = "select p.ID_process, p.process_order, p.role, p.name, r.ID_registry, r.url " +
				"from process p, registry r " +
				"where p.ID_registry = r.ID_registry " +
				"order by p.process_order"; 
	*/
		// Thomas
		String sql = "SELECT p.ID_process, p.process_order, p.role, p.name, p.ID_registry "+
				"from process p " +
				"order by p.process_order"; 

		try
		{
			connect = createConnection();

			statement = connect.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next())
			{
				BeanProcess bean = new BeanProcess();
				bean.setIdprocess(resultSet.getInt("ID_process"));

				bean.setProcessorder(resultSet.getInt("process_order"));
				bean.setRole(resultSet.getString("role"));
				bean.setName(resultSet.getString("name"));
				bean.setIdregistry(resultSet.getInt("ID_registry"));		
				//Thomas		
				//bean.setUrl(resultSet.getString("url"));
			
				list.add(bean);
			}
			connect.close();	
		} catch (Exception e)
		{
			System.out.println("getListstep " + e);
		}
		return list;
	}

	@WebMethod
	public Integer initprocess(@WebParam(name="position") String position)
	{
		String sql = "insert into candidat (process_order, dateexec, position) values (?, ?, ?)";
		java.util.Date dt = new java.util.Date(); 
		Integer id = -1;
		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try
		{
			connect = createConnection();
			preparedStatement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, dt.toString());
			preparedStatement.setString(3, position);
			preparedStatement.executeUpdate();

    			ResultSet rs = preparedStatement.getGeneratedKeys();
    			if (rs.next()) 
        			id = rs.getInt(1); 
			rs.close();
    			rs = null;
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
		return id;
	}

	@WebMethod
    	public Beancandidat getCandidat(@WebParam(name="candidat")int id) throws Exception
	{
		String req = "select process_order, position, description, firstname,"+
                        "lastname, resume, interviewrh, interviewop, validation from candidat where ID_candidat= "+id;
		Connection connect = null;
                Statement statement = null;
                ResultSet rs = null;
		Beancandidat candidat = new Beancandidat();
		try
		{
			connect = createConnection();
			statement = connect.createStatement();
                        rs = statement.executeQuery(req);
                        while(rs.next()) 
                        {
                            candidat.setProcessorder(rs.getInt(1));
                            candidat.setIntitule(rs.getString(3));
                            candidat.setDescriptif(rs.getString(4));
                            candidat.setPrenom(rs.getString(5));
                            candidat.setNom(rs.getString(6));
                            candidat.setCv(rs.getString(7));
                            candidat.setRh(rs.getString(8));
                            candidat.setDop(rs.getString(9));
                            candidat.setValidation(rs.getString(10));
                        }
                }
                catch (Exception e)
                {
				System.out.println(e);
		}
                return candidat;
	}

	@WebMethod
    	public boolean setCandidat(@WebParam(name="candidat") Beancandidat candidat) throws Exception
	{
            String sql = "update into candidat (process_order, description, firstname,"+
                        "lastname, resume, interviewrh, interviewop, validation) values (?,?,?,?,?,?,?,?)";
		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try
		{
			connect = createConnection();
			preparedStatement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1,candidat.getProcessorder());
			preparedStatement.setString(2, candidat.getDescriptif());
                        preparedStatement.setString(3, candidat.getPrenom());
                        preparedStatement.setString(4, candidat.getNom());
                        preparedStatement.setString(5, candidat.getCv());
                        preparedStatement.setString(6, candidat.getRh());
                        preparedStatement.setString(7, candidat.getDop());
                        preparedStatement.setString(8, candidat.getValidation());
			preparedStatement.executeUpdate();
                        return true;
    			
		} catch (Exception e)
		{
			System.out.println(e);
                        return false;
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

/*
	private Nextstep getNextStep(String process, String username, Integer step, boolean isnextstep)
	{
		String sql;
		Nextstep next = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		if (isnextstep)
			sql = "select s.name, r.type_role "+
				"from step s, role r "+
				"where s.ID_step = r.ID_step "+
				"and s.process = ? "+ 
				"and s.process_order = ? "+
				"and r.username = ?"; 
		else

			sql = "select s.name, r.type_role "+
				"from step s, role r "+
				"where s.ID_step = r.ID_step "+
				"and r.type_role <> (select r1.type_role "+
				"	from step s1, role r1 "+
				"	where s1.ID_step = r1.ID_step "+
				"	and s1.process = ? "+
				"	and r1.type_role = 1000"+
				"	and s1.process_order = ? "+
				"	and r1.username <> ?) "+
				"and s.process = ? "+
				"and s.process_order = ? "+
				"and r.username = ?"; 
		try
		{
			connect = createConnection();
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, process);
			if (isnextstep)
				preparedStatement.setInt(2, step+1);
			else
				preparedStatement.setInt(2, step);
			preparedStatement.setString(3, username);
			if (!isnextstep)
			{
				preparedStatement.setString(4, process);
				preparedStatement.setInt(5, step);
				preparedStatement.setString(6, username);
			}
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				next = new Nextstep();
				next.process_order = step;
				next.role = resultSet.getInt("type_role");
				next.name =  resultSet.getString("name");
			}
			connect.close();
		} catch (Exception e)
		{ System.out.println("Nextstep " + e); }
		return next;
	}

	@WebMethod
	public List<BeanProcessOnGoing> getListOnGoing(@WebParam(name="username") String username)
	{
		List<BeanProcessOnGoing> list = new ArrayList<BeanProcessOnGoing>();
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String sql = "Select w.ID_workflow, w.ID_process, w.last_step, e.status "+
				"from workflow w, execute e, step s, role r "+
				"where w.ID_workflow = e.ID_workflow  "+
				"and w.ID_process = s.process  "+
				"and s.process_order = w.last_step  "+
				"and s.ID_step = r.ID_step "+
				"and e.status <> 2 and e.status <> 0 " +
				"and w.last_step = e.step_order  "+
				"and r.username = '" + username + "' ";

		try
		{
			connect = createConnection();

			statement = connect.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next())
			{

				Nextstep next = null;
				
				if (resultSet.getInt("status") == 1)
					next = getNextStep(resultSet.getString("ID_process"), username, resultSet.getInt("last_step"), true);
				else
					next = getNextStep(resultSet.getString("ID_process"), username, resultSet.getInt("last_step"), false);
				if (next !=null)
				{
					BeanProcessOnGoing bean = new BeanProcessOnGoing();
					bean.setIdworkflow(resultSet.getInt("ID_workflow"));
					bean.setProcessname(resultSet.getString("ID_process"));
					bean.setProcessorder(next.process_order);
					bean.setName(next.name);
					bean.setTyperole(next.role);
					list.add(bean);
				}
			}
			connect.close();	
		} catch (Exception e)
		{
			System.out.println("getListOnGoing " + e);
		}

		return list;
	}
*/
}

