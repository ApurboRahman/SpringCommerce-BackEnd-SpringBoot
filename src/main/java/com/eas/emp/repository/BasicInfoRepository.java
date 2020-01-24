package com.eas.emp.repository;

import com.eas.emp.dto.BasicInfoDto;
import com.eas.emp.model.BasicInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasicInfoRepository extends JpaRepository<BasicInfoModel, String> {
  @Query(
      value =
          "SELECT COUNT (u.employeeId) FROM BasicInfoModel u WHERE u.employeeId =:employeeId AND u.companyId =:companyId")
  int countByEmployeeIdAndCompanyId(String employeeId, Integer companyId);

  @Query(
      value =
          "SELECT  new com.eas.emp.dto.BasicInfoDto ("
              + " a.employeeId,a.firstName,a.lastName,a.companyId,d.name, a.phoneNo"
              + " ,a.sex, b.name, a.birthDate,a.joiningDate,a.department,c.name) FROM "
              + " BasicInfoModel a INNER JOIN a.genderModel b"
              + " INNER JOIN a.departmentModel c"
              + " INNER JOIN a.companyModel d order by a.employeeId")
  List<BasicInfoDto> getBasicInfoList();

  @Query(
      value =
          "SELECT  new com.eas.emp.dto.BasicInfoDto ("
              + " a.employeeId,a.firstName,a.lastName,a.companyId,d.name, a.phoneNo"
              + " ,a.sex, b.name, a.birthDate,a.joiningDate,a.department,c.name) FROM "
              + " BasicInfoModel a INNER JOIN a.genderModel b"
              + " INNER JOIN a.departmentModel c"
              + " INNER JOIN a.companyModel d WHERE a.employeeId =:employeeId")
  Optional<BasicInfoDto> getBasicInfoByEmployeeId(String employeeId);
}
