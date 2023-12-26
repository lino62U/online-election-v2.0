package com.selenium.test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestCandidateApplication {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        // Configurar el WebDriver antes de todas las pruebas
        // Se ejecuta solo una vez
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:5173/");
        driver.manage().window().maximize();
        
    }

    @Test
    public void testShowCandidateHome() {
        
        // Encontrar todos los elementos que coinciden con el xpath
        List<WebElement> tablaElements = driver.findElements(By.xpath("//*[@id='root']/div/div[2]/table"));

        // Verificar si la lista de elementos no está vacía
        assertTrue("La tabla no está presente", !tablaElements.isEmpty());
    }


    @Test
    public void testErrorFetchShowCandidateHome() {
        
        // Encontrar todos los elementos que coinciden con el xpath
        String error = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/p")).getText();

        // Verificar si la lista de elementos no está vacía
        assertEquals("Conexión a BD incorrecta",error);
    }

   
    @After
    public void tearDown() {
        // No es necesario hacer nada aquí, ya que la limpieza se realiza en tearDownClass
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @AfterClass
    public static void tearDownClass() {
        // Cerrar el WebDriver después de todas las pruebas
        
    }
}
