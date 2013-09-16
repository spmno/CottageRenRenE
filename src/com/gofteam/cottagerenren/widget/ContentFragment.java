package com.gofteam.cottagerenren.widget;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gofteam.cottagerenren.R;
/**
 * Created by spmno on 13-9-13.
 */
public class ContentFragment extends Fragment {
    String text = null;

    public ContentFragment() {
    }

    public ContentFragment(String text) {
        Log.i("Custrutor", text);
        this.text = text;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Log.e("Content", "onCreate:"+text);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("Content", "onCreateView:"+ text);
        //inflater the layout
        View view = inflater.inflate(R.layout.fragment_text, null);
        TextView textView =(TextView)view.findViewById(R.id.textView);
        if(!TextUtils.isEmpty(text)) {
            textView.setText(text);
        }
        return view;
    }
}