package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    private static Properties props = new Properties();
    LoggerManager logger = new LoggerManager();

    public Properties getProps() throws IOException {
        InputStream is = null;
        String propsFileName = "config.properties";

        if(props.isEmpty()){
            try{
                logger.log().info("loading config properties");
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                logger.log().fatal("Failed to load config properties. ABORT!!" + e.toString());
                throw e;
            } finally {
                if(is != null){
                    is.close();
                }
            }
        }
        return props;
    }

}
