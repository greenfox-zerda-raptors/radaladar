/// Created by BB on 2016-12-14.

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Workshop02 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        String databaseUrl = "jdbc:mysql://localhost:3306/workshop02?user=root&password=" + password + "&SSL=false";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        TableUtils.createTableIfNotExists(connectionSource, OldAccount.class);

        Dao<OldAccount, String> accountDao = DaoManager.createDao(connectionSource, OldAccount.class);

        ArrayList<String> names = new ArrayList<>(Arrays.asList("Captain America", "Iron Man", "Wolverine", "Hulk", "Loki"));
        ArrayList<String> passwords = new ArrayList<>(Arrays.asList("uejnsd632**234.", "fdghj", "ipokn644hr", "3qyjyu78", "43tjdtu9"));


        for(int i = 0; i < names.size(); i++) {
            createAccountIfNotExists(accountDao, new OldAccount(names.get(i), passwords.get(i)));
        }

        QueryBuilder<OldAccount, String> queryBuilder = accountDao.queryBuilder();
        queryBuilder.orderBy("name", true);
        PreparedQuery<OldAccount> preparedQuery = queryBuilder.prepare();
        List<OldAccount> accounts = accountDao.query(preparedQuery);

        for (OldAccount temp : accounts) {
            System.out.println(temp.getName());
        }
    }

    private static void createAccountIfNotExists(Dao<OldAccount, String> accountDao, OldAccount acc) throws SQLException {
        if(accountDao.queryForId(acc.getName()) == null) {
            accountDao.create(acc);
        }
    }
}