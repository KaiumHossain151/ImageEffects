 package com.example.kaium.imageeffects;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

 public class MainActivity extends AppCompatActivity {

    ImageView myImageView;
    Drawable myFlower;
    Bitmap bitmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myImageView = (ImageView) findViewById(R.id.myImageView);


        myFlower = ResourcesCompat.getDrawable(getResources(),R.drawable.images,null);
        bitmapImage = ((BitmapDrawable) myFlower).getBitmap();
        Bitmap newphoto = invertImage(bitmapImage);

        myImageView.setImageBitmap(newphoto);



        /* Drawable[] layres = new Drawable[2];;
        layres[0] = ResourcesCompat.getDrawable(getResources(),R.drawable.images,null);
        layres[1] = ResourcesCompat.getDrawable(getResources(),R.drawable.download,null);

        LayerDrawable layerDrawable = new LayerDrawable(layres);
        myImageView.setImageDrawable(layerDrawable); */

    }

    public static Bitmap invertImage(Bitmap original){

        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(),original.getHeight(),original.getConfig());

        int A,R,G,B;
        int pixelColor;
        int width = original.getWidth();
        int height = original.getHeight();

        for(int y = 0; y<height; y++)
        {
            for(int x = 0; x<width; x++){

                pixelColor = original.getPixel(x,y);
                A = Color.alpha(pixelColor);
                R = 255 - Color.red(pixelColor);
                G = 255 - Color.green(pixelColor);
                B = 255 - Color.blue(pixelColor);

                finalImage.setPixel(x,y,Color.argb(A,R,G,B));
            }

        }

        return finalImage;
    }


}
