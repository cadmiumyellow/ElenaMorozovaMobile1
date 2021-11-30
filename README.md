To start testing:

A) locally

Run an emulator
Run Appuim server
mvn -P web test to run web tests
mvn -P native test to run native tests
B) in the cloud

Login to mobilecloud.epam.com
Pick a mobile device
Fill in your epam cloud token into property in pom.xml
Insert device id/udid into udid parameter of the corresponding TNG.xml file
Install EPAMTestApp.ipa/EPAMTestApp.apk to IOS/Android device
mvn -P cloudWebAndroid test to run cloud web test on Android device
mvn -P cloudWebIOS test to run cloud web test on IOS device
mvn -P cloudNativeAndroid test to run cloud native test on Android device
mvn -P cloudNativeIOS test to run cloud native test on IOS device
