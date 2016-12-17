package com.essai.secondapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    Button submit;
    DatePickerDialog dpd = null;

    Button btn;
    int year_x,month_x,day_x;
    static final int DIALOG_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //récuperer des éléments graphiques en objet java
        TextView tv_hw = (TextView)findViewById(R.id.tv_hello_world);
        final TextView btn_hw = (Button)findViewById(R.id.btn_hello_world);

        // ajouter la date dans un TextView

        // Implémenter un clique qui lance un toast

        btn_hw.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) { //Tous les objets graphiques héritent de View
                                          TextView changeMe = (Button)findViewById(R.id.btn_hello_world); // on récupère le boutton
                                          changeMe.setText("Yes");// Change le texte, le remplace par yes
                                          Toast.makeText(getApplicationContext(),"Apps is running",Toast.LENGTH_LONG).show();//Ne marche pas encore
                                      }
                                  }
        );

        btn_hw.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                TextView ColorMe = (Button)findViewById(R.id.btn_hello_world);
                ColorMe.setTextColor(Color.CYAN);// Met le texte en bleu cyan

                return true;
            }
        });


        ActionBar ab = getSupportActionBar();
        ab.setLogo(R.drawable.ic_stat_name);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);



        //showDialogOnButtonClick();




        // Créer le datePickerDialog
        //UI References
        /*final EditText fromDateEtxt = null;
        final EditText toDateEtxt = null;

        final DatePickerDialog fromDatePickerDialog = new DatePickerDialog(this);
        final DatePickerDialog toDatePickerDialog = new DatePickerDialog(this);
        //SimpleDateFormat dateFormatter;
        DatePickerDialog dpd = new DatePickerDialog(this);
        dpd.OnDateSetListener();*/
        //dateFormatter = new SimpleDateFormat(“dd-MM-yyyy”, Locale.FRANCE);

        //fromDateEtxt.setOnClickListener(this);
        //toDateEtxt.setOnClickListener(this);

        //TextView fdate_hw = (TextView)findViewById(R.id.etxt_fromdate);
        //TextView tdate_hw = (TextView)findViewById(R.id.etxt_todate);
       /* TextView btn2_hw = (Button)findViewById(R.id.btn2_hello_world);

        btn2_hw.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View view) {
                                           if (view == fromDateEtxt) {
                                               fromDatePickerDialog.show();
                                           } else if (view == toDateEtxt) {
                                               toDatePickerDialog.show();
                                           }
                                       }
                                   });*/





    }

//La notification test
    public void showNotification(View view){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_stat_name);
        builder.setContentTitle("My notification");
        builder.setContentText("This is my first notification...");
        Intent intent = new Intent(this,Notif_class.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Notif_class.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NM.notify(0,builder.build());


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    public void showDialogOnButtonClick(){
        btn = (Button)findViewById(R.id.btn2_hello_world);

        btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerlistener, year_x,month_x, day_x);
        return null;

    }

    private DatePickerDialog.OnDateSetListener dpickerlistener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear;
            day_x = dayOfMonth;
            Toast.makeText(MainActivity.this,year_x + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();
        }
    };



}
