# DrawerLayout+RelativeLayout+LinearLayout实现侧滑菜单

```java

/**
 * 侧滑菜单的实现
 * 注意：使用v4包
 */

/**
 * 使用DrawerLayout实现左、右侧滑菜单：
 *
 * 官方的用法是DrawerLayout+FrameLayout+ListView实现侧滑菜单。之后又推出了NavigationView等实现方式。
 *
 * 本例中，是DrawerLayout+RelativeLayout+LinearLayout等实现的。与官方实现用法上有一点区别。且未使用ActionBarDrawerToggle等组件
 */

```
activity_main.xml
```java

<android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/drawerlayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <RelativeLayout
        android:id="@+id/fragment_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent" >

        <RelativeLayout
            android:id="@+id/title_bar"
            android:layout_width="match_parent"
            android:layout_height="48dp"
            android:background="#63B8FF" >
            <ImageView
                android:id="@+id/leftmenu"
                android:layout_width="48dp"
                android:layout_height="48dp"
                android:padding="12dp"
                android:src="@drawable/menu" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="48dp"
                android:layout_centerInParent="true"
                android:gravity="center"
                android:text="Title Bar" />

            <ImageView
                android:id="@+id/rightmenu"
                android:layout_width="48dp"
                android:layout_height="48dp"
                android:layout_alignParentRight="true"
                android:padding="12dp"
                android:src="@drawable/p_center" />
        </RelativeLayout>

        <LinearLayout
            android:id="@+id/content"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_below="@id/title_bar"
            android:orientation="vertical" >
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="I am Fragment Content"/>
        </LinearLayout>

    </RelativeLayout>

    <RelativeLayout
        android:id="@+id/left"
        android:layout_width="200dp"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        android:background="@android:color/white" >
        <ListView
            android:id="@+id/left_listview"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
    </RelativeLayout>

    <RelativeLayout
        android:id="@+id/right_layout"
        android:layout_width="260dp"
        android:layout_height="match_parent"
        android:layout_gravity="end"
        android:background="#BCEE68" >
        <ImageView
            android:id="@+id/p_pic"
            android:layout_width="72dp"
            android:layout_height="72dp"
            android:layout_centerInParent="true"
            android:src="@drawable/p_pic" />

        <TextView
            android:id="@+id/right_textview"
            android:layout_width="wrap_content"
            android:layout_height="48dp"
            android:layout_below="@id/p_pic"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="12dp"
            android:text="个人中心"
            android:textColor="@android:color/black"
            android:textSize="14sp" />
    </RelativeLayout>

</android.support.v4.widget.DrawerLayout>

```
---
![](https://github.com/ykmeory/DrawerLayout_Unofficial_Use/blob/master/img_folder/drawer01.png)
----
![](https://github.com/ykmeory/DrawerLayout_Unofficial_Use/blob/master/img_folder/drawer02.png)
----

![img two](https://github.com/ykmeory/DrawerLayout_Unofficial_Use/blob/master/img_folder/img02.jpg "screenshot two")
&nbsp;&nbsp;&nbsp;
![img one](https://github.com/ykmeory/DrawerLayout_Unofficial_Use/blob/master/img_folder/img01.jpg "screenshot one")
&nbsp;&nbsp;&nbsp;
![img three](https://github.com/ykmeory/DrawerLayout_Unofficial_Use/blob/master/img_folder/img03.jpg "screenshot three")
