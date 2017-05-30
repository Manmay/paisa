package za.co.reverside.paisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.paisa.domain.AdminComment;

@Repository
public interface AdminCommentRepository extends JpaRepository<AdminComment, Long> {
   

}

