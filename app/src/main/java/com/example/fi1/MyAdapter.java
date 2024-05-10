package com.example.fi1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> mData; // 假设你的数据是一个String列表

    // 构造函数，传入数据
    public MyAdapter(List<String> data) {
        mData = data;
    }

    // 创建新的列表项视图（由布局管理器调用）
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    // 将数据绑定到列表项视图上（由布局管理器调用）
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = mData.get(position);
        holder.bind(item);
    }

    // 返回数据项数量（由布局管理器调用）
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // ViewHolder类，保存对列表项视图中控件的引用
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_view);
        }

        // 绑定数据到控件上
        public void bind(String item) {
            mTextView.setText(item);
        }
    }
}
