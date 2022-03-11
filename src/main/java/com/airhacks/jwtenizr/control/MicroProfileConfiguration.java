
package com.airhacks.jwtenizr.control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author airhacks.com
 */
public interface MicroProfileConfiguration {

    static final String MP_CONFIG_FILENAME = "microprofile-config.properties";

    public static void generate(String publicKey) throws IOException {
        String location = Configuration.mpConfigurationLocation();
        String issuer = Configuration.issuer();
        String algorithm = Configuration.algorithm();
        Properties properties = new Properties();
        properties.setProperty("mp.jwt.verify.publickey", publicKey);
        properties.setProperty("mp.jwt.verify.issuer", issuer);
        properties.setProperty("mp.jwt.verify.publickey.algorithm", algorithm);
        Path path = Paths.get(location, MP_CONFIG_FILENAME);
        File configurationLocation = path.toFile();
        Terminal.info("Writing mpconfig to: " + MP_CONFIG_FILENAME);
        properties.store(new FileWriter(configurationLocation), "generated by jwtenizr");
    }

}
