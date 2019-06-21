package AppiumTutorial;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class AndroidTestExtServer {
	
	AppiumDriverLocalService service;
	AndroidDriver<AndroidElement> driver;
	
  @Test
  public void f() {
	  System.out.println("AndroidTest ExtService version");
  }
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  
	  // Android Virtual Device �Ӽ� �߰�
	  capabilities.setCapability("platformName","Android");
	  capabilities.setCapability("deviceName","Pixel 2 API 23");
	  capabilities.setCapability("avd","Pixel_2_API_23");
	  capabilities.setCapability("platformversion","6.0");
	  // �׽�Ʈ �� APK�� �����ϱ� ���� �Ӽ�
	  capabilities.setCapability("noReset","false");
	  capabilities.setCapability("fullReset","true");

	  // APK ��ġ �� ������ ���� �Ӽ�
	  capabilities.setCapability("app", "C:\\MobileAppTest\\workspace\\apk\\app-debug.apk");
	  capabilities.setCapability("appPackage", "io.appium.android.apis");
	  capabilities.setCapability("appActivity", "ApiDemos"); 
	  
	  // Appium ���� ����
	  AppiumServiceBuilder builder;
	  builder = new AppiumServiceBuilder();
	  builder.withIPAddress("127.0.0.1");
	  builder.usingPort(4723);
	  builder.withCapabilities(capabilities);
	  builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
	  builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
	  service = AppiumDriverLocalService.buildService(builder);
	  service.start();
	 
	  driver = new AndroidDriver<AndroidElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
	  // Appium ���� ����
	  service.stop();
	  
	  // Appium�� Android Virtual Device�� �����ϴ� ����� �������� �����Ƿ�,
	  // �ʿ��� ���, adb ������� ���� ���� �ʿ� (���� �ڵ� ����)
	  try {
		Runtime.getRuntime().exec("cmd.exe /c adb -s emulator-5554 emu kill");
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
  }
  
  @Test
  public void editText() {
	  
	  // Appium inspector�� recording ��ɿ��� ������ script
	  MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Preference");
	  el1.click();
	  MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("4. Default values");
	  el2.click();
	  //MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]");
	  // -> recording�� script�� ���忡 ���� �ٸ� �Լ��� ��ü
	  MobileElement el3 = driver.findElementByAndroidUIAutomator("text(\"Edit text preference\")");
	  el3.click();
	  MobileElement el4 = (MobileElement) driver.findElementById("android:id/edit");
	  el4.clear();
	  //el4.sendKeys("Dog");
	  el4.setValue("Dog");
	  MobileElement el5 = (MobileElement) driver.findElementById("android:id/button1");
	  el5.click();

	// ��� ����: �ٽ� Edit â�� ����� �� ������ ���ڿ�(Dog)�� ǥ�õǴ��� assert�� Ȯ��
	  el3.click();
	  assert el4.getText().equals("Dog"):"Actual value is : "+el4.getText()+" did not match with expected value: Dog";
  }

}
