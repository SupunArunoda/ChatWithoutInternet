package com.software_engineering.supunarunoda.chatwithoutinternet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.software_engineering.supunarunoda.chatwithoutinternet.data.DB.SQLChatDAO;
import com.software_engineering.supunarunoda.chatwithoutinternet.data.model.Chat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Supun on 6/14/2016.
 */
public class ChatHistoryActivity extends Activity{

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    SQLChatDAO sqlChatDAO;
    ArrayList<String> planetList;
    ArrayList<String> chatDataList;
    ArrayList<Chat> chatList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_history);
        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.chat_history );
        sqlChatDAO=new SQLChatDAO();
        chatList=sqlChatDAO.getChatList();

        planetList = new ArrayList<String>();
        for(Chat c:chatList){
            planetList.add(c.getChat_name());
        }
        Set<String> hs = new HashSet<>();
        hs.addAll(planetList);
        planetList.clear();
        planetList.addAll(hs);
        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_row, planetList);

        mainListView.setAdapter( listAdapter );

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String chatname=(mainListView.getItemAtPosition(position)).toString();
                chatDataList= new ArrayList<String>();
                for(Chat c:chatList){
                    if(chatname.equals(c.getChat_name())){
                        chatDataList.add(c.getChat_data());
                    }
                }
                Intent intent = new Intent(ChatHistoryActivity.this, HistoryViewActivity.class);
                intent.putExtra("chatname",chatname);
                intent.putStringArrayListExtra("chatdata",chatDataList);
                startActivity(intent);

            }
        });
    }

    }
