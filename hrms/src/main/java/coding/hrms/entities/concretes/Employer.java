package coding.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer{
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="company_name", nullable = false)
    private String companyName;

    @Column(name="website", nullable = false, unique = true)
    private String website;

    @Column(name="phone", nullable = false, unique = true)
    private String phone;

    @Column(name="verified_by_system", nullable = false)
    private boolean verifiedBySystem;

    public Employer(int userId, String companyName, String website, String phone, boolean verifiedBySystem) {
        this.userId = userId;
        this.companyName = companyName;
        this.website = website;
        this.phone = phone;
        this.verifiedBySystem = verifiedBySystem;
    }
}
