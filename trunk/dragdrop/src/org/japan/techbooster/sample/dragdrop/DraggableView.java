package org.japan.techbooster.sample.dragdrop;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.widget.TextView;

public class DraggableView extends TextView {
	public DraggableView(Context context) {
		super(context);
		setOnLongClickListener(new View.OnLongClickListener() {
			public boolean onLongClick(View v) {
				ClipData data = ClipData.newPlainText("text", "text : " + v.toString());
				v.startDrag(data, new DragShadowBuilder(v),(Object)v, 0);
				return true;
			}
		});
	}

	
    // Shadow builder that can ANR if desired
//    class ANRShadowBuilder extends DragShadowBuilder {
//        boolean mDoAnr;
//
//        public ANRShadowBuilder(View view) {
//            super(view);
//        }
//
//        @Override
//        public void onDrawShadow(Canvas canvas) {
//            super.onDrawShadow(canvas);
//        }
//    }
        
    @Override
    public boolean onDragEvent(DragEvent event) {
        boolean result = false;
        switch (event.getAction()) {
        case DragEvent.ACTION_DRAG_STARTED: {
            Log.i("DragSample", "Drag started, event=" + event);
            result = true;
        } break;

        case DragEvent.ACTION_DRAG_ENDED: {
            Log.i("DragSample", "Drag ended.");
        } break;

        case DragEvent.ACTION_DRAG_LOCATION: {
           Log.i("DragSample", "... seeing drag locations ...");
           result = true;
        } break;

        case DragEvent.ACTION_DROP: {
            Log.i("DragSample", "Got a drop! =" + this + " event=" + event);
            result = true;
        } break;

        case DragEvent.ACTION_DRAG_ENTERED: {
            Log.i("DragSample", "Entered  " + this);
            result = true;
        } break;

        case DragEvent.ACTION_DRAG_EXITED: {
            Log.i("DragSample", "Exited  " + this);
//            result = true;
        } break;

        default:
            Log.i("DragSample", "other drag event: " + event);
            result = true;
            break;
        }

        return result;
    }    

}
