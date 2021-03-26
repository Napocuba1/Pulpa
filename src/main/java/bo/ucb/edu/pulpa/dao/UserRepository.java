package bo.ucb.edu.pulpa.dao;

import bo.ucb.edu.pulpa.domain.PulpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<PulpaUser, Integer> {

    @Query(value = "select * from parking_user where email=?1 and password=?2 LIMIT 1",nativeQuery = true)
    PulpaUser findByEmailAndPassword(String email, String password);

}
