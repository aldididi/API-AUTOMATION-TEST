package apiengine;

import org.example.utils.ConfigReader;

public class Endpoints {
    public static final String BASEURL = ConfigReader.getProperty("base.url");
    public static final String GETUSER = ConfigReader.getProperty("getUser.path");
    public static final String APPID = ConfigReader.getProperty("appid");
    public static final String CREATEUSER = ConfigReader.getProperty("createUser.path");


}
