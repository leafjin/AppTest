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
	  
	  // Android Virtual Device 속성 추가
	  capabilities.setCapability("platformName","Android");
	  capabilities.setCapability("deviceName","Pixel 2 API 23");
	  capabilities.setCapability("avd","Pixel_2_API_23");
	  capabilities.setCapability("platformversion","6.0");
	  // 테스트 후 APK를 삭제하기 위한 속성
	  capabilities.setCapability("noReset","false");
	  capabilities.setCapability("fullReset","true");

	  // APK 설치 및 실행을 위한 속성
	  capabilities.setCapability("app", "C:\\MobileAppTest\\workspace\\apk\\app-debug.apk");
	  capabilities.setCapability("appPackage", "io.appium.android.apis");
	  capabilities.setCapability("appActivity", "ApiDemos"); 
	  
	  // Appium 서비스 시작
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
	  
	  // Appium 서비스 종료
	  service.stop();
	  
	  // Appium은 Android Virtual Device를 종료하는 기능을 제공하지 않으므로,
	  // 필요할 경우, adb 명령으로 직접 종료 필요 (다음 코드 참고)
	  try {
		Runtime.getRuntime().exec("cmd.exe /c adb -s emulator-5554 emu kill");
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
  }
  
  @Test
  public void editText() {
	  
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
