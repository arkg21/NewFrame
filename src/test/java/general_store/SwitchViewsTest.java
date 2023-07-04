package general_store;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import base.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class SwitchViewsTest extends BaseClass 
{
	
	@Test
	public void verifySwitchView() throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		dc.setCapability(MobileCapabilityType.UDID, "97d179ec");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus 7");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".SplashActivity");

		URL url= new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver =new AndroidDriver(url, dc);
		
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		
		String countryText="text";
		String countName="India";
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+countryText+"(\""+countName+"\"))")).click();
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Archit");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		String shoeText="text";
		String shoeName="Air Jordan 9 Retro";
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+shoeText+"(\""+shoeName+"\"))")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(4000);
		Set<String> contextNames = driver.getContextHandles();
	
		for (String contextName : contextNames) 
		{
			Thread.sleep(7000);
		    System.out.println(contextName);     
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.xpath("//div[@class='SDkEP']")).sendKeys("RCB");
		
	}
}
