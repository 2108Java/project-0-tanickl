package com.revature.tan.service;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import com.revature.tan.models.Account;
import com.revature.tan.models.User;
import com.revature.tan.presentation.Displays;
import com.revature.tan.presentation.DisplaysImpl;
import com.revature.tan.repo.EmpDAO;
import com.revature.tan.repo.TransactionDAO;



public class EmpDAOImpl implements EmpDAO {

	//FIELDS
//	private Connection connection = ConnectionMaker.getConnection(); // try it, but might..
	private Account a;
	private Account b;
	private User u;
	private ArrayList<Account> acctListFromDAO;
	private Object[] acctArrayFromDAO;
	private static final org.apache.logging.log4j.Logger BANKLOG = LogManager.getLogger();


	
	//CONSTRUCTORS
	public EmpDAOImpl() {
		this.a = new Account();
		this.b = new Account();
		this.u = new User();
		this.acctListFromDAO = new ArrayList<Account>();
//		this.acctArrayFromDAO = new Object[]();
	}
	
	

	//METHODS from EmpDAO
	@Override
	public void viewAll() { // SELECT from ACCOUNTS
		
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";

//		String sql = "select username, bsim_accounts from bsim_accounts inner join bsim_users\r\n"
//				+ "	on bsim_accounts.user_id = bsim_users.user_id order by username asc";
		String sql = "select * from bsim_accounts";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					b.setPkAcct(rs.getInt("acct_num"));
					b.setApproved(rs.getBoolean("is_approved"));
				    b.setBalance(rs.getDouble("balance"));
				    b.setUserForKey(rs.getInt("user_id"));
				    b.setAcctType(rs.getString("type_of"));
				   System.out.println(" ");
				   System.out.println(" ---------------- ");
				   System.out.println("Account details: ");
				   System.out.println(b.toString());
				   System.out.println(" ---------------- ");
				   System.out.println(" ");
				   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	@Override
	public void viewCustRoll() {
		
			final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
			final String USERNAME= "postgres";
			final String PASSWORD = "49STOREdata40$16";

			String sql = "select username from bsim_users where is_emp = false";
			PreparedStatement ps;
			try {
				Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						User u = new User();
						u.setUserName(rs.getString("username"));
						System.out.println(" ");
						System.out.println(" ---------------- ");
						System.out.println(u.getUserName());
						System.out.println(" ---------------- ");
						System.out.println(" ");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
	
	
	
	@Override
	public void viewByName(String cust) { 
			
			final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
			final String USERNAME= "postgres";
			final String PASSWORD = "49STOREdata40$16";
			
		String sql = "select * from bsim_accounts inner join bsim_users\r\n"
				+ "	on bsim_accounts.user_id = bsim_users.user_id where bsim_users.username = ?";
		PreparedStatement ps;
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setString(1, cust);
			ResultSet rs = ps.executeQuery();	
			ArrayList<Account> acctListFromDAO = new ArrayList<Account>();
			while(rs.next()) {
					Account acct = new Account();
//					acct.setUsername(rs.getString("username"));
					System.out.println(" ");
					System.out.println(" ------------- ");
					acct.setPkAcct(rs.getInt("acct_num"));
					acct.setApproved(rs.getBoolean("is_approved"));
					acct.setBalance(rs.getDouble("balance"));
					acct.setUserForKey(rs.getInt("user_id"));
					acct.setAcctType(rs.getString("type_of"));
					System.out.println(" ------------- ");
					System.out.println(" ");
					
	////			    ArrayList<Account> acctListFromDAO = new ArrayList<Account>();
					acctListFromDAO.add(acct);
				    System.out.println(acct.toString());

		} u.setUserAcctList(acctListFromDAO);	

		rs.close();
		ps.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} Displays next = new DisplaysImpl(u);
	next.displayEmpMenu(u);
}

	
	@Override
	public void selectPending() {

		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
		
		String sql = "SELECT * from bsim_accounts WHERE is_approved = false";
		PreparedStatement ps;
			try {
				Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
						Account acct = new Account();
						acct.setPkAcct(rs.getInt("acct_num"));
						acct.setApproved(rs.getBoolean("is_approved"));
						acct.setBalance(rs.getDouble("balance"));
						acct.setUserForKey(rs.getInt("user_id"));
						acct.setAcctType(rs.getString("type_of"));
						acctListFromDAO.add(acct);
						System.out.println(" ---------------- ");
						System.out.println(acct.toString());
					    System.out.println(" ");
					    System.out.println(" ");
					    System.out.println(" ---------------- ");
//					System.out.println("Here is your result: " + rs.toString());
					}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	}


		

	@Override
	public void approvePending(int cust3) {
		
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
		String sql = "UPDATE bsim_accounts SET is_approved = true WHERE acct_num = ? returning *"; //check this
		PreparedStatement ps;
			try {
				Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				ps = connection.prepareStatement(sql);
				ps.setInt(1, cust3);
//				ps.execute();
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Account acct = new Account();
					acct.setPkAcct(rs.getInt("acct_num"));
					acct.setApproved(rs.getBoolean("is_approved"));
					acct.setBalance(rs.getDouble("balance"));
					acct.setUserForKey(rs.getInt("user_id"));
					acct.setAcctType(rs.getString("type_of"));
					acctListFromDAO.add(acct);
					System.out.println(" ---------------- ");
					System.out.println("Account APPROVAL is confirmed. You have APPROVED this account: ");
					System.out.println(acct.toString());
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(" ---------------- ");
					String desc = "Account number " + cust3 + " was APPROVED.";
					TransactionDAO.changePending(cust3, desc);
					BANKLOG.info(desc);
				}
			connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}


	
	
	@Override
	public void viewLog() { 
			
			
			final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
			final String USERNAME= "postgres";
			final String PASSWORD = "49STOREdata40$16";
			
			String sql = "select * from bsim_log";
			PreparedStatement ps;
			try {
				Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery(); 
				while(rs.next()) {
					System.out.println(" ---------------- ");
					System.out.println("Transaction number " + rs.getInt("trans_num"));
					System.out.println("Involved Accounts: " + rs.getInt("deb_acct") + " and " + rs.getInt("cred_acct"));
					System.out.println("Amount: " + rs.getDouble("amount"));
					System.out.println("Description: " + rs.getString("description"));
					System.out.println("Timestamp: " + rs.getDate("datetime")); //try toString next, or getStream
					System.out.println(" ---------------- ");
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(" ");
				} connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
//			Displays next = new DisplaysImpl();
//				next.displayEmpMenu(u);
//			
		//first idea was to use logger for transaction log
//			try  {
//				File file=new File("D:/Documents/BANKLOG.log");
//				Scanner sc = new Scanner(file);     //file to be scanned  
//				while (sc.hasNextLine())        //returns true if and only if scanner has another token  
//				System.out.println(sc.nextLine());    
//				}  
//				catch(Exception e)  
//				{  
//				e.printStackTrace();  
//			}  
}	
	

	
	




	@Override
	public void rejectPending(int cust4) {
		
		final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com:5432/";
		final String USERNAME= "postgres";
		final String PASSWORD = "49STOREdata40$16";
		
		String sql = "DELETE from bsim_accounts WHERE acct_num = ? returning * "; //check this
		PreparedStatement ps;
			try {
				Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				ps = connection.prepareStatement(sql);
				ps.setInt(1, cust4);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Account acct = new Account();
					acct.setPkAcct(rs.getInt("acct_num"));
					acct.setApproved(rs.getBoolean("is_approved"));
					acct.setBalance(rs.getDouble("balance"));
					acct.setUserForKey(rs.getInt("user_id"));
					acct.setAcctType(rs.getString("type_of"));
					acctListFromDAO.add(acct);
					System.out.println(" ---------------- ");
					System.out.println("Account REJECTION is confirmed. You have DELETED this account: ");
					System.out.println(acct.toString());
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(" ---------------- ");
					String desc = "Account number " + cust4 + " was REJECTED.";
					TransactionDAO.changePending(cust4, desc);
					BANKLOG.info(desc);
					} 
			connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
