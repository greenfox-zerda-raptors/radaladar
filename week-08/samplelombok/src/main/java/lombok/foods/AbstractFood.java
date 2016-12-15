package lombok.foods;

import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public abstract class AbstractFood implements Food {
    private String name;
    private Long weight;
    private Long calories;
    private LocalDate creationDate;
    protected Float qualityMultiplier;

    public AbstractFood(String name, Long weight, Long calories, Float qualityMultiplier) {
        this(name, weight, calories, new LocalDate(), qualityMultiplier);
    }

    private AbstractFood(String name, Long weight, Long calories, LocalDate creationDate, Float qualityMultiplier) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
        this.creationDate = creationDate;
        this.qualityMultiplier = qualityMultiplier;
    }

    public String getName() {
        return this.name;
    }

    public Long getWeight() {
        return this.weight;
    }

    public Long getCalories() {
        return this.calories;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public Float getQualityMultiplier() {
        return this.qualityMultiplier;
    }

    public void setQualityMultiplier(Float qualityMultiplier) {
        this.qualityMultiplier = qualityMultiplier;
    }

    public String toString() {
        return "AbstractFood(name=" + this.getName() + ", weight=" + this.getWeight() + ", calories=" + this.getCalories() + ", creationDate=" + this.getCreationDate() + ", qualityMultiplier=" + this.getQualityMultiplier() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AbstractFood)) {
            return false;
        } else {
            AbstractFood other = (AbstractFood) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71:
                {
                    String this$name = this.getName();
                    String other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label71;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label71;
                    }

                    return false;
                }

                Long this$weight = this.getWeight();
                Long other$weight = other.getWeight();
                if (this$weight == null) {
                    if (other$weight != null) {
                        return false;
                    }
                } else if (!this$weight.equals(other$weight)) {
                    return false;
                }

                label57:
                {
                    Long this$calories = this.getCalories();
                    Long other$calories = other.getCalories();
                    if (this$calories == null) {
                        if (other$calories == null) {
                            break label57;
                        }
                    } else if (this$calories.equals(other$calories)) {
                        break label57;
                    }

                    return false;
                }

                LocalDate this$creationDate = this.getCreationDate();
                LocalDate other$creationDate = other.getCreationDate();
                if (this$creationDate == null) {
                    if (other$creationDate != null) {
                        return false;
                    }
                } else if (!this$creationDate.equals(other$creationDate)) {
                    return false;
                }

                Float this$qualityMultiplier = this.getQualityMultiplier();
                Float other$qualityMultiplier = other.getQualityMultiplier();
                if (this$qualityMultiplier == null) {
                    if (other$qualityMultiplier == null) {
                        return true;
                    }
                } else if (this$qualityMultiplier.equals(other$qualityMultiplier)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof AbstractFood;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        String $name = this.getName();
        int result1 = result * 59 + ($name == null ? 43 : $name.hashCode());
        Long $weight = this.getWeight();
        result1 = result1 * 59 + ($weight == null ? 43 : $weight.hashCode());
        Long $calories = this.getCalories();
        result1 = result1 * 59 + ($calories == null ? 43 : $calories.hashCode());
        LocalDate $creationDate = this.getCreationDate();
        result1 = result1 * 59 + ($creationDate == null ? 43 : $creationDate.hashCode());
        Float $qualityMultiplier = this.getQualityMultiplier();
        result1 = result1 * 59 + ($qualityMultiplier == null ? 43 : $qualityMultiplier.hashCode());
        return result1;
    }
}
