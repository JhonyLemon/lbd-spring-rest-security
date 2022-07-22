package pl.fissst.lbd.restsecurity.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.fissst.lbd.restsecurity.security.Permissions;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Authorities")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    private User user;
    @Column(name = "AUTHORITY")
    @Enumerated(EnumType.STRING)
    private Permissions authority;

    public Authority(Long id, User user, Permissions authority) {
        this.id = id;
        this.user = user;
        this.authority = authority;
    }

    public Authority() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority.name();
    }

    public Permissions getAuthorityPerm() {
        return authority;
    }

    public void setAuthority(Permissions authority) {
        this.authority = authority;
    }

}

