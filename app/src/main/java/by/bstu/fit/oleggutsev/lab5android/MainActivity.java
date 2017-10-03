package by.bstu.fit.oleggutsev.lab5android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton mFamaleRadioButton;
    private RadioButton mMaleRadioButton;

    private EditText mWeightEditText;
    private EditText mHeightEditText;
    private EditText mYearsEditText;

    private TextView mFinalResultTextView;
    private TextView mValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFamaleRadioButton = (RadioButton) findViewById(R.id.GenderFamale_radioButton);
        mMaleRadioButton = (RadioButton) findViewById(R.id.GenderMale_radioButton);

        mWeightEditText = (EditText) findViewById(R.id.Weight_editText);
        mHeightEditText = (EditText) findViewById(R.id.Height_editText);
        mYearsEditText = (EditText) findViewById(R.id.Years_editText);

        mFinalResultTextView = (TextView) findViewById(R.id.FinalResult_textView);
        mValueTextView = (TextView) findViewById(R.id.Value_TextView);

        mFamaleRadioButton.setChecked(true);
    }

    public void event_onClick(View view) {
        switch (view.getId()) {
            case R.id.Sedentary_button:
                CalculationOfData(mWeightEditText.getText().toString(),
                        mHeightEditText.getText().toString(),
                        mYearsEditText.getText().toString(),
                        1.2f);
                break;
            case R.id.LevelActive_button:
                CalculationOfData(mWeightEditText.getText().toString(),
                        mHeightEditText.getText().toString(),
                        mYearsEditText.getText().toString(),
                        1.55f);
                break;
            case R.id.Intensive_button:
                CalculationOfData(mWeightEditText.getText().toString(),
                        mHeightEditText.getText().toString(),
                        mYearsEditText.getText().toString(),
                        1.725f);
                break;
        }
    }

    private void CalculationOfData(String weight, String height, String years, float amr) {
        double bmr = 0d;

        if(weight.isEmpty() || height.isEmpty() || years.isEmpty()) return;

        if (mFamaleRadioButton.isChecked()) {
            bmr = 655.0955 + (9.5634 * Float.parseFloat(weight)) +
                    (1.8496 * Float.parseFloat(height)) - (4.6756 * Float.parseFloat(years));
        } else {
            bmr = 66.4730 + (13.7516 * Float.parseFloat(weight)) +
                    (5.0033 * Float.parseFloat(height)) - (6.7550 * Float.parseFloat(years));
        }

        mFinalResultTextView.setText(String.valueOf(bmr * amr));
        mValueTextView.setVisibility(View.VISIBLE);
    }
}
