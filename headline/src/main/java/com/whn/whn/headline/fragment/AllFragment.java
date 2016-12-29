package com.whn.whn.headline.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.whn.whn.headline.DetailActivity;
import com.whn.whn.headline.R;
import com.whn.whn.headline.bean.ReceivedInfo;
import com.whn.whn.headline.http.HttpHelper;

/**
 * Created by whn on 2016/12/23.
 * 用来显示界面的
 */

public class AllFragment extends Fragment {
    private final String type;
    private String url;
    private TextView textView;
    private PullToRefreshListView ptfListView;
    public ReceivedInfo resultInfo;
    private DetailAdapter detailAdapter;
    private Dialog progressDialog;
    private RelativeLayout failView;

    public AllFragment(String type) {
        this.type = type;
        url = "http://v.juhe.cn/toutiao/index?type=" + type + "&key=5179fabeb9ef2c8abc97da57da976d9f";
    }

    /**
     * 获取控件,并显示
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.layout_listview, null);
        ptfListView = (PullToRefreshListView) view.findViewById(R.id.ptfListView);
        failView = (RelativeLayout) view.findViewById(R.id.loadfail);

        //携带url 跳转详情界面
        ptfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = resultInfo.result.data.get(position-1).url;
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
        return view;
    }


    /**
     * 请求数据更新UI
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requestData();//请求数据

        //下拉刷新重新请求数据
        ptfListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                requestData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }




    /**
     * Adapter
     */
    class DetailAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            if (resultInfo == null) {
                return 0;
            }else{
                return resultInfo.result.data.size();
            }
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if(convertView==null){
                viewHolder = new ViewHolder();
                convertView = View.inflate(getContext(),R.layout.item_listview,null);
                viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.iv_title);
                viewHolder.tvAuthor = (TextView) convertView.findViewById(R.id.tv_author);
                viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
                viewHolder.ivPic = (SimpleDraweeView) convertView.findViewById(R.id.iv_pic);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            ReceivedInfo.ResultEntity.DataEntity dataEntity = resultInfo.result.data.get(position);
            viewHolder.tvTitle.setText(dataEntity.title);
            viewHolder.tvAuthor.setText(dataEntity.author_name);
            viewHolder.tvTime.setText(dataEntity.date);

            viewHolder.ivPic.setImageURI(dataEntity.thumbnail_pic_s);

            return convertView;
        }
    }

    static class ViewHolder{
        TextView tvTitle;
        TextView tvAuthor;
        TextView tvTime;
        SimpleDraweeView ivPic;
    }


    /**
     * 网络请求数据
     */
    private void requestData() {
        HttpHelper httpHelper = new HttpHelper();
        httpHelper.execGet(url, new HttpHelper.HttpCallback() {
            @Override
            public void onSuccess(String data) {
                //可以更新UI
                Gson gson = new Gson();
                resultInfo = gson.fromJson(data, ReceivedInfo.class);
                //数据展示
                detailAdapter = new DetailAdapter();
                ptfListView.setAdapter(detailAdapter);
                ptfListView.onRefreshComplete();
                failView.setVisibility(View.GONE);
            }

            @Override
            public void onFail(Exception e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
                ptfListView.onRefreshComplete();
            }
        });
    }
}
