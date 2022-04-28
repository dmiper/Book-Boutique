package com.learnup.project.service;

import com.learnup.project.dao.entity.Users;
import com.learnup.project.dao.filter.UsersFilter;
import com.learnup.project.dao.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.util.Set;

import static com.learnup.project.dao.specification.UsersSpecification.byUsersFilter;

@Slf4j
@AllArgsConstructor
@Service
public class UsersService {
    
    private final UsersRepository usersRepository;
    
    public Set<Users> getAllUsers(UsersFilter usersFilter) {
        Specification<Users> specification = Specification.where(byUsersFilter(usersFilter));
        log.info("Request getAllUsers: {}", specification);
        return usersRepository.findAll(specification);
    }
    
    public Users createUser(Users users) {
        log.info("CreateUser: {}", users.toString());
        return usersRepository.save(users);
    }
    
    public Users getUserById(Long id) {
        log.info("Request getUserById: {}", id);
        return usersRepository.getById(id);
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
