package com.learnup.project.service;

import com.learnup.project.dao.entity.Role;
import com.learnup.project.dao.entity.Users;
import com.learnup.project.dao.filter.UsersFilter;
import com.learnup.project.dao.repository.RoleRepository;
import com.learnup.project.dao.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.OptimisticLockException;
import java.util.List;

import static com.learnup.project.dao.specification.UsersSpecification.byUsersFilter;

@Slf4j
@AllArgsConstructor
@Service
public class UsersService {
    
    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    
    public List<Users> getAllUsers(UsersFilter usersFilter) {
        Specification<Users> specification = Specification.where(byUsersFilter(usersFilter));
        log.info("Request getAllUsers: {}", specification);
        return usersRepository.findAll(specification);
    }
    
    public Users createUser(Users users) {
        Users exist = usersRepository.findByLoginName(users.getLoginName());
        if (exist != null) {
            throw new EntityExistsException("login with login " + users.getLoginName() + " already exist");
        }
    
        //String password = passwordEncoder.encode(user.getPassword());
        //TODO: Alo???
        /*
        users.setHashPassword(users.getHashPassword());
    
        String roles = users.getRole().getRole();
    
        Role existRoles = roleRepository.findByRole(roles);
        users.setRole(existRoles);
        existRoles.setUsers(List.of(users));
        */
        log.info("CreateUser: {}", users.toString());
        return usersRepository.save(users);
    }
    
    public Users getUserById(Long id) {
        log.info("Request getUserById: {}", id);
        return usersRepository.getUsersById(id);
    }
    
    public Boolean deleteUser(Long id) {
        log.info("DeleteUser by id: {}", id);
        usersRepository.delete(usersRepository.getById(id));
        return true;
    }
    
    public Users updateUser(Users users) {
        try {
            log.info("UpdateUser: {}", users.toString());
            return usersRepository.save(users);
        } catch (OptimisticLockException e) {
            log.warn("Optimistic lock exception for User {}", users.getId());
            throw e;
        }
    }
    
}
