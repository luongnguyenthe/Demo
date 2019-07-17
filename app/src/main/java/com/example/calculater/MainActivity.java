package com.example.calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,
            btnCong,btnTru, btnNhan, btnChia,btnBang,btnAC,btnPhanTram,btnCham, btn;
    TextView txtHienThi,txtkq;
    float value1 = Float.NaN;
    float value2, t;
    boolean cong, tru, nhan ,chia;
    final char CONG ='+';
    final char TRU ='-';
    final char NHAN ='*';
    final char CHIA ='/';
    final char NUL =0;
    char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrols();
        addEvent();

    }

    private void addcontrols() {
        txtHienThi = findViewById(R.id.txtHienThi);
        txtkq = findViewById(R.id.txtkq);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnCham = findViewById(R.id.btnCham);
        btnBang= findViewById(R.id.btnBang);
        btn = findViewById(R.id.btn);
        btnAC = findViewById(R.id.btnAC);
        btnPhanTram = findViewById(R.id.btnPhanTram);
    }



    private void addEvent() {


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText(txtHienThi.getText()+"1");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText(txtHienThi.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText(txtHienThi.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText(txtHienThi.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText(txtHienThi.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText(txtHienThi.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText(txtHienThi.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText(txtHienThi.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText(txtHienThi.getText()+"9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText(txtHienThi.getText()+"0");
            }
        });
        btnCham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText(txtHienThi.getText()+".");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtHienThi.getText().length()>0){
                    String num = txtHienThi.getText().toString();
                    txtHienThi.setText(num.substring(0,txtHienThi.getText().length()-1));
                }
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText("");
                txtkq.setText("0");
                value1 = Float.NaN;
                value2 = Float.NaN;
                txtHienThi.setText(null);
                txtkq.setText(null);

            }
        });

       // -----------------------------------------------------------

        btnPhanTram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtkq.getText().length()>0){
                    txtkq.setText(String.valueOf(txtkq));
                }
            }
        });

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txtHienThi.getText() != "") {
                    compute();
                    ACTION = CONG;
                    txtkq.setText(String.valueOf(value1) + "+");

                    txtHienThi.setText(null);
                }
            }
         });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtHienThi.getText() != "") {
                compute();
                ACTION = TRU;
                txtkq.setText(String.valueOf(value1)+"-");
                txtHienThi.setText(null);
            }
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtHienThi.getText() != "") {
                    compute();
                    ACTION = NHAN;
                    txtkq.setText(String.valueOf(value1) + "*");
                    txtHienThi.setText(null);
                }
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtHienThi.getText() != "") {
                    compute();
                    ACTION = CHIA;
                    txtkq.setText(String.valueOf(value1) + "/");
                    txtHienThi.setText(null);

                }
            }
        });
        //--------------------------------------------------------
        btnBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = NUL;
                txtkq.setText( String.valueOf(value1));
                value2 = value1;
                txtHienThi.setText(null);
                txtHienThi.setText("0");
            }
        });
    }



    private void compute(){

        if(!Float.isNaN(value1)){

            if(txtHienThi.getText()!=""){
                value2 = Float.parseFloat(txtHienThi.getText().toString());
            }else{
                value2 = Float.parseFloat(txtkq.getText().toString());
            }

            switch(ACTION){

                case CONG:

                    value1 = value1 + value2;
                    break;
                case TRU:
                    value1 = value1 - value2;
                    break;

                case NHAN:
                    value1 = value1 * value2;
                    break;

                case CHIA:
                    value1 = value1 / value2;
                    break;

                case NUL:
                    break;
            }
        }else{
            value1 = Float.parseFloat(txtHienThi.getText().toString());
        }
    }

}
