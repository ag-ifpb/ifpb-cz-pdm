package ag.utacapp;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by arigarcia on 6/13/17.
 */

public class TextsGroup extends LinearLayout {
    private TextView title;
    private TextView descr;

    public TextsGroup(Context context, String titleText, String descrText) {
        super(context);
        //
        setOrientation(LinearLayout.VERTICAL);
        LayoutParams lp = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        setLayoutParams(lp);
        //
        title = new TextView(context);
        title.setText(titleText);
//        title.setLayoutParams(new LayoutParams(
//                LayoutParams.WRAP_CONTENT,
//                LayoutParams.WRAP_CONTENT
//        ));
        addView(title);
        //
        descr = new TextView(context);
        descr.setText(descrText);
//        descr.setLayoutParams(new LayoutParams(
//                LayoutParams.WRAP_CONTENT,
//                LayoutParams.WRAP_CONTENT
//        ));
        addView(descr);
        //

    }

}
