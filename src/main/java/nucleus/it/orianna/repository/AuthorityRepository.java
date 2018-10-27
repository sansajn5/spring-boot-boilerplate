package nucleus.it.orianna.repository;

import nucleus.it.orianna.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {

    Authority findOneByName(String name);
}
