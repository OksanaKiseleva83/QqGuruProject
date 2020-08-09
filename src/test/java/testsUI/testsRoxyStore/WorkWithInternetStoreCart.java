package testsUI.testsRoxyStore;

import testsUI.Pages.InternetStorePage;
import testsUI.core.SelenideBaseTest;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

public class WorkWithInternetStoreCart extends SelenideBaseTest {


    /**
     * Тест проверяет, что товар добавлен в корзину и добавлен именно выбранный товар
     * 1. открываем страницу интернет-магазина
     * 2. выбираю катагорию товаров
     * 3. выбираю товар
     * 4. добавляю товар в корзину
     * 5. перехожу в корзину
     * 6. проверяю, что в корзине нужный товар в нужном кол-ве
     * Предусловие:
     * кол-во товара в корзине = 1
     * тест не параметризованный, все значения зашиты в код
     */
    @Test
    public void testCheckAddProductToCart() {

        InternetStorePage pageRoxyRussiaStore = new InternetStorePage("https://www.roxy-russia.ru/");
        pageRoxyRussiaStore.openMainPageInternetStore();
        pageRoxyRussiaStore.selectBikiniWearBottom();
        pageRoxyRussiaStore.gotoCart();
        pageRoxyRussiaStore.checkCountProduct();
    }

    /**
     * тест проверяет, что без выбора размера нельзя совершить покупку
     * Предусловие:
     * кол-во товара в корзине = 1
     * тест не параметризованный, все значения зашиты в код
     */
    @Test
    public void testCheckSelectSize(){
        InternetStorePage pageRoxyRussiaStore = new InternetStorePage("https://www.roxy-russia.ru/");
        pageRoxyRussiaStore.openMainPageInternetStore();
        pageRoxyRussiaStore.makeOrderWithoutSize();
        pageRoxyRussiaStore.checkSelectSize();
    }

    /**
     * тест проверяет, что товар удаляется из корзины
     * Предусловие:
     * кол-во товара в корзине = 1
     * тест не параметризованный, все значения зашиты в код
     * проверяется удаление при условии, что в корзине был 1 товар
     */
    @Test
    public void testCheckDeleteProduct(){
        InternetStorePage pageRoxyRussiaStore = new InternetStorePage("https://www.roxy-russia.ru/");
        pageRoxyRussiaStore.openMainPageInternetStore();
        pageRoxyRussiaStore.selectBikiniWearBottom();
        pageRoxyRussiaStore.gotoCart();
        pageRoxyRussiaStore.checkCountProduct();
        pageRoxyRussiaStore.deleteProductFromCart();
        pageRoxyRussiaStore.checkDeletingProduct();

    }


}
