To start testing:

A) locally

1. Run an emulator
2. Run Appuim server
3. mvn -P web test to run web tests
4. mvn -P native test to run native tests


B) in the cloud

1. Login to mobilecloud.epam.com
2. Pick a mobile device
3. Fill in your epam cloud token into property in pom.xml (make sure that it doesn't contain forward slashes or plus signes, they should be replaced by %2F and %2B respectively. You can use TokenConverter class to do it programmatically).
4. Insert device id/udid into udid parameter of the corresponding TNG.xml file
5. Install EPAMTestApp.ipa/EPAMTestApp.apk to IOS/Android device
6. mvn -P cloudWebAndroid test to run cloud web test on Android device
7. mvn -P cloudWebIOS test to run cloud web test on IOS device
8. mvn -P cloudNativeAndroid test to run cloud native test on Android device
9. mvn -P cloudNativeIOS test to run cloud native test on IOS device
