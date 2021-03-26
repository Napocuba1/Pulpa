package bo.ucb.edu.pulpa.dao;
import bo.ucb.edu.pulpa.domain.PulpaItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<PulpaItem, Integer> {

    @Query(value = "select * from pulpa_item where iduser=?1",nativeQuery = true)
    List<PulpaItem> findByPulpaIduser(Integer iduser);

}
