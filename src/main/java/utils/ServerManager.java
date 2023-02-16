package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.IOException;

public class ServerManager {
    public static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    LoggerManager logger = new LoggerManager();
    PropertyManager propertyManager= new PropertyManager();

    public AppiumDriverLocalService getServer() {
        return server.get();
    }

    public void startServer() throws IOException {

        AppiumDriverLocalService service;

        service = new AppiumServiceBuilder()
                .withIPAddress(propertyManager.getProps().getProperty("ipAddress"))
                .usingPort(Integer.parseInt(propertyManager.getProps().getProperty("systemPort")))
                .build();
        service.start();

        if (service == null || !service.isRunning()) {
            logger.log().fatal("Appium server not started. ABORT!!!");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
//        server.clearOutPutStreams();
        this.server.set(service);
        logger.log().info("Appium server started");

    }


}
