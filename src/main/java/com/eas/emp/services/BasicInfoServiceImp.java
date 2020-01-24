package com.eas.emp.services;

import com.eas.emp.dto.BasicInfoDto;
import com.eas.emp.exceptions.EmployeeNotFoundException;
import com.eas.emp.model.BasicInfoModel;
import com.eas.emp.repository.BasicInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("basicInfoService")
public class BasicInfoServiceImp implements BasicInfoService {
  private static final Logger logger = LoggerFactory.getLogger(BasicInfoServiceImp.class);
  @Autowired private BasicInfoRepository basicInfoRepository;

  @Override
  public void save(BasicInfoDto basicInfoDto) {
    BasicInfoModel basicInfoModel = new BasicInfoModel();
    basicInfoModel.setEmployeeId(basicInfoDto.getEmployeeId());
    basicInfoModel.setFirstName(basicInfoDto.getFirstName());
    basicInfoModel.setLastName(basicInfoDto.getLastName());
    basicInfoModel.setSex(basicInfoDto.getSexId());
    basicInfoModel.setPhoneNo(basicInfoDto.getPhoneNo());
    basicInfoModel.setBirthDate(basicInfoDto.getBirthDate());
    basicInfoModel.setCompanyId(basicInfoDto.getCompanyId());
    basicInfoModel.setDepartment(basicInfoDto.getDepartment());
    basicInfoModel.setJoiningDate(basicInfoDto.getJoiningDate());
    basicInfoRepository.save(basicInfoModel);
    logger.info("Employee {} save completed successfully", basicInfoDto.getEmployeeId());
  }

  @Override
  public List<BasicInfoDto> findAll() {
    List<BasicInfoDto> basicInfoDtoList = basicInfoRepository.getBasicInfoList();
    basicInfoDtoList.forEach(e -> logger.info("Employee : {}", e.getEmployeeId()));
    return basicInfoDtoList;
  }

  @Override
  public BasicInfoDto getEmployeeBasicInfoById(String employeeId) {
    BasicInfoDto basicInfoDto = new BasicInfoDto();
    Optional<BasicInfoDto> basicInfo = basicInfoRepository.getBasicInfoByEmployeeId(employeeId);
    if (basicInfo.isPresent()) {
      basicInfoDto = basicInfo.get();
      basicInfoDto.setEmployeeExist(true);
    } else {
      basicInfoDto.setEmployeeId(employeeId);
      basicInfoDto.setEmployeeExist(false);
    }
    logger.info("Employee : ", employeeId);
    return basicInfoDto;
  }

  @Override
  public BasicInfoModel updateEmployeeInfo(String employeeId, BasicInfoModel basicInfoModel) {
    BasicInfoModel oldInfo =
        basicInfoRepository
            .findById(employeeId)
            .orElseThrow(
                () ->
                    new EmployeeNotFoundException("BasicInfoModel", "employeeId", basicInfoModel));
    oldInfo.setFirstName(basicInfoModel.getFirstName());
    oldInfo.setLastName(basicInfoModel.getLastName());
    oldInfo.setPhoneNo(basicInfoModel.getPhoneNo());
    oldInfo.setSex(basicInfoModel.getSex());
    oldInfo.setBirthDate(basicInfoModel.getBirthDate());
    oldInfo.setJoiningDate(basicInfoModel.getJoiningDate());
    oldInfo.setDepartment(basicInfoModel.getDepartment());
    basicInfoRepository.save(oldInfo);
    logger.info("Employee {} has updated successfully", employeeId);
    return oldInfo;
  }

  @Override
  public void deleteEmployeeById(String employeeId) {
    basicInfoRepository
        .findById(employeeId)
        .orElseThrow(
            () -> new EmployeeNotFoundException("BasicInfoModel", "employeeId", employeeId));
    basicInfoRepository.deleteById(employeeId);
    logger.info("Employee {} has deleted successfully", employeeId);
  }

  @Override
  public boolean notEmployee(String employeeId, Integer companyId) {
    return basicInfoRepository.countByEmployeeIdAndCompanyId(employeeId, companyId) == 0;
  }
}
