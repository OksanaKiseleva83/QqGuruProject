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
            , infoMessageProductDelete = $(".cartempty");


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

    public void selectBikiniWearBottom() {
        this.linkBeachWear.click();
        this.linkBikiniWearBottom.click();
        this.linkChoiceProduct.click();
        this.buttonSelectSize.click();
        this.buttonSize.click();
        this.buttonAddToCart.click();
    }

    public void makeOrderWithoutSize(){
        this.linkBeachWear.click();
        this.linkBikiniWearBottom.click();
        this.linkChoiceProduct.click();
        this.buttonAddToCart.click();
    }

    public void gotoCart() {
        this.buttonGoToCart.click();
    }

    public void checkCountProduct() {
        assertEquals("ЖЕНСКИЕ ПЛАВКИ PRINTED BEACH CLASSICS", this.labelNamePructInCart.getText());
        assertEquals("1", this.inputCountProductInCart.getValue());
    }

    public void checkSelectSize(){
        this.errorMessage.exists();
    }

    public void deleteProductFromCart(){
        this.buttonDeleteProduct.click();
    }

    public void checkDeletingProduct(){
        this.infoMessageProductDelete.exists();
        assertEquals("ВАША КОРЗИНА ПУСТА.",this.infoMessageProductDelete.getText());
    }

}
