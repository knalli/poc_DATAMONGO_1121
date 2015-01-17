package de.knallisworld.poc.mongo.repository;

import de.knallisworld.poc.mongo.model.Envelope;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends MongoRepository<Envelope, String> {
}
