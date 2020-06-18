package org.tensorflow.lite.examples.classification;

import android.content.Context;

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
            R.drawable.nail_biting,
            R.drawable.nail_polish,
            R.drawable.illumination,
            R.drawable.weather_condition,
            R.drawable.warning
    };

    // heading Array
    public String[] heading_slide ={
            "HANDS ONLY",
            "NAIL BITING",
            "NAIL POLISH",
            "ILLUMINATION",
            "WEATHER",
            "WARNING"
    };

    // description Array
    public String[] description_slide ={
            "We will not consider the image of toenail for analysis purpose because toenail is not exposed to air so its color is not too natural when compared with finger-nail; also toe-nail is harder in comparison to the finger nail, so it is easier to detect the disease if present in human body through finger nail.",
            "The case of oral compulsive habit of nail biting will not be taken under consideration, these images can not be used for the data present as they can produce erroneous results. Pitted nail and bitted nail cannot be differentiated properly even by human eyes. therefore the proposed system will not cater to this problem.",
            "Polished nail/dyed nail (using some kind of Ink generally the case of voting) will not be considered for the analysis, so before performing the analysis the nail must be cleaned properly such that the nail must be translucent in appearance",
            "The illumination in the room must be proper or focus of the light on the nail must be adequate before taking an image.",
            "The nail image must be taken in normal room temperature as color of the nail can be affected in extreme cold temperature.",
            "This app is not intended to replace traditional methods of the evaluation of fingernail risk level, is not a diagnosis, and is not a substitute for visits to a healthcare professional."
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


