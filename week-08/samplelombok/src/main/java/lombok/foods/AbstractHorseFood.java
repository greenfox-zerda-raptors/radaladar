package lombok.foods;

import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public abstract class AbstractHorseFood extends AbstractFood implements HorseFood {
    protected LocalDate expirationDate;

    public AbstractHorseFood(String name, Long weight, Long calories, Float qualityMultiplier, LocalDate expirationDate) {
        super(name, weight, calories, qualityMultiplier);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public String toString() {
        return "AbstractHorseFood(super=" + super.toString() + ", expirationDate=" + this.getExpirationDate() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AbstractHorseFood)) {
            return false;
        } else {
            AbstractHorseFood other = (AbstractHorseFood) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else {
                LocalDate this$expirationDate = this.getExpirationDate();
                LocalDate other$expirationDate = other.getExpirationDate();
                if (this$expirationDate == null) {
                    if (other$expirationDate != null) {
                        return false;
                    }
                } else if (!this$expirationDate.equals(other$expirationDate)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof AbstractHorseFood;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        int result1 = result * 59 + super.hashCode();
        LocalDate $expirationDate = this.getExpirationDate();
        result1 = result1 * 59 + ($expirationDate == null ? 43 : $expirationDate.hashCode());
        return result1;
    }
}
