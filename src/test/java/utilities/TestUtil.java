package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import baseClass.BaseClass;

public class TestUtil extends BaseClass{
	 private Properties prop;

	    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
	        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
	        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
	                + ".png";
	        File finalDestination = new File(destination);
	        FileUtils.copyFile(source, finalDestination);
	        return destination;
	    }

	    public Properties init_Properties(String fileName){
	        prop = new Properties();
	        try {
	            FileInputStream inputStream=new FileInputStream("./src/test/resources/propertyFiles/"+ fileName +".properties");
	            prop.load(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return prop;
	    }

	    public void update_Properties(String fileName, String key, String value){
	        prop = new Properties();
	        try {
	            FileInputStream inputStream=new FileInputStream("./src/test/resources/propertyFiles/"+ fileName +".properties");
	            prop.load(inputStream);
	            inputStream.close();
	            FileOutputStream outputStream = new FileOutputStream("./src/test/resources/propertyFiles/"+ fileName +".properties");
	            prop.setProperty(key,value);
	            prop.store(outputStream,"Property file has been updated : "+key+" updated");
	            outputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static String getRandomString(final Integer size) {
	        return RandomStringUtils.randomAlphabetic(size);
	    }

	    public static String getSerializedJson(Object obj) throws JsonProcessingException {
	        ObjectMapper mapper = new ObjectMapper();
	        return mapper.writeValueAsString(obj);
	    }
}
