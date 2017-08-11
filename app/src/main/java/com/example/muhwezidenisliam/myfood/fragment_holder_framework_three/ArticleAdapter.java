package com.example.muhwezidenisliam.myfood.fragment_holder_framework_three;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.muhwezidenisliam.myfood.R;
import com.example.muhwezidenisliam.myfood.scroll_view.NonScrollListView;
import com.forcelain.awesomelayoutmanager.AwesomeViewHolder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private static final String TAG = "ArticleAdapter";
    private static final String SCHEME_ASSETS = "assets://";
    private List<Article> articles;
    private OnItemClickListener itemClickListener;
    private View.OnLayoutChangeListener onLayoutChangeListener;
    DataProvider dataProvider;
    Context context;

    String []trial = {""};

    public OnItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_three, parent, false);
        context=parent.getContext();
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArticleViewHolder articleViewHolder, final int position) {
        final Article article = articles.get(position);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context,R.layout.list_view_items, R.id.text_id,article.benefits);
        articleViewHolder.benefits.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter_new = new ArrayAdapter<String>(context,R.layout.list_view_items, R.id.text_id,article.nutrients);
        articleViewHolder.nutrients.setAdapter(arrayAdapter_new);



        new Thread(new Runnable() {
            @Override
            public void run() {

                try{

       // articleViewHolder.textContent.setText(article.text);
        //articleViewHolder.textTitle.setText(article.title + " " + position);
        articleViewHolder.textTitle.setText(article.title);
        if (article.image.startsWith(SCHEME_ASSETS)) {
            String fileName = article.image.replace(SCHEME_ASSETS, "");
            AssetManager assetManager = articleViewHolder.itemView.getContext().getAssets();
            InputStream is = null;
            try {
                is = assetManager.open(fileName);
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                articleViewHolder.imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                Log.e(TAG, Log.getStackTraceString(e));
            } finally {
                closeQuietly(is);
            }
        }
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClicked(articleViewHolder.getAdapterPosition());
                }
            }
        };
        articleViewHolder.readMoreAction.setOnClickListener(clickListener);
        articleViewHolder.itemView.setOnClickListener(clickListener);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    @Override
    public void onViewAttachedToWindow(final ArticleViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        onLayoutChangeListener = new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                View readMore = holder.readMore;
                int readMoreHeight = readMore.getHeight();
                readMore.setBottom(bottom - top - holder.itemView.getPaddingBottom());
                readMore.setTop(readMore.getBottom() - readMoreHeight);
            }
        };
        holder.itemView.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    @Override
    public void onViewDetachedFromWindow(ArticleViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.removeOnLayoutChangeListener(onLayoutChangeListener);
    }

    private void closeQuietly(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                //ignore
            }
        }
    }

    @Override
    public int getItemCount() {
        return articles == null ? 0 : articles.size();
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder implements AwesomeViewHolder {

        ImageView imageView;
        NonScrollListView benefits;
        NonScrollListView nutrients;
        TextView textTitle;
        View readMore;
        View readMoreAction;

        ArticleViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.article_image);
            benefits = (NonScrollListView) itemView.findViewById(R.id.text_list);
            nutrients = (NonScrollListView) itemView.findViewById(R.id.fourth_content);
            textTitle = (TextView) itemView.findViewById(R.id.article_title);
            readMore = itemView.findViewById(R.id.read_more);
            readMoreAction = itemView.findViewById(R.id.read_more_action);
        }

        @Override
        public void onStateChanged(float progress) {
            readMore.setAlpha(1 - progress);
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(int pos);
    }
}
