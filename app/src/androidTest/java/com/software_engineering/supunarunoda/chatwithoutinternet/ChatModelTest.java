package com.software_engineering.supunarunoda.chatwithoutinternet;

import com.software_engineering.supunarunoda.chatwithoutinternet.data.model.Chat;

import junit.framework.Assert;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
/**
 * Created by Supun on 6/15/2016.
 */
public class ChatModelTest {

    @Test
    public void getChatNameTest() {
        Chat chat=new Chat("Chat Room","Hello ! How are u?");
        assertTrue(chat.getChat_name().equals("Chat Room"));
        assertTrue(chat.getChat_data().equals("Hello ! How are u?"));

    }
}
