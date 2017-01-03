package generator;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.NullProgressCallback;

public class Generator {
	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		String path = Generator.class.getResource("/generatorConfig.xml").getFile();
		File configFile = new File(path);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config;
		try {
			config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(!overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(new NullProgressCallback());

		} catch (IOException | XMLParserException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		System.out.println("############warnings:\r\n"+warnings);
	}
	// warnings: Table Configuration local-test.user matched more than one table
	// 解決方法
}