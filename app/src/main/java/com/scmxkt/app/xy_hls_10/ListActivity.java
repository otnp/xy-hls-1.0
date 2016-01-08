package com.scmxkt.app.xy_hls_10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ListActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, Object>> data;
    private ListView lv;

    private final OkHttpClient client=new OkHttpClient();
    private final Gson gson = new Gson();

    private static final String ACTIVITY_TAG="ListActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lv=(ListView)findViewById(R.id.list2);
        //获取将要绑定的数据设置到data中
        data = getData();

        final ListAdapter myadapter = new ListAdapter(this,data);
        lv.setAdapter(myadapter);
        Log.i(ListActivity.ACTIVITY_TAG, "=========|||@@@@@@@@@@@@@@@@@@@@@@@@@@@====sadf");
        //远程获取json
        try{
            getJsonData();
        }catch (Exception e){
            System.out.println(e);
        }



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent videoShow=new Intent(ListActivity.this,VideoActivity.class);
                //HashMap<String,Integer> map=(HashMap<String, Integer>) parent.getItem(position);
                //final TextView content=(TextView) view.findViewById(R.id.list_info);
                //获得选中项的HashMap对象
                HashMap<String,Object> map=(HashMap<String,Object>)parent.getItemAtPosition(position);
                //HashMap<String,String> map=(HashMap<String, String>) parent.getItemAtPosition(position);
                String url=(String)map.get("info");
                String title=(String)map.get("title");
                videoShow.putExtra("url", url);
                videoShow.putExtra("title", title);
                startActivity(videoShow);
            }
        });



    }


    /**
     * 超时设置
     * @throws Exception
     */
   /* public ConfigureTimeouts() throws Exception {
        client = new OkHttpClient();
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setWriteTimeout(10, TimeUnit.SECONDS);
        client.setReadTimeout(30, TimeUnit.SECONDS);
    }*/
    private void getJsonData()  throws Exception{
        Log.i(ListActivity.ACTIVITY_TAG,"进入到 json 流程");
        //获取远程数据通过okhttp
        Request request = new Request.Builder()
                .url("https://api.github.com/gists/c2a7c39532239ff261be")
                .build();
        Log.w(ListActivity.ACTIVITY_TAG,"远程开始执行到此了");
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        Log.w(ListActivity.ACTIVITY_TAG,"远程请求完成，执行到此了");

        Gist gist = gson.fromJson(response.body().charStream(), Gist.class);
        for (HashMap.Entry<String, GistFile> entry : gist.files.entrySet()) {
            //System.out.println(entry.getKey());
            //System.out.println(entry.getValue().content);
            Log.i(ListActivity.ACTIVITY_TAG, "=========@@@@@@@@@@@@@@@@@@@@@@@@@@@===="+entry.getKey());
            Log.i(ListActivity.ACTIVITY_TAG,"=========!!!!!@@@@@@@@@@@@@@@@@@@@@@@@@@@===="+entry.getValue().content);

        }

    }

    private ArrayList<HashMap<String, Object>> getData()
    {
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map;

        for(int i=0;i<9;i++)
        {
            map = new HashMap<String, Object>();
            map.put("img", R.drawable.btn_play_big);
            map.put("title", "祥云演示课堂"+(i+1)+"");
            if(i==0){
                map.put("info", "http://121.40.67.180:8080/scapee_cms/upload/02/playlist.m3u8");
            }
            else if (i==1){
                map.put("info", "http://121.40.67.180:8080/scapee_cms/upload/04/playlist.m3u8");
            }
            else if (i==2){
                map.put("info", "http://121.40.67.180:8080/scapee_cms/upload/01/playlist.m3u8");
            }
            else if (i==3){
                map.put("info", "http://121.40.67.180:8080/scapee_cms/upload/05/playlist.m3u8");
            }
            else{
                map.put("info", "http://121.40.67.180:8080/scapee_cms/upload/06/playlist.m3u8");
            }

            list.add(map);
        }
        return list;
    }

    static class Gist {
        HashMap<String, GistFile> files;
    }

    static class GistFile {
        String content;
    }

}
