package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class PaymentActivity extends AppCompatActivity implements PaymentResultWithDataListener {

    Button paybtn;
    TextView paytext;
    ImageView payback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Checkout.preload(getApplicationContext());

        paybtn = findViewById(R.id.paybtn);
        paytext = findViewById(R.id.paytext);
        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makepayment();
            }
        });
        payback = findViewById(R.id.pay_back);
        payback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentActivity.this,TrackingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void makepayment() {
        Checkout checkout = new Checkout();

            checkout.setKeyID("rzp_test_JuiYmArGmYBP4F");

            checkout.setImage(R.drawable.logo);

            final Activity activity = this;


            try {
                JSONObject options = new JSONObject();

                options.put("name", "Sizzling Bites");
                options.put("description", "Reference No. #123456");
                options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
//                options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
                options.put("theme.color", "#3399cc");
                options.put("currency", "INR");
                options.put("amount", "40000");//pass amount in currency subunits
                options.put("prefill.email", "gaurav.kumar@example.com");
                options.put("prefill.contact","9407106470");
                JSONObject retryObj = new JSONObject();
                retryObj.put("enabled", true);
                retryObj.put("max_count", 4);
                options.put("retry", retryObj);

                checkout.open(activity, options);

            } catch(Exception e) {
                Log.e(TAG, "Error in starting Razorpay Checkout", e);
            }
        }

    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        paytext.setText("Successful Payment ID :"+s);
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        paytext.setText("Failed and cause is :"+s);

    }
}

