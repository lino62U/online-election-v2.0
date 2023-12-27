import time
import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By

class TestElectorVoteApplication(unittest.TestCase):

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

        # Click on Math Calculators
        self.driver.find_element(By.XPATH, "//*[@id=\"root\"]/div/div[1]/div/a[2]").click()

        # Limpiar los campos de entrada antes de cada prueba
        try:
            # Limpiar los campos de entrada
            self.driver.find_element(By.NAME, "userName").clear()
            self.driver.find_element(By.NAME, "password").clear()
        except Exception as e:
            print("Error al limpiar campos de entrada:", e)

        username = "lyon"
        password = "12345"
        # Ingresar el campo de usuario
        self.driver.find_element(By.NAME, "userName").send_keys(username)

        # Ingresar el campo de la contrasena
        self.driver.find_element(By.NAME, "password").send_keys(password)

        # Click login
        self.driver.find_element(By.XPATH, "//*[@id='root']/div/div/div[3]/button").click()

    def test_save_vote(self):
        time.sleep(2)

        # Click en el primer candidato
        self.driver.find_element(By.XPATH, "//*[@id=\'root\']/div/div[2]/table/tbody/tr[1]/td[3]/button").click()

        # Click en el boton de votar
        self.driver.find_element(By.XPATH, "//*[@id=\'root\']/div/div[3]/button").click()

        time.sleep(2)

        # click en el boton de verificacion
        self.driver.find_element(By.XPATH, "//*[@id=\'root\']/div/div[4]/div/div/div[2]/button[1]").click()

        time.sleep(2)

        # Get the Result Text based on its xpath
        result = self.driver.find_element(By.XPATH, "//*[@id=\'root\']/div/div[6]/div/div/h2").text

        time.sleep(2)

        # assert the value of result
        self.assertEqual("Voto registrado", result)

    def test_save_vote_repit_user(self):
        time.sleep(2)

        # Click en el primer candidato
        self.driver.find_element(By.XPATH, "//*[@id=\'root\']/div/div[2]/table/tbody/tr[1]/td[3]/button").click()

        time.sleep(2)

        # Click en el boton de votar
        self.driver.find_element(By.XPATH, "//*[@id=\'root\']/div/div[3]/button").click()

        time.sleep(2)

        # click en el boton de verificacion
        self.driver.find_element(By.XPATH, "//*[@id=\'root\']/div/div[4]/div/div/div[2]/button[1]").click()

        time.sleep(2)

        # Get the Result Text based on its xpath
        result = self.driver.find_element(By.XPATH, "//*[@id=\'root\']/div/div[6]/div/div/h2").text

        time.sleep(2)

        # assert the value of result
        self.assertEqual("El voto es unico", result)

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
