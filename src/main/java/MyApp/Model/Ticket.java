package MyApp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "userFK")
    private Account account;
}