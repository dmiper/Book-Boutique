package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Роль - наименование роли, ид
 */
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(schema = "schema")
public class Role /*implements GrantedAuthority*/ {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String role;
    
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(this.role, role.role) && Objects.equals(users, role.users);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @Override
    public String getAuthority() {
        return role;
    }*/
    
}
