package safetools.safetools;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentTransaction;

import android.content.Intent;
import android.net.*;
import java.io.*;
import android.content.res.*;
import safetools.safetools.Communicator;
import android.support.design.widget.NavigationView;
import android.os.*;
import android.content.*;
import java.net.*;
import android.util.*;




public class MainActivity extends AppCompatActivity
         implements Communicator
		{

	DrawerLayout drawer ;
	FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
	UpdateApp autoUpdateApp;
			
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
		
		
		mFragmentManager = getSupportFragmentManager();
		mFragmentTransaction = mFragmentManager.beginTransaction();
		mFragmentTransaction.replace(R.id.content_main,new PrivacyItems()).commit();
		
		

		
		
		
		
		
		

					
		
		
		
		
		
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Author Ahmed mohamed", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
			new NavigationView.OnNavigationItemSelectedListener() {
				@Override
				public boolean onNavigationItemSelected(MenuItem menuItem) {
					drawer.closeDrawers();



					if (menuItem.getItemId() == R.id.nav_camera) {
						mFragmentManager = getSupportFragmentManager();
						mFragmentTransaction = mFragmentManager.beginTransaction();
						mFragmentTransaction.replace(R.id.content_main,new MyStore()).commit();

						return true;
					}else if(menuItem.getItemId() == R.id.nav_gallery) {
						mFragmentManager = getSupportFragmentManager();
						mFragmentTransaction = mFragmentManager.beginTransaction();
						mFragmentTransaction.replace(R.id.content_main,new PrivacyItems()).commit();

						return true;
					}else if(menuItem.getItemId() == R.id.nav_manage) {
						mFragmentManager = getSupportFragmentManager();
						mFragmentTransaction = mFragmentManager.beginTransaction();
						mFragmentTransaction.replace(R.id.content_main,new MyEmail()).commit();

						return true;
						
					}else if(menuItem.getItemId() == R.id.nav_share) {
						mFragmentManager = getSupportFragmentManager();
						mFragmentTransaction = mFragmentManager.beginTransaction();
						mFragmentTransaction.replace(R.id.content_main,new PrivacyItems()).commit();

						return true;

					}else if(menuItem.getItemId() == R.id.nav_slideshow) {
						mFragmentManager = getSupportFragmentManager();
						mFragmentTransaction = mFragmentManager.beginTransaction();
						mFragmentTransaction.replace(R.id.content_main,new MyChat()).commit();

						return true;
						}else if(menuItem.getItemId() == R.id.nav_send) {
						mFragmentManager = getSupportFragmentManager();
						mFragmentTransaction = mFragmentManager.beginTransaction();
						mFragmentTransaction.replace(R.id.content_main,new Mabout()).commit();

						return true;
						}
						
						
						
					return false;
				}
						});
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
			
			mFragmentManager = getSupportFragmentManager();
			mFragmentTransaction = mFragmentManager.beginTransaction();
			mFragmentTransaction.replace(R.id.content_main,new Mabout()).commit();
			
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
			
			mFragmentManager = getSupportFragmentManager();
		mFragmentTransaction = mFragmentManager.beginTransaction();
		mFragmentTransaction.replace(R.id.content_main,new MyStore()).commit();
		
			
        } else if (id == R.id.nav_gallery) {
			
			mFragmentManager = getSupportFragmentManager();
			mFragmentTransaction = mFragmentManager.beginTransaction();
			mFragmentTransaction.replace(R.id.content_main,new PrivacyItems()).commit();
			

        } else if (id == R.id.nav_slideshow) {

          } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
	
	


	  @SuppressWarnings("StatementWithEmptyBody")

	@Override
	public void respond(String data)
	{
		  AssetManager assetManager = getAssets();
		  InputStream in = null;
		  OutputStream out = null;
		
		// TODO: Implement this method
		if(data.equalsIgnoreCase("a1")){
			  try {
				  in = assetManager.open("orbott.apk");
				  out = new FileOutputStream("/sdcard/orbott.apk");
				  byte[] buffer = new byte[1024];
				  int read;
				  while((read = in.read(buffer)) != -1){
					  out.write(buffer, 0, read);
				  }
				  in.close();
				  in = null;
				  out.flush();
				  out.close();
				  out = null;
				  Intent intent = new Intent(Intent.ACTION_VIEW);
				  intent.setDataAndType(Uri.fromFile(new File("/sdcard/orbott.apk")), "application/vnd.android.package-archive");
				  startActivity(intent);
			  }catch(Exception e){
				  // deal with copying problem
			  }
			  
//
		  }else if(data.equalsIgnoreCase("a2")){
			
			  Intent intent = new Intent();
			  
			  intent.setData(Uri.parse("market://details?id=info.guardianproject.orfox"));
			  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);

			  // launch Google Play Store app :-)
			  startActivity(intent);
			  
//
		  }else if(data.equalsIgnoreCase("a3")){
			  try {
				  in = assetManager.open("i2pp.apk");
				  out = new FileOutputStream("/sdcard/i2pp.apk");
				  byte[] buffer = new byte[1024];
				  int read;
				  while((read = in.read(buffer)) != -1){
					  out.write(buffer, 0, read);
				  }
				  in.close();
				  in = null;
				  out.flush();
				  out.close();
				  out = null;
				  Intent intent = new Intent(Intent.ACTION_VIEW);
				  intent.setDataAndType(Uri.fromFile(new File("/sdcard/i2pp.apk")), "application/vnd.android.package-archive");
				  startActivity(intent);
			  }catch(Exception e){
				  // deal with copying problem
			  }
			  
			  
		  }else if(data.equalsIgnoreCase("a4")){
			  try {
				  in = assetManager.open("orwebb.apk");
				  out = new FileOutputStream("/sdcard/orwebb.apk");
				  byte[] buffer = new byte[1024];
				  int read;
				  while((read = in.read(buffer)) != -1){
					  out.write(buffer, 0, read);
				  }
				  in.close();
				  in = null;
				  out.flush();
				  out.close();
				  out = null;
				  Intent intent = new Intent(Intent.ACTION_VIEW);
				  intent.setDataAndType(Uri.fromFile(new File("/sdcard/orwebb.apk")), "application/vnd.android.package-archive");
				  startActivity(intent);
			  }catch(Exception e){
				  // deal with copying problem
			  }
			  }else if(data.equalsIgnoreCase("S1")){
				  try {
					  in = assetManager.open("fdr.apk");
					  out = new FileOutputStream("/sdcard/fdr.apk");
					  byte[] buffer = new byte[1024];
					  int read;
					  while((read = in.read(buffer)) != -1){
						  out.write(buffer, 0, read);
					  }
					  in.close();
					  in = null;
					  out.flush();
					  out.close();
					  out = null;
					  Intent intent = new Intent(Intent.ACTION_VIEW);
					  intent.setDataAndType(Uri.fromFile(new File("/sdcard/fdr.apk")), "application/vnd.android.package-archive");
					  startActivity(intent);
				  }catch(Exception e){
					  // deal with copying problem
				  }
			  }else if(data.equalsIgnoreCase("S2")){
				  try {
					  in = assetManager.open("k9.apk");
					  out = new FileOutputStream("/sdcard/k9.apk");
					  byte[] buffer = new byte[1024];
					  int read;
					  while((read = in.read(buffer)) != -1){
						  out.write(buffer, 0, read);
					  }
					  in.close();
					  in = null;
					  out.flush();
					  out.close();
					  out = null;
					  Intent intent = new Intent(Intent.ACTION_VIEW);
					  intent.setDataAndType(Uri.fromFile(new File("/sdcard/k9.apk")), "application/vnd.android.package-archive");
					  startActivity(intent);
				  }catch(Exception e){
					  // deal with copying problem
				  }
			  }else if(data.equalsIgnoreCase("S3")){
				  
				  Intent intent = new Intent();

				  intent.setData(Uri.parse("market://details?id=im.vector.alpha"));
				  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);

				  // launch Google Play Store app :-)
				  startActivity(intent);
				  
				  }
	}
	
	
	
	
	public class UpdateApp extends AsyncTask<String,Void,Void>{
		private Context context;
		public void setContext(Context contextf){
			context = contextf;
		}

		@Override
		protected Void doInBackground(String... arg0) {
			try {
				URL url = new URL(arg0[0]);
				HttpURLConnection c = (HttpURLConnection) url.openConnection();
				c.setRequestMethod("GET");
				c.setDoOutput(true);
				c.connect();

				String PATH = "/mnt/sdcard/Download/";
				File file = new File(PATH);
				file.mkdirs();
				File outputFile = new File(file, url.getFile().toString());
				if(outputFile.exists()){
					outputFile.delete();
				}
				FileOutputStream fos = new FileOutputStream(outputFile);

				InputStream is = c.getInputStream();

				byte[] buffer = new byte[1024];
				int len1 = 0;
				while ((len1 = is.read(buffer)) != -1) {
					fos.write(buffer, 0, len1);
				}
				fos.close();
				is.close();

				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setDataAndType(Uri.fromFile(new File("/mnt/sdcard/Download/ url.getFile().toString()")), "application/vnd.android.package-archive");
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // without this flag android returned a intent error!
				context.startActivity(intent);


				
			} catch (Exception e) {
				Log.e("UpdateAPP", "Update error! " + e.getMessage());
			}
			return null;
		}
	}   
}
