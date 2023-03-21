package MyApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Object Relational Mapping: this 'entity' is a class which is directly related to a database table.
 *
 * Lombok - NOT part of Spring, although it will help us automatically fill in this class's getters, setters, and basic
 * constructors/methods
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String type;
    private boolean resolved;
}