/// Created by BB on 2016-12-14.

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/// Created by BB on 2016-12-14.

@DatabaseTable
public class OldAccount {
    @DatabaseField(id = true)
    private String name;
    @DatabaseField
    private String password;

    public OldAccount() {}

    public OldAccount(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("{\nname = %s\npassword= %s\n}", name, password);
    }
}
