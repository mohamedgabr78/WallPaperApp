package algonquin.cst2335.wallpaperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class SetWallpaper extends AppCompatActivity {

    Intent intent;
    ImageView imageView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_wallpaper);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final WallpaperManager wallpaper=WallpaperManager.getInstance(getApplicationContext());
        btn=findViewById(R.id.set);
        imageView=findViewById(R.id.finalimage);
        intent=getIntent();

        String url= intent.getStringExtra("image");
        Glide.with(getApplicationContext()).load(url).into(imageView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                    wallpaper.setBitmap(bitmap);
                    Toast.makeText(getApplicationContext(),text: "Done",Toast.LENGTH_LONG).show();
                }

                catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

    }
}