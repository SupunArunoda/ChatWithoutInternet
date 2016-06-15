package com.software_engineering.supunarunoda.chatwithoutinternet;
import static android.support.test.InstrumentationRegistry.getTargetContext;

import android.database.sqlite.SQLiteDatabase;
import android.support.test.runner.AndroidJUnit4;

import com.software_engineering.supunarunoda.chatwithoutinternet.data.DB.DBAccess;
import com.software_engineering.supunarunoda.chatwithoutinternet.data.DB.SQLChatDAO;
import com.software_engineering.supunarunoda.chatwithoutinternet.data.model.Chat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
/**
 * Created by Supun on 6/15/2016.
 */
@RunWith(AndroidJUnit4.class)
public class DBAccessTest {

    SQLiteDatabase database;
    @Before
    public void setup() throws Exception{
    getTargetContext().deleteDatabase(DBAccess.DATABASE_NAME);
     database= DBAccess.getWritableDatabase();

    }

    @After
    public void down()throws Exception{
       database.close();
    }

    @Test
    public void addChatTest(){
        SQLChatDAO chatDAO=new SQLChatDAO();
        chatDAO.addChat(new Chat("MyFirst", "Hello ! How are u?"));

        ArrayList<Chat> mylist=chatDAO.getChatList();

        assertThat(mylist.size(),is(1));
        assertTrue(mylist.get(0).getChat_name().equals("MyFirst"));
        assertTrue(mylist.get(0).getChat_data().equals("Hello ! How are u?"));

    }

    @Test
    public void getChatListTest() {

        SQLChatDAO chatDAO=new SQLChatDAO();
        chatDAO.addChat(new Chat("MySecond", "Hi, Whats up?"));

        ArrayList<Chat> mylist=chatDAO.getChatList();
        assertTrue(mylist.get(0).getChat_data().equals("Hi, Whats up?"));
        assertTrue(mylist.get(0).getChat_name().equals("MySecond"));
    }
    }
