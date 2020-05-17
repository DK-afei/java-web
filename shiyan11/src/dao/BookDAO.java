package dao;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import bean.Book;
  
public class BookDAO {
	private String username = null;
	private String password = null;
	private String driverClassName = null;
	private String url = null;
	private ResourceBundle rb = null;
	private String path = "connection";

	public void init()
	{
		this.rb = ResourceBundle.getBundle(this.path);
		this.username = rb.getString("username");
		this.password = rb.getString("password");
		this.driverClassName = rb.getString("driverClassName");
		this.url = rb.getString("url");
//		System.out.println(this.username+" "+this.password+" "+this.driverClassName+" "+this.url);
	}
    public BookDAO() {
    	init();
        try {
            Class.forName(this.driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url,this.username,this.password);
    }
  
    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from book";
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
  
            System.out.println("total:" + total);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }
  
    public void add(Book book) {
  
        String sql = "insert into book values(?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
  
            ps.setString(1, book.getNo());
            ps.setString(2, book.getName());
            ps.setFloat(3, book.getPrice());
            ps.setInt(4, book.getNum());
  
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
    
    public void update0(String no, int num) {
    	  
        String sql = "update book set bnum = bnum-? where bno = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
        	ps.setInt(1, num);
        	ps.setString(2, no);
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
    
    public void update(Book book) {
  
        String sql = "update book set bname= ?, bprice = ? , bnum = ? where bno = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, book.getName());
            ps.setFloat(2, book.getPrice());
            ps.setInt(3, book.getNum());
            ps.setString(4, book.getNo());
  
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
  
    public void delete(String no) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from book where bno = " + no;
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public Book get(String no) {
        Book book = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from book where bno = " + no;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                book = new Book();
                String name = rs.getString(2);
                float price = rs.getFloat("bprice");
                int num = rs.getInt(4);
                book.setNo(no);
                book.setName(name);
                book.setPrice(price);
                book.setNum(num);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return book;
    }
  
    public List<Book> list() {
        return list(0, Short.MAX_VALUE);
    }
  
    public List<Book> list(int start, int count) {
        List<Book> books = new ArrayList<Book>();
  
        String sql = "select * from book limit ?,? ";
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                Book book = new Book();
                String no = rs.getString(1);
                String name = rs.getString(2);
                float price = rs.getFloat("bprice");
                int num = rs.getInt(4);
                book.setNo(no);
                book.setName(name);
                book.setPrice(price);
                book.setNum(num);
                books.add(book);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return books;
    }
  
}