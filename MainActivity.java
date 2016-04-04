package com.example.progressbar;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ProgressBar pb;
	int progress;
	Button b1;
	 ProgressDialog pd;

	 Handler handle;

TextView t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		t1=(TextView)findViewById(R.id.textView1);
		b1=(Button)findViewById(R.id.bbb);
		//pb=(ProgressBar)findViewById(R.id.pB1);
		
        b1.setOnClickListener(new OnClickListener()
        
  {
		
 @Override
			
public void onClick(View arg0) 
		  
  {
	
		 // TODO Auto-generated method stub
		
	 showDialog(1);

	progress = 0;
		
        pd.setProgress(0);

	handle.sendEmptyMessage(0);
		
	}
		
});


        
        handle = new Handler()

        {

         public void handleMessage(Message msg)

         {

           super.handleMessage(msg);
  
         if(progress>=100)
     
      {
    
    	pd.dismiss();
  
      	
           }

           else
     
      {
   
     	progress++;
        
	pd.incrementProgressBy(1);
   
     	handle.sendEmptyMessageDelayed(0,100);
  
      	try
   
     	{
			
 Thread.sleep(500);

			}
        	
catch (InterruptedException e)
 
        	{
	
		// TODO Auto-generated catch block
	
		 e.printStackTrace();

			}
        
   }
 
          
         }
   
     };
   
   
    
    }


    protected Dialog onCreateDialog(int i)
   
 {
	 
 pd = new ProgressDialog(this);
	 
 pd.setIcon(R.drawable.ic_launcher);
	 
 pd.setTitle("Submiting in progress.......");
	 
 pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
 pd.setButton(DialogInterface.BUTTON_POSITIVE,"Exit",new DialogInterface.OnClickListener()
	
	
{

		 @Override

		public void onClick(DialogInterface arg0, int arg1) 
		 
   {

			 // TODO Auto-generated method stub
	
		 System.exit(0);	
	
		}
		
 });
  
	
  pd.setButton(DialogInterface.BUTTON_NEGATIVE,"Display",new DialogInterface.OnClickListener()

	  {
	
	@Override

		public void onClick(DialogInterface arg0, int arg1) 

		{
		 
// TODO Auto-generated method stub

		 Toast.makeText(getApplicationContext(),"Submiting has been completed",Toast.LENGTH_SHORT).show();	


		}

	 });

	
     pd.show();	

   	return pd;


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
