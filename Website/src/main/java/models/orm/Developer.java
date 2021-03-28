package models.orm;

//import jakarta.persistence.*;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Developer.findAll",
                query = "select dev from Developer dev "
        )
    })
@Data
@Table(name = "developer")
public class Developer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long adminId;
    @NotNull
    @NotBlank
    @Column(unique = true, nullable = false)
    private String job;
    @NotNull
    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;
    @NotNull
    @NotBlank
    @Column(unique = true, nullable = false)
    private String facebook;
    @NotNull
    @NotBlank
    @Column(unique = true, nullable = false)
    private String linkedIn;
    @NotNull
    @NotBlank
    @Column(unique = true, nullable = false)
    private String twitter;
    @NotNull
    @NotBlank
    @Column(unique = true, nullable = false)
    private String instgram;



    public Developer() {

    }

}