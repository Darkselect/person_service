package uz.darkselect.person_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.darkselect.person_service.entity.PersonAddress;

import java.util.UUID;

@Repository
public interface PersonAddressRepository extends JpaRepository<PersonAddress, UUID> {
}
