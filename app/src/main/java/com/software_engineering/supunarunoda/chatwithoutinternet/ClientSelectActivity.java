package com.software_engineering.supunarunoda.chatwithoutinternet;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.software_engineering.supunarunoda.chatwithoutinternet.wifimanager.ClientScanResult;
import com.software_engineering.supunarunoda.chatwithoutinternet.wifimanager.WifiApiManager;

import java.util.ArrayList;

public class ClientSelectActivity  extends Activity {


    private String username;

    private WifiApiManager wifiApManager;
    private String[] values;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    Intent i;

    //-------------- Client

    TextView textPort;

    static final int SocketServerPORT = 8080;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_sharing);

        wifiApManager = new WifiApiManager(this);
        listView = (ListView) findViewById(R.id.listView2);

        username = (String) getIntent().getExtras().get("name");

        textPort = (TextView) findViewById(R.id.port);
        textPort.setText("port: " + SocketServerPORT);

        SelectClient sendImage = new SelectClient();
        sendImage.execute((Void) null);

    }



    private class SelectClient extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            final ArrayList<ClientScanResult> clients = wifiApManager.getClientList(false);


            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    ClientScanResult clientScanResult;
                    values = new String[clients.size()];
                    for (int i = 0; i < clients.size(); i++) {
                        clientScanResult = clients.get(i);
                        values[i] = "IpAddress: " + clientScanResult.getIpAddress();//store client's ip addresses in values array
                    }
                    adapter = new ArrayAdapter<>(ClientSelectActivity.this, R.layout.list_white_text, R.id.list_content, values);
                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getApplicationContext(), clients.get(position).getIpAddress(), Toast.LENGTH_SHORT).show();

                            i = new Intent(ClientSelectActivity.this, PrivateChatActivity.class);
                            i.putExtra("ipAddress",clients.get(position).getIpAddress());
                            i.putExtra("name", username);
                            startActivity(i);

                        }
                    });
                }
            });
            return true;
        }
    }




}