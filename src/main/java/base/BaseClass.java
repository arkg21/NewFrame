package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseClass 

{

	public AppiumDriverLocalService server;
	public AndroidDriver driver;

	public AppiumDriverLocalService getServer()
	{
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				//.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				//.withAppiumJS(new File("C:\\Users\\ArchitKG\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\lib\\main.js"))
				.usingPort(4723)
				.withLogFile(new File("../AppiumDemo/target/ServiceLogs.txt"))
				.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub"));	
	}


	@BeforeTest
	public void startServer() throws MalformedURLException
	{
		server=getServer();
		server.start();
		server.clearOutPutStreams();
		
	}

	@AfterTest
	public void tearDown()
	{
		server.stop();
	}
}
