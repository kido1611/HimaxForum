package id.himax.forum;

import android.graphics.Bitmap;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private Drawer mDrawer;
    private Toolbar mToolbar;
    private CoordinatorLayout mCoordinatorLayout;
    private Snackbar mSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);

        setSupportActionBar(mToolbar);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(false);
//        mWebView.loadUrl("http://forum.himax.co.id");
        mWebView.setWebViewClient(new HimaxWebClient());

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIdentifier(0),
                        new ExpandableDrawerItem().withName("Introduction").withSubItems(
                                new SecondaryDrawerItem().withName("Himax FAQ").withIdentifier(1),
                                new SecondaryDrawerItem().withName("Himax Event, Info & News").withIdentifier(2),
                                new SecondaryDrawerItem().withName("Forum Rules").withIdentifier(3)
                        ),
                        new ExpandableDrawerItem().withName("Product").withSubItems(
                                new SecondaryDrawerItem().withName("Waiting lounge").withIdentifier(4),
                                new SecondaryDrawerItem().withName("H-Classic").withIdentifier(5),
                                new SecondaryDrawerItem().withName("M-One").withIdentifier(6),
                                new SecondaryDrawerItem().withName("H-One").withIdentifier(7),
                                new SecondaryDrawerItem().withName("M-Two").withIdentifier(8),
                                new SecondaryDrawerItem().withName("X-Plus").withIdentifier(9),
                                new SecondaryDrawerItem().withName("Pure III S").withIdentifier(10),
                                new SecondaryDrawerItem().withName("Aura Y11s").withIdentifier(11),
                                new SecondaryDrawerItem().withName("Bravo Y01i").withIdentifier(12),
                                new SecondaryDrawerItem().withName("Polymer 3").withIdentifier(13),
                                new SecondaryDrawerItem().withName("Bravo Y10").withIdentifier(14),
                                new SecondaryDrawerItem().withName("Aura Y11").withIdentifier(15),
                                new SecondaryDrawerItem().withName("Polymer 2").withIdentifier(16),
                                new SecondaryDrawerItem().withName("Polymer 2x").withIdentifier(17),
                                new SecondaryDrawerItem().withName("Polymer X").withIdentifier(18),
                                new SecondaryDrawerItem().withName("Pure III").withIdentifier(19),
                                new SecondaryDrawerItem().withName("Polymer Octacore").withIdentifier(20),
                                new SecondaryDrawerItem().withName("Zoom").withIdentifier(21),
                                new SecondaryDrawerItem().withName("Pure S").withIdentifier(22),
                                new SecondaryDrawerItem().withName("Polymer U").withIdentifier(23),
                                new SecondaryDrawerItem().withName("Pure I").withIdentifier(24),
                                new SecondaryDrawerItem().withName("Pure II").withIdentifier(25),
                                new SecondaryDrawerItem().withName("Compare Products").withIdentifier(26)
                        ),
                        new ExpandableDrawerItem().withName("General").withSubItems(
                                new SecondaryDrawerItem().withName("Tips & Trick").withIdentifier(27),
                                new SecondaryDrawerItem().withName("Application").withIdentifier(28),
                                new SecondaryDrawerItem().withName("Games").withIdentifier(29),
                                new SecondaryDrawerItem().withName("Video").withIdentifier(30),
                                new SecondaryDrawerItem().withName("Photos").withIdentifier(31),
                                new SecondaryDrawerItem().withName("Themes").withIdentifier(32)
                        )
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        openWeb(drawerItem.getIdentifier());
                        return false;
                    }
                })
                .build();

        mDrawer.setSelection(0, true);
    }

    private void openWeb(long identifier){
        String url = "http://forum.himax.co.id";
        //Home
        if(identifier==0) url = "http://forum.himax.co.id";
        //Introduction
        else if(identifier==1) url = "http://forum.himax.co.id/forum-2-1/himax-faq";
        else if(identifier==2) url = "http://forum.himax.co.id/forum-56-1/himax-event,-info-&-news";
        else if(identifier==3) url = "http://forum.himax.co.id/forum-36-1/forum-rules";

//        Product
        else if(identifier==4) url = "http://forum.himax.co.id/forum-269-1/waiting-lounge";
        else if(identifier==5) url = "http://forum.himax.co.id/forum-339-1/h-classic";
        else if(identifier==6) url = "http://forum.himax.co.id/forum-321-1/m-one";

        else if(identifier==7) url = "http://forum.himax.co.id/forum-322-1/h-one";
        else if(identifier==8) url = "http://forum.himax.co.id/forum-315-1/m-two";
        else if(identifier==9) url = "http://forum.himax.co.id/forum-307-1/x-plus";

        else if(identifier==10) url = "http://forum.himax.co.id/forum-228-1/pure-iii-s";
        else if(identifier==11) url = "http://forum.himax.co.id/forum-303-1/aura-y11s";
        else if(identifier==12) url = "http://forum.himax.co.id/forum-284-1/bravo-y10i";

        else if(identifier==13) url = "http://forum.himax.co.id/forum-280-1/polymer-3";
        else if(identifier==14) url = "http://forum.himax.co.id/forum-276-1/bravo-y10";
        else if(identifier==15) url = "http://forum.himax.co.id/forum-272-1/aura-y11";

        else if(identifier==16) url = "http://forum.himax.co.id/forum-224-1/polymer-2";
        else if(identifier==17) url = "http://forum.himax.co.id/forum-232-1/polymer-2x";
        else if(identifier==18) url = "http://forum.himax.co.id/forum-233-1/polymer-x";

        else if(identifier==19) url = "http://forum.himax.co.id/forum-234-1/pure-iii";
        else if(identifier==20) url = "http://forum.himax.co.id/forum-235-1/polymer-octacore";
        else if(identifier==21) url = "http://forum.himax.co.id/forum-236-1/zoom";

        else if(identifier==22) url = "http://forum.himax.co.id/forum-237-1/pure-s";
        else if(identifier==23) url = "http://forum.himax.co.id/forum-238-1/polymer-li";
        else if(identifier==24) url = "http://forum.himax.co.id/forum-240-1/pure-i";

        else if(identifier==25) url = "http://forum.himax.co.id/forum-239-1/pure-ii";
        else if(identifier==26) url = "http://forum.himax.co.id/forum-122-1/compare-product";
//        General
        else if(identifier==27) url = "http://forum.himax.co.id/forum-271-1/tips-&-trick";
        else if(identifier==28) url = "http://forum.himax.co.id/forum-52-1/application";
        else if(identifier==29) url = "http://forum.himax.co.id/forum-74-1/games";
        else if(identifier==30) url = "http://forum.himax.co.id/forum-48-1/video";
        else if(identifier==31) url = "http://forum.himax.co.id/forum-47-1/photo";
        else if(identifier==32) url = "http://forum.himax.co.id/forum-50-1/themes";

        mWebView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack())
            mWebView.goBack();
        else
            super.onBackPressed();
    }

    class HimaxWebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            getSupportActionBar().setTitle(R.string.app_name);
            mSnackbar = Snackbar.make(mCoordinatorLayout, "Mohon ditunggu...", Snackbar.LENGTH_LONG);
            mSnackbar.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            getSupportActionBar().setTitle(view.getTitle());
            mSnackbar.dismiss();
        }
    }
}
