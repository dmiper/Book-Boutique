package com.learnup.project.service;

import com.learnup.project.dao.entity.Users;
import com.learnup.project.dao.filter.UsersFilter;
import com.learnup.project.dao.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.learnup.project.dao.specification.UsersSpecification.byUsersFilter;

@Slf4j
@AllArgsConstructor
@Service
public class UsersService {
    
    private final UsersRepository usersRepository;
    
    public List<Users> getAllUsers(UsersFilter usersFilter) {
        Specification<Users> specification = Specification.where(byUsersFilter(usersFilter));
        log.info("{}", specification);
        return usersRepository.findAll(specification);
    }
    
    public Users createUser(Users users) {
        log.info("{}", users.toString());
        return usersRepository.save(users);
    }
    
    public Users getUserById(Long id) {
        log.info("{}", id);
        return usersRepository.getById(id);
    }
}
