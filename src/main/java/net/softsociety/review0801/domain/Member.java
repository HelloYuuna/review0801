package net.softsociety.review0801.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Data
public class Member implements UserDetails, Serializable {
//    private static final long serialVersionUID = 362498820763181265L;
    private String memberid;
    private String memberpw;
    private String membername;
    private String email;
    private String phone;
    private String address;
    private boolean enabled;
    private String rolename;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return memberpw;
    }

    @Override
    public String getUsername() {
        return memberid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
