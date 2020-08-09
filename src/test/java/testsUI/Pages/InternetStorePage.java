package testsUI.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InternetStorePage {

    private String baseURL;

    private SelenideElement
            linkBeachWear = $(By.linkText("ПЛЯЖНАЯ ОДЕЖДА"))
            , linkBikiniWearBottom = $(By.linkText("Бикини: низ"))
            , linkChoiceProduct = $(By.linkText("Женские плавки Printed Beach Classics"))
            , buttonSelectSize = $(".r-dropdown-sizes-init > span")
            , buttonSize = $(".r-dropdown-size:nth-child(1) > .swatchanchor")
            , buttonAddToCart = $(".add-to-cart-btn")
            , buttonGoToCart = $(".r-bh-panel-wrapper .link2cart")
            , inputCountProductInCart = $(".quantityinput")
            , labelNamePructInCart = $(".name:nth-child(1) > a")
            , errorMessage = $(".r-availability-size-error")
            , buttonDeleteProduct = $(".btn-remove")
            , infoMessageProductDelete = $(".cartempty")
            , buttonSale = $(By.linkText("SALE"))
            , columnSale = $("#leftcolumn")
            , labelTableSale = $(".js-search-replace-content")
            , buttonHelp = $(".r-bh-panel-action")
            , panelHelp = $(".r-bh-panel-wrapper > .helpleft-container .r-bh-panel-titles");


    public String getBaseURL() {
        return baseURL;
    }

    /**
     * конструктор
     *
     * @param baseURL - URL главной страницы интернет магазина
     */
    public InternetStorePage(String baseURL) {
        this.baseURL = baseURL;
    }

    /**
     * открываем главную страницу интернет магазина
     */
    public void openMainPageInternetStore() {
        Selenide.open(this.baseURL);
    }

    /**
     * выбор товара и добавление его в корзину
     */
    public void selectBikiniWearBottom() {
        this.linkBeachWear.click();
        this.linkBikiniWearBottom.click();
        this.linkChoiceProduct.click();
        this.buttonSelectSize.click();
        this.buttonSize.click();
        this.buttonAddToCart.click();
    }

    /**
     * добавление товара в корзину без выбора размера
     */
    public void makeOrderWithoutSize(){
        this.linkBeachWear.click();
        this.linkBikiniWearBottom.click();
        this.linkChoiceProduct.click();
        this.buttonAddToCart.click();
    }

    /**
     * переход в корзину
     */
    public void gotoCart() {
        this.buttonGoToCart.click();
    }

    /**
     * проверка что выбран нужный товар в нужном кол-ве
     */
    public void checkCountProduct() {
        assertEquals("ЖЕНСКИЕ ПЛАВКИ PRINTED BEACH CLASSICS", this.labelNamePructInCart.getText());
        assertEquals("1", this.inputCountProductInCart.getValue());
    }

    /**
     * проверка появления сообщения об ошибке, если не выбран размер при попытке добавт товар в корзину
     */
    public void checkSelectSize(){
        this.errorMessage.exists();
    }

    /**
     * удаление товара из корзины
     */
    public void deleteProductFromCart(){
        this.buttonDeleteProduct.click();
    }

    /**
     * проверка товар удален из корзины
     */
    public void checkDeletingProduct(){
        this.infoMessageProductDelete.exists();
        assertEquals("ВАША КОРЗИНА ПУСТА.",this.infoMessageProductDelete.getText());
    }

    /**
     * переход в раздел Скидки
     */
    public void goToSaleDepartment(){
        this.buttonSale.click();
    }

    /**
     * Проверка, что открыта страница Sale
     */
    public void checkSalePage(){
        this.columnSale.exists();
        this.labelTableSale.getText().contains("Sale");
    }

    public void goToHelp(){
        this.buttonHelp.click();
    }

    public void pageHeplIsOpened(){
        assertEquals("НУЖНА ПОМОЩЬ?",this.panelHelp.getText());
    }

}
