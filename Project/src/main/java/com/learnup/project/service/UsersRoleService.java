package com.learnup.project.service;

import com.learnup.project.dao.entity.UsersRole;
import com.learnup.project.dao.filter.UsersRoleFilter;
import com.learnup.project.dao.repository.UsersRoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.learnup.project.dao.specification.UsersRoleSpecification.byUsersRoleFilter;

@Slf4j
@AllArgsConstructor
@Service
public class UsersRoleService {
    
    private final UsersRoleRepository usersRoleRepository;
    
    public List<UsersRole> getAllUsersRole(UsersRoleFilter usersRoleFilter) {
        Specification<UsersRole> specification = Specification.where(byUsersRoleFilter(usersRoleFilter));
        log.info("{}", specification);
        return usersRoleRepository.findAll(specification);
    }
    
    public UsersRole createUserRole(UsersRole books) {
        log.info("{}", books.toString());
        return usersRoleRepository.save(books);
    }
    
    public UsersRole getUserRoleById(Long id) {
        log.info("{}", id);
        return usersRoleRepository.getById(id);
    }
}
