package com.eas.emp.services;

import com.eas.emp.dto.BasicInfoDto;
import com.eas.emp.model.BasicInfoModel;

import java.util.List;

public interface BasicInfoService {

    void save(BasicInfoDto basicInfoDto);

    List<BasicInfoDto> findAll();

    BasicInfoDto getEmployeeBasicInfoById(String employeeId);

    BasicInfoModel updateEmployeeInfo(String employeeId, BasicInfoModel basicInfoModel);

    void deleteEmployeeById(String employeeId);

    boolean notEmployee(String employeeId, Integer companyId);
}
