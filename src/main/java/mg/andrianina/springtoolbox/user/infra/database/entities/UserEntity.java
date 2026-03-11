package mg.andrianina.springtoolbox.user.infra.database.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    public int id;
    @Column(nullable = false, unique = true)
    public String username;
    @Column(nullable = false, unique = true)
    public String email;
    @Column(nullable = false)
    public String password;
    @CreationTimestamp
    public Instant createdAt = Instant.now();

    public UserEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserEntity() {}
}
