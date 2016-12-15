package lombok.foods;

import lombok.Builder;
import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */

public class Barley extends AbstractHorseFood {

    @Builder
    protected Barley(Long weight, Float qualityMultiplier, LocalDate expirationDate) {
        super("Barley", weight, Long.valueOf(weight.longValue() * 5L), qualityMultiplier, expirationDate);
    }

    public String toString() {
        return "Barley(super=" + super.toString() + ")";
    }
}
