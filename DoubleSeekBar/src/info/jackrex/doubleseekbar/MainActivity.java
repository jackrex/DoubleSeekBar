package info.jackrex.doubleseekbar;

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

	EditText addOil, oilBox;
	DoubleSeekView doubleSeekView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addOil = (EditText) findViewById(R.id.addoil);
		oilBox = (EditText) findViewById(R.id.oilbox);
		doubleSeekView = (DoubleSeekView)findViewById(R.id.doubleseekview);
		initListener();
	}

	private void initListener() {
		// TODO Auto-generated method stub
		oilBox.addTextChangedListener(new TextWatcher() {

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
			    if (TextUtils.isEmpty(addOil.getText().toString())) {
				Toast.makeText(MainActivity.this, "请输入加油数量", 0).show();
			    } else if (TextUtils.isEmpty(oilBox.getText().toString())) {
				Toast.makeText(MainActivity.this, "请输入正确的加油量", 0).show();
			    } else {
				BigDecimal oil = new BigDecimal(addOil.getText().toString());
				BigDecimal box = new BigDecimal(oilBox.getText().toString());
				if (oil.floatValue() > box.floatValue()) {
				    Toast.makeText(MainActivity.this, "油量不能大于邮箱", 0).show();
				} else {
				    float percent = oil.floatValue() / box.floatValue();
				    Log.e("percent is :", percent + "");
				    int length = (int) (percent * doubleSeekView.getTotal());
				    doubleSeekView.setMiddleLength(length);
				}
			    }

			} catch (NumberFormatException e) {
			    // TODO: handle exception
			    Toast.makeText(MainActivity.this, "请输入正确的数据", 0).show();
			} catch (Exception e) {
			    // TODO: handle exception
			    Toast.makeText(MainActivity.this, "请输入正确的数据", 0).show();
			}

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
