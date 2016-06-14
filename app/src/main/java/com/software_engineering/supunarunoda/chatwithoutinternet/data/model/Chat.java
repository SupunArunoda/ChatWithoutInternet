package com.software_engineering.supunarunoda.chatwithoutinternet.data.model;

/**
 * Created by Supun on 6/14/2016.
 */
public class Chat {
    private int chat_id;
    private String chat_name;
    private String chat_data;

    public Chat(String chat_name, String chat_data) {
        this.chat_name = chat_name;
        this.chat_data = chat_data;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public String getChat_data() {
        return chat_data;
    }

    public void setChat_data(String chat_data) {
        this.chat_data = chat_data;
    }
}
