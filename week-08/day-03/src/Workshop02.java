/// Created by BB on 2016-12-14.

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Workshop02 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        String databaseUrl = "jdbc:mysql://localhost:3306/workshop02?user=root&password=" + password + "&SSL=false";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        TableUtils.createTableIfNotExists(connectionSource, Account.class);

        Dao<Account, String> accountDao = DaoManager.createDao(connectionSource, Account.class);

        Account account = new Account("Captain America", "uejnsd632**234.");
        createAccountIfNotExists(accountDao, account);
        account = new Account("Iron Man","");
        createAccountIfNotExists(accountDao, account);
        account = new Account("Hulk","");
        createAccountIfNotExists(accountDao, account);
        account = new Account("Loki","");
        createAccountIfNotExists(accountDao, account);
        account = new Account("Wolverine","");
        createAccountIfNotExists(accountDao, account);

        account = accountDao.queryForId("Captain America");
        System.out.println("Account: " + account.toString());

        List<Account> accountlist = accountDao.queryBuilder()
                .selectColumns("name")
                .orderBy("name", true)
                .query();
        for (Account acc : accountlist) {
            System.out.println(acc.getName());
        }
    }

    private static void createAccountIfNotExists(Dao<Account, String> accountDao, Account acc) throws SQLException {
        if(accountDao.queryForId(acc.getName()) == null) {
            accountDao.create(acc);
        }
    }
}
