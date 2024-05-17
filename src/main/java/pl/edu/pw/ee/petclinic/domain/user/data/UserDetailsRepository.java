package pl.edu.pw.ee.petclinic.domain.user.data;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.ee.petclinic.domain.user.entity.UserDetails;

@Repository
interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
  Optional<UserDetails> findUserDetailsByEmail(String userEmail);
}
