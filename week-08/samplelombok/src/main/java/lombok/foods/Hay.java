package lombok.foods;

import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public class Hay extends AbstractHorseFood {
    protected Hay(Long weight, Float qualityMultiplier, LocalDate expirationDate) {
        super("Hay", weight, Long.valueOf(weight.longValue() * 2L), qualityMultiplier, expirationDate);
    }

    public static Hay.HayBuilder builder() {
        return new Hay.HayBuilder();
    }

    public String toString() {
        return "Hay(super=" + super.toString() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Hay)) {
            return false;
        } else {
            Hay other = (Hay) o;
            return !other.canEqual(this) ? false : super.equals(o);
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Hay;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        int result1 = result * 59 + super.hashCode();
        return result1;
    }

    public static class HayBuilder {
        private Long weight;
        private Float qualityMultiplier;
        private LocalDate expirationDate;

        HayBuilder() {
        }

        public Hay.HayBuilder weight(Long weight) {
            this.weight = weight;
            return this;
        }

        public Hay.HayBuilder qualityMultiplier(Float qualityMultiplier) {
            this.qualityMultiplier = qualityMultiplier;
            return this;
        }

        public Hay.HayBuilder expirationDate(LocalDate expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Hay build() {
            return new Hay(this.weight, this.qualityMultiplier, this.expirationDate);
        }

        public String toString() {
            return "Hay.HayBuilder(weight=" + this.weight + ", qualityMultiplier=" + this.qualityMultiplier + ", expirationDate=" + this.expirationDate + ")";
        }
    }
}
