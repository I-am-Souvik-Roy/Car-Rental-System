package com.CarRental.Car_Rental.entity;

import com.CarRental.Car_Rental.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    //private UserRole userRole;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "user_role")
    private UserRole userRole;

@Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
    return List.of(new SimpleGrantedAuthority("ROLE_" + userRole.name()));
}
@Override
    public String getUsername(){
    return email;
}

@Override
    public boolean isAccountNonExpired(){
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
    @Override
    public String getPassword() {
        return password;
    }


}
