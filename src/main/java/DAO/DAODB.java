package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Context.DBContext;
import Entity.Account;
import Entity.Category;
import Entity.Product;

public class DAODB {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList();
		String query = "Select * from product";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList();
		String query = "Select * from Category";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Category(rs.getInt(1), 
						rs.getString(2)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Product getLastestProduct() {
		String query = "SELECT top 1 * FROM product\r\n"
				+ "order by id desc";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> getProductByCateID(String cateID) {
		List<Product> list = new ArrayList();
		String query = "Select * from product where cateID = ?";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cateID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Product getProductByID(String id) {
		String query = "Select * from product where id = ?";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Product> searchByName(String txtSearch) {
		List<Product> list = new ArrayList();
		String query = "Select * from product where [name] like ?";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txtSearch + "%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Account login(String user, String pass) {
		String query = "select * from Account\r\n"
				+ "where [user] = ? and pass = ?";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);;
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return new Account(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Account checkAccountExist(String user) {
		String query = "select * from Account\r\n"
				+ "where [user] = ?";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);;
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return new Account(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void signup(String user, String pass) {
		String query = "insert into Account\r\n"
				+ "values (?, ?, 0, 0)";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);;
			ps.setString(2, pass);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> getProductBySellID(int sellID) {
		List<Product> list = new ArrayList();
		String query = "SELECT * FROM product\r\n"
				+ "WHERE sell_ID = ?";
		
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, sellID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void deleteProduct(String pid) {
		String query = "DELETE FROM product\r\n"
				+ "WHERE id = ?";
		
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, pid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertProduct(Product product,String category , int sid) {
		String query = "INSERT INTO [dbo].[product] ([name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setString(2, product.getImage());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getTitle());
			ps.setString(5, product.getDescription());
			ps.setString(6, category);
			ps.setInt(7, sid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editProduct(String name, String image, double price, String title, String description, String category, String pid) {
		String query = "UPDATE product\r\n"
				+ "SET [name] = ?,\r\n"
				+ "	[image] = ?,\r\n"
				+ "	price = ?,\r\n"
				+ "	title = ?,\r\n"
				+ "	[description] = ?,\r\n"
				+ "	cateID = ?\r\n"
				+ "WHERE id = ?";
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setDouble(3, price);
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, category);
			ps.setString(7, pid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> getTop3() {
		List<Product> list = new ArrayList();
		String query = "Select top 3 * from product";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Product> getNext3Product(int amount) {
		List<Product> list = new ArrayList();
		String query = "select * \r\n"
				+ "from product\r\n"
				+ "order by id\r\n"
				+ "offset ? rows\r\n"
				+ "fetch next 3 rows only";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, amount);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int getTotalAccount() {
		String query = "SELECT count(*) FROM Account";
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			
		}
		return 0;
	}
	
	public List<Account> pagingAccount(int index) {
		List<Account> list = new ArrayList<>();
		String query = "SELECT * FROM Account\r\n"
				+ "ORDER BY uID\r\n"
				+ "OFFSET ? ROW FETCH NEXT 3 ROWS ONLY";
		
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*3);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add( new Account(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int getTotalProduct() {
		String query = "SELECT count(*) FROM product";
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			
		}
		return 0;
	}
	
	public List<Product> pagingProduct(int index) {
		List<Product> list = new ArrayList<>();
		String query = "SELECT * FROM product\r\n"
				+ "ORDER BY id\r\n"
				+ "OFFSET ? ROW FETCH NEXT 5 ROWS ONLY";
		
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*5);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		DAODB dao = new DAODB();
//		System.out.println(dao.getTotalAccount());
//		List<Product> list = dao.getProductBySellID(1);
//		List<Category> list2 = dao.getAllCategory();
//		Account acc = dao.login("Adam", "123456");
		
//		System.out.println(acc);
//		for (Product o : list) {
//			System.out.println(o);
//		}
		
		List<Product> list = dao.pagingProduct(1);
//		
		for (Product o : list) {
			System.out.println(o);
		}
	}
}
