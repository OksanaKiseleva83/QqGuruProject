package testsUI.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InternetStorePage {

    private String baseURL;

    private SelenideElement
            beachWearLink = $(by("aria-controls", "aria-control-swim")),
            linkBikiniWearBottom = $(by("data-category-id", "swim_bikini-bottoms")),  // todo linkBikiniWearBottom -> bikiniWearBottomLink
            linkChoiceProduct = $(byLinkText("Женские плавки Printed Beach Classics")),
            buttonSelectSize = $(".r-dropdown-sizes-init"),
            buttonSize = $(by("data-attribute-value-id", "xs")),
            buttonAddToCart = $(".add-to-cart-btn"),
            buttonGoToCart = $(".r-bh-panel-wrapper .link2cart"),
            inputCountProductInCart = $(".quantityinput"),
            labelNamePructInCart = $(".name:nth-child(1) > a"),
            errorMessage = $(".r-availability-size-error"),
            buttonDeleteProduct = $(".btn-remove"),
            infoMessageProductDelete = $(".cartempty"),
            buttonSale = $(byLinkText("SALE")),
            columnSale = $("#leftcolumn"),
            labelTableSale = $(".js-search-replace-content"),
            buttonHelp = $(".r-bh-panel-action"),
            panelHelp = $(".r-bh-panel-wrapper > .helpleft-container .r-bh-panel-titles");


    @Step("Выбор товара и добавление его в корзину")
    public void selectBikiniWearBottom() {
        beachWearLink.click();
        linkBikiniWearBottom.click();
        linkChoiceProduct.click();
        buttonSelectSize.click();
        buttonSize.click();
        buttonAddToCart.click();
    }

    /**
     * добавление товара в корзину без выбора размера
     */
    public void makeOrderWithoutSize(){
        beachWearLink.click();
        linkBikiniWearBottom.click();
        linkChoiceProduct.click();
        buttonAddToCart.click();
    }

    /**
     * переход в корзину
     */
    public void gotoCart() {
        buttonGoToCart.click();
    }

    /**
     * проверка что выбран нужный товар в нужном кол-ве
     */
    public void checkCountProduct() {
        labelNamePructInCart.shouldHave(text("ЖЕНСКИЕ ПЛАВКИ PRINTED BEACH CLASSICS"));
        inputCountProductInCart.shouldHave(value("1"));
    }

    /**
     * проверка появления сообщения об ошибке, если не выбран размер при попытке добавт товар в корзину
     */
    public void checkSelectSize(){
        errorMessage.shouldHave(value("1"));
    }

    /**
     * удаление товара из корзины
     */
    public void deleteProductFromCart(){
        buttonDeleteProduct.click();
    }

    /**
     * проверка товар удален из корзины
     */
    public void checkDeletingProduct(){
        infoMessageProductDelete.shouldHave(text("ВАША КОРЗИНА ПУСТА."));
    }

    /**
     * переход в раздел Скидки
     */
    public void goToSaleDepartment(){
        buttonSale.click();
    }

    /**
     * Проверка, что открыта страница Sale
     */
    public void checkSalePage(){
        columnSale.shouldBe(visible);
        labelTableSale.shouldHave(text("Sale"));
    }

    public void goToHelp(){
        buttonHelp.click();
    }

    public void pageHeplIsOpened(){
        panelHelp.shouldHave(text("НУЖНА ПОМОЩЬ?"));
    }

}
