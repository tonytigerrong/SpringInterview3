package rc.springinterview.multiplemodules.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rc.springinterview.multiplemodules.models.Role;
import rc.springinterview.multiplemodules.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {
    private User user;

    private Collection<? extends GrantedAuthority> authorities;
    public MyUserDetails(User user) {
        this.user = user;
        List<GrantedAuthority> authors = new ArrayList<>();
        for(Role role : user.getRoles()){
            authors.add( new SimpleGrantedAuthority(role.getName()));
        }
        this.authorities = authors;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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
        return true;
    }
}
