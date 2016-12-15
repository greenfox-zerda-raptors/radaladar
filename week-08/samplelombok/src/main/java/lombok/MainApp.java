package lombok;

import com.google.common.collect.Lists;
import lombok.animals.Animal;
import lombok.animals.Horse;
import lombok.animals.Mouse;
import lombok.extern.java.Log;
import lombok.foods.*;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Random;

/**
 * Created by kicsen on 2016. 12. 12..
 */
@Log
public class MainApp {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        List<Animal> animals = Lists.newArrayList();
        animals.add(Horse.builder().name("Paci").weightInGram(100000).happiness(2300).build());
        animals.add(Horse.builder().name("Saci").weightInGram(98000).happiness(1300).build());
        animals.add(Horse.builder().name("Laci").weightInGram(110000).happiness(3300).build());
        animals.add(Horse.builder().name("CinCin").weightInGram(50).happiness(100).build());
        animals.add(Horse.builder().name("Siccc").weightInGram(70).happiness(120).build());

        List<HorseFood> horseFoods = Lists.newArrayList();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        horseFoods.add(Barley.builder().weight(2300L).qualityMultiplier(1.2F).expirationDate(LocalDate.parse("2017-12-12", dateTimeFormatter)).build());
        horseFoods.add(Barley.builder().weight(1700L).qualityMultiplier(1.6F).expirationDate(LocalDate.parse("2017-11-23", dateTimeFormatter)).build());
        horseFoods.add(Hay.builder().weight(1000L).qualityMultiplier(1.1F).expirationDate(LocalDate.parse("2018-08-25", dateTimeFormatter)).build());
        horseFoods.add(LumpSugar.builder().weight(300L).qualityMultiplier(3F).expirationDate(LocalDate.parse("2017-09-25", dateTimeFormatter)).build());

        Cheese cheese = Cheese.builder().weight(400L).calories(1200L).qualityMultiplier(4F).build();

        log.info("Food storage:");
        for (HorseFood horseFood : horseFoods) {
            log.info(horseFood.toString());
        }
        log.info(cheese.toString());

        log.info("Initial animal states:");
        for (Animal animal : animals) {
            animal.logOwnInfo();
        }

        log.info("Random feeding ...");
        for (int i = 0; i < 10; i++) {
            Animal animal = animals.get(RANDOM.nextInt(animals.size()));
            if (animal instanceof Horse) {
                ((Horse) animal).feed(horseFoods.get(RANDOM.nextInt(horseFoods.size())));
            } else if (animal instanceof Mouse) {
                Mouse mouse = (Mouse) animal;
                int feedingRandom = RANDOM.nextInt(10000);
                if (feedingRandom % 100 == 0) {
                    mouse.feed(cheese);
                } else {
                    mouse.feed(horseFoods.get(feedingRandom % horseFoods.size()));
                }
            }
        }

        log.info("Animal states after random feeding:");
        for (Animal animal : animals) {
            animal.logOwnInfo();
        }

        log.info("Random animal movements...");
        for (Animal animal : animals) {
            animal.move(RANDOM.nextInt(10000));
        }

        log.info("Animal states after random movements:");
        for (Animal animal : animals) {
            animal.logOwnInfo();
        }
    }
}
