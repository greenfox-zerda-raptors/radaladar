package lombok.animals;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.foods.Food;
import org.joda.time.LocalDate;

import java.util.List;

/**
 * Created by kicsen on 2016. 12. 12..
 */

@Getter
@Setter

public abstract class AbstractAnimal implements Animal {
    private String name;
    private LocalDate birthDate;

    protected List<? extends Animal> children = Lists.newArrayList();
    protected Integer childrenNumber = this.children.size();
    protected Long movedDistanceInMilliMeters = 0L;
    protected Double happiness;
    protected Long weightInGram;

    public AbstractAnimal(String name, long weightInGram, double happiness) {
        this.name = name;
        this.weightInGram = weightInGram;
        this.happiness = happiness;
        this.birthDate = new LocalDate();
    }

    public void move(long distanceInMilliMeters) {
        this.movedDistanceInMilliMeters = this.movedDistanceInMilliMeters.longValue() + distanceInMilliMeters;
        this.happiness = this.happiness.doubleValue() - this.getMoveHappinessDecrease();
        this.weightInGram = this.weightInGram.longValue() - distanceInMilliMeters;
    }

    protected void feed(Food food) {
        this.weightInGram = this.weightInGram + food.getCalories();
        this.happiness = this.happiness + food.getWeight() * food.getQualityMultiplier();
    }

    protected abstract int getMoveHappinessDecrease();

    public ImmutableList<? extends Animal> getChildren() {
        return ImmutableList.copyOf(this.children);
    }

    public void setMovedDistanceInMilliMeters(Long movedDistanceInMilliMeters) {
        this.movedDistanceInMilliMeters = movedDistanceInMilliMeters;
    }

    public void setHappiness(Double happiness) {
        this.happiness = happiness;
    }

    public void setWeightInGram(Long weightInGram) {
        this.weightInGram = weightInGram;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AbstractAnimal)) {
            return false;
        } else {
            AbstractAnimal other = (AbstractAnimal) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                String this$name = this.getName();
                String other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                LocalDate this$birthDate = this.getBirthDate();
                LocalDate other$birthDate = other.getBirthDate();
                if (this$birthDate == null) {
                    if (other$birthDate != null) {
                        return false;
                    }
                } else if (!this$birthDate.equals(other$birthDate)) {
                    return false;
                }

                ImmutableList this$children = this.getChildren();
                ImmutableList other$children = other.getChildren();
                if (this$children == null) {
                    if (other$children != null) {
                        return false;
                    }
                } else if (!this$children.equals(other$children)) {
                    return false;
                }

                label62:
                {
                    Long this$movedDistanceInMilliMeters = this.getMovedDistanceInMilliMeters();
                    Long other$movedDistanceInMilliMeters = other.getMovedDistanceInMilliMeters();
                    if (this$movedDistanceInMilliMeters == null) {
                        if (other$movedDistanceInMilliMeters == null) {
                            break label62;
                        }
                    } else if (this$movedDistanceInMilliMeters.equals(other$movedDistanceInMilliMeters)) {
                        break label62;
                    }

                    return false;
                }

                label55:
                {
                    Double this$happiness = this.getHappiness();
                    Double other$happiness = other.getHappiness();
                    if (this$happiness == null) {
                        if (other$happiness == null) {
                            break label55;
                        }
                    } else if (this$happiness.equals(other$happiness)) {
                        break label55;
                    }

                    return false;
                }

                Long this$weightInGram = this.getWeightInGram();
                Long other$weightInGram = other.getWeightInGram();
                if (this$weightInGram == null) {
                    if (other$weightInGram != null) {
                        return false;
                    }
                } else if (!this$weightInGram.equals(other$weightInGram)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof AbstractAnimal;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        String $name = this.getName();
        int result1 = result * 59 + ($name == null ? 43 : $name.hashCode());
        LocalDate $birthDate = this.getBirthDate();
        result1 = result1 * 59 + ($birthDate == null ? 43 : $birthDate.hashCode());
        ImmutableList $children = this.getChildren();
        result1 = result1 * 59 + ($children == null ? 43 : $children.hashCode());
        Long $movedDistanceInMilliMeters = this.getMovedDistanceInMilliMeters();
        result1 = result1 * 59 + ($movedDistanceInMilliMeters == null ? 43 : $movedDistanceInMilliMeters.hashCode());
        Double $happiness = this.getHappiness();
        result1 = result1 * 59 + ($happiness == null ? 43 : $happiness.hashCode());
        Long $weightInGram = this.getWeightInGram();
        result1 = result1 * 59 + ($weightInGram == null ? 43 : $weightInGram.hashCode());
        return result1;
    }

    public String toString() {
        return "AbstractAnimal(name=" + this.getName() + ", birthDate=" + this.getBirthDate() + ", children=" + this.getChildren() + ", movedDistanceInMilliMeters=" + this.getMovedDistanceInMilliMeters() + ", happiness=" + this.getHappiness() + ", weightInGram=" + this.getWeightInGram() + ")";
    }
}
