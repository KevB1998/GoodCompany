package com.project.GoodCompany;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class ServiceController {

    @PostMapping("/EmployeeInfo")
    @ResponseBody
    public String getEmployeeInfo(@RequestBody Map<String, Object> payload) {
        String eid = payload.get("eid").toString();
        String password = payload.get("password").toString();

        com.project.GoodCompany.GoodCompanyService service = new com.project.GoodCompany.GoodCompanyService();
        String out = service.getEmployeeInfo(eid, password);

        return out;
    }

    @RequestMapping(value="/ChangePassword", method=RequestMethod.POST)
    public String changePassword(@RequestBody Map<String, Object> payload){
        String eid = payload.get("eid").toString();
        String cPassword = payload.get("cPassword").toString();
        String nPassword = payload.get("nPassword").toString();

        com.project.GoodCompany.GoodCompanyService service = new com.project.GoodCompany.GoodCompanyService();
        boolean changed = service.changePassword(eid, cPassword, nPassword);

        if (changed) {
            return "success";
        } else {
            return "error";
        }
    }
}
