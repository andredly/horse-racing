package com.charniauski.training.horsesrace.services.testutil;

import org.apache.commons.io.FileUtils;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by Andre on 12.11.2016.
 */
@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class XMLDB implements BaseCreator {
    @Override
    public void createRelationDB() {
    }

    @Override
    public void createXMLDB() {
        try {
            File file = new File("D://xmlstorage");
            if (file.exists()&&file.mkdir()) {FileUtils.cleanDirectory(file);}
            FileUtils.copyDirectoryToDirectory(new File("src/test/resources/xmlstorage"),new File("D://"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
