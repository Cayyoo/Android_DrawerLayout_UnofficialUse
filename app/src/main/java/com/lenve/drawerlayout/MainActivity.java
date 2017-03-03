package com.lenve.drawerlayout;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lenve.drawerlayout.adapter.LeftListViewAdapter;
import com.lenve.drawerlayout.bean.ContentModel;
import com.lenve.drawerlayout.fragment.ContentFragment;

/**
 * 侧滑菜单的实现
 * 注意：使用v4包
 */

/**
 * 使用DrawerLayout实现左、右侧滑菜单：
 *
 * 官方的用法是DrawerLayout+FrameLayout+ListView实现侧滑菜单。
 *
 * 本例中，是DrawerLayout+RelativeLayout+LinearLayout等实现的。与官方实现用法上有一点区别。且未使用ActionBarDrawerToggle等组件
 */
public class MainActivity extends FragmentActivity {

	private DrawerLayout drawerLayout;
	private RelativeLayout rightLayout;
	private ListView listView;

	private LeftListViewAdapter adapter;
	private List<ContentModel> list;

	private ImageView leftMenu, rightMenu;

	private FragmentManager fm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getActionBar().hide();//原有的标题栏隐藏
		
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
		rightLayout = (RelativeLayout) findViewById(R.id.right_layout);
		listView = (ListView) findViewById(R.id.left_listview);
		
		leftMenu = (ImageView) findViewById(R.id.leftmenu);
		rightMenu = (ImageView) findViewById(R.id.rightmenu);
		
		fm = getSupportFragmentManager();//v7包中是getFragmentManager()

		initData();//手动给出数据
		
		adapter = new LeftListViewAdapter(this, list);
		listView.setAdapter(adapter);
		
		leftMenu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//参数传Gravity.LEFT表示让左边的侧拉菜单出来
				drawerLayout.openDrawer(Gravity.START);//打开左侧滑菜单
			}
		});
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				Bundle bundle=new Bundle();
				bundle.putString("text", list.get(position).getText());

				ContentFragment contentFragment=new ContentFragment();
				contentFragment.setArguments(bundle);

				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.content, contentFragment);

				switch ((int) id) {
					case 1:
						Toast.makeText(MainActivity.this,list.get(position).getText()+"",Toast.LENGTH_SHORT).show();
						break;
					case 2:
						Toast.makeText(MainActivity.this,list.get(position).getText()+"",Toast.LENGTH_SHORT).show();
						break;
					case 3:
						Toast.makeText(MainActivity.this,list.get(position).getText()+"",Toast.LENGTH_SHORT).show();
						break;
					case 4:
						Toast.makeText(MainActivity.this,list.get(position).getText()+"",Toast.LENGTH_SHORT).show();
						break;
					case 5:
						Toast.makeText(MainActivity.this,list.get(position).getText()+"",Toast.LENGTH_SHORT).show();
						break;
					case 6:
						Toast.makeText(MainActivity.this,list.get(position).getText()+"",Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}

				ft.commit();
				drawerLayout.closeDrawer(Gravity.START);//关闭左侧滑菜单
			}
		});
		
		rightMenu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//参数Gravity.RIGHT，则表示让右边的侧拉菜单出来
				drawerLayout.openDrawer(Gravity.END);//打开右侧滑菜单
			}
		});
		
		rightLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				drawerLayout.closeDrawer(Gravity.END);//关闭右侧滑菜单
			}
		});
		
	}

	private void initData() {
		list = new ArrayList<>();
		list.add(new ContentModel(R.drawable.doctoradvice2, "新闻", 1));
		list.add(new ContentModel(R.drawable.infusion_selected, "订阅", 2));
		list.add(new ContentModel(R.drawable.mypatient_selected, "图片", 3));
		list.add(new ContentModel(R.drawable.mywork_selected, "视频", 4));
		list.add(new ContentModel(R.drawable.nursingcareplan2, "跟帖", 5));
		list.add(new ContentModel(R.drawable.personal_selected, "投票", 6));
	}

}
