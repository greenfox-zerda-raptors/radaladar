/// Created by BB on 2017-01-02.
package com.greenfoxacademy.caloriecounter.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository<Meal, Integer> {
}
