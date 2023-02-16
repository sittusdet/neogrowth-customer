package utils;

public class GlobalParams {
    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> globalWait = new ThreadLocal<String>();

    public String getGlobalWait() {
        return globalWait.get();
    }

    public void setGlobalWait(String waitTime) {
        globalWait.set(waitTime);
    }

    public void setPlatformName(String platformName1){
        platformName.set(platformName1);
    }

    public String getPlatformName(){
        return platformName.get();
    }

    public String getUDID() {
        return udid.get();
    }

    public void setUDID(String udid2) {
        udid.set(udid2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemPort2) {
        systemPort.set(systemPort2);
    }



    public void intializedGlobalParams(){
        this.setPlatformName(System.getProperty("platformName", "Android"));
        this.setUDID(System.getProperty("udid", "emulator-5554"));
        this.setDeviceName(System.getProperty("deviceName", "Android12"));
//        this.setSystemPort(System.getProperty("systemPort", "10000"));
        this.setGlobalWait(System.getProperty("globalWait", "50000"));
    }

}
