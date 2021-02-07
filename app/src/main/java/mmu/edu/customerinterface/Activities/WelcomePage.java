package mmu.edu.customerinterface.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import mmu.edu.customerinterface.R;

import static android.widget.Toast.LENGTH_SHORT;

public class WelcomePage extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), ClientDashBoard.class));
            finish();
        }
        configureGetStartedButton();
    }

    private void configureGetStartedButton() {
        Button getStartedButton = findViewById(R.id.GetStartedbutton);
        getStartedButton.setOnClickListener(view -> {
                    startActivity(new Intent(WelcomePage.this, HowToActivity1.class));
                    finish();
                }
        );
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", LENGTH_SHORT).show();
        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
    }
}