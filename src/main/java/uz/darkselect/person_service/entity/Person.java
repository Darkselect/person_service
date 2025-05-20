package uz.darkselect.person_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "persons_table")
public class Person {
    @Id
    @Column(columnDefinition = "uuid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "born_date")
    private LocalDate bornDate;

    @Column(name = "hidden")
    private Boolean hidden;

    @OneToMany(mappedBy = "person", orphanRemoval = true)
    private List<IdentityDocument> documents;

    @OneToMany(mappedBy = "person", orphanRemoval = true)
    private List<PersonAddress> personAddresses;

    @OneToMany(mappedBy = "person", orphanRemoval = true)
    private List<Contact> contacts;
}
