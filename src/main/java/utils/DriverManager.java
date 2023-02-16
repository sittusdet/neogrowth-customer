package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    LoggerManager logger = new LoggerManager();

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();
        PropertyManager props = new PropertyManager();

        if(driver == null){
            try{
                logger.log().info("initializing Appium driver");
                switch(params.getPlatformName()){
                    case "Android":
                        driver = new AndroidDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                        break;
                    case "iOS":
                        driver = new IOSDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }
                logger.log().info("Driver is initialized");
                this.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                logger.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
                throw e;
            }
        }

    }

}
