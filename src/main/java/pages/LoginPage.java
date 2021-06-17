package pages;

import base.PageBase;

/**
 * @author Sargis Sargsyan on 6/7/21
 * @project internal-training-exam
 */
public class LoginPage extends PageBase {

    public LoginPage() {
        super();
        driver.get(getUrl());
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    @Override
    public String getUrl() {
        return BASE_URL + "/login";
    }
}
