package lombok.foods;

import lombok.Builder;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public class Cheese extends AbstractFood {

    @Builder
    protected Cheese(Long weight, Long calories, Float qualityMultiplier) {
        super("Cheese", weight, calories, qualityMultiplier);
    }

    public String toString() {
        return "Cheese(super=" + super.toString() + ")";
    }
}
