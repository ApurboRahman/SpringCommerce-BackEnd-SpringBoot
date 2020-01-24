package com.eas.emp.controllers;

import com.eas.emp.dto.BasicInfoDto;
import com.eas.emp.model.BasicInfoModel;
import com.eas.emp.services.BasicInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/basicInfo")
public class BasicInfoController {
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired private BasicInfoService basicInfoService;

  @GetMapping("/getAllEmployeeBasicInfo")
  public List<BasicInfoDto> getAllEmployeeBasicInfo() {
    return basicInfoService.findAll();
  }

  @GetMapping("/getEmployeeBasicInfoById/{employeeId}")
  public BasicInfoDto getEmployeeBasicInfoById(@PathVariable String employeeId) {
    return basicInfoService.getEmployeeBasicInfoById(employeeId);
  }

  @PostMapping(
      path = "/save",
      consumes = {"application/json"})
  public void save(@Valid @RequestBody BasicInfoDto basicInfoDto) {

    basicInfoService.save(basicInfoDto);
    logger.info(logger + "save operation completed.");
  }

  @PutMapping("/updateEmployeeInfo/{employeeId}")
  public BasicInfoModel updateEmployeeInfo(
          @PathVariable(value = "employeeId") String employeeId,
          @Valid @RequestBody BasicInfoModel basicInfoModel) {
    return basicInfoService.updateEmployeeInfo(employeeId, basicInfoModel);
  }

  @DeleteMapping("/delete/{employeeId}")
  public void deleteEmployeeById(@PathVariable String employeeId) {
    basicInfoService.deleteEmployeeById(employeeId);
  }
}
