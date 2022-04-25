package com.learnup.project.service;

import com.learnup.project.dao.entity.UsersRole;
import com.learnup.project.dao.filter.UsersRoleFilter;
import com.learnup.project.dao.repository.UsersRoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.util.List;

import static com.learnup.project.dao.specification.UsersRoleSpecification.byUsersRoleFilter;

@Slf4j
@AllArgsConstructor
@Service
public class UsersRoleService {
    
    private final UsersRoleRepository usersRoleRepository;
    
    public List<UsersRole> getAllUsersRole(UsersRoleFilter usersRoleFilter) {
        Specification<UsersRole> specification = Specification.where(byUsersRoleFilter(usersRoleFilter));
        log.info("Request getAllUsersRole: {}", specification);
        return usersRoleRepository.findAll(specification);
    }
    
    public UsersRole createUserRole(UsersRole usersRole) {
        log.info("CreateUserRole: {}", usersRole.toString());
        return usersRoleRepository.save(usersRole);
    }
    
    public UsersRole getUserRoleById(Long id) {
        log.info("Request getUserRoleById: {}", id);
        return usersRoleRepository.getById(id);
    }
    
    public Boolean deleteUserRole(Long id) {
        log.info("DeleteUserRole by id: {}", id);
        usersRoleRepository.delete(usersRoleRepository.getById(id));
        return true;
    }
    
    public UsersRole updateUserRole(UsersRole usersRole) {
        try {
            log.info("UpdateUserRole: {}", usersRole.toString());
            return usersRoleRepository.save(usersRole);
        } catch (OptimisticLockException e) {
            log.warn("Optimistic lock exception for UserRole {}", usersRole.getId());
            throw e;
        }
    }
    
}
