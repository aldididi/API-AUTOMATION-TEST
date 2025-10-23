package apiengine;

import utils.ConfigReader;

public class Endpoints {
    public static final String BASEURL = ConfigReader.getProperty("base.url");
    public static final String GETUSER = ConfigReader.getProperty("getUser.path");
}
