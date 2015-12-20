package za.co.reverside.paisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.paisa.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
      public User  findByEmailAndPassword(String email, String password);

}

