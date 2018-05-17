package gov.medicaid.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScreeningsController extends gov.medicaid.controllers.BaseController {
    @RequestMapping(value = "/admin/screenings", method = RequestMethod.GET)
    public ModelAndView view() {
        return new ModelAndView("admin/screenings");
    }
}
