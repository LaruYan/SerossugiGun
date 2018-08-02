package kr.LaruYan.SerossugiGun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText et_inputText;
	Button btn_serolize;
	EditText et_inputHeight;
	CheckBox chkb_hasSpacesBetLines;
	CheckBox chkb_hasReversed;
	Button btn_sendto;
	TextView tv_serolizedText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_serolizerui);
		
		et_inputText = (EditText)findViewById(R.id.editText_InputText);
		btn_serolize = (Button)findViewById(R.id.button_Serolize);
		et_inputHeight = (EditText)findViewById(R.id.editText_charsPerLine);
		chkb_hasSpacesBetLines = (CheckBox)findViewById(R.id.checkBox_hasSpacesBetweenLines);
		chkb_hasReversed = (CheckBox)findViewById(R.id.checkBox_hasReversed);
		btn_sendto = (Button)findViewById(R.id.button_SendTo);
		tv_serolizedText = (TextView)findViewById(R.id.textView_SerolizedText);
		
		
		btn_serolize.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View vw) {
				// TODO Auto-generated method stub
				tv_serolizedText.setText(
						Serossugi.Serolize(et_inputText.getText().toString(),et_inputHeight.getText().toString(),chkb_hasSpacesBetLines.isChecked(),chkb_hasReversed.isChecked())
						);
				if(btn_sendto.isEnabled() != true){
					btn_sendto.setEnabled(true);
				}
			}
			
		});
		btn_sendto.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent.putExtra(Intent.EXTRA_TEXT, tv_serolizedText.getText().toString());
				sendIntent.setType("text/plain");
				startActivity(sendIntent);
			}});
	}
}
