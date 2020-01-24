package com.eas.emp.repository;

import com.eas.emp.model.VisitDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitHistoryRepository extends JpaRepository<VisitDetailsModel, Long> {
  @Query(
      value =
          "SELECT MAX(u.id) FROM VisitDetailsModel u WHERE u.employeeId =:employeeId AND u.goOutTime is not null AND u.returnTime is null")
  Long getIdForGoOutTime(String employeeId);

  @Query(
      nativeQuery = true,
      value =
          "SELECT id,employee_id, min(goouttime), max(returntime) FROM visitdetails \n"
              + " WHERE employee_id=:employeeId  group by date(goouttime)")
  List<VisitDetailsModel> getVisitDetailsModelByEmployeeId(String employeeId);
}
