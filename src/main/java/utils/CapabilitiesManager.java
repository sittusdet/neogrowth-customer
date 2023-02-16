package utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {

    LoggerManager logger = new LoggerManager();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try{
            logger.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
            caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

            switch(params.getPlatformName()){
                case "Android":
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());

                    //String androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "CustomerApp.apk";
                    logger.log().info("appUrl is" + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    break;
                case "iOS":
                    //need to implement
            }
            return caps;
        } catch(Exception e){
            e.printStackTrace();
            logger.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}
