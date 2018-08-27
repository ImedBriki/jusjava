
package com.example.android.jusjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * this method to display text on the screen
     */
    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;
        if (addWhippedCream){
            basePrice += 1;
        }

        if (addChocolate){
            basePrice += 2;
        }

        return basePrice * quantity;
    }

    /**
     * This method is called to display order message.
     */
    public String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChoclate, String name){

        String msg = "Name: " + name  + "\n Quantity: " + quantity + "\nTotal:$ " + price;
        msg += "\nAdd WhippedCream? " + hasWhippedCream;
        msg += "\nAdd Chocolate? " + hasChoclate;
        msg += "\n thank you!";
        return msg;

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       /* EditText nameField = (EditText)findViewById(R.id.name_filed);
        String name= nameField .getText().toString();
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox choclateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChoclate = choclateCheckBox.isChecked();
        int price = calculatePrice(hasWhippedCream, hasChoclate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChoclate, name);
        displayMessage(priceMessage); */

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:36.7948624, 10.0732372"));
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    int quantity = 2;

    /**
     * This method to increment.
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_LONG).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);

    }

    /**
     * This method to decrement.
     */
    public void decrement(View view) {
        if (quantity == 1){
            Toast.makeText(this, "You cannot have less than one coffee", Toast.LENGTH_LONG).show();
            return;
        }
            quantity = quantity - 1;
            display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}