/// Created by BB on 2016-12-14.

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.Scanner;

public class Workshop03 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        String databaseUrl = "jdbc:mysql://localhost:3306/workshop03?user=root&password=" + password + "&SSL=false";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        TableUtils.createTableIfNotExists(connectionSource, Account.class);
        TableUtils.createTableIfNotExists(connectionSource, Address.class);

        Dao<Account, String> accountDao =
                DaoManager.createDao(connectionSource, Account.class);

        Address caAddress = new Address(1, "aaa", "bbb", 1111, "ccc");
        Account account = new Account(1, "Captain America", "uejnsd632**234.", caAddress);
        createAccountIfNotExists(accountDao, account);

        account = accountDao.queryForId("1");
        System.out.printf("Account: " + account.toString());
    }

    private static void createAccountIfNotExists(Dao<Account, String> accountDao, Account acc) throws SQLException {
        if(accountDao.queryForId(Integer.toString(acc.getId())) == null) {
            accountDao.create(acc);
        }
    }
}