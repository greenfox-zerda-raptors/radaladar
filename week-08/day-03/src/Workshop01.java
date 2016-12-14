/// Created by BB on 2016-12-14.

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

public class Workshop01 {
    public static void main(String[] args) throws SQLException {
        String databaseUrl = "jdbc:h2:mem:account";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        Dao<Account, String> accountDao =
                DaoManager.createDao(connectionSource, Account.class);

        TableUtils.createTable(connectionSource, Account.class);

        Account account = new Account();
        account.setName("Captain America");
        account.setPassword("uejnsd632**234.");

        accountDao.create(account);

        Account account2 = accountDao.queryForId("Captain America");
        System.out.println("Account: " + account2.getName());
    }
}