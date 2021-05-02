package ma.fstt.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.model.Book;

public class BaseBook extends BaseDao<Book> {

	public BaseBook() throws SQLException {
		super();
	}

	@Override
	public void save(Book object) throws SQLException{
		
		String sql = "insert into book (name , auteur , annee) values ( ? ,? ,?)" ;
		
		this.preparedStatement = connection.prepareStatement(sql);
		
		this.preparedStatement.setString(1,object.getName() );
		this.preparedStatement.setString(2,object.getAuteur() );
		this.preparedStatement.setString(3,object.getAnnee() );
		this.preparedStatement.execute();
		
	}

	@Override
	public void update(Book object) throws SQLException{

		String sql = "UPDATE Users SET name=?, auteur=?, annee=? WHERE id_book=?";
        try{
        	this.preparedStatement = connection.prepareStatement(sql);
        	this.preparedStatement.setString(1, object.getName());
        	this.preparedStatement.setString(2, object.getAuteur());
        	this.preparedStatement.setString(3, object.getAnnee());
        }catch(Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public void delete(Book object) throws SQLException{

		String sql = "DELETE FROM Users WHERE username=?";
		try{
			this.preparedStatement = connection.prepareStatement(sql);
			this.preparedStatement.setInt(1, object.getId_book());
			this.preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 

	}

	@Override
	public List<Book> getAll() throws SQLException{
			
		List<Book> lsit  = new ArrayList() ;
		
		String sql = "select * from book" ;
		
		this.statement = connection.createStatement();
		
	  this.resultSet = 	this.statement.executeQuery(sql) ;
	  
	  // iteration 
	  
	  while( this.resultSet.next()) {
		  
		  lsit.add(new	Book(this.resultSet.getInt(1) ,this.resultSet.getString(2) ,
				  this.resultSet.getString(3)  , this.resultSet.getString(4)));
		  
		  
		  
	  }
		
		return lsit ;
		
	}

	@Override
	public Book getOne(int id ) throws SQLException {
   Book  book   = new Book() ;
		
		String sql = "select * from book where id_book = ?" ;
		
		this.preparedStatement = connection.prepareStatement(sql);
		this.preparedStatement.setInt(1, id);
		
	  this.resultSet = 	this.preparedStatement.executeQuery() ;
	  
	  // iteration 
	  
	  while( this.resultSet.next()) {
		  
		  book = new	Book(this.resultSet.getInt(1) ,this.resultSet.getString(2) ,
				  this.resultSet.getString(3)  , this.resultSet.getString(4));
		  
		  break ;
		  
	  }
		
		return book ;
	}

}
