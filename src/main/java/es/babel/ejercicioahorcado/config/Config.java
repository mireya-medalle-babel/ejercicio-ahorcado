package es.babel.ejercicioahorcado.config;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "es.babel.ejercicioahorcado")
public class Config {

    private static final String CONFIGURATION_FILE = "config.properties";
    private static final int DEFAULT_TRIES = 8;
    private static final String TRIES_KEY = "tries";
    private Properties configuration;

    private void loadCofig() {
        configuration = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(CONFIGURATION_FILE);

        try (InputStreamReader configReader = new InputStreamReader(inputStream)) {
            configuration.load(configReader);
        } catch(IOException e) {
            //
        }
    }

    public Config() {
        loadCofig();
    }

    public int getDefaultTries() {
        try {
            return Integer.parseInt(configuration.getProperty(TRIES_KEY));
        } catch (Exception e) {
            return DEFAULT_TRIES;
        }
    }

}
