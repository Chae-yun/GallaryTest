package kr.hs.emirim.dbfl0406.gallerytest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Gallery gallery;
    ImageView imgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery=(Gallery)findViewById(R.id.gallery_1);
        imgMain=(ImageView)findViewById(R.id.imgv_main);
        MyGalleryAdapter adapter=new MyGalleryAdapter(this);
        gallery.setAdapter(adapter);
    }

    public class MyGalleryAdapter extends BaseAdapter{

        Context context;
        int[] ImageIDs={R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,
                R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08,
                R.drawable.img09,R.drawable.img10};

        public MyGalleryAdapter(Context context){
            this.context=context;
        }

        @Override
        public int getCount() {
            return ImageIDs.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imgV=new ImageView(context);
            imgV.setLayoutParams(new Gallery.LayoutParams(150,150));
            imgV.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgV.setImageResource(ImageIDs[position]);
            final int pos=position; //이렇게 해주지 않으면 온터치 안에서 못쓴다 왜징 익명클래스라 그렇다고??
            imgV.setOnTouchListener(new View.OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    imgMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imgMain.setImageResource(ImageIDs[pos]);
                    return false;
                }
            });
            return imgV;
        }
    }
}
