package lombok.foods;

import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public interface HorseFood extends Food {
    LocalDate getExpirationDate();
}
