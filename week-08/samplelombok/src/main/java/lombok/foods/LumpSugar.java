package lombok.foods;

import lombok.Builder;
import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public class LumpSugar extends AbstractHorseFood {

    @Builder
    protected LumpSugar(Long weight, Float qualityMultiplier, LocalDate expirationDate) {
        super("LumpSugar", weight, Long.valueOf(weight.longValue() * 13L), qualityMultiplier, expirationDate);
    }
    public String toString() {
        return "LumpSugar(super=" + super.toString() + ")";
    }
}
