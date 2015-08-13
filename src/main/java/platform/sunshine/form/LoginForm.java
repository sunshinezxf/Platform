package platform.sunshine.form;

import javax.validation.constraints.NotNull;

/**
 * Created by sunshine on 15/8/13.
 */
public class LoginForm {
    @NotNull
    private String email;

    @NotNull
    private String password;
}
