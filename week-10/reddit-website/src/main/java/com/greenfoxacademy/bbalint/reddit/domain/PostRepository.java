/// Created by BB on 2017-01-04.
package com.greenfoxacademy.bbalint.reddit.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
}
