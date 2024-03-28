package pl.edu.pw.ee.petclinic.domain.user.data;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.ee.petclinic.domain.user.entity.AuthData;

@Repository
interface AuthDataRepository extends JpaRepository<AuthData, Long> {
  Optional<AuthData> findAuthDataByEmail(String userEmail);
  boolean existsByEmail(String userEmail);
}
