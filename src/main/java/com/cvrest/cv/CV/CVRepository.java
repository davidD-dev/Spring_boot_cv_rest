package com.cvrest.cv.CV;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CVRepository extends MongoRepository<CV, String> {

}
