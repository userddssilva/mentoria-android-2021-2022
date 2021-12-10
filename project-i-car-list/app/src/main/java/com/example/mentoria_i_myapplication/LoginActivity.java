package com.example.mentoria_i_myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentoria_i_myapplication.databinding.ActivityLoginBinding;

import kotlin.Unit;

public class LoginActivity extends AppCompatActivity {

    private String TAG = LoginActivity.class.getSimpleName();
    private Utils utils = new Utils();

    private ActivityLoginBinding binding;
    private boolean isLoading = false;

    private AlertDialog mLoginDialog;
    private ProgressBar mLoginLoading;
    private LinearLayout mLoginCard;
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setViewComponents();

        if (mLoginLoading.getVisibility() != View.GONE) {
            mLoginLoading.setVisibility(View.GONE);
        }

        if (mLoginCard.getVisibility() != View.VISIBLE) {
            mLoginCard.setVisibility(View.VISIBLE);
        }

        mButtonLogin.setOnClickListener(v -> {
            Log.d(TAG, "The button was clicked");
            displayLoginOptions();
        });
    }

    private void displayLoginOptions() {
        mLoginDialog.show();
    }

    private void setViewComponents() {
        mLoginLoading = findViewById(R.id.login_loading);
        mLoginCard = findViewById(R.id.login_card);
        mButtonLogin = findViewById(R.id.button_login);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.content_login_options, null));
        builder.setMessage("Log in");
        builder.setPositiveButton("Ok", (dialog, which) -> {
            startLoading();
        });
        mLoginDialog = builder.create();
    }

    private void startLoading() {
        mLoginCard.setVisibility(View.GONE);
        mLoginLoading.setVisibility(View.VISIBLE);
        utils.delayFunction(() -> {
            startContent();
            return Unit.INSTANCE;
        }, 3000);
    }

    private void startContent() {
        Intent intent = new Intent(this, CarsActivity.class);
        startActivity(intent);
    }
}