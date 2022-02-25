package junia.lab04.web.controller;

import com.google.protobuf.compiler.PluginProtos;
import junia.lab04.core.entity.Company;
import junia.lab04.core.service.CompanyService;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
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

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(ModelMap modelMap){

        Company company = new Company();

        modelMap.put("company", company);

        return "companyForm";
    }

    @ModelAttribute("company")
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(Company company) {

        companyService.save(company);
        return "";
    }
}
