package com.nolanlawson.customsender;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DemoActivity extends Activity implements OnClickListener {

	private EditText subjectEditText, bodyEditText;
	private Button button;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        subjectEditText = (EditText) findViewById(android.R.id.text1);
        bodyEditText = (EditText) findViewById(android.R.id.text2);
        
        button = (Button) findViewById(android.R.id.button1);
        
        button.setOnClickListener(this);
        
    }


	public void onClick(View v) {
		
		final String subject = subjectEditText.getText().toString();
		final String body = bodyEditText.getText().toString();
		
		final SenderAppAdapter adapter = new SenderAppAdapter(this);
		
		new AlertDialog.Builder(this)
				.setTitle(R.string.share)
				.setCancelable(true)
				.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						adapter.respondToClick(which, subject, body);
						
						dialog.dismiss();
						
					}
				})
				.show();
		
	}
}