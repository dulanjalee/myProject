package student.myapp;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import student.myapp.*;
/**
 * Created with IntelliJ IDEA.
 * User: hmspct8
 * Date: 10/2/12
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginValidator implements Validator {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean supports(Class clazz) {
        return Login.class.isAssignableFrom(clazz);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void validate(Object obj, Errors errors) {
        Login login = (Login) obj;
        if (login.getUsername() == null || login.getUsername().length() == 0) {
            errors.rejectValue("username",
                    "error.empty.field", "Please Enter User Name");
        }
        else if (usernameValidation(login.getUsername()).isEmpty()) {
            errors.rejectValue("username", "unknown.user", "Unknown User");
        }
        if (login.getPassword() == null || login.getPassword().length() == 0) {
            errors.rejectValue("password",
                    "error.empty.field", "Please Enter Password");
        }
        else if (passwordValidation(login.getUsername()).isEmpty()){
            errors.rejectValue("password", "wrong.password", "Wrong Password");

        }
    }

    public String usernameValidation(String username) {
        return (String)jdbcTemplate.queryForObject(
                "select username from login where user_name=?", new Object[] { username }, String.class);
    }

    public String passwordValidation(String username) {
        return (String)jdbcTemplate.queryForObject(
                "select username from login where user_name=?", new Object[] { username }, String.class);
    }
}

