import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/// Created by BB on 2016-12-14.

@DatabaseTable(tableName = "accounts")
public class Account {

    @DatabaseField(id = true)
    private int id;
    @DatabaseField
    private String name;
    @DatabaseField(canBeNull = true)
    private String password;
    @DatabaseField(canBeNull = true, foreign = true, columnName = "id")
    private Address address;

    public Account() {}

    public Account(String name) {
        this.name = name;
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Account(String name, String password, Address address) {
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public Account(int id, String name, String password, Address address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\n{\n");
        str.append("name = ");
        str.append(name);
        str.append(address.toString());
        str.append("\n}");
        return str.toString();
    }
}
