package api;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import base.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OpenNotificationsTest extends BaseClass
{

	@Test
	public void scrollAction() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		dc.setCapability(MobileCapabilityType.UDID, "97d179ec");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus 7");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");

		URL url= new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		
		driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/continue_button")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Notification")).click();
		driver.findElement(AppiumBy.accessibilityId("IncomingMessage")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Show App Notification")).click();
		driver.openNotifications();
		driver.findElement(AppiumBy.id("android:id/text")).click();
		String message=driver.findElement(AppiumBy.id("io.appium.android.apis:id/message")).getText();
		System.out.println(message);
		
	}
}
