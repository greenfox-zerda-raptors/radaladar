package lombok.foods;

import lombok.Builder;
import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */

public class Hay extends AbstractHorseFood {

    @Builder
    protected Hay(Long weight, Float qualityMultiplier, LocalDate expirationDate) {
        super("Hay", weight, Long.valueOf(weight.longValue() * 2L), qualityMultiplier, expirationDate);
    }

    public String toString() {
        return "Hay(super=" + super.toString() + ")";
    }
}
