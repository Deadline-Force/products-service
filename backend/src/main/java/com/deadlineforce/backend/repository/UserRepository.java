package com.deadlineforce.backend.repository;

import com.deadlineforce.backend.entity.User;
import com.deadlineforce.backend.security.details.AuthorizationRoles;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Tag(name = "UserController")
@RepositoryRestResource(path = "users", itemResourceRel = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    @RestResource(exported = false)
    Optional<User> findUserByLogin(String login);
    @RestResource(exported = false)
    List<User> findUsersByRoleAndIdIsNot(AuthorizationRoles role, long currentUserId);
}
