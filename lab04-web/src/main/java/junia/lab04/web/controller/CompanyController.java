package junia.lab04.web.controller;

import junia.lab04.core.entity.Company;
import junia.lab04.core.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListOfCompany(ModelMap modelMap) {
        List<Company> companies = companyService.findAllWithProjects();

        modelMap.put("companies", companies);

        return "companiesList";
    }
}
