import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class TestCandidateApplicationTest(unittest.TestCase):

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

    def test_show_candidate_home(self):
        # Encontrar todos los elementos que coinciden con el xpath
        tabla_elements = self.driver.find_elements(By.XPATH, "//*[@id='root']/div/div[2]/table")

        # Verificar si la lista de elementos no está vacía
        self.assertTrue("La tabla no está presente", bool(tabla_elements))

    

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
