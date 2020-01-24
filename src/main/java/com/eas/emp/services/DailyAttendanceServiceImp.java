package com.eas.emp.services;

import com.eas.emp.dto.AttendanceReportDto;
import com.eas.emp.model.DailyAttendanceModel;
import com.eas.emp.repository.DailyAttendanceRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.eas.emp.util.DateUtil.convertStringToDate;

@Service(value = "dailyAttendanceService")
public class DailyAttendanceServiceImp implements DailyAttendanceService {

  private final String officeStartTime = "09:00:00";
  private final int breakTime = 1;
  private final int totalOfficeHour = 9;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  DailyAttendanceRepository dailyAttendanceRepository;

  @Override
  public void saveInTime(String employeeId) throws ParseException {
    Timestamp currentTime = getCurrentTime();
    Date date = getCurrentDate();

    DailyAttendanceModel attendanceModel = new DailyAttendanceModel();
    attendanceModel.setEmployeeId(employeeId);
    attendanceModel.setDate(date);
    attendanceModel.setInTime(currentTime);
    // generation calendar
    /*   if (dailyAttendanceRepository.countByEmployeeId(employeeId, attendanceModel.getDate()) == 0) {
      generateCalender(employeeId);
    }*/

    Long id = dailyAttendanceRepository.findByEmployeeIdAndAndDate(employeeId, date);
    attendanceModel.setId(id);
    dailyAttendanceRepository.save(attendanceModel);
    logger.info("Employee {} in time: {} save successfully", employeeId, currentTime);
  }

  @Override
  public void saveOutTime(String employeeId) throws ParseException {
    Timestamp currentTime = getCurrentTime();
    Date date = getCurrentDate();
    DailyAttendanceModel attendanceModel =
        dailyAttendanceRepository.findByEmployeeIdAAndDate(employeeId, date);
    attendanceModel.setOutTime(currentTime);
    dailyAttendanceRepository.save(attendanceModel);
    logger.info("Employee {} Out time: {} save successfully", employeeId, currentTime);
  }

  @Override
  public void saveGoOutTime(String employeeId) throws ParseException {
    Date date = getCurrentDate();
    Timestamp goOuTime = getCurrentTime();
    DailyAttendanceModel attendanceModel =
        dailyAttendanceRepository.findByEmployeeIdAAndDate(employeeId, date);
    attendanceModel.setGoOutTime(goOuTime);

    dailyAttendanceRepository.save(attendanceModel);

    logger.info("Employee {} go out time: {} save successfully", employeeId, goOuTime);
  }

  @Override
  public void saveReturnTime(String employeeId) throws ParseException {
    Date date = getCurrentDate();
    Timestamp returnTime = getCurrentTime();

    DailyAttendanceModel attendanceModel =
        dailyAttendanceRepository.findByEmployeeIdAAndDate(employeeId, date);
    attendanceModel.setReturnTime(returnTime);
    dailyAttendanceRepository.save(attendanceModel);

    logger.info("Employee {} Return time: {} save successfully", employeeId, returnTime);
  }

  @Override
  public List<DailyAttendanceModel> getAttendanceDetailById(String employeeId) {
    logger.info(logger + "Attendance Details generating for {}", employeeId);
    List<DailyAttendanceModel> attendanceModelList =
        dailyAttendanceRepository.findByEmployeeId(employeeId);
    attendanceModelList.forEach(this::accept);
    return attendanceModelList;
  }

  @Override
  public List<DailyAttendanceModel> getAllEmployeeByDate(String date) {
    logger.info(logger + "Attendance Details generating by date: {}", date);
    List<DailyAttendanceModel> attendanceModelList =
        dailyAttendanceRepository.findAll().stream()
            .filter(i -> i.getDate().equals(convertStringToDate(date)))
            .collect(Collectors.toList());
    attendanceModelList.forEach(this::accept);
    return attendanceModelList;
  }

  @Override
  public List<DailyAttendanceModel> getAllEmployeeAttendanceByDateRange(
      String fromDate, String toDate) {
    logger.info(logger + "Attendance Details generating from: {} to: ", fromDate, toDate);
    List<DailyAttendanceModel> getAllEmployeeByDateRange = new ArrayList<>();
    dailyAttendanceRepository.getAllEmployeeAttendanceByDateRange(
        convertStringToDate(fromDate), convertStringToDate(toDate));
    getAllEmployeeByDateRange.forEach(this::accept);
    return getAllEmployeeByDateRange;
  }

  @Override
  public List<DailyAttendanceModel> getAttendanceReport(AttendanceReportDto attendanceReportDto) {

    List<DailyAttendanceModel> reportList = dailyAttendanceRepository.findAllOrOrderByEmployeeId();
    reportList.forEach(this::accept);
    if (attendanceReportDto.getEmployeeType() == 2) {
      reportList =
          reportList.stream()
              .filter(i -> i.getEmployeeId().equals(attendanceReportDto.getEmployeeId()))
              .collect(Collectors.toList());
    }
    return reportList;
  }

  /*List<DailyAttendanceModel> getAllEmployeeAttendanceByDateRange =
      dailyAttendanceRepository.getAllEmployeeAttendanceByDateRange(
          attendanceReportDto.getFromDate(), attendanceReportDto.getToDate());

  reportList.forEach(this::accept);
  if (attendanceReportDto.getEmployeeId() != null) {
    reportList =
        reportList.stream()
            .filter(i -> i.getEmployeeId().equals(attendanceReportDto.getEmployeeId()))
            .collect(Collectors.toList());
    if (attendanceReportDto.getDateType() == 1) {
      reportList = reportList.stream().filter(this::test).collect(Collectors.toList());
    } else {

    }
  }*/

  private void accept(DailyAttendanceModel i) {
    i.setDayName(new SimpleDateFormat("EEEE").format(i.getDate()));
    String totalWorkingTime =
        getTotalWorkHour(
            i.getInTime(), i.getOutTime(), i.getGoOutTime(), i.getReturnTime(), breakTime);

    i.setTotalWorkingTime(totalWork(totalWorkingTime));

    String extraWorkHour =
        getTotalWorkHour(
            i.getInTime(), i.getOutTime(), i.getGoOutTime(), i.getReturnTime(), totalOfficeHour);
    int index = extraWorkHour.indexOf(':');
    long hours = Long.parseLong(extraWorkHour.substring(0, index));
    long mins = Long.parseLong(extraWorkHour.substring(index + 1));
    if (hours < 0 || mins < 0) {
      i.setExtraWork("00:00");
      i.setUnderWork(String.format("%02d:%02d", Math.abs(hours), Math.abs(mins)));
    } else {
      i.setExtraWork(String.format("%02d:%02d", hours, mins == 0 ? mins : mins + 1));
      i.setUnderWork("00:00");
    }

    i.setLate(getLateTime(i.getInTime()));
  }

  private String getTotalWorkHour(
      Date inTime, Date outTime, Date goOutTime, Date returnTime, int breakTime) {

    Duration workHour;
    Duration visitHour;
    if (outTime != null && inTime != null) {
      workHour =
          Duration.between(
              Instant.ofEpochMilli(outTime.getTime()), Instant.ofEpochMilli(inTime.getTime()));
      if (returnTime != null && goOutTime != null) {
        visitHour =
            Duration.between(
                Instant.ofEpochMilli(returnTime.getTime()),
                Instant.ofEpochMilli(goOutTime.getTime()));
        workHour = workHour.minus(visitHour);
      }
      Duration minusLunchTime = workHour.abs().minusHours(breakTime);
      long hours = minusLunchTime.toHours();
      long minutes = minusLunchTime.toMinutes() % 60;

      return String.format("%02d:%02d", hours, minutes);
    } else {
      return "00:00";
    }
  }

  private String getLateTime(Date inTime) {

    Time time = Time.valueOf(officeStartTime);
    LocalTime officeTime = time.toLocalTime();
    LocalTime comeInToOffice = ((Timestamp) inTime).toLocalDateTime().toLocalTime();

    if (comeInToOffice.isAfter(officeTime)) {
      int hr = comeInToOffice.getHour() - officeTime.getHour();
      int min = comeInToOffice.getMinute() - officeTime.getMinute();
      return String.format("%02d:%02d", hr, min);
    }
    return "00:00";
  }

  private Timestamp getCurrentTime() {
    LocalDateTime now = LocalDateTime.now();
    Timestamp currentTime = Timestamp.valueOf(now);
    return currentTime;
  }

  private Date getCurrentDate() throws ParseException {
    LocalDateTime now = LocalDateTime.now();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = sdf.parse(java.sql.Timestamp.valueOf(now).toString());
    return date;
  }

  private String totalWork(String workHour) {
    int index = workHour.indexOf(':');
    long hours = Long.parseLong(workHour.substring(0, index));
    long mins = Long.parseLong(workHour.substring(index + 1));
    if (mins < 0) {
      mins = 59 + mins;
    } else {
      mins = (mins == 0 ? 0 : mins + 1);
    }
    return String.format("%02d:%02d", hours, mins);
  }

  private void generateCalender(String employeeId) {
    List<DailyAttendanceModel> models = new ArrayList<>();
    Date date = new Date();
    LocalDate localDate = LocalDate.now();
    int lengthOfMonth = localDate.lengthOfMonth();

    DateTime now = new DateTime(date);

    DateTime plusDays = now.withDayOfMonth(1);

    int i = 0;
    while (i < lengthOfMonth) {
      DailyAttendanceModel model = new DailyAttendanceModel();
      model.setEmployeeId(employeeId);
      model.setDate(plusDays.plusDays(i).toDate());
      models.add(model);
      i++;
    }
    dailyAttendanceRepository.saveAll(models);

    logger.info("attendance sheet generated for the month of {} of employee: {}", date, employeeId);
  }

  private boolean filterByDate(DailyAttendanceModel i) {
    try {
      return i.getDate().equals(getCurrentDate());
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return false;
  }
}
