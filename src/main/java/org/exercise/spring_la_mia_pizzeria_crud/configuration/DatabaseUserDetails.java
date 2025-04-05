package org.exercise.spring_la_mia_pizzeria_crud.configuration;

import java.util.HashSet;
import java.util.Set;

import org.exercise.spring_la_mia_pizzeria_crud.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DatabaseUserDetails implements UserDetails {

    private final Integer id;
    private final String username;
    private final String password;
    private final Set<GrantedAuthority> authorities;

    public DatabaseUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = new HashSet<GrantedAuthority>();
    }
    // Implementazione dei metodi di UserDetails
    // Ad esempio, puoi implementare i metodi getAuthorities(), getPassword(),
    // getUsername(), ecc.
    // in base alla tua logica di autenticazione e autorizzazione.

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
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
