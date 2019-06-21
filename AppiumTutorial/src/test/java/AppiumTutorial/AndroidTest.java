package AppiumTutorial;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class AndroidTest {
	
	AndroidDriver<AndroidElement> driver;
	
  @Test
  public void f() {
	  System.out.println("@Test NC - Default TC");
  }
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  System.out.println("@BeforeTest");
	  // ADV 실행
	  // Appium  server 실행
	  
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("platformName","Android");
	  capabilities.setCapability("deviceName","Pixel 2 API 23");
	  capabilities.setCapability("uuid","emulator-5554");
	  capabilities.setCapability("platformversion","6.0");
	  capabilities.setCapability("appPackage", "io.appium.android.apis");
	  capabilities.setCapability("appActivity", "ApiDemos"); 
	 
	   driver = new AndroidDriver<AndroidElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("@AfterTest");
	  // Appium server 종료
	  // ADV 종료
	  
	  driver.quit();
  }
  
  @Test
  public void editText() {
	  System.out.println("@Test : EditText");
	  
	  // Appium inspector의 recording 기능에서 가져온 script
	  MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Preference");
	  el1.click();
	  MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("4. Default values");
	  el2.click();
	  //MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]");
	  // -> recording한 script의 권장에 따라 다른 함수로 대체
	  MobileElement el3 = driver.findElementByAndroidUIAutomator("text(\"Edit text preference\")");
	  el3.click();
	  MobileElement el4 = (MobileElement) driver.findElementById("android:id/edit");
	  el4.clear();
	  //el4.sendKeys("Dog");
	  el4.setValue("Dog");
	  MobileElement el5 = (MobileElement) driver.findElementById("android:id/button1");
	  el5.click();

	// 결과 점검: 다시 Edit 창을 띄웠을 때 설정한 문자열(Dog)가 표시되는지 assert로 확인
	  el3.click();
	  assert el4.getText().equals("Dog"):"Actual value is : "+el4.getText()+" did not match with expected value: Dog";
  }

}
