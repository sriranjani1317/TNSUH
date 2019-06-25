package cgg.gov.in.tnsuh;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import cgg.gov.in.tnsuh.Model.PersonasDetail;
import cgg.gov.in.tnsuh.Model.ShelterMainBean;
import cgg.gov.in.tnsuh.Model.ShelterResponseBean;
import cgg.gov.in.tnsuh.Model.Updateshelter;
import cgg.gov.in.tnsuh.gps.GPSTracker;
import cgg.gov.in.tnsuh.retrofit.ApiClient;
import cgg.gov.in.tnsuh.retrofit.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StockActivity extends AppCompatActivity {
    TextView tvlatitude, tvlongitude;
    Button btn_submit;
    private String latitude, longitude;
    private double mLat, mLng;
    GPSTracker gps;
    ImageView cam1;
    private int picNumber = 0;
    ShelterMainBean saveRequest;
    //Updateshelte updateshelterlistBeans;
    ProgressDialog pDialog;
    private Bitmap bmp, processedBitmap;
    private String result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatelocation);
        locationFinder();
        tvlatitude = (TextView) findViewById(R.id.latitude);
        tvlongitude = (TextView) findViewById(R.id.longitude);
        cam1 = (ImageView) findViewById(R.id.cam);
        latitude = String.valueOf(mLat);
        longitude = String.valueOf(mLng);
        tvlatitude.setText(latitude);
        tvlongitude.setText(longitude);
        btn_submit = (Button) findViewById(R.id.submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callupdatelocation();
                //   showResponseAlert("Location Updated Successfully", true);

            }
        });
        cam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picNumber = 1;

                openCamera();
            }
        });

    }

    private void openCamera() {

        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.CAMERA}, 5);
            }
        } else {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, 100);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 5) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 100);

            } else {
                Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();

            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (requestCode == 100 && resultCode == RESULT_OK) {

                bmp = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                if (picNumber == 1) {

                    processedBitmap = ProcessingBitmap();


                    if (processedBitmap != null) {
                        cam1.setImageBitmap(processedBitmap);

                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        processedBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                        byte[] arr = baos.toByteArray();
                        result1 = Base64.encodeToString(arr, Base64.DEFAULT);

                    } else if (requestCode == 200 && resultCode == RESULT_OK && data != null && data.getData() != null) {
                        Uri uri = data.getData();

                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), uri);
                            if (picNumber == 1) {
                                cam1.setImageBitmap(bitmap);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap ProcessingBitmap() {

        Bitmap bm1 = null;
        Bitmap newBitmap = null;

        try {
            bm1 = bmp;


            Bitmap.Config config = bm1.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;


            }

            newBitmap = Bitmap.createBitmap(bm1.getWidth(), bm1.getHeight(), config);
            Canvas newCanvas = new Canvas(newBitmap);


            newCanvas.drawBitmap(bm1, 0, 0, null);

            String currentDateTimeString = (String) DateFormat.format("yyyy/MM/dd kk:mm",
                    System.currentTimeMillis());

            if (latitude != null && longitude != null) {

                Paint paintText = new Paint(Paint.ANTI_ALIAS_FLAG);

                paintText.setTextSize(10);
                paintText.setStyle(Paint.Style.FILL);

                Rect rectText = new Rect();
                paintText.getTextBounds(latitude, 0, latitude.length(), rectText);

                paintText.setColor(Color.WHITE);
                newCanvas.drawText(currentDateTimeString,
                        0, 120, paintText);
                paintText.setColor(Color.WHITE);
                newCanvas.drawText(latitude,
                        0, 140, paintText);
                paintText.setColor(Color.WHITE);
                newCanvas.drawText(longitude,
                        0, 150, paintText);


            } else {

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return newBitmap;
    }


    //Geo Location
    private boolean locationFinder() {
        gps = new GPSTracker(StockActivity.this);

        if (gps.canGetLocation()) {
            mLat = gps.getLatitude();
            mLng = gps.getLongitude();

            latitude = String.valueOf(mLat);
            longitude = String.valueOf(mLng);
            return true;
        } else {

            gps.showSettingsAlert();
            return false;
        }

    }

    private void callupdatelocation() {


        saveRequest = new ShelterMainBean();
        Updateshelter us = new Updateshelter();
        us.setShelterId("1");
        us.setLatitude(latitude);
        us.setLongitude(longitude);
        us.setFile(result1);
        List<Updateshelter> updateshelters = new ArrayList<>();
        updateshelters.add(us);
        saveRequest.setPersonasDetails(updateshelters);


        saveinitateddata(saveRequest);
        String objectsting = new Gson().toJson(saveRequest);
        Log.e("request", objectsting);

    }


    private void saveinitateddata(ShelterMainBean saveCheckOutReq) {
    /*    pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();*/
//        if (CheckInternet.isOnline(OtherActiviesActivity.this)) {

//            progressbar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ShelterResponseBean> call = apiInterface.updatelocation(saveCheckOutReq);
        Log.i("retro_reguest", call.request().url() + "");
        call.enqueue(new Callback<ShelterResponseBean>() {
            @Override
            public void onResponse(Call<ShelterResponseBean> call, Response<ShelterResponseBean> response) {
                // pDialog.dismiss();
//                    progressbar.setVisibility(View.GONE);
                Log.i("retro_responce", response.body().toString());
                if (response.body() != null)
                    showResponseAlert(response.body().getPersonasDetails().toString(), true);
                else {
                    Toast.makeText(StockActivity.this, "Please try again", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<ShelterResponseBean> call, Throwable t) {
                // pDialog.dismiss();
//                    progressbar.setVisibility(View.GONE);
                Log.i("retro_error", t.toString());
//                    ShowRetroAlert.show(OtherActiviesActivity.this);
            }
        });
    }

    private void showResponseAlert(String message, final Boolean Flag) {
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(StockActivity.this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        if (Flag) {
                            Intent i = new Intent(StockActivity.this, Profile.class);
                            startActivity(i);
                        }
                    }
                });
        android.app.AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }
//        } else {
//            Toast.makeText(OtherActiviesActivity.this, getResources().getString(R.string.please_check_yourinternet), Toast.LENGTH_SHORT).show();
//        }
}

