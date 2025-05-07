package MiniBank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDBService {

	public static void saveBankAccount(BankingSystem account) {
		String queryString="INSERT INTO accounts (account_number, owner_name, pin, balance) VALUES(?,?,?,?)";
		
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement(queryString);
			stmt.setLong(1, account.getAccountNumber());
			stmt.setString(2, account.getOwnerName());
			stmt.setInt(3, account.getPin());
			stmt.setDouble(4, account.getBalance());
			int rows=stmt.executeUpdate();
			if(rows>0) {
				System.out.println("Account saved to database successfully");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error"+e.getMessage());
		}
		
		
	}
	
	public static BankingSystem login(long acno, int pinno) {
		Connection con= DatabaseConnection.getConnection();
		String sqlString= "SELECT * from accounts WHERE account_number = ? AND pin = ?" ;
		
		try {
			PreparedStatement pStatement=con.prepareStatement(sqlString);
			pStatement.setLong(1, acno);
			pStatement.setInt(2, pinno);
			ResultSet rSet=pStatement.executeQuery();
			if(rSet.next()) {
				String nameString= rSet.getString("owner_name");
				double bal=rSet.getDouble("balance");
				BankingSystem userSystem=new BankingSystem(nameString, acno, pinno, bal);
				return userSystem;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	
}
