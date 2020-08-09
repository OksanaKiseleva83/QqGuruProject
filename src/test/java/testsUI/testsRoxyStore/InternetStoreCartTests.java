package testsUI.testsRoxyStore;

import testsUI.Pages.InternetStorePage;
import testsUI.core.SelenideBaseTest;
import org.junit.jupiter.api.Test;


public class InternetStoreCartTests extends TestBase {

    @Test
    @DisplayName("Проверка, что товар успешно добавляется в корзину")
    @Description("1. открываем страницу интернет-магазина\n" +
        "2. выбираю катагорию товаров\n" +
        "3. выбираю товар\n" +
        "4. добавляю товар в корзину\n" +
        "5. перехожу в корзину\n" +
        "6. проверяю, что в корзине нужный товар в нужном кол-ве\n" +
        "Предусловие:\n" +
        "кол-во товара в корзине = 1\n" +
        "тест не параметризованный, все значения зашиты в код")
    public void addProductToCartTest() {
        InternetStorePage internetStorePage = new InternetStorePage();
        open("https://www.roxy-russia.ru/");
        
        internetStorePage.selectBikiniWearBottom();
        internetStorePage.gotoCart();
        
        internetStorePage.checkCountProduct();
    }

    /**
     * тест проверяет, что без выбора размера нельзя совершить покупку
     * Предусловие:
     * кол-во товара в корзине = 1
     * тест не параметризованный, все значения зашиты в код
     */
    @Test
    public void testCheckSelectSize(){
        InternetStorePage internetStorePage = new InternetStorePage();
        open("https://www.roxy-russia.ru/");

        internetStorePage.openMainPageInternetStore();
        internetStorePage.makeOrderWithoutSize();
        
        internetStorePage.checkSelectSize();
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

    /**
     * проверка, что при нажатии на меню Sale осуществляется переход к скидочным товарам, а не в основное меню
     */
    @Test
    public void testGotoSaleProducts(){
        InternetStorePage pageRoxyRussiaStore = new InternetStorePage("https://www.roxy-russia.ru/");
        pageRoxyRussiaStore.openMainPageInternetStore();
        pageRoxyRussiaStore.goToSaleDepartment();
        pageRoxyRussiaStore.checkSalePage();
    }

    /**
     * проверка, что страница техподдержки открылась
     */
    @Test
    public void testGotoHelp(){
        InternetStorePage pageRoxyRussiaStore = new InternetStorePage("https://www.roxy-russia.ru/");
        pageRoxyRussiaStore.openMainPageInternetStore();
        pageRoxyRussiaStore.goToHelp();
        pageRoxyRussiaStore.pageHeplIsOpened();
    }

}
