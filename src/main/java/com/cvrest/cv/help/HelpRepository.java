package com.cvrest.cv.help;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRepository extends MongoRepository<Help, Long> {

}
