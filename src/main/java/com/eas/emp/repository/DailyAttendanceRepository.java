package com.eas.emp.repository;

import com.eas.emp.model.DailyAttendanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DailyAttendanceRepository extends JpaRepository<DailyAttendanceModel, Long> {
  @Query(value = "SELECT u FROM DailyAttendanceModel u WHERE u.date BETWEEN :formDate AND :toDate")
  List<DailyAttendanceModel> getAllEmployeeAttendanceByDateRange(Date formDate, Date toDate);

  @Query(value = "SELECT u FROM DailyAttendanceModel u WHERE u.employeeId =:employeeId")
  List<DailyAttendanceModel> findByEmployeeId(String employeeId);

  @Query(
      value =
          "SELECT u FROM DailyAttendanceModel u WHERE u.employeeId =:employeeId AND u.date =:date")
  DailyAttendanceModel findByEmployeeIdAAndDate(String employeeId, Date date);

  @Query(
      value =
          "SELECT count (u.date) FROM DailyAttendanceModel u WHERE u.employeeId =:employeeId AND u.date =:date")
  int countByEmployeeId(String employeeId, Date date);

  @Query(
      value =
          "SELECT u.id FROM DailyAttendanceModel u WHERE u.employeeId =:employeeId AND u.date =:date")
  Long findByEmployeeIdAndAndDate(String employeeId, Date date);

  /* @Query(nativeQuery = true,
        value =
            "SELECT A.*,min(B.goouttime) AS goOutTime, max(B.returntime) AS returnTime FROM dailyattendance AS A INNER JOIN \n"
                + " visitdetails AS B on A.employee_id = B.employee_id \n"
                + " AND date(A.intime) = date(B.goouttime)\n"
                + " WHERE A.employee_id=:employeeId")
    List<DailyAttendanceModel> findByEmployeeId(String employeeId);
  */
  @Query(
      value =
          "SELECT MAX(u.id) FROM DailyAttendanceModel u WHERE u.employeeId =:employeeId AND u.inTime is not null AND u.outTime is null")
  Long getIdForLatestIntime(String employeeId);

  @Query(
      nativeQuery = true,
      value =
          "SELECT *  from dailyattendance u WHERE u.employee_id =:employeeId ORDER BY u.outtime desc limit 1")
  DailyAttendanceModel findTopByOutTimeOrderByOutTimeDayNameDesc(String employeeId);

  @Query(value = "SELECT u FROM DailyAttendanceModel u ORDER BY u.employeeId")
  List<DailyAttendanceModel> findAllOrOrderByEmployeeId();
}
