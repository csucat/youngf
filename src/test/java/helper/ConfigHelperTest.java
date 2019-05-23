package helper;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigHelperTest {

    @Test
    public void getJdbcDriver() {
        System.out.println(ConfigHelper.getJdbcDriver());
    }

    @Test
    public void getJdbcUrl() {
        System.out.println(ConfigHelper.getJdbcUrl());
    }

    @Test
    public void getJdbcUsername() {
        System.out.println(ConfigHelper.getJdbcUsername());
    }

    @Test
    public void getJdbcPassword() {
        System.out.println(ConfigHelper.getJdbcPassword());
    }

    @Test
    public void getAppBasePackage() {
        System.out.println(ConfigHelper.getAppBasePackage());
    }

    @Test
    public void getAppJspPath() {
        System.out.println(ConfigHelper.getAppJspPath());
    }

    @Test
    public void getAppAssetPath() {
        System.out.println(ConfigHelper.getAppAssetPath());
    }
}