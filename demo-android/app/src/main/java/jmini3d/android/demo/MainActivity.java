package jmini3d.android.demo;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import jmini3d.android.GlSurfaceView3d;
import jmini3d.input.InputController;

public class MainActivity extends AppCompatActivity {

    InputController inputController;

    public GlSurfaceView3d glSurfaceView3d;

    public boolean traslucent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DemoScreenController screenController = new DemoScreenController();
        glSurfaceView3d = new GlSurfaceView3d(this, traslucent);
        glSurfaceView3d.setScreenController(screenController);
        glSurfaceView3d.setLogFps(true);
        inputController = new InputController(glSurfaceView3d);
        inputController.setTouchListener(screenController);
        inputController.setKeyListener(screenController);
        onCreateSetContentView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCreateSetContentView() {
        /*setContentView(R.layout.activity_main);
        LinearLayout root = ((LinearLayout) findViewById(R.id.fab));
        root.addView(glSurfaceView3d);*/

        setContentView(glSurfaceView3d);
    }
}