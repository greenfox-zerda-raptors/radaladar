package lombok.animals;

import lombok.Getter;
import lombok.foods.HorseFood;

import java.util.logging.Logger;

/**
 * Created by kicsen on 2016. 12. 12..
 */

public class Horse extends AbstractAnimal {
    private static final Logger log = Logger.getLogger(Horse.class.getName());

    public Horse(String name, long weightInGram, double happiness) {
        super(name, weightInGram, happiness);
    }

    public void feed(HorseFood food) {
        super.feed(food);
    }

    public void logOwnInfo() {
        log.info(this.toString());
    }

    protected int getMoveHappinessDecrease() {
        return 1;
    }

    public static Horse.HorseBuilder builder() {
        return new Horse.HorseBuilder();
    }

    public String toString() {
        return "Horse(super=" + super.toString() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Horse)) {
            return false;
        } else {
            Horse other = (Horse) o;
            return !other.canEqual(this) ? false : super.equals(o);
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Horse;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        int result1 = result * 59 + super.hashCode();
        return result1;
    }

    public static class HorseBuilder {
        private String name;
        private long weightInGram;
        private double happiness;

        HorseBuilder() {
        }

        public Horse.HorseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Horse.HorseBuilder weightInGram(long weightInGram) {
            this.weightInGram = weightInGram;
            return this;
        }

        public Horse.HorseBuilder happiness(double happiness) {
            this.happiness = happiness;
            return this;
        }

        public Horse build() {
            return new Horse(this.name, this.weightInGram, this.happiness);
        }

        public String toString() {
            return "Horse.HorseBuilder(name=" + this.name + ", weightInGram=" + this.weightInGram + ", happiness=" + this.happiness + ")";
        }
    }
}
