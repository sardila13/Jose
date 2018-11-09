package prueba;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class main {

	public static int ID = 3;
	public static String urlFacebook="https://www.facebook.com";	
	public static String urlSRTA = "http://votaciones.srtacolombia.org/";
	public static String urlVotacion = "http://votaciones.srtacolombia.org/votaciones/quintojurado";

	public static void main(String[] args) throws SQLException, InterruptedException, AWTException, FileNotFoundException {

		//Interaccion_Objeto objeto=new Interaccion_Objeto();
		//objeto.Objeto(url, id_objeto, name_user);
		//--------------
		System.out.println("Termine elprimer llamado--------------------");
		System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");


		//Leer archivo .txt
		File archivoCuentas= new File("data/cuentas.txt");

		Scanner sCuentas = null;


		try{		

			sCuentas = new Scanner(archivoCuentas);
			
			Robot robot=new Robot();

			//Leo Primer Registro del encabezado para conocer la URL
			String linea = sCuentas.nextLine();	//Se guarda la linea leida en un String
			while(linea != "") {
				System.out.println("Entra");
				String[] cuenta = linea.split(";");

				WebDriver driver=new ChromeDriver();
				//driver.get(valoresEncabezado[0]);
				driver.navigate().to(urlFacebook);
				System.out.println("inicio Web driver--------------------");
//				Thread.sleep(3000);
				
				WebElement correo = driver.findElement(By.id("email"));
				correo.sendKeys(cuenta[0]);
				
				WebElement contrasenha = driver.findElement(By.id("pass"));
				contrasenha.sendKeys(cuenta[1]);
				
				WebElement ingreso = driver.findElement(By.id("loginbutton"));
				ingreso.click();
				
				driver.navigate().to(urlSRTA);
				
				Thread.sleep(3000);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(300);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(300);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(300);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(300);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(300);
				robot.keyPress(KeyEvent.VK_ENTER);
			
				Thread.sleep(10000);
				driver.navigate().to(urlVotacion);
				
				Thread.sleep(30000);
				driver.close();
				
				
//				WebElement buttonFB = driver.findElement(By.id("button_facebook"));
//				buttonFB.click();
//				
				linea = sCuentas.nextLine();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
