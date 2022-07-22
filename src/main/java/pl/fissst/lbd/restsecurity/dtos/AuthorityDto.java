package pl.fissst.lbd.restsecurity.dtos;

import pl.fissst.lbd.restsecurity.entities.User;
import pl.fissst.lbd.restsecurity.security.Permissions;


public class AuthorityDto {

    private Long id;
    private Permissions authority;

    public AuthorityDto(Long id, Permissions authority) {
        this.id = id;
        this.authority = authority;
    }

    public AuthorityDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Permissions getAuthority() {
        return authority;
    }

    public void setAuthority(Permissions authority) {
        this.authority = authority;
    }
}
