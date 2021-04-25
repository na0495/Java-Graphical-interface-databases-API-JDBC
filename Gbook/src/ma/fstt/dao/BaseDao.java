package ma.fstt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class   BaseDao <T> {
	
	
	protected  Connection connection ;
	
	protected Statement statement ;
	
	protected PreparedStatement preparedStatement ;
	
	protected ResultSet resultSet ;
	
	
	private String url = "jdbc:mysql://localhost:3306/bookstore";
	private String user = "root";
	private String password = "";
	
	public BaseDao() throws SQLException {
		
		this.connection = DriverManager.getConnection(url, user, password);
		
	}
	
	
	public abstract void save(T object)throws SQLException;
	public abstract void update(T object) throws SQLException;
	public abstract void delete(T object)throws SQLException;
	public abstract List<T> getAll()throws SQLException;
	public abstract T getOne(int id )throws SQLException;
	
	
	
	
	
	
	
	

}
