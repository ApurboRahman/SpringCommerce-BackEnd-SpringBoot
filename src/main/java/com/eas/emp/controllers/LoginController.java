package com.eas.emp.controllers;

import com.eas.emp.dto.LoginDto;
import com.eas.emp.dto.SignupDto;
import com.eas.emp.services.LoginService;
import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class LoginController {

  @Autowired private LoginService loginService;

  @PostMapping("/login")
  @ResponseBody
  public LoginDto login(HttpServletRequest request, @RequestBody LoginDto loginDto) {
    userLocation();
    return loginService.userLogin(loginDto);
  }

  public void userLocation() {
    File file =
        new File("C:\\Users\\BJIT\\Downloads\\GeoLite2-City_20190226\\GeoLiteCity.dat");

    LookupService lookup = null;
    try {
      lookup = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE);
    } catch (IOException e) {
      e.printStackTrace();
    }
    assert lookup != null;
    String ipAddress = "206.190.36.45";
    //String ipAddress = "39.110.213.207";
    Location locationServices = lookup.getLocation(ipAddress);
    System.out.println(locationServices.countryCode);
    System.out.println(locationServices.countryName);
    System.out.println(locationServices.region);
    System.out.println(
        regionName.regionNameByCode(locationServices.countryCode, locationServices.region));
    System.out.println(locationServices.city);
    System.out.println(locationServices.postalCode);
    System.out.println(String.valueOf(locationServices.latitude));
    System.out.println(String.valueOf(locationServices.longitude));
  }

  @GetMapping("login/checkUser")
  @ResponseBody
  public SignupDto getUserInfo(@RequestBody SignupDto signupDto) {
    return loginService.getUserInfo(signupDto);
  }
}
