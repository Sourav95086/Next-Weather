package com.nextgenius.nextweather;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView mtemp , mfeels , mmax_temp , mmin_temp , mhumidity , mwind_speed , mdiscription;
    ImageView imageView;
    private final String API_KEY = "6e875cc920a8503751dca0a784359395";
    String baseurl = "https://api.openweathermap.org/data/2.5/";
    double temp , max , min , feels_like , windspeed ;
    int humidity;
    String discription;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //getting id's
        button = findViewById(R.id.search_button);
        editText = findViewById(R.id.search);
        mtemp = findViewById(R.id.temp);
        mfeels = findViewById(R.id.feel_like);
        mmax_temp = findViewById(R.id.max);
        mmin_temp = findViewById(R.id.min);
        mhumidity = findViewById(R.id.humidity);
        mwind_speed = findViewById(R.id.windspeed);
        imageView = findViewById(R.id.discription);
        mdiscription = findViewById(R.id.mdiscription);
        progressBar = findViewById(R.id.bar);


        progressBar.setVisibility(View.INVISIBLE);


        //on click listner on search button

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = editText.getText().toString().trim();
                progressBar.setVisibility(View.VISIBLE);

                //checking search bar is empty or not
                if(city.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter city first ", Toast.LENGTH_SHORT).show();
                }else{

                    //creating retrofit object

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(baseurl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    //connecting retrofit with myapi interface

                    MyApi myapi = retrofit.create(MyApi.class);

                    //creating retrofit call

                    Call<ModalClass> call = myapi.getapi(city,API_KEY,"metric");
                    call.enqueue(new Callback<ModalClass>() {
                        @Override
                        public void onResponse(Call<ModalClass> call, Response<ModalClass> response) {
                            if(response.isSuccessful()){

                                //fetching data from api
                               ModalClass data = response.body();
                               // Log.d("weather", "temp is " + data.getMain().temperature + " and description is " + data.getWeathers()[0].description);
                                 temp = data.getMain().temperature;
                                 max = data.getMain().max_temp;
                                 min = data.getMain().min_temp;
                                 humidity = data.getMain().humidity;
                                 feels_like = data.getMain().feel_like;
                                 discription = data.getWeathers()[0].description;
                                 windspeed = data.getWind().windspeed;
                                 progressBar.setVisibility(View.INVISIBLE);
                                setimage(discription);
                                mtemp.setText(""+temp+"°C");
                                mfeels.setText("feels like : "+feels_like+"°C");
                                mmax_temp.setText("Max temp : "+max+"°C");
                                mmin_temp.setText("Min temp : "+min+"°C");
                                mhumidity.setText("Humidity : "+humidity);
                                mwind_speed.setText("Wind Speed : "+windspeed);
                                mdiscription.setText("Discription : "+discription);

                            }else{

                                //case of fetching falure
                                Toast.makeText(MainActivity.this, "cant identify city", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }

                        //case of no risponse

                        @Override
                        public void onFailure(Call<ModalClass> call, Throwable t) {
                            Log.d("error message", "error " +t.getMessage());
                        }
                    });
                }


            }
        });

        //seting text





    }
    public void setimage(String discription){
        if(discription.equals("clear sky")){
            imageView.setImageResource(R.drawable.sunny);
        }else if(discription.equals("Few Clouds") || discription.equals("Scattered Clouds") ){
            imageView.setImageResource(R.drawable.broken_cloud);
        }else if(discription.equals("Rain") || discription.equals("Drizzle") || discription.equals("Shower Rain") ){
            imageView.setImageResource(R.drawable.fully_raining);
        }else if(discription.equals("Thunderstorm")){
            imageView.setImageResource(R.drawable.thunder);
        }else {
            imageView.setImageResource(R.drawable.cloudy);
        }
    }
}