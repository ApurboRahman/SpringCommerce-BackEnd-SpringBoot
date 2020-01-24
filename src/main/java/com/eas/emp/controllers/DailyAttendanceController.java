package com.eas.emp.controllers;

import com.eas.emp.dto.AttendanceReportDto;
import com.eas.emp.model.DailyAttendanceModel;
import com.eas.emp.services.DailyAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/dailyAttendance")
public class DailyAttendanceController {

  @Autowired private DailyAttendanceService dailyAttendanceService;

  @GetMapping(value = "/getAttendanceDetailById/{employeeId}")
  public List<DailyAttendanceModel> getAttendanceDetailById(@PathVariable String employeeId) {
    return dailyAttendanceService.getAttendanceDetailById(employeeId);
  }

  @GetMapping(value = "/getAllEmployeeAttendanceByDate/{date}")
  public List<DailyAttendanceModel> getAllEmployeeByDate(@PathVariable String date) {
    return dailyAttendanceService.getAllEmployeeByDate(date);
  }

  @GetMapping(value = "/getAllEmployeeAttendanceByDateRange/{fromDate}/{toDate}")
  public List<DailyAttendanceModel> getAllEmployeeByDateRange(
      @PathVariable String fromDate, @PathVariable String toDate) {
    return dailyAttendanceService.getAllEmployeeAttendanceByDateRange(fromDate, toDate);
  }

  @PostMapping(value = "/inTime/{employeeId}")
  public void saveInTime(@PathVariable String employeeId) throws ParseException {
    dailyAttendanceService.saveInTime(employeeId);
  }

  @PostMapping(value = "/goOutTime/{employeeId}")
  public void saveGoOutTime(@PathVariable String employeeId) throws ParseException {
    dailyAttendanceService.saveGoOutTime(employeeId);
  }

  @PostMapping(value = "/returnTime/{employeeId}")
  public void saveReturnTime(@PathVariable String employeeId) throws ParseException {
    dailyAttendanceService.saveReturnTime(employeeId);
  }

  @PostMapping(value = "/outTime/{employeeId}")
  public void saveOutTime(@PathVariable String employeeId) throws ParseException {
    dailyAttendanceService.saveOutTime(employeeId);
  }

  @PostMapping(value = "/getAttendanceReport")
  public List<DailyAttendanceModel> getAttendanceReport(@RequestBody AttendanceReportDto attendanceReportDto) {
    return dailyAttendanceService.getAttendanceReport(attendanceReportDto);
  }
}
