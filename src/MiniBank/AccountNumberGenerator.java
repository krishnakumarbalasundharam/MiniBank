package MiniBank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountNumberGenerator {

    private static long lastAccountNumber = 1000000000L;

    public static long generateAcNo() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
             
            ResultSet rs = stmt.executeQuery("SELECT MAX(account_number) FROM accounts");
            if (rs.next()) {
                long maxFromDB = rs.getLong(1);
                if (maxFromDB > lastAccountNumber) {
                    lastAccountNumber = maxFromDB;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ++lastAccountNumber;
    }
}

