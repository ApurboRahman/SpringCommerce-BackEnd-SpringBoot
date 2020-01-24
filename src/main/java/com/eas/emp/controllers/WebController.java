package com.eas.emp.controllers;

import com.eas.emp.model.CompanyModel;
import com.eas.emp.model.DepartmentModel;
import com.eas.emp.model.GenderModel;
import com.eas.emp.repository.CompanyRepository;
import com.eas.emp.repository.DepartmentRepository;
import com.eas.emp.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WebController {
  @Autowired private GenderRepository genderRepository;
  @Autowired private CompanyRepository companyRepository;
  @Autowired private DepartmentRepository departmentRepository;

  @RequestMapping("/")
  ModelAndView basicInfo(ModelAndView modelAndView) {
    List<GenderModel> genderList = genderRepository.findAll();
    List<CompanyModel> companyList = companyRepository.findAll();
    List<DepartmentModel> departmentList = departmentRepository.findAll();
    modelAndView.addObject("genderList", genderList);
    modelAndView.addObject("companyList", companyList);
    modelAndView.addObject("departmentList", departmentList);
    modelAndView.setViewName("basicInformation");

    return modelAndView;
  }

  @RequestMapping("/employeeList")
  ModelAndView employeeList(ModelAndView modelAndView) {
    List<GenderModel> genderList = genderRepository.findAll();
    List<CompanyModel> companyList = companyRepository.findAll();
    List<DepartmentModel> departmentList = departmentRepository.findAll();
    modelAndView.addObject("genderList", genderList);
    modelAndView.addObject("companyList", companyList);
    modelAndView.addObject("departmentList", departmentList);
    modelAndView.setViewName("employeeList");

    return modelAndView;
  }


  @RequestMapping("/attendance")
  ModelAndView attendance(ModelAndView modelAndView) {

    modelAndView.setViewName("attendance");

    return modelAndView;
  }

  @RequestMapping("/attendanceReport")
  ModelAndView attendanceReport(ModelAndView modelAndView) {

    modelAndView.setViewName("attendanceReport");

    return modelAndView;
  }

  @RequestMapping("/signup")
  ModelAndView signUp(ModelAndView modelAndView) {

    modelAndView.setViewName("signup");

    return modelAndView;
  }

  @RequestMapping("/login")
  ModelAndView login(ModelAndView modelAndView) {

    modelAndView.setViewName("login");

    return modelAndView;
  }

  @RequestMapping("/changePasswords")
  ModelAndView passwordsChange(ModelAndView modelAndView) {

    modelAndView.setViewName("changePasswords");

    return modelAndView;
  }
}
