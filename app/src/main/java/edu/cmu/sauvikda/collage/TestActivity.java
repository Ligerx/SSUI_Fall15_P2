package edu.cmu.sauvikda.collage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.FrameLayout;

/**
 * Minimal test app for SSUI Mobile Project #2 (Collage).  To use this 
 * test framework implement the body of buildTest().
 * 
 * @author Scott Hudson
 *
 */
public class TestActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	// let the base class take care of bookkeeping stuff...
        super.onCreate(savedInstanceState);

        // create an ArtistView widget and install a generated test tree there
        ArtistView root = new ArtistView(this);
        root.setChildArtist(myTest9()); // <======================= CHANGE THIS TO TEST
        
        // put that widget in a frame so we have a layout object above it to 
        // listen to the fact that it doesn't want to be expanded to fill the
        // screen (the frame gets expanded, but then the root object stays 
        // it's original size within the frame).  
        FrameLayout frame = new FrameLayout(this);
        frame.addView(root);
        setContentView(frame);
    }

    // Basic test of SimpleFrames
    protected Artist myTest1() {
        Artist rootFrame = new SimpleFrame(0, 0, 500, 500);
        Artist childFrame = new SimpleFrame(50, 50, 100, 200);

        childFrame.addChild(new SimpleFrame(5, 5, 150, 190));
        rootFrame.addChild(childFrame);

        rootFrame.addChild(new SimpleFrame(80, 70, 100, 200));

        return rootFrame;
    }


    // Basic test of SolidBackDrops
    protected Artist myTest2() {
        Artist rootBackDrop = new SolidBackDrop(0, 0, 800, 500, Color.CYAN);

        Artist drop2 = new SolidBackDrop(30, 30, 200, 200, Color.GRAY);
        Artist drop3 = new SolidBackDrop(5, 5, 190, 190, Color.BLACK);

        Artist drop4 = new SolidBackDrop(300, 80, 200, 200, Color.WHITE);
        Artist drop5 = new SolidBackDrop(1, 1, 198, 198, Color.BLACK);

        Artist drop6 = new SolidBackDrop(100, 300, 150, 150, Color.GREEN);
        Artist drop7 = new SolidBackDrop(0, 0, 100, 200, Color.BLACK);
        Artist drop8 = new SolidBackDrop(50, 50, 50, 50, Color.YELLOW);

        drop2.addChild(drop3);
        drop4.addChild(drop5);
        drop6.addChild(drop7);
        drop6.addChild(drop8);
        rootBackDrop.addChild(drop2);
        rootBackDrop.addChild(drop4);
        rootBackDrop.addChild(drop6);

        return rootBackDrop;
    }


    // icon test
    protected Artist myTest3() {
        Artist rootBackDrop = new SolidBackDrop(0, 0, 800, 800, Color.CYAN);

        Bitmap iconBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        Artist icon1 = new Icon(0, 0, iconBitmap1);

        Bitmap iconBitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.bluebutton);
        Artist icon2 = new Icon(40, 10, iconBitmap2);

        rootBackDrop.addChild(icon1);
        rootBackDrop.addChild(icon2);

        return rootBackDrop;
    }


    // nine part image test
    protected Artist myTest4() {
        Artist rootBackDrop = new SolidBackDrop(0, 0, 800, 800, Color.CYAN);

        Bitmap patchImage = BitmapFactory.decodeResource(getResources(), R.drawable.bluebutton);
        byte[] chunk = patchImage.getNinePatchChunk();
        NinePatch np = new NinePatch(patchImage, chunk, null);

        Artist npImage = new NinePartImage(50, 50, 400, 200, np);

        rootBackDrop.addChild(npImage);

        return rootBackDrop;
    }


    // text artist test
    protected Artist myTest5() {
        Artist rootBackDrop = new SolidBackDrop(0, 0, 800, 800, Color.CYAN);

        Typeface type1 = Typeface.create("sans-serif-light", Typeface.NORMAL);
        Typeface type2 = Typeface.create("sans-serif", Typeface.ITALIC);
        Typeface type3 = Typeface.create("sans-serif-condensed", Typeface.BOLD);

        TextArtist text1 = new TextArtist(100, 50, "Testinggggg text artist!", type1, 24);

        TextArtist text2 = new TextArtist(0, 0, "blaaaaah", type2, 12);
        text1.addChild(text2);

        TextArtist text3 = new TextArtist(300, 300, "W y b W g j W", type3, 30);


        TextArtist text4 = new TextArtist(100, 50, "Testing ROW", type1, 24); //not really

        rootBackDrop.addChild(text1);
        rootBackDrop.addChild(text3);
        rootBackDrop.addChild(text4);

        return rootBackDrop;
    }


    // pile test
    protected Artist myTest6() {
        Artist pile = new Pile(0, 0, 500, 500);

        Artist backDrop = new SolidBackDrop(0, 0, 400, 400, Color.CYAN);
        pile.addChild(backDrop);

        Artist simpleFrame = new SimpleFrame(10, 10, 100, 100);
        pile.addChild(simpleFrame);

        Bitmap iconBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        Artist icon = new Icon(0, 0, iconBitmap1);
        pile.addChild(icon);

        Typeface type1 = Typeface.create("sans-serif-light", Typeface.NORMAL);
        TextArtist text1 = new TextArtist(100, 50, "Testing PILE", type1, 24);
        pile.addChild(text1);

        return pile;
    }


    // row test
    protected Artist myTest7() {
        Artist row = new Row(0, 0, 750, 500);

        Artist backDrop = new SolidBackDrop(0, 0, 400, 400, Color.CYAN);
        row.addChild(backDrop);

        Artist simpleFrame = new SimpleFrame(10, 10, 100, 100);
        row.addChild(simpleFrame);

        Typeface type1 = Typeface.create("sans-serif-light", Typeface.NORMAL);
        TextArtist text1 = new TextArtist(100, 50, "This is a Jg", type1, 24);
        row.addChild(text1);

        Artist simpleFrame2 = new SimpleFrame(10, 10, 100, 100);
        row.addChild(simpleFrame2);

        Bitmap iconBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        Artist icon = new Icon(0, 0, iconBitmap1);
        row.addChild(icon);

        return row;
    }


    // column test
    protected Artist myTest8() {
        Artist column = new Column(0, 0, 800, 800);

        Artist backDrop = new SolidBackDrop(0, 0, 400, 400, Color.CYAN);
        column.addChild(backDrop);

        Artist simpleFrame = new SimpleFrame(10, 10, 100, 100);
        column.addChild(simpleFrame);

        Typeface type1 = Typeface.create("sans-serif-light", Typeface.NORMAL);
        TextArtist text1 = new TextArtist(100, 50, "This is a Jg", type1, 24);
        column.addChild(text1);

        Artist simpleFrame2 = new SimpleFrame(10, 10, 100, 100);
        column.addChild(simpleFrame2);

        Bitmap iconBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        Artist icon = new Icon(0, 0, iconBitmap1);
        column.addChild(icon);

        return column;
    }


    // circle test
    protected Artist myTest9() {
        Artist circle = new Circle(0, 0, 1000, 1000, 200, 200, 150);

//        Artist backDrop1 = new SolidBackDrop(0, 0, 50, 50, Color.CYAN);
//        circle.addChild(backDrop1);
//
//        Artist backDrop2 = new SolidBackDrop(0, 0, 10, 10, Color.GRAY);
//        circle.addChild(backDrop2);
//
//        Artist backDrop3 = new SolidBackDrop(0, 0, 100, 25, Color.RED);
//        circle.addChild(backDrop3);
//
//        Artist backDrop4 = new SolidBackDrop(0, 0, 5, 30, Color.GREEN);
//        circle.addChild(backDrop4);



        Artist backDrop1 = new SimpleFrame(0, 0, 50, 50);
        circle.addChild(backDrop1);

        Artist backDrop2 = new SimpleFrame(0, 0, 10, 10);
        circle.addChild(backDrop2);

        Artist backDrop3 = new SimpleFrame(0, 0, 100, 25);
        circle.addChild(backDrop3);

        Artist backDrop4 = new SimpleFrame(0, 0, 5, 30);
        circle.addChild(backDrop4);



//
//        Artist backDrop5 = new SolidBackDrop(0, 0, 50, 50, Color.CYAN);
//        circle.addChild(backDrop5);

//        Artist simpleFrame = new SimpleFrame(10, 10, 100, 100);
//        circle.addChild(simpleFrame);
//
//        Typeface type1 = Typeface.create("sans-serif-light", Typeface.NORMAL);
//        TextArtist text1 = new TextArtist(100, 50, "This is a Jg", type1, 24);
//        circle.addChild(text1);
//
//        Artist simpleFrame2 = new SimpleFrame(10, 10, 100, 100);
//        circle.addChild(simpleFrame2);
//
//        Bitmap iconBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
//        Artist icon = new Icon(0, 0, iconBitmap1);
//        circle.addChild(icon);

        return circle;
    }


    // oval test
    protected Artist myTest10() {
        Artist oval = new OvalClip(0, 0, 500, 300);

        Artist backDrop1 = new SolidBackDrop(0, 0, 300, 300, Color.GRAY);
        oval.addChild(backDrop1);

        Artist backDrop2 = new SolidBackDrop(100, 100, 300, 300, Color.CYAN);
        oval.addChild(backDrop2);

        return oval;
    }




    protected Artist buildTest() {
        // create and return a test Artist tree here...
        Artist child = new ArtistBase();
        child.addChild(new ArtistBase());
        return /* replace this: */ new ArtistBase();
    }




//	protected Artist buildTest1(){
//		SolidBackDrop rootArtist = new SolidBackDrop(0, 0, 400, 800, Color.WHITE);
//		putAll(rootArtist);
//		Pile p = new Pile(5, 200, 100, 100);
//		p.addChild(new SolidBackDrop(0, 0, 900, 900, Color.GRAY));
//		p.addChild(new SimpleFrame(0, 0, 100, 100));
//		rootArtist.addChild(p);
//		putAll(p);
//		p.addChild(new SolidBackDrop(0, 0, 20, 20, Color.GRAY));
//		Row r = new Row(5, 310, 350, 50);
//		rootArtist.addChild(r);
//		putAll(r);
//		Column col = new Column(5, 370, 50, 200);
//		rootArtist.addChild(col);
//		putAll(col);
//
//		return rootArtist;
//	}
//
//    protected Artist buildTest2(){
//		SolidBackDrop rootArtist = new SolidBackDrop(0, 0, 400, 800, Color.WHITE);
//		SolidBackDrop s = new SolidBackDrop(0, 0, 50, 50, Color.GREEN);
//		rootArtist.addChild(s);
//		s.setPosition(-40, -40);
//		SolidBackDrop s2 = new SolidBackDrop(0, 0, 50, 50, Color.BLUE);
//		rootArtist.addChild(s2);
//		SolidBackDrop s3 = new SolidBackDrop(0, 0, 50, 50, Color.RED);
//		rootArtist.addChild(s3);
//		rootArtist.moveChildLast(s);
//		rootArtist.removeChild(s3);
//
//		Circle c = new Circle(100, 100, 300, 400, 150, 200, 100);
//		rootArtist.addChild(c);
//		for(int i = 0; i<8; i++){
//			c.addChild(new SolidBackDrop(0, 0, 20, 20, Color.BLUE));
//		}
//		SolidBackDrop s4 = new SolidBackDrop(100, 100, 50, 50, Color.MAGENTA);
//		c.addChild(s4);
//		rootArtist.addChild(s4);
//
//		OvalClip o = new OvalClip(5, 200, 50, 50);
//		rootArtist.addChild(o);
//		o.addChild(new SolidBackDrop(0, 0, 50, 50, Color.BLUE));
//		putAll(o, true);
//
//		return rootArtist;
//	}
//
//    protected Artist buildTest3(){
//		SolidBackDrop rootArtist = new SolidBackDrop(0, 0, 400, 800, Color.WHITE);
//
//		try{
//			rootArtist.addChild(null);
//			Log.d("ssui_grading", "Add null child:PASS");
//		} catch (Exception e){
//			Log.d("ssui_grading", "Add null Child:FAIL");
//		}
//
//		try{
//			if(rootArtist.getChildAt(-1) == null)
//				Log.d("ssui_grading", "Get bad Child:PASS");
//			else
//				Log.d("ssui_grading", "Get bad Child:FAIL");
//		} catch (Exception e){
//			Log.d("ssui_grading", "Get bad Child:FAIL");
//		}
//
//		try{
//			if(rootArtist.findChild(new SolidBackDrop(0, 0, 400, 800, Color.WHITE)) == -1 && rootArtist.findChild(null) == -1)
//				Log.d("ssui_grading", "Find bad Child:PASS");
//			else
//				Log.d("ssui_grading", "Find bad Child:FAIL");
//		} catch (Exception e){
//			Log.d("ssui_grading", "Find bad Child:FAIL");
//		}
//
//
//		try{
//			rootArtist.moveChildLater(new SolidBackDrop(0, 0, 400, 800, Color.WHITE));
//			rootArtist.moveChildLater(null);
//			Log.d("ssui_grading", "Move bad Child:PASS");
//		} catch (Exception e){
//			Log.d("ssui_grading", "Move bad Child:FAIL");
//		}
//
//		try{
//			SolidBackDrop s = new SolidBackDrop(0, 0, 50, 50, Color.GREEN);
//			s.setPosition(null);
//			s.setSize(null);
//			Log.d("ssui_grading", "Set position/size null:PASS");
//		} catch (Exception e){
//			Log.d("ssui_grading", "Set position/size null:FAIL");
//		}
//
//		return rootArtist;
//	}
//
//  protected void putAll(Artist rootArtist){putAll(rootArtist, false);}
//
//	protected void putAll(Artist rootArtist, boolean allAtOrigin){
//		if(allAtOrigin){
//			rootArtist.addChild(new SimpleFrame(0, 0, 20, 20));
//			rootArtist.addChild(new SolidBackDrop(0, 0, 20, 20, Color.BLUE));
//			rootArtist.addChild(new Icon(0, 0, BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)));
//			Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.bluebutton);
//			NinePatch patches = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
//			rootArtist.addChild(new NinePartImage(0, 0, 200, 20, patches));
//			rootArtist.addChild(new TextArtist(0, 0, "SSUI RoCkS!!!!", Typeface.DEFAULT_BOLD, 50f));
//		}
//		else{
//			rootArtist.addChild(new SimpleFrame(5, 5, 20, 20));
//			rootArtist.addChild(new SolidBackDrop(5, 30, 20, 20, Color.BLUE));
//			rootArtist.addChild(new Icon(5, 55, BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)));
//			Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.bluebutton);
//			NinePatch patches = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
//			rootArtist.addChild(new NinePartImage(30, 5, 200, 20, patches));
//			rootArtist.addChild(new TextArtist(30, 30, "SSUI RoCkS!!!!", Typeface.DEFAULT_BOLD, 50f));
//		}
//	}
}
