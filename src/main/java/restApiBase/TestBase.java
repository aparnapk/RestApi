package restApiBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(
					"C:\\Users\\user\\eclipse-workspace\\restApi\\src\\main\\java\\config\\config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
