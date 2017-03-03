package com.lenve.drawerlayout.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenve.drawerlayout.R;

/**
 * 使用v4包
 */
public class ContentFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_content, null);
		TextView textView= (TextView) view.findViewById(R.id.tv_content);

		Bundle bundle=getArguments();
		if (bundle!=null){
			String text=bundle.getString("text");
			textView.setText(text);
		}

		return view;
	}
}
