package com.learnup.project.service;

import com.learnup.project.dao.entity.Users;
import com.learnup.project.dao.filter.UsersFilter;
import com.learnup.project.dao.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.util.List;

import static com.learnup.project.dao.specification.UsersSpecification.byUsersFilter;

@Slf4j
@AllArgsConstructor
@Service
public class UsersService {
    
    private final UsersRepository usersRepository;
    
    public List<Users> getAllUsers(UsersFilter usersFilter) {
        Specification<Users> specification = Specification.where(byUsersFilter(usersFilter));
        log.info("Request getAllUsers: {}", specification);
        return usersRepository.findAll(specification);
    }
    
    @Transactional
    public Users createUser(Users users) {
        Users exist;
        exist = usersRepository.findByLoginName(users.getLoginName());
        if (exist != null) {
            throw new EntityExistsException("User with Login " + users.getLoginName() + " already exist");
        }
        exist = usersRepository.findByEmail(users.getEmail());
        if (exist != null) {
            throw new EntityExistsException("User with Email " + users.getEmail() + " already exist");
        }
        log.info("CreateUser: {}", users);
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
            log.warn("Optimistic lock exception for User id {}", users.getId());
            throw e;
        }
    }
    
}
