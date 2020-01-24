package com.eas.emp.repository;

import com.eas.emp.model.SignupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository extends JpaRepository<SignupModel, Long> {
  @Query(
      value =
          "SELECT count(u.employeeId) FROM SignupModel u WHERE u.employeeId =:employeeId AND u.companyId =:companyId")
  int existByEmployeeIdAndCompanyId(String employeeId, Integer companyId);

  @Query(
      value =
          "SELECT count(u.employeeId) FROM SignupModel u WHERE u.employeeId =:employeeId AND u.companyId =:companyId AND u.passwords =:passwords")
  int findByEmployeeIdAndCompanyIdAndPasswords(
          String employeeId, Integer companyId, String passwords);

  SignupModel findByEmployeeIdAndCompanyId(String employeeId, Integer companyId);
}
