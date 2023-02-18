package ma.enset.calculatrice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewPropertyAnimatorListener;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView enter, result;
    MaterialButton ButtonC, ButtonAC, Button0, Button1, Button2, Button3, Button4, Button5, Button6, Button7,
            Button8, Button9, ButtonVir, ButtonRight, ButtonLeft, ButtonDiv, ButtonMul, ButtonSus, ButtonAdd, ButtonEq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter = findViewById(R.id.textview_enter);
        result = findViewById(R.id.textview_result);

        clickButtons(Button0, R.id.button0);
        clickButtons(Button1, R.id.button1);
        clickButtons(Button2, R.id.button2);
        clickButtons(Button3, R.id.button3);
        clickButtons(Button4, R.id.button4);
        clickButtons(Button5, R.id.button5);
        clickButtons(Button6, R.id.button6);
        clickButtons(Button7, R.id.button7);
        clickButtons(Button8, R.id.button8);
        clickButtons(Button9, R.id.button9);
        clickButtons(ButtonVir, R.id.buttonVerg);
        clickButtons(ButtonLeft, R.id.button_left);
        clickButtons(ButtonRight, R.id.button_right);

        clickButtons(ButtonDiv, R.id.button_div);
        clickButtons(ButtonMul, R.id.button_mul);
        clickButtons(ButtonSus, R.id.button_sus);
        clickButtons(ButtonAdd, R.id.button_add);
        clickButtons(ButtonEq, R.id.button_eq);
        clickButtons(ButtonAC, R.id.buttonAC);
        clickButtons(ButtonC, R.id.button_C);

    }

    void clickButtons(MaterialButton button, int id) {
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String buttonTxt = button.getText().toString();

        String calcul = result.getText().toString();

        if (buttonTxt.equals("AC")) {
            enter.setText("0");
            result.setText("");
            return;
        }
        if (buttonTxt.equals("=")) {
            calcul = enter.getText().toString();
            result.setText(calcul);
            return;
        }
        if (buttonTxt.equals("C")) {
            calcul = calcul.substring(0, calcul.length() - 1);
        } else {
            calcul += buttonTxt;
        }
        result.setText(calcul);
        String finalResults = getResult(calcul);
        if (!finalResults.equals("Error")){
            enter.setText(finalResults);
        }
    }

    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (finalResult.endsWith(".0")){
                finalResult=finalResult.replace(".0","");
            }
            return finalResult;

        } catch (Exception e) {
            return "Error";
        }
    }
}