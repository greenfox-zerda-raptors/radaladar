package lombok.foods;

import lombok.Getter;
import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */

@Getter

public abstract class AbstractHorseFood extends AbstractFood implements HorseFood {
    protected LocalDate expirationDate;

    public AbstractHorseFood(String name, Long weight, Long calories, Float qualityMultiplier, LocalDate expirationDate) {
        super(name, weight, calories, qualityMultiplier);
        this.expirationDate = expirationDate;
    }

    public String toString() {
        return "AbstractHorseFood(super=" + super.toString() + ", expirationDate=" + this.getExpirationDate() + ")";
    }
}
