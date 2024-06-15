package com.ro.portfolio.repo;

import com.ro.portfolio.entity.VisitorsInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends MongoRepository<VisitorsInfo,String> {

}
