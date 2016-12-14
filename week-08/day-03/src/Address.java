/// Created by BB on 2016-12-14.

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "address")
public class Address {

    @DatabaseField(id = true)
    private int id;
    @DatabaseField(canBeNull = true)
    private String street;
    @DatabaseField(canBeNull = true)
    private String city;
    @DatabaseField(canBeNull = true)
    private int postcode;
    @DatabaseField(canBeNull = true)
    private String country;

    public Address() {}

    public Address(int id, String street, String city, int postcode, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{\n");
        str.append("postCode = ");
        str.append(this.postcode);
        str.append("city = ");
        str.append(this.city);
        str.append("country = ");
        str.append(this.country);
        str.append("street = ");
        str.append(this.street);
        str.append("\n}");
        return str.toString();
    }
}
