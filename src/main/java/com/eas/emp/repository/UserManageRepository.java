package com.eas.emp.repository;

import com.eas.emp.model.UserModel;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserManageRepository extends JpaRepository<UserModel, Integer> {
    String USERS_BY_LOGIN_CACHE = "usersByLogin";

    String USERS_BY_EMAIL_CACHE = "usersByEmail";

    Optional<UserModel> findOneByActivationKey(String activationKey);

    List<UserModel> findAllByActivatedIsFalseAndActivationKeyIsNotNullAndCreatedDateBefore(Instant dateTime);

    Optional<UserModel> findOneByResetKey(String resetKey);

    Optional<UserModel> findOneByEmailIgnoreCase(String email);

    Optional<UserModel> findOneByLogin(String login);

    @EntityGraph(attributePaths = "authorities")
    Optional<UserModel> findOneWithAuthoritiesById(Long id);

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
    Optional<UserModel> findOneWithAuthoritiesByLogin(String login);

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
    Optional<UserModel> findOneWithAuthoritiesByEmailIgnoreCase(String email);

    Page<UserModel> findAllByLoginNot(Pageable pageable, String login);
}
