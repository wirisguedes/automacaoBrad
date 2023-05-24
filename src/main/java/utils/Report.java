package utils;

import java.io.File;
import java.io.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Report {

	static WebDriver driver;

	public Report(WebDriver driver) {
		this.driver = driver;
	}

	public static void capturarTela() {
		String dateDay = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(Calendar.getInstance().getTime());
		String nomePrint = "print";

		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "//resources//reports//prints//"
					+ "_" + dateDay + " " + nomePrint + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
