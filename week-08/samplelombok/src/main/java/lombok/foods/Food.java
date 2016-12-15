package lombok.foods;

import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public interface Food {

    String getName();

    Long getWeight();

    Long getCalories();

    Float getQualityMultiplier();

    void setQualityMultiplier(Float multiplier);

    LocalDate getCreationDate();
}
