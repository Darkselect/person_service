package uz.darkselect.person_service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.darkselect.person_service.entity.Person;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    @Query("""
                SELECT DISTINCT p 
                FROM Person p
                LEFT JOIN p.personAddresses pa
                LEFT JOIN pa.address a
                WHERE p.hidden = false
                AND (:region IS NULL OR a.region = :region)
            """)
    Page<Person> findAllVisibleAndFilterByRegion(@Param("region") String region, Pageable pageable);

    @Query("""
        SELECT p
        FROM Person p
          JOIN p.documents d
        WHERE CONCAT(p.lastName, ' ', p.firstName, ' ', p.middleName) = :fullName
          AND d.docType = 'PASSPORT'
          AND d.docNumber = :passportNumber
    """)
    Optional<Person> findByFullNameAndPassport(@Param("fullName") String fullName, @Param("passportNumber") String passportNumber);
}
