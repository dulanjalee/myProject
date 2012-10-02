package student.myapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import student.myapp.Login;
/**
 * Created with IntelliJ IDEA.
 * User: hmspct8
 * Date: 10/2/12
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("deprecation")
public class LoginFormController extends SimpleFormController {

    @Override
    protected ModelAndView onSubmit(Object command) throws ServletException {
        Login login = (Login) command;
        String name = login.getUsername();
        String prestatement = "Hello";

        ModelAndView modelAndView = new ModelAndView(getSuccessView());
        modelAndView.addObject("name", name);
        return modelAndView;

    }
}