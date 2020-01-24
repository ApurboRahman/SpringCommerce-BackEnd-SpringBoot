package com.eas.emp;

import com.eas.emp.model.BasicInfoModel;
import com.eas.emp.services.BasicInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest()
@ActiveProfiles("test")
public class BasicInfoServiceImpTest {
  @Autowired
  BasicInfoService basicInfoService;


  @Test
  public void testFindAll() throws ParseException {
    // new SimpleDateFormat("dd-MMM-yy").parse("1988-12-12");

    DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

    BasicInfoModel testModel = new BasicInfoModel();
    testModel.setEmployeeId("56789");
    testModel.setFirstName("Unit");
    testModel.setLastName("Test");
    testModel.setCompanyId(1);
    testModel.setSex('M');
    testModel.setPhoneNo("09808");
    testModel.setBirthDate(formatter.parse("1988-12-12"));
    testModel.setJoiningDate(formatter.parse("2019-12-12"));
    testModel.setDepartment(1);

   // basicInfoService.save(testModel);
   // BasicInfoModel find = basicInfoService.getEmployeeBasicInfoById(testModel.getEmployeeId());
   // Assert.assertEquals(find.getEmployeeId(), testModel.getEmployeeId());
  }
}
