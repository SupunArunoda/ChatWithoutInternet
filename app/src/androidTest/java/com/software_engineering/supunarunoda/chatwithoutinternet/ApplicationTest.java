package com.software_engineering.supunarunoda.chatwithoutinternet;


import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;

import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.test.ActivityInstrumentationTestCase2;
import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
//import org.junit.Test;
//import java.util.regex.Pattern;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(JUnit4.class)
public class ApplicationTest extends ActivityInstrumentationTestCase2 {


    private UiDevice device;

    public ApplicationTest(Class activityClass) {
        super(activityClass);
    }

    public void setUp() {
        //device=device.getInstance(getInstrumentation());
        Assert.assertTrue(true);
    }

    public void testAdd() {
        //device.wait(Until.hasObject(By.text("Create")), 3000);

// Select the button for 9
        //UiObject2 buttonCreate = device.findObject(By.text("Create"));
        //buttonCreate.click();
        Assert.assertTrue(true);

    }

}