package lombok.foods;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public class Cheese extends AbstractFood {
    protected Cheese(Long weight, Long calories, Float qualityMultiplier) {
        super("Cheese", weight, calories, qualityMultiplier);
    }

    public static Cheese.CheeseBuilder builder() {
        return new Cheese.CheeseBuilder();
    }

    public String toString() {
        return "Cheese(super=" + super.toString() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Cheese)) {
            return false;
        } else {
            Cheese other = (Cheese) o;
            return !other.canEqual(this) ? false : super.equals(o);
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Cheese;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        int result1 = result * 59 + super.hashCode();
        return result1;
    }

    public static class CheeseBuilder {
        private Long weight;
        private Long calories;
        private Float qualityMultiplier;

        CheeseBuilder() {
        }

        public Cheese.CheeseBuilder weight(Long weight) {
            this.weight = weight;
            return this;
        }

        public Cheese.CheeseBuilder calories(Long calories) {
            this.calories = calories;
            return this;
        }

        public Cheese.CheeseBuilder qualityMultiplier(Float qualityMultiplier) {
            this.qualityMultiplier = qualityMultiplier;
            return this;
        }

        public Cheese build() {
            return new Cheese(this.weight, this.calories, this.qualityMultiplier);
        }

        public String toString() {
            return "Cheese.CheeseBuilder(weight=" + this.weight + ", calories=" + this.calories + ", qualityMultiplier=" + this.qualityMultiplier + ")";
        }
    }
}
