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

        Dao<Account, String> accountDao = DaoManager.createDao(connectionSource, Account.class);

        Address address = new Address("Andrassy ut 66", "Budapest", 1061, "Hungary");
        Account account = new Account("Captain America", "uejnsd632**234.", address);
        Account account2 = new Account("Hulk", "smash", address);
        createAccountIfNotExists(accountDao, account);
        createAccountIfNotExists(accountDao, account2);

        account = accountDao.queryForId("Captain America");
        System.out.println("Account: " + account.toString());
    }

    private static void createAccountIfNotExists(Dao<Account, String> accountDao, Account acc) throws SQLException {
        if(accountDao.queryForId(acc.getName()) == null) {
            accountDao.create(acc);
        }
    }
}