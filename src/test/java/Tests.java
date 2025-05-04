import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Tests {


    public static void main(String[] args) {
        int a[] = {1,2,3,5,5};
        int len = a.length;

        for (int i=0;i<=len-1;i++)
        {
            System.out.print(a[i]);
        }

}
}
