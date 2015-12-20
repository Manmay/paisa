package za.co.reverside.paisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.paisa.domain.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    
      public Login  findByUserNameAndPassword(String userName, String password);
    
      public Login findByUserName(String userName);
      
      public Login findByRole(String role);

}

