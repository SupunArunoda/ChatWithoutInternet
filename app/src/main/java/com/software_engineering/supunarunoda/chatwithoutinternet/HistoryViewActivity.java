package com.software_engineering.supunarunoda.chatwithoutinternet;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.software_engineering.supunarunoda.chatwithoutinternet.data.DB.SQLChatDAO;
import com.software_engineering.supunarunoda.chatwithoutinternet.data.model.Chat;

import java.util.ArrayList;

/**
 * Created by Supun on 6/14/2016.
 */


public class HistoryViewActivity extends Activity {
    String chat_name;
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    private TextView namechat;
    SQLChatDAO sqlChatDAO;
    ArrayList<String> chatdatalist;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);
        mainListView = (ListView) findViewById(R.id.history_view);
        namechat=(TextView) findViewById(R.id.historyViewtext);
        chat_name = (String) getIntent().getExtras().get("chatname");
        chatdatalist=(ArrayList)getIntent().getExtras().get("chatdata");

        listAdapter = new ArrayAdapter<String>(this, R.layout.list_row_history, chatdatalist);

        mainListView.setAdapter( listAdapter );
    }
}
