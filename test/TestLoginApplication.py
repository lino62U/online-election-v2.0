import time
import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

class TestLoginApplication(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # Configurar el WebDriver antes de todas las pruebas
        # Se ejecuta solo una vez
        pass

    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(10)
        self.driver.get("http://localhost:5173/")
        self.driver.maximize_window()

        # Click on Login Button
        self.driver.find_element(By.XPATH, "//*[@id=\"root\"]/div/div[1]/div/a[2]").click()

        # Limpiar los campos de entrada antes de cada prueba
        try:
            # Limpiar los campos de entrada
            self.driver.find_element(By.NAME, "userName").clear()
            self.driver.find_element(By.NAME, "password").clear()
        except Exception as e:
            print("Error al limpiar campos de entrada:", e)

    def test_role_user(self):
        username = "aldito"
        password = "12345"

        # Ingresar el campo de usuario
        self.driver.find_element(By.NAME, "userName").send_keys(username)

        # Ingresar el campo de la contrasena
        self.driver.find_element(By.NAME, "password").send_keys(password)

        # Click login
        self.driver.find_element(By.XPATH, "//*[@id='root']/div/div/div[3]/button").click()

        time.sleep(2)

        # Get the Result Text based on its xpath
        result = self.driver.find_element(By.XPATH, "//*[@id=\'root\']/div/div[1]/div[1]").text

        # assert the value of result
        self.assertEqual("Bienvenido " + username, result)

    def test_role_admin(self):
        username = "gustav"
        password = "12345"

        # Ingresar el campo de usuario
        self.driver.find_element(By.NAME, "userName").send_keys(username)

        # Ingresar el campo de la contrasena
        self.driver.find_element(By.NAME, "password").send_keys(password)

        # Click login
        self.driver.find_element(By.XPATH, "//*[@id='root']/div/div/div[3]/button").click()

        time.sleep(2)

        # Get the Result Text based on its xpath
        result = self.driver.find_element(By.XPATH, "//*[@id=\'root\']/div/div[1]/div[1]").text

        # assert the value of result
        self.assertEqual("Bienvenido " + username, result)

    def test_user_invalid(self):
        username = "carlos"
        password = "12345"

        # Ingresar el campo de usuario
        self.driver.find_element(By.NAME, "userName").send_keys(username)

        # Ingresar el campo de la contrasena
        self.driver.find_element(By.NAME, "password").send_keys(password)

        # Click login
        self.driver.find_element(By.XPATH, "//*[@id='root']/div/div/div[3]/button").click()

        time.sleep(2)

        # Get the Result Text based on its xpath
        result = self.driver.find_element(By.XPATH, "//*[@id=\'root\']/div/div/h1").text

        # assert the value of result
        self.assertEqual("Credenciales inválidas", result)

    def tearDown(self):
        # No es necesario hacer nada aquí, ya que la limpieza se realiza en tearDownClass
        if self.driver:
            self.driver.close()
            self.driver.quit()

    @classmethod
    def tearDownClass(cls):
        # Cerrar el WebDriver después de todas las pruebas
        pass

if __name__ == "__main__":
    unittest.main()
