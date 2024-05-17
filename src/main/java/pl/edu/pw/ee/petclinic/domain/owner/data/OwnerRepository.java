package pl.edu.pw.ee.petclinic.domain.owner.data;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.ee.petclinic.domain.owner.entity.Owner;

@Repository
interface OwnerRepository extends JpaRepository<Owner, Long> {
  Optional<Owner> findOwnerByAuthDataEmail(String userEmail);
}
