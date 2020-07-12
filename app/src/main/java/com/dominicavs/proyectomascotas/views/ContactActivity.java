package com.dominicavs.proyectomascotas.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dominicavs.proyectomascotas.R;
import com.dominicavs.proyectomascotas.utils.JavaMailAPI;
import com.google.android.material.textfield.TextInputEditText;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar inActionBar;
    private TextView tvToolbarTitle;
    private TextInputEditText etName;
    private TextInputEditText etEmail;
    private TextInputEditText etMessage;
    private Button btnSendComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        inActionBar = (Toolbar) findViewById(R.id.inActionBar);
        tvToolbarTitle = (TextView) inActionBar.findViewById(R.id.tvToolbarTitle);
        tvToolbarTitle.setText(getResources().getString(R.string.app_name));
        setSupportActionBar(inActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etName = (TextInputEditText) findViewById(R.id.etName);
        etName.requestFocus();
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etMessage = (TextInputEditText) findViewById(R.id.etMessage);
        btnSendComment = (Button) findViewById(R.id.btnSendComment);
        btnSendComment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendComment:
                sendMail();
                break;
            default:
                break;
        }
    }

    private void sendMail() {
        String emailSend = etEmail.getText().toString().trim();
        String nameSend = etName.getText().toString().trim();
        String messageSend = etMessage.getText().toString();
        String subjectSend = getResources().getString(R.string.name_email);
        String messageContent;

        if (TextUtils.isEmpty(emailSend) || TextUtils.isEmpty(messageSend) || TextUtils.isEmpty(nameSend)) {
            Toast.makeText(this, "¡Completar los campos!", Toast.LENGTH_SHORT).show();
        } else {
            messageContent = "Nombre: " + nameSend + "\nMensaje: " + messageSend;

            JavaMailAPI javaMailAPI = new JavaMailAPI(this, emailSend, subjectSend, messageContent);
            javaMailAPI.execute();

            // Clear fields
            etEmail.setText("");
            etName.setText("");
            etMessage.setText("");
            etName.requestFocus();
        }
    }
}
