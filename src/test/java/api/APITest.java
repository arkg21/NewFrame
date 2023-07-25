package api;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import base.BaseClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class APITest extends BaseClass
{
	@Test
	public void createTest() throws MalformedURLException, InterruptedException
	{

		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		dc.setCapability(MobileCapabilityType.UDID, "97d179ec");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus 7");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability("appPackage", "com.superapp");
		dc.setCapability("appActivity", ".MainActivity");

		URL url= new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		
//		adb uninstall io.appium.settings
//		adb uninstall io.appium.uiautomator2.server
//		adb uninstall io.appium.uiautomator2.server.test   
//		adb uninstall io.appium.unlock
		
		
//		driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/continue_button")).click();
//		Thread.sleep(3000);
//		driver.findElement(AppiumBy.id("android:id/button1")).click();
//		
//		driver.findElement(AppiumBy.accessibilityId("Animation")).click();
		
		
	}
}
