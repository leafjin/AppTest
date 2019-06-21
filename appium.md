강의 내용정리

공유된 문서 : http://bitly.kr/TTA0620

# 1. test 환경 구축
- JDK -> JAVA_HOME Path
- Eclipse -> TestNG,cucumber, Maven
- Appium -> Android Studio

# 2. Appium
- Appium Desktop
- Desire Capability
- session

# 3. Android
- AVD -> adb devices



bitly.kr/TTA0620

강의 중 명령어(텍스트)를 공유하는 등 의사소통을 위한 문서 입니다.

제가 지식이 짧아 답을 드리지 못한 내용은 이후 확인하여,
정리해 놓겠습니다.
또한, 강의 중 미처 전해 드리지 못한 내용도 이곳에 정리해 놓겠습니다.

한주 정도 있다 확인해 보시거나, kchris000@gmail.com 으로 메일 부탁드립니다.

[확인해 볼 것]

Q) Sikuli를 이용한 한글 입력에 문제가 있을 경우, 이를 해결하는 방법은?

   

---------

ㅇemulator -list-avds : 안드로이드 가상장치 확인 명령어

ㅇemulator -avd ‘가상장치명’ : 안드로이드 가상장치 실행
                                                  단, %ANDROID_HOME%\tools 로 이동후 실행하셔야 합니다.

   => 만일, 위 명령어로 AVD 실행시 adb.exe 오류 발생시, Android Studio의 SDK-tools를 업데이트 하신후,
        리부팅하시거나 ‘adb.exe start-server’를 실행하시면 됩니다. 

------ (교안: 71페이지)

•Open Source Automation Tools for iOS and Android
ühttps://afourtech.com/automation-tools-for-ios-and-android-apps/
-Calabash (Android, iOS), Appium (Android, iOS),  Robotium (Android),  Frank (iOS),
UIAutomator (Android) 도구 소개
ü
•공개 SW 테스트
ühttps://www.oss.kr/info_test/show/b3f50bf5-7d67-486f-bc70-d426d6f01dc4
-다양한 공개 SW 기반 테스트 도구 소개
------------- (교안: 77페이지)
•ndroid, iOS, Windows에서 동작하는 Native, Web, Hybrid-App을 WebDriver protocol과
 JSON Wire protocol로 테스트하는 오픈소스 테스트 자동화 프레임워크
ühttp://appium.io/
ühttps://discuss.appium.io/
ühttps://github.com/appium/java-client
https://github.com/serhatbolsu/robotframework-appiumlibrary
------ [교안: 79페이지]
•WebDriver API와 JSON Wire Protocol 지원
üAppium Client Libraries: http://appium.io/downloads
üWebDriver: https://docs.seleniumhq.org/projects/webdriver/
 - http://appium.io/docs/en/drivers/android-uiautomator2/#requirements-and-support
    	-  http://appium.io/docs/en/drivers/ios-xcuitest/
üJSON Wire Protocol: https://github.com/SeleniumHQ/selenium/wiki/JsonWireProtocol
BDD (Cucumber), TDD (Test NG, jUnit), ATDD (Robot framework) 등과 연동


am start -n io.appium.android.apis/.ApiDemos 
C:\MobileAppTest\nodejs

```json
{
"platformName": "Android",
"deviceName": "Pixel 2 API 23",
"uuid": "emulator-5554",
"platformversion": "6.0",
"appPackage": "io.appium.android.apis",
"appActivity": "ApiDemos"
}
```

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>AppiumTest</groupId>
  <artifactId>AppiumTutorial</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <dependencies>
    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>3.141.59</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.testng/testng -->
    <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>6.14.3</version>
      <scope>test</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/io.appium/java-client -->
    <dependency>
      <groupId>io.appium</groupId>
      <artifactId>java-client</artifactId>
      <version>7.0.0</version>
    </dependency>
  </dependencies>
</project>
```

---------- [교안 128페이지]
•Test NG의 주요 노테이션
ü참고 사이트
-https://testng.org/doc/documentation-main.html
-https://www.tutorialspoint.com/testng/index.htm

---------- [교안 129페이지]
•테스트 결과 확인에 사용할 수 있는 함수 (일부 발췌)
ü참고 사이트
-http://appium.io/docs/en/about-appium/api/
-https://static.javadoc.io/org.testng/testng/6.8.17/org/testng/Assert.html
https://testng.org/doc/documentation-main.html#test-results


--------
ㅇ iOS 실제 장치
- https://dejavuqa.tistory.com/66?category=261992

ㅇ Element를 찾는 다양한 방법
https://seleniumbycharan.com/2016/08/07/finding-elements-using-locators-in-appium/




* libimobiledevice
: iphone <=> itunes 통신을 구현한 모듈

