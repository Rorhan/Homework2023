package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;



public class ToDoListPage extends PageObject{

    @FindBy(id = "to-do-list")
    private WebElement todoList;

    @FindBy(tagName = "input")
    private static WebElement addNewTodo;

    @FindBy(xpath = "//ul/li")
    private static List<WebElement> liste;



        //********** Method ************

    public void clickTodoList(){
        scrollInto(todoList);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();",todoList);
    }

    public static void sendNewTodo(String todoList){
        addNewTodo.sendKeys(todoList, Keys.ENTER);
    }

    public static List<String> listText(){
        List<String> listTodo = new ArrayList<>();
        for (WebElement element : liste) {
            listTodo.add(element.getText());
        }
        return listTodo;
    }

}
