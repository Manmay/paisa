package za.co.reverside.paisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.paisa.domain.LoanType;


@Repository
public interface LoanTypeRepository extends JpaRepository<LoanType, Long> {

}

