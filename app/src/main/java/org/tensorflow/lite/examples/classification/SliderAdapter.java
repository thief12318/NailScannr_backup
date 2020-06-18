package org.tensorflow.lite.examples.classification;

import android.content.Context;

import android.graphics.drawable.RippleDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import org.tensorflow.lite.examples.classification.R;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

//    private TextView slideHeading, slideDescription;
//    private ImageView slide_imageView;


    public SliderAdapter(Context context) {

        this.context = context;
    }

    // img Array
    public int[] image_slide ={
            R.drawable.hands_only,
            R.drawable.distal_edge,
            R.drawable.nail_biting,
            R.drawable.nail_polish,
            R.drawable.illumination,
            R.drawable.weather_condition,
            R.drawable.plain_background,
            R.drawable.warning
    };

    // heading Array
    public String[] heading_slide ={
            "HANDS ONLY",
            "Distal Edge",
            "NAIL BITING",
            "NAIL POLISH",
            "ILLUMINATION",
            "WEATHER",
            "PLAIN COLOR BACKGROUND",
            "WARNING"
    };

    // description Array
    public String[] description_slide ={
            "NailScannr only allow fingernails to be tested, because toenails tends to discolor due to its nature.",
            "Distal edge (free edges) of nails can affect the result of analysis, always trim your fingernail before using NailScannr",
            "Pitted nail and bitted nail cannot be differentiated properly even by human eyes. therefore NailScannr will not allow bitten nails.",
            "Nail must be cleaned properly before using NailScannr to avoid getting wrong results.",
            "The illumination in the room must be proper or focus of the light on the nail must be adequate before taking an image.",
            "The nail image must be taken in normal room temperature as color of the nail can be affected in extreme cold temperature.",
            "Use plain color background to increase accuracy",
            "NailScannr is not intended to replace traditional methods of the evaluation of fingernail risk level, is not a diagnosis, and is not a substitute for visits to a healthcare professional."
    };




    @Override
    public int getCount() {

        return heading_slide.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);
        container.addView(view);

        ImageView slide_imageView = view.findViewById(R.id.imageView1);
        TextView slideHeading = view.findViewById(R.id.tvHeading);
        TextView  slideDescription = view.findViewById(R.id.tvDescription);

        slide_imageView.setImageResource(image_slide[position]);
        slideHeading.setText(heading_slide[position]);
        slideDescription.setText(description_slide[position]);

        return view;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        View view = (View) object;
//        container.removeView(view);
//    }

}


