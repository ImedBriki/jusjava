
package com.example.android.jusjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
<<<<<<< HEAD
        int quantity = 2;
        displayPrice(quantity*5);
=======
        int numberOfCoffees = 2;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees*5);
>>>>>>> 89ed20f1dfe00ce8b86edb5ee5d9c642ede95fa2
    }

    /**
     * This method to increment.
     */
    public void increment(View view) {
        int quantity = 3;
        display(quantity);
    }
    /**
     * This method to decrement.
     */
    public void decrement(View view) {
        int quantity = 1;
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
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}