package com.selenium.test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TestLoginApplication {
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
        // Click on Login Button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/a[2]")).click();
        
        // Limpiar los campos de entrada antes de cada prueba
        try {
            // Limpiar los campos de entrada
            driver.findElement(By.name("userName")).clear();
            driver.findElement(By.name("password")).clear();
        } catch (Exception e) {
            System.err.println("Error al limpiar campos de entrada: " + e.getMessage());
        }
    }

    @Test
    public void testRoleUser() {
        
        String username = "aldito";
        String pass = "12345";
        // Ingresar el campo de usuario
        driver.findElement(By.name("userName")).sendKeys(username);

        // Ingresar el campo de la contrasena
        driver.findElement(By.name("password")).sendKeys(pass);

        // Click login
        driver.findElement(By.xpath("//*[@id='root']/div/div/div[3]/button")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the Result Text based on its xpath
        String result = driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[1]")).getText();

        // assert the value of result
        assertEquals("Bienvenido "+ username, result);
    }

    @Test
    public void testRoleAdmin() {
        
        String username = "gustav";
        String pass = "12345";
        // Ingresar el campo de usuario
        driver.findElement(By.name("userName")).sendKeys(username);

        // Ingresar el campo de la contrasena
        driver.findElement(By.name("password")).sendKeys(pass);

        // Click login
        driver.findElement(By.xpath("//*[@id='root']/div/div/div[3]/button")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the Result Text based on its xpath
        String result = driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[1]")).getText();

        // assert the value of result
        assertEquals("Bienvenido " + username, result);
    }

    @Test
    public void testUserInvalid() {
        
        String username = "carlos";
        String pass = "12345";
        // Ingresar el campo de usuario
        driver.findElement(By.name("userName")).sendKeys(username);

        // Ingresar el campo de la contrasena
        driver.findElement(By.name("password")).sendKeys(pass);

        // Click login
        driver.findElement(By.xpath("//*[@id='root']/div/div/div[3]/button")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the Result Text based on its xpath
        String result = driver.findElement(By.xpath("//*[@id=\'root\']/div/div/h1")).getText();

        // assert the value of result
        assertEquals("Credenciales inválidas", result);
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
