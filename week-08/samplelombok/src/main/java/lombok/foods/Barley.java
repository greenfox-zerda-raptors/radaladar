package lombok.foods;

import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public class Barley extends AbstractHorseFood {
    protected Barley(Long weight, Float qualityMultiplier, LocalDate expirationDate) {
        super("Barley", weight, Long.valueOf(weight.longValue() * 5L), qualityMultiplier, expirationDate);
    }

    public static Barley.BarleyBuilder builder() {
        return new Barley.BarleyBuilder();
    }

    public String toString() {
        return "Barley(super=" + super.toString() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Barley)) {
            return false;
        } else {
            Barley other = (Barley) o;
            return !other.canEqual(this) ? false : super.equals(o);
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Barley;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        int result1 = result * 59 + super.hashCode();
        return result1;
    }

    public static class BarleyBuilder {
        private Long weight;
        private Float qualityMultiplier;
        private LocalDate expirationDate;

        BarleyBuilder() {
        }

        public Barley.BarleyBuilder weight(Long weight) {
            this.weight = weight;
            return this;
        }

        public Barley.BarleyBuilder qualityMultiplier(Float qualityMultiplier) {
            this.qualityMultiplier = qualityMultiplier;
            return this;
        }

        public Barley.BarleyBuilder expirationDate(LocalDate expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Barley build() {
            return new Barley(this.weight, this.qualityMultiplier, this.expirationDate);
        }

        public String toString() {
            return "Barley.BarleyBuilder(weight=" + this.weight + ", qualityMultiplier=" + this.qualityMultiplier + ", expirationDate=" + this.expirationDate + ")";
        }
    }
}
