package lombok.animals;

import lombok.Getter;
import lombok.foods.Food;

import java.util.logging.Logger;

/**
 * Created by kicsen on 2016. 12. 12..
 */

public class Mouse extends AbstractAnimal {
    private static final Logger log = Logger.getLogger(Mouse.class.getName());

    public Mouse(String name, long weightInGram, double happiness) {
        super(name, weightInGram, happiness);
    }

    public void feed(Food food) {
        super.feed(food);
    }

    public void logOwnInfo() {
        log.info(this.toString());
    }

    protected int getMoveHappinessDecrease() {
        return 3;
    }

    public static Mouse.MouseBuilder builder() {
        return new Mouse.MouseBuilder();
    }

    public String toString() {
        return "Mouse(super=" + super.toString() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Mouse)) {
            return false;
        } else {
            Mouse other = (Mouse) o;
            return !other.canEqual(this) ? false : super.equals(o);
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Mouse;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        int result1 = result * 59 + super.hashCode();
        return result1;
    }

    public static class MouseBuilder {
        private String name;
        private long weightInGram;
        private double happiness;

        MouseBuilder() {
        }

        public Mouse.MouseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Mouse.MouseBuilder weightInGram(long weightInGram) {
            this.weightInGram = weightInGram;
            return this;
        }

        public Mouse.MouseBuilder happiness(double happiness) {
            this.happiness = happiness;
            return this;
        }

        public Mouse build() {
            return new Mouse(this.name, this.weightInGram, this.happiness);
        }

        public String toString() {
            return "Mouse.MouseBuilder(name=" + this.name + ", weightInGram=" + this.weightInGram + ", happiness=" + this.happiness + ")";
        }
    }
}
