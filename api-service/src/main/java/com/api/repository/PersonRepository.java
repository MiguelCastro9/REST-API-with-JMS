package com.api.repository;

import com.api.model.PersonModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Miguel Castro
 */
public interface PersonRepository  extends MongoRepository<PersonModel, String> {
}
