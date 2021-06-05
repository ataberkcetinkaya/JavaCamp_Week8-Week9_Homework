package coding.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee{

    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(mappedBy = "employee")
    private Resume resume;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="identity_no", nullable = false, unique = true)
    private String identityNo;

    @Column(name="birth_year", nullable = false)
    private int birthYear;

    public Employee(int userId, String firstName, String lastName, String identityNo, int birthYear, Position position) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNo = identityNo;
        this.birthYear = birthYear;
        this.position = position;
    }
}
