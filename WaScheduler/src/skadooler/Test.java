package skadooler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void whatsapp() throws InterruptedException{
        String File = "Data.txt";
        BufferedReader br = null;
        String line = "";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //creates a driver to open browser with
        String baseUrl = "https://web.whatsapp.com/"; //url to open

        driver.get(baseUrl);  //opens url
        //automation to send predefined messages
        try {
            //reading line by line input from name.txt file
            br = new BufferedReader(new FileReader(File));
            line = br.readLine(); //name of the contact
            String line2 = br.readLine(); // message to send
            String line3 = br.readLine(); // time delay in seconds
            int delay = Integer.parseInt(line3);
            Thread.sleep(delay*1000);  // delay the message by the given amount of seconds.
            driver.findElement(By.xpath("//div[@title=\"Search input textbox\"]")).click(); //Clicks on the name search textbox using xpath
            WebElement ser = driver.findElement(By.xpath("//div[@title=\"Search input textbox\"]")); //creates an object to type into the searchbox
            ser.sendKeys(line + "\n"); //picks the first line from "names.txt" containing the name of the contact and inputs it in the search box
            Thread.sleep(3000);
            WebElement e = driver.findElement(By.xpath("//div[@title=\"Type a message\"]")); //finds the text box to type into and creates object
            e.sendKeys(line2 + "\n"); //inputs line 2 of the names.txt file which contains the text message.
            Thread.sleep(2000);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    

    public static void main(String[] args) throws InterruptedException {
       int choice = 0;
       if (choice == 0)
           whatsapp();
    }
}


