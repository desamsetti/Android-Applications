package edu.cs.niu.z1829024.implicitintents;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private ImageView pictureIV;
    static final int REQUEST_CODE = 7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pictureIV = (ImageView)findViewById(R.id.pictureImageView);










    }


    public void doBrowser(View view )
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cs.niu.edu"));
        startActivity(intent);
    }

    public void doPhone(View view)
    {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:3125365336"));
        startActivity(phoneIntent);
    }
    public void doPicture(View view){
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(pictureIntent.resolveActivity( getPackageManager())!= null)
        {
            startActivityForResult(pictureIntent,REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap)bundle.get("data");
            pictureIV.setImageBitmap(bitmap);
        }
    }
}
