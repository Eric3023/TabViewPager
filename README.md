# TabViewPager
### 使用手册


github地址：https://github.com/Eric3023/TabViewPager
### 1.工程的build.gradle文件中添加依赖  
allprojects {

    repositories {  
        maven { url 'https://jitpack.io' }  
    }
}


dependencies {

    compile 'com.github.Eric3023:TabViewPager:v1.0.0'
    
}

### 2.控件使用
#### 2.1 FragmentViewPager

布局文件中添加控件：

```xml
    <com.dong.tabviewpager.widget.FragmentViewPager
        android:id="@+id/fragmentviewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

java代码中设置控件的属性

```java
//配置LoopViewPager参数
        FragmentViewPager fragmentViewPager = findViewById(R.id.fragmentviewpager);
        fragmentViewPager.setActivity(this)
                .setBeans(FragmentFactory.createFragmentList())
                .initialise();
```

数据源beans是个集合（List<Fragment>）

举例说明数据源的初始化：
```java
//数据源
public class FragmentFactory {

    public static List<Fragment> createFragmentList(){

        List<Fragment> beans = new ArrayList<Fragment>();

        HomeFragment homeFragment = HomeFragment.newInstance("HOME","0");
        TopicFragment topicFragment = TopicFragment.newInstance("TOPIC","1");
        MesseageFragment messeageFragment = MesseageFragment.newInstance("MESSEAGE","2");
        MineFragment mineFragment = MineFragment.newInstance("MINE","3");

        beans.add(homeFragment);
        beans.add(topicFragment);
        beans.add(messeageFragment);
        beans.add(mineFragment);

        return beans;
    }
}
```


##### 效果：
 ![image](https://github.com/Eric3023/PointViewPager/blob/master/app/screenshoot/1.gif)

#### 2.2 BottomTabFragmentViewPager
布局文件中添加控件：

```xml
    <com.dong.tabviewpager.widget.BottomTabFragmentViewPager
        android:id="@+id/bottomtabfragmentviewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

java代码中设置控件的属性

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab_fragment_view_pager);

        BottomTabFragmentViewPager tabFragmentViewPager = findViewById(R.id.bottomtabfragmentviewpager);

        FragmentViewPager fragmentViewPager = tabFragmentViewPager.getFragmentViewPager();

        BottomNavigationBar bottomNavigationBar = tabFragmentViewPager.getBottomNavigationBar();

        //初始化ViewPager
        initFragmentViewPager(fragmentViewPager);
        //初始化Tab标签
        initTab(bottomNavigationBar);
    }

    private void initFragmentViewPager(FragmentViewPager fragmentViewPager) {
        fragmentViewPager.setActivity(this)//设置Fragment所在的Activity
                .setBeans(FragmentFactory.createFragmentList())//设置Fragment数据源
                .initialise();
    }

    private void initTab(BottomNavigationBar bottomNavigationBar) {
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_tab_home_selected,"主页").setInactiveIconResource(R.drawable.ic_tab_home).setActiveColor(getResources().getColor(R.color.colorblue)))
                .addItem(new BottomNavigationItem(R.drawable.ic_tab_topic_selected,"主题").setInactiveIconResource(R.drawable.ic_tab_topic).setActiveColor(getResources().getColor(R.color.colorblue)))
                .addItem(new BottomNavigationItem(R.drawable.ic_tab_message_selected,"消息").setInactiveIconResource(R.drawable.ic_tab_message).setActiveColor(getResources().getColor(R.color.colorblue)))
                .addItem(new BottomNavigationItem(R.drawable.ic_tab_me_selected,"我的").setInactiveIconResource(R.drawable.ic_tab_me).setActiveColor(getResources().getColor(R.color.colorblue)))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .initialise();
    }
```
##### 效果：


 ![image](https://github.com/Eric3023/PointViewPager/blob/master/app/screenshoot/2.gif)
 

#### 2.3 TopFragmentViewPager

布局文件

```xml
    <com.dong.tabviewpager.widget.TopTabFragmentViewPager
        android:id="@+id/toptabfragmentviewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
代码文件
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_tab_fragment_view_pager);

        TopTabFragmentViewPager tabFragmentViewPager = findViewById(R.id.toptabfragmentviewpager);

        FragmentViewPager fragmentViewPager = tabFragmentViewPager.getFragmentViewPager();

        BottomNavigationBar bottomNavigationBar = tabFragmentViewPager.getBottomNavigationBar();

        //初始化ViewPager
        initFragmentViewPager(fragmentViewPager);
        //初始化Tab标签
        initTab(bottomNavigationBar);
    }

    private void initFragmentViewPager(FragmentViewPager fragmentViewPager) {
        fragmentViewPager.setActivity(this)//设置Fragment所在的Activity
                .setBeans(FragmentFactory.createFragmentList())//设置Fragment数据源
                .initialise();
    }

    private void initTab(BottomNavigationBar bottomNavigationBar) {
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_tab_home_selected,"主页").setInactiveIconResource(R.drawable.ic_tab_home).setActiveColor(getResources().getColor(R.color.colorblue)))
                .addItem(new BottomNavigationItem(R.drawable.ic_tab_topic_selected,"主题").setInactiveIconResource(R.drawable.ic_tab_topic).setActiveColor(getResources().getColor(R.color.colorblue)))
                .addItem(new BottomNavigationItem(R.drawable.ic_tab_message_selected,"消息").setInactiveIconResource(R.drawable.ic_tab_message).setActiveColor(getResources().getColor(R.color.colorblue)))
                .addItem(new BottomNavigationItem(R.drawable.ic_tab_me_selected,"我的").setInactiveIconResource(R.drawable.ic_tab_me).setActiveColor(getResources().getColor(R.color.colorblue)))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .initialise();
    }
```
效果：

 ![image](https://github.com/Eric3023/PointViewPager/blob/master/app/screenshoot/3.gif)
 
