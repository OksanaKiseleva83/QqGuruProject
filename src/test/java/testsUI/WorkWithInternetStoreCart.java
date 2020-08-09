package testsUI;

import Pages.InternetStorePage;
import core.SelenideBaseTest;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

public class WorkWithInternetStoreCart extends SelenideBaseTest {


    /**
     * Тест проверяет, что товар добавлен в корзину и добавлен именно выбранный товар
     * 1. открываем страницу интернет-магазина
     * 2. выбираю катагорию товаров
     */
    @Test
    public void testCheckAddProductToCart() {

        InternetStorePage pageRoxyRussiaStore = new InternetStorePage("https://www.roxy-russia.ru/");
        pageRoxyRussiaStore.getBaseURL();

    }


}
