package ir.myempire.iraniansanstxtview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by alihaghighatdoost on 7/26/16.
 */
public class IranianSansTextView extends TextView {

    private static final String REGULAR = "regular";
    private static final String BOLD = "bold";
    private static final String EXPANDED = "expanded";
    private static final String LIGHT = "light";

    public static char[] persianNumbers = {'\u06f0', '\u06f1', '\u06f2', '\u06f3', '\u06f4', '\u06f5', '\u06f6', '\u06f7', '\u06f8', '\u06f9'};
    private boolean convertPersianNumbers = false;
    private String fontType;

    public IranianSansTextView(Context context) {
        super(context);
        setTypeface();
    }

    public IranianSansTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttrs(context, attrs);
        setTypeface();

    }

    public IranianSansTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setAttrs(context, attrs);
        setTypeface();

    }

    private void setAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.IranianSansTextView, 0, 0);
        try {
            this.convertPersianNumbers = ta.getBoolean(R.styleable.IranianSansTextView_convertPersianNumbers,false);
            this.fontType = ta.getString(R.styleable.IranianSansTextView_font);
        } finally {
            ta.recycle();
        }
        if(this.convertPersianNumbers){
            setText(convertToPersianNumbers(getText().toString()));
        }
    }

    private void setTypeface() {
        if(!isInEditMode()){
        Typeface tf;
        if (fontType != null) {
            switch (fontType) {
                case REGULAR:
                    tf = Typeface.createFromAsset(getContext().getAssets(),
                            "IRAN_Sans.ttf");
                    break;
                case BOLD:
                    tf = Typeface.createFromAsset(getContext().getAssets(),
                            "IRAN_Sans_Bold.ttf");
                    break;
                case EXPANDED:
                    tf = Typeface.createFromAsset(getContext().getAssets(),
                            "IRAN_Sans_Expanded.ttf");
                    break;
                case LIGHT:
                    tf = Typeface.createFromAsset(getContext().getAssets(),
                            "IRAN_Sans_Light.ttf");
                    break;
                default:
                    tf = Typeface.createFromAsset(getContext().getAssets(),
                            "IRAN_Sans_Expanded.ttf");
                    break;
            }
        }else{
            tf = Typeface.createFromAsset(getContext().getAssets(),
                    "IRAN_Sans_Expanded.ttf");
        }
        this.setTypeface(tf);}
    }

    private boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    private String convertToPersianNumbers(String str) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '0') {
                builder.append(persianNumbers[0]);
            } else if (ch == '1') {
                builder.append(persianNumbers[1]);
            } else if (ch == '2') {
                builder.append(persianNumbers[2]);
            } else if (ch == '3') {
                builder.append(persianNumbers[3]);
            } else if (ch == '4') {
                builder.append(persianNumbers[4]);
            } else if (ch == '5') {
                builder.append(persianNumbers[5]);
            } else if (ch == '6') {
                builder.append(persianNumbers[6]);
            } else if (ch == '7') {
                builder.append(persianNumbers[7]);
            } else if (ch == '8') {
                builder.append(persianNumbers[8]);
            } else if (ch == '9') {
                builder.append(persianNumbers[9]);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
