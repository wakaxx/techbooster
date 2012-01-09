package org.japan.techbooster.sample.dragdrop;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class DragDropSample extends Activity {
    /** Called when the activity is first created. */
    private final int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT; 
    private final int FILL_PARENT = ViewGroup.LayoutParams.FILL_PARENT; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.lLayout);
        
        final DraggableView draggableText = new DraggableView(this);
        draggableText.setText("DraggableView!");
        linearLayout.addView(draggableText, 
                new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        
        final Button btn1 = (Button)findViewById(R.id.Button01);
        final Button btn2 = (Button)findViewById(R.id.Button02);
        final Button btn3 = (Button)findViewById(R.id.Button03);
        
        //setOnDragListnerは、受け側のViewにセットする。
        btn1.setOnDragListener(new View.OnDragListener() {
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();
                boolean result = false;
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED: {
                    	draggableText.setVisibility(View.VISIBLE);
                    	result = true;
                    } break;

                    case DragEvent.ACTION_DRAG_ENDED: {
                        Log.i("DragSample", "Drag ended.");
//                    	draggableText.setVisibility(View.INVISIBLE);
                    } break;
                    case DragEvent.ACTION_DRAG_LOCATION: {
//                    	btn1.setBackgroundColor(Color.BLUE);
                    	result = true;
                    }break;
                    case DragEvent.ACTION_DROP:{
                    	btn1.setBackgroundColor(Color.RED);
                    	result = true;
                    }break;
                }
                return result;
            }
        });

        btn2.setOnDragListener(new View.OnDragListener() {
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();
                boolean result = false;
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED: {
                    	draggableText.setVisibility(View.VISIBLE);
                    	result = true;
                    } break;

                    case DragEvent.ACTION_DRAG_ENDED: {
                        Log.i("DragSample", "Drag ended.");
//                    	draggableText.setVisibility(View.INVISIBLE);
                    } break;
                    case DragEvent.ACTION_DRAG_LOCATION: {
                    	btn2.setBackgroundColor(Color.BLUE);
                    	result = true;
                    }break;
                    case DragEvent.ACTION_DROP:{
//                    	btn1.setBackgroundColor(Color.BLUE);
                    	result = true;
                    }break;
                }
                return result;
            }
        });
        
        btn3.setOnDragListener(new View.OnDragListener() {
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();
                boolean result = false;
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED: {
                    	draggableText.setVisibility(View.VISIBLE);
                    	result = true;
                    } break;

                    case DragEvent.ACTION_DRAG_ENDED: {
                        Log.i("DragSample", "Drag ended.");
//                    	draggableText.setVisibility(View.INVISIBLE);
                    } break;
                    case DragEvent.ACTION_DRAG_LOCATION: {
                    	btn3.setBackgroundColor(Color.BLUE);
                    	result = true;
                    }break;
                    case DragEvent.ACTION_DROP:{
//                    	btn1.setBackgroundColor(Color.BLUE);
                    	result = true;
                    }break;
                }
                return result;
            }
        });
    }
}