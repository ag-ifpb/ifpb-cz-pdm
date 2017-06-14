package ag.utacapp;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by arigarcia on 6/13/17.
 */

public class BoxComp extends LinearLayout {
    private ImageView img;
    private LinearLayout textsGroup;

    public BoxComp(Context context) {
        super(context);
        //
        setOrientation(LinearLayout.HORIZONTAL);
        LayoutParams lp = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );
        setLayoutParams(lp);
        //
        ImageView img = new ImageView(context);
        img.setImageResource(R.drawable.logo);
        addView(img);
        //
        addView(textsGroup = new TextsGroup(
                context, "Título 1", "Descrição 1"
        ));
        //
    }


}
