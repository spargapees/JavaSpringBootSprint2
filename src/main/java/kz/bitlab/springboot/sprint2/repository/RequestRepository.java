package kz.bitlab.springboot.sprint2.repository;

import kz.bitlab.springboot.sprint2.db.ApplicationRequest;
import kz.bitlab.springboot.sprint2.model.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<RequestModel, Long>{
    List<RequestModel> findAllByHandledIsFalse();
    List<RequestModel> findAllByHandledIsTrue();
}
