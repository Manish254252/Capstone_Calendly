package com.automation.utils;

import com.automation.pages.BasePage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigWriter {

    public void writeToPropertiesFile( String key, String value) {
        Properties properties = new Properties();
        String filePath = "src/test/resources/Config/A.properties";
        try (FileInputStream in = new FileInputStream(filePath)) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            // Set the key-value pair
            properties.setProperty(key, value);

            // Save the properties to the specified file
            properties.store(out, "Updated properties file");
            System.out.println("Property " + key + " has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConfigWriter writer = new ConfigWriter();
        BasePage basePage = new BasePage();
        String key = "invite.email";
        String value = basePage.getRandomEmail();

        writer.writeToPropertiesFile(key, value);
    }
}

