package com.eas.emp.services;

import com.eas.emp.dto.AttendanceReportDto;
import com.eas.emp.model.DailyAttendanceModel;

import java.text.ParseException;
import java.util.List;

public interface DailyAttendanceService {
    void saveInTime(String employeeId) throws ParseException;

    void saveGoOutTime(String employeeId) throws ParseException;

    void saveReturnTime(String employeeId) throws ParseException;

    void saveOutTime(String employeeId) throws ParseException;

    List<DailyAttendanceModel> getAttendanceDetailById(String employeeId);

    List<DailyAttendanceModel> getAllEmployeeByDate(String date);

    List<DailyAttendanceModel> getAllEmployeeAttendanceByDateRange(String fromDate, String toDate);

    List<DailyAttendanceModel> getAttendanceReport(AttendanceReportDto attendanceReportDto);
}
