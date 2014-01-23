package info.jackrex.doubleseekbar;

import info.jackrex.doubleseekbar.DoubleSeekView.OnSeekBarChangeListener;

import java.math.BigDecimal;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	EditText addoil,oilbox;
	
	DoubleSeekView doubleSeekView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addoil = (EditText) findViewById(R.id.addoil);
		oilbox = (EditText) findViewById(R.id.oilbox);
		doubleSeekView = (DoubleSeekView)findViewById(R.id.doubleseekview);

		initListener();
	}

	
	
	
	
	
	private void initListener() {
		// TODO Auto-generated method stub
		
		
		
		
		
		oilbox.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
				
				try {
					
					
				if(TextUtils.isEmpty(addoil.getText().toString())){
					
					Toast.makeText(MainActivity.this, "请输入加油数量", 0).show();
					return;
				}else if(TextUtils.isEmpty(oilbox.getText().toString())){
					
					Toast.makeText(MainActivity.this, "请输入正确的加油量", 0).show();
					return;
					
				}else {
					
					BigDecimal oil = new BigDecimal(addoil.getText().toString());
					BigDecimal box = new BigDecimal(oilbox.getText().toString());
					
					if(oil.floatValue()>box.floatValue()) {
						
						Toast.makeText(MainActivity.this, "油量不能大于邮箱", 0).show();
						return;
						
					} else {
						
						float percent = oil.floatValue()/box.floatValue();
						Log.e("percent is :", percent+"");
						int length = (int) (percent * doubleSeekView.getTotal());
						doubleSeekView.setmMiddleLength(length);
						
					}
					
					
				}				
					
					
					
					
					
				} catch (NumberFormatException e) {
					// TODO: handle exception
					Toast.makeText(MainActivity.this, "请输入正确的数据", 0).show();
				}catch (Exception e) {
					// TODO: handle exception
					Toast.makeText(MainActivity.this, "请输入正确的数据", 0).show();
				}
				
			}
		});
		
		
		
		
		doubleSeekView.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onProgressChanged(DoubleSeekView seekBar, int preOil,
					int afterOil) {
				// TODO Auto-generated method stub
				//get data here
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
