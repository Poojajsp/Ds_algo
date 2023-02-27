package ds_algo_Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
			File src=new File("./Configuration/config.properties");
try {
		FileInputStream fis = new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		}
		
	 catch (Exception e) {
		System.out.println("Exception is "+e.getMessage());
	}
}
	
public String getapplicationURL()
{
	String url=pro.getProperty("baseURL");
	return url;
}
public String gethomepageURL()
{
	String homeurl=pro.getProperty("homepageURL");
	return homeurl;
			
}

public String getusername()
{
String username=pro.getProperty("username");
return username;
}

public String getpassword()
{
String password=pro.getProperty("password");
return password;
}
public String getchromepath()
{
	String chromepath=pro.getProperty("chromepath");
return chromepath;
	
}
public String getfirefox()
{
	String firefox=pro.getProperty("firefoxpath");
return firefox;
	}
public String getmsedge()
{
	String msedge=pro.getProperty("msedgepath");
return msedge;
}
public String getcode() {
String pythoncode=pro.getProperty("code");
return pythoncode;
}
}
