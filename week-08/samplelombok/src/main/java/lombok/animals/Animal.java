package lombok.animals;

import com.google.common.collect.ImmutableList;
import org.joda.time.LocalDate;

/**
 * Created by kicsen on 2016. 12. 12..
 */
public interface Animal {

    String getName();

    LocalDate getBirthDate();

    ImmutableList<? extends Animal> getChildren();

    Integer getChildrenNumber();

    Long getMovedDistanceInMilliMeters();

    Double getHappiness();

    Long getWeightInGram();

    void logOwnInfo();

    void move(long distanceInMilliMeters);
}
