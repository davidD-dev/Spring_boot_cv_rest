package com.cvrest.cv.CurliculumVitae;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CvRepository extends MongoRepository<Cv, String> {
    @Query(value = "{ '_id' : ?0 }", fields = "{'cvXml': 1, '_id' : 0}")
    String getXmlById(String id);

    @Query(value = "{  }", fields = "{'cvXml': 1, '_id' : 0}")
    List<String> getAllXml();
}
