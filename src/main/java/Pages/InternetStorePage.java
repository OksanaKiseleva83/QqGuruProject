package Pages;

import com.codeborne.selenide.Selenide;

public class InternetStorePage {

    private String baseURL;


    public String getBaseURL() {
        return baseURL;
    }

    /**
     * конструктор
     * @param baseURL - URL главной страницы интернет магазина
     */
    public InternetStorePage(String baseURL){

        this.baseURL = baseURL;

    }

    /**
     * открываем главную страницу интернет магазина
     */
    public void openMainPageInternetStore(){

        Selenide.open(this.baseURL);

    }


}
