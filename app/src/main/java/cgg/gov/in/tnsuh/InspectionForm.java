package cgg.gov.in.tnsuh;

import android.app.Activity;
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
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.Formatter;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutionException;

import cgg.gov.in.tnsuh.Model.InspectionRequestMainBean;
import cgg.gov.in.tnsuh.Model.InspectionResponse;
import cgg.gov.in.tnsuh.Model.inspectionrequest;
import cgg.gov.in.tnsuh.gps.GPSTracker;
import cgg.gov.in.tnsuh.internetcheck.CheckInternet;
import cgg.gov.in.tnsuh.retrofit.ApiClient;
import cgg.gov.in.tnsuh.retrofit.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InspectionForm extends AppCompatActivity {

    private String Y = "Excellent";
    private String N = "Poor";
    private String Monthly = "Excellent";
    private String Quaterly = "Good";
    private String Halfyearly = "Poor";

    ProgressDialog pDialog;
    private String Formation, registration, attendanceselection, housekeepingselection, complaintsselection;
    private String Noofmeetings;
    RadioButton attendance_yes, attendance_no, housekeeping_yes, housekeeping_no, complaints_yes, complaints_no;
    private double issuesresolved;
    private double noofissuesresolve;
    private double noofissuesrasied;
    ImageView uploaddocument_imageview;
    private String Grade;
    private String Gradeformation;
    private String Grademeetings;
    private String Gradescale;
    private int Gradepoints;
    long roomdata, bathroomdata;
    TextView tvlatitude, tvlongitude;
    private String latitude, longitude;
    private double mLat, mLng;
    GPSTracker gps;
    private int picNumber = 0;

    private Bitmap bmp, processedBitmap;
    private int[] counsVals = new int[]{10, 9, 8, 7};
    //Capacity
    EditText nocapacity, magedpeople, Mdifferentlyabled, M_others, maletotal, F_Agedpeople, F_abled, F_others, femaletotal, C_Male, C_female, childtotal, NGORemark, housekeeping_remark,complaintsremark;
    int nnocapacity, nmagedpeople, nMdifferentlyabled, nM_others, nmaletotal, nF_Agedpeople, nF_abled, nF_others, nfemaletotal, nC_Male, nC_female, nchildtotal;
    EditText et_locationname, et_shelter_extent, enrollment_remark;
    int Capacitygrade;
    RadioButton rb_Yesregis_maintained, rb_Noregis_maintained,interactoin_yes,interactoin_no;
    LinearLayout registerdata;

    //Medical Camp
    EditText medicalremark, medicalcampnumber;
    RadioButton medicalyes, medicalno;
    String medicalcamp;
    EditText etUpto14, etMiddleage, etAbove50;
    //Festivals
    EditText nofestival, nofestivalremark;
    int nofestivalorganized;
    int festivgrade;
    String counsType,sus;
    //Excecutive Committee
    EditText dateofformation, noofissuesraised, noofissuesresolved, councilcampnumber, councilremark, attendance_remark;
    EditText etoutflow, etinflow,orientation,student_attended,drpstatus,overallremark;
    RadioButton susyes, susno;
    Spinner fundflow,Interactionspinner;
    RadioButton rb_Yescommitte, rb_nocommitte;
    EditText etToilets, etBathroom, etWoolen, etInmates;
    Spinner roomspinner, bathroomspinner, Councilspinner, onceinaspinner;
    private String result1;
    private String interactiondata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspectionform);
        uploaddocument_imageview = (ImageView) findViewById(R.id.uploaddocument_imageview);
        //Capacity
        Button submit = (Button) findViewById(R.id.submit);
        nocapacity = (EditText) findViewById(R.id.nocapacity);

        et_locationname = (EditText) findViewById(R.id.et_locationname);
        et_shelter_extent = (EditText) findViewById(R.id.et_shelter_extent);
        overallremark = (EditText) findViewById(R.id.overallremark);
        magedpeople = (EditText) findViewById(R.id.magedpeople);
        etInmates = (EditText) findViewById(R.id.etInmates);
        enrollment_remark = (EditText) findViewById(R.id.enrollment_remark);
        Mdifferentlyabled = (EditText) findViewById(R.id.Mdifferentlyabled);
        M_others = (EditText) findViewById(R.id.M_others);
        maletotal = (EditText) findViewById(R.id.maletotal);
        F_Agedpeople = (EditText) findViewById(R.id.F_Agedpeople);
        F_abled = (EditText) findViewById(R.id.F_abled);
        F_others = (EditText) findViewById(R.id.F_others);
        femaletotal = (EditText) findViewById(R.id.femaletotal);
        C_Male = (EditText) findViewById(R.id.C_Male);
        C_female = (EditText) findViewById(R.id.C_female);
        childtotal = (EditText) findViewById(R.id.childtotal);
        complaintsremark = (EditText) findViewById(R.id.complaintsremark);
        NGORemark = (EditText) findViewById(R.id.NGORemark);
        etAbove50 = (EditText) findViewById(R.id.etAbove50);
        etMiddleage = (EditText) findViewById(R.id.etMiddleage);
        etUpto14 = (EditText) findViewById(R.id.etUpto14);
        etToilets = (EditText) findViewById(R.id.etToilets);
        etBathroom = (EditText) findViewById(R.id.etBathroom);
        etWoolen = (EditText) findViewById(R.id.etWoolen);
        etinflow = (EditText) findViewById(R.id.etinflow);
        orientation = (EditText) findViewById(R.id.orientation);
        student_attended = (EditText) findViewById(R.id.student_attended);
        drpstatus = (EditText) findViewById(R.id.drpstatus);
        etoutflow = (EditText) findViewById(R.id.etoutflow);
        registerdata = (LinearLayout) findViewById(R.id.registerdata);
        rb_Noregis_maintained = (RadioButton) findViewById(R.id.rb_NOregis_maintained);
        rb_Yesregis_maintained = (RadioButton) findViewById(R.id.rb_Yesregis_maintained);
        susyes = (RadioButton) findViewById(R.id.susyes);
        attendance_yes = (RadioButton) findViewById(R.id.attendance_yes);
        housekeeping_yes = (RadioButton) findViewById(R.id.housekeeping_yes);
        housekeeping_no = (RadioButton) findViewById(R.id.housekeeping_no);
        complaints_yes = (RadioButton) findViewById(R.id.complaints_yes);
        complaints_no = (RadioButton) findViewById(R.id.complaints_no);
        susyes = (RadioButton) findViewById(R.id.susyes);
        attendance_no = (RadioButton) findViewById(R.id.attendance_no);
        roomspinner = (Spinner) findViewById(R.id.roomspinner);
        bathroomspinner = (Spinner) findViewById(R.id.bathroomspinner);
        Councilspinner = (Spinner) findViewById(R.id.Councilspinner);
        onceinaspinner = (Spinner) findViewById(R.id.onceinaspinner);
        fundflow = (Spinner) findViewById(R.id.assesmentspinner);
        Interactionspinner = (Spinner) findViewById(R.id.Interactionspinner);
        councilremark = (EditText) findViewById(R.id.councilremark);
        councilcampnumber = (EditText) findViewById(R.id.councilcampnumber);
        // Notify the selected item text

        //Medical
        medicalyes = (RadioButton) findViewById(R.id.medicalyes);
        interactoin_no = (RadioButton) findViewById(R.id.interaction_no);
        interactoin_yes = (RadioButton) findViewById(R.id.interactoin_yes);
        medicalno = (RadioButton) findViewById(R.id.medicalno);
        medicalcampnumber = (EditText) findViewById(R.id.medicalcampnumber);
        medicalremark = (EditText) findViewById(R.id.medicalremark);
        housekeeping_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                housekeepingselection = "N";
            }
        });
        housekeeping_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                housekeepingselection = "Y";
            }
        });
        uploaddocument_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });
        try {
            //issues
            //Excecutive Committee
            Spinner s = (Spinner) findViewById(R.id.meetingsspinner);
            s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Noofmeetings = (String) parent.getItemAtPosition(position);
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + Noofmeetings, Toast.LENGTH_SHORT)
                            .show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            rb_nocommitte = (RadioButton) findViewById(R.id.rb_nocommitte);
            rb_Yescommitte = (RadioButton) findViewById(R.id.rb_Yescommitte);
            dateofformation = (EditText) findViewById(R.id.dateofformation);
            noofissuesraised = (EditText) findViewById(R.id.noofissuesraised);
            housekeeping_remark = (EditText) findViewById(R.id.housekeeping_remark);
            noofissuesresolved = (EditText) findViewById(R.id.noofissuesresolved);
            attendance_remark = (EditText) findViewById(R.id.attendance_remark);
            attendance_yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    attendanceselection = "Y";
                }
            });
            attendance_no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    attendanceselection = "N";
                }
            });
            rb_Yescommitte.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dateofformation.setVisibility(View.VISIBLE);
                    Formation = "Y";
                }
            });
            rb_nocommitte.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dateofformation.setVisibility(View.GONE);
                    Formation = "N";
                }
            });

            rb_Noregis_maintained.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    registerdata.setVisibility(View.GONE);
                    registration = "N";
                }
            });
            rb_Yesregis_maintained.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    registerdata.setVisibility(View.VISIBLE);
                    registration = "Y";
                }
            });
            medicalyes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    medicalremark.setVisibility(View.GONE);
                    medicalcamp = "Y";
                }
            });
            medicalno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    medicalremark.setVisibility(View.VISIBLE);
                    medicalcamp = "N";
                }
            });interactoin_no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interactiondata = "N";
                }
            });interactoin_yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interactiondata = "Y";
                }
            });
            complaints_yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    complaintsselection = "Y";
                }
            }); complaints_no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    complaintsselection = "N";
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalculateCapacity();
                CalculateMedicalCamp();
                CalculateFestivals();
                CalculateExecComitee();
                CalculateSkillgrade();
                CalculateInfraGrade();
                CalculateCouncellingGrade();
                CalculateSusAsessment();
                Callpostworkinitiatedata();
              /*  Intent i = new Intent(InspectionForm.this, GradeReport.class);
                startActivity(i);*/
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


                uploaddocument_imageview.setImageBitmap(bmp);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] arr = baos.toByteArray();
                result1 = Base64.encodeToString(arr, Base64.DEFAULT);


            } else if (requestCode == 200 && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(InspectionForm.this.getContentResolver(), uri);

                    uploaddocument_imageview.setImageBitmap(bitmap);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public void CalculateCapacity() {
        try {
            double total = 0;
            double CapacityValidation;
            nnocapacity = Integer.parseInt(nocapacity.getText().toString().isEmpty() ? "0" : nocapacity.getText().toString());
            //Male
            nmagedpeople = Integer.parseInt(magedpeople.getText().toString().isEmpty() ? "0" : magedpeople.getText().toString());
            nMdifferentlyabled = Integer.parseInt(Mdifferentlyabled.getText().toString().isEmpty() ? "0" : Mdifferentlyabled.getText().toString());
            nM_others = Integer.parseInt(M_others.getText().toString().isEmpty() ? "0" : M_others.getText().toString());
            nmaletotal = nmagedpeople + nMdifferentlyabled + nM_others;
            //Female
            nF_Agedpeople = Integer.parseInt(F_Agedpeople.getText().toString().isEmpty() ? "0" : F_Agedpeople.getText().toString());
            nF_abled = Integer.parseInt(F_abled.getText().toString().isEmpty() ? "0" : F_abled.getText().toString());
            nF_others = Integer.parseInt(F_others.getText().toString().isEmpty() ? "0" : F_others.getText().toString());
            nfemaletotal = nF_Agedpeople + nF_abled + nF_others;
            //Children
            nC_Male = Integer.parseInt(C_Male.getText().toString().isEmpty() ? "0" : C_Male.getText().toString());
            nC_female = Integer.parseInt(C_female.getText().toString().isEmpty() ? "0" : C_female.getText().toString());
            nchildtotal = nC_Male + nC_female;
            total = nmaletotal + nfemaletotal + nchildtotal;
            CapacityValidation = (total / nnocapacity) * 100;

            if (CapacityValidation <= 50) {
                Capacitygrade = 4;
                NGORemark.setVisibility(View.GONE);

            } else if (CapacityValidation > 50 && CapacityValidation < 75) {
                Capacitygrade = 7;
                NGORemark.setVisibility(View.GONE);

            } else if (CapacityValidation > 75 && CapacityValidation < 90) {
                Capacitygrade = 8;
                NGORemark.setVisibility(View.GONE);

            } else if (CapacityValidation > 90 && CapacityValidation < 110) {
                Capacitygrade = 10;
                NGORemark.setVisibility(View.GONE);

            } else if (CapacityValidation >= 110) {
                NGORemark.setVisibility(View.VISIBLE);
            }
            MarksObtained.capacity = Capacitygrade;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CalculateMedicalCamp() {
        double nomedicalcamp, medicalgrade;
        int mgradepoint = 0;
        //Medical
        try {
            nomedicalcamp = Double.parseDouble(medicalcampnumber.getText().toString().isEmpty() ? "0" : medicalcampnumber.getText().toString());
            medicalgrade = nomedicalcamp / 3;
            if (medicalgrade == 1) {
                mgradepoint = 10;
            } else if (medicalgrade >= 0.5 && medicalgrade < 1) {
                mgradepoint = 8;
            } else if (medicalgrade >= 0.16 && medicalgrade < 0.5) {
                mgradepoint = 7;
            } else if (medicalgrade < 0.16) {
                mgradepoint = 4;
                medicalremark.setVisibility(View.VISIBLE);
            }
            MarksObtained.medicalcamp = mgradepoint;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CalculateFestivals() {
        //Festivals
        nofestival = (EditText) findViewById(R.id.nofestival);
        nofestivalremark = (EditText) findViewById(R.id.nofestivalremark);
        try {
            nofestivalorganized = Integer.parseInt(nofestival.getText().toString().isEmpty() ? "0" : nofestival.getText().toString());
            if (nofestivalorganized == 3) {
                festivgrade = 10;
            } else if (nofestivalorganized == 2) {
                festivgrade = 8;
            } else if (nofestivalorganized == 1) {
                festivgrade = 6;
            } else if (nofestivalorganized == 0) {
                festivgrade = 0;
                nofestivalremark.setVisibility(View.VISIBLE);
            }
            MarksObtained.festival = festivgrade;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CalculateExecComitee() {
        try {
            noofissuesresolve = Double.parseDouble(noofissuesresolved.getText().toString().isEmpty() ? "0" : noofissuesresolved.getText().toString());
            noofissuesrasied = Double.parseDouble(noofissuesraised.getText().toString().isEmpty() ? "0" : noofissuesraised.getText().toString());
            issuesresolved = noofissuesresolve / noofissuesrasied;
            if (issuesresolved == 1) {
                Grade = "E";
            } else if (issuesresolved < 1 && issuesresolved >= 0.5) {
                Grade = "G";
            } else if (issuesresolved < 0.5 && issuesresolved >= 0.25) {
                Grade = "SI";
            } else if (issuesresolved < 0.25) {
                Grade = "Poor";
            }
            //no of meetings

            if (Noofmeetings.equalsIgnoreCase("Monthly")) {
                Grademeetings = "M";
            } else if (Noofmeetings.equalsIgnoreCase("Quaterly")) {
                Grademeetings = "Q";
            } else if (Noofmeetings.equalsIgnoreCase("Halfyearly")) {
                Grademeetings = "H";
            }
            //formation

            if (Formation.equals("Y")) {
                Gradeformation = "Y";

            } else if (Formation.equals("N")) {
                Gradeformation = "N";
            }


            //10 point scale

            Gradescale = Gradeformation + Grademeetings + Grade;
            if (Gradescale.equals("YME")) {
                Gradepoints = 10;
            } else if (Gradescale.equals("YMG")) {
                Gradepoints = 9;
            } else if (Gradescale.equals("YMSI")) {
                Gradepoints = 8;
            } else if (Gradescale.equals("YMP")) {
                Gradepoints = 7;
            } else if (Gradescale.equals("YQE")) {
                Gradepoints = 9;
            } else if (Gradescale.equals("YQG")) {
                Gradepoints = 8;
            } else if (Gradescale.equals("YQSI")) {
                Gradepoints = 7;
            } else if (Gradescale.equals("YQP")) {
                Gradepoints = 6;
            } else if (Gradescale.equals("YHE")) {
                Gradepoints = 8;
            } else if (Gradescale.equals("YHG")) {
                Gradepoints = 7;
            } else if (Gradescale.equals("YHSI")) {
                Gradepoints = 6;
            } else if (Gradescale.equals("YHP")) {
                Gradepoints = 5;
            }
            MarksObtained.exccomitee = Gradepoints;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CalculateSkillgrade() {
        try {
            Double childrenPercent = Double.parseDouble(etUpto14.getText().toString().isEmpty() ? "0" : etUpto14.getText().toString());
            Double middleagePercent = Double.parseDouble(etMiddleage.getText().toString().isEmpty() ? "0" : etMiddleage.getText().toString());
            Double elderPercent = Double.parseDouble(etAbove50.getText().toString().isEmpty() ? "0" : etAbove50.getText().toString());
            String strGrade;
            int Grade = 0;
            if (childrenPercent < 25) {
                strGrade = "SI";
            } else if (childrenPercent >= 25 && childrenPercent < 50) {
                strGrade = "NS";
            } else if (childrenPercent >= 50 && childrenPercent < 75) {
                strGrade = "G";
            } else {
                strGrade = "E";
            }


            if (middleagePercent < 50) {
                strGrade += "SI";
            } else if (middleagePercent >= 50 && middleagePercent < 75) {
                strGrade += "G";
            } else {
                strGrade += "E";
            }

            if (elderPercent < 25) {
                strGrade += "G";
            } else {
                strGrade += "E";

            }

            switch (strGrade) {

                case "EEE":
                    Grade = 10;
                    break;
                case "EEG":
                case "EGE":
                case "GEE":
                case "GGG":
                    Grade = 9;
                    break;
                case "ESIG":
                case "ESIE":
                case "GGE":
                case "GSIE":
                case "GSIG":
                case "GEG":
                case "NSEE":
                    Grade = 8;
                    break;
                case "NSSIE":
                case "NSGG":
                case "NSGE":
                case "SIEE":
                case "NSEG":
                    Grade = 7;
                    break;
                case "NSSIG":
                case "SISIE":
                case "SIGG":
                case "SIGE":
                case "SIEG":
                    Grade = 6;
                    break;
                case "SISIG":
                    Grade = 5;
                    break;

            }
            MarksObtained.skilltraining = Grade;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void CalculateInfraGrade() {
        try {
            roomdata = roomspinner.getSelectedItemId();
            bathroomdata = bathroomspinner.getSelectedItemId();

            int grade = 0;
            int noOfInmates = Integer.parseInt(etInmates.getText().toString().isEmpty() ? "0" : etInmates.getText().toString());
            int noOfToilets = Integer.parseInt(etToilets.getText().toString().isEmpty() ? "0" : etToilets.getText().toString());
            int noOfBathroom = Integer.parseInt(etBathroom.getText().toString().isEmpty() ? "0" : etBathroom.getText().toString());
            int noOfBlankets = Integer.parseInt(etWoolen.getText().toString().isEmpty() ? "0" : etWoolen.getText().toString());

            int toiletPercent = 0;
            int bathPercent = 0;
            int blanketPercent = 0;

            if (noOfToilets != 0) {
                toiletPercent = noOfInmates / noOfToilets;
                grade += GetRoomGrade(toiletPercent);
            }

            if (noOfBathroom != 0) {
                bathPercent = noOfInmates / noOfBathroom;
                grade += GetRoomGrade(bathPercent);
            }
            if (noOfBlankets != 0) {
                blanketPercent = noOfInmates / noOfBlankets;
                if (blanketPercent >= 1) {
                    grade += 1;
                }
            }
            grade += roomdata + bathroomdata;

            MarksObtained.infra = grade;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CalculateCouncellingGrade() {
        try {
            String selIntervel = onceinaspinner.getSelectedItem().toString();
            if (selIntervel.equals("Once in a year")) {
                counsType = Councilspinner.getSelectedItem().toString();
                if (counsType.equals("External")) {
                    MarksObtained.councelling = 3;
                } else
                    MarksObtained.councelling = 5;
            } else {
                MarksObtained.councelling = counsVals[onceinaspinner.getSelectedItemPosition()];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CalculateSusAsessment() {
        try {

            String strGrade = "";
            String[] drpvals = new String[]{"M", "Q", "H"};
            int infFlow = Integer.parseInt(etinflow.getText().toString().isEmpty() ? "0" : etinflow.getText().toString());
            int outFlow = Integer.parseInt(etoutflow.getText().toString().isEmpty() ? "0" : etoutflow.getText().toString());

            if (susyes.isChecked()) {
                sus="Y";
                strGrade += "Y";
            } else {
                sus="N";
                strGrade += "N";
            }
            if (infFlow != 0) {
                double flowPercent = ((double) outFlow) / ((double) infFlow);
                if (flowPercent < 0.25) {
                    strGrade += "E";
                } else if (flowPercent >= 0.25 && flowPercent < 0.75) {
                    strGrade += "G";
                } else if (flowPercent >= 0.7 && flowPercent < 1) {
                    strGrade += "M";
                } else {
                    strGrade += "P";
                }
            }
            strGrade += drpvals[fundflow.getSelectedItemPosition()];

            switch (strGrade) {
                case "YME":
                    MarksObtained.assessment = 10;
                    break;
                case "YNG":
                case "YQE":
                    MarksObtained.assessment = 9;
                    break;
                case "YMM":
                case "YQG":
                case "YHE":
                    MarksObtained.assessment = 8;
                    break;
                case "YMP":
                case "YQM":
                case "YHG":
                    MarksObtained.assessment = 7;
                    break;
                case "YQP":
                case "YHM":
                    MarksObtained.assessment = 6;
                    break;
                case "YHP":
                    MarksObtained.assessment = 5;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int GetRoomGrade(int num) {
        if (num < 20) {
            return 2;
        } else if (num == 20) {
            return 1;
        } else {
            return 0;
        }
    }


    private void Callpostworkinitiatedata() {

        /*IMEI = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        WifiManager wm = (WifiManager) getApplicationContext().getApplicationContext().getSystemService(WIFI_SERVICE);
        ipaddress = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());*/


        inspectionrequest saveRequest = new inspectionrequest();

        saveRequest.setShelterId(GlobalDeclaration.shelterid);
        saveRequest.setShelterLocation(et_locationname.getText().toString());
        saveRequest.setShelterExtend(et_shelter_extent.getText().toString());
        saveRequest.setDistrictId("1");
        saveRequest.setCorporation("1");
        saveRequest.setShelterExecutiveCommittee(Formation);
        saveRequest.setShelterExecutiveCommitteeDate(dateofformation.getText().toString());
        saveRequest.setNoOfIssueRaised(noofissuesraised.getText().toString());
        saveRequest.setNoOfIssueResolved(noofissuesresolved.getText().toString());
        saveRequest.setExecutiveCommitteeMeeting(Noofmeetings);
        saveRequest.setNoInmates(etInmates.getText().toString());
        saveRequest.setAgedMale(maletotal.getText().toString());
        saveRequest.setAgedFemale(femaletotal.getText().toString());
        saveRequest.setDifferentlyAbledMale(String.valueOf(nMdifferentlyabled));
        saveRequest.setDifferentlyAbledFemale(String.valueOf(nF_abled));
        saveRequest.setOthersFemale(String.valueOf(nF_others));
        saveRequest.setOthersMale(String.valueOf(nM_others));
        saveRequest.setChildrensMale(String.valueOf(nC_Male));
        saveRequest.setChildrensFemale(String.valueOf(nC_female));
        saveRequest.setNgoName(NGORemark.getText().toString());
        saveRequest.setRegistersMaintainedNot(registration);
        saveRequest.setEnrollmentRegister("1");
        saveRequest.setEnrollmentRegisterRemarks(enrollment_remark.getText().toString());
        saveRequest.setMedicalRegister("1");
        saveRequest.setMedicalCampsConducted(medicalcamp);
        saveRequest.setMedicalCounselling(counsType);
        saveRequest.setMedicalCounsellingTime("1");
        saveRequest.setMedicalCounsellingsInYear(councilcampnumber.getText().toString());
        saveRequest.setMedicalCounsellingRemarks(councilremark.getText().toString());
        saveRequest.setAttendanceRegister(attendanceselection);
        saveRequest.setAttendanceRemarks(attendance_remark.getText().toString());
        saveRequest.setHouseKeepingRegister(housekeepingselection);
        saveRequest.setHouseKeepingRegisterRemarks(housekeeping_remark.getText().toString());
        saveRequest.setComplaintsSuggestionsRegister(complaintsselection);
        saveRequest.setComplaintsSuggestionsRegisterRemarks(complaintsremark.getText().toString());
        saveRequest.setAmenitiesToiletNoOfInmates(etInmates.getText().toString());
        saveRequest.setAmenitiesToiletNoOfToilets(etToilets.getText().toString());
        saveRequest.setAmenitiesBathroomNoOfBathrooms(etBathroom.getText().toString());
        saveRequest.setAmenitiesBathroomNoOfInmates("1");
        saveRequest.setAmenitiesCotsNoOfInmates(etWoolen.getText().toString());
        saveRequest.setAmenitiesCotsNoOfBedsheets("1");
        saveRequest.setCleaningOfRoom(String.valueOf(roomdata));
        saveRequest.setCleaningOfBathroom(String.valueOf(bathroomdata));
        saveRequest.setBankAccountFormed(sus);
        saveRequest.setFundInFlow(etinflow.getText().toString());
        saveRequest.setFundOutFlow(etoutflow.getText().toString());
        saveRequest.setCorpusFundTime(String.valueOf(fundflow.getSelectedItemPosition()));
        saveRequest.setInteractionCollegeArrangingProjectWorkStudents(interactiondata);
        saveRequest.setOrientationPerMonth(orientation.getText().toString());
        saveRequest.setNoOfStudentsPerMonth(student_attended.getText().toString());
        saveRequest.setOrientationPeriod(String.valueOf(Interactionspinner.getSelectedItemPosition()));
        saveRequest.setDprStatus(drpstatus.getText().toString());
        saveRequest.setSuggestionsOfInmates(result1);
        saveRequest.setOverallRemarks(overallremark.getText().toString());
        saveRequest.setFestivalsOrganizedPerYear(String.valueOf(nofestivalorganized));
        saveRequest.setAuditorId(GlobalDeclaration.username);
        saveRequest.setMarksCapacity(String.valueOf(MarksObtained.capacity));
        saveRequest.setMarksMedicalCamp(String.valueOf(MarksObtained.medicalcamp));
        saveRequest.setMarksFestivalOrganized(String.valueOf(MarksObtained.festival));
        saveRequest.setMarksSkillTraining(String.valueOf(MarksObtained.skilltraining));
        saveRequest.setMarksCounsellingFacility(String.valueOf(MarksObtained.councelling));
        saveRequest.setMarksInfrastructureFacility(String.valueOf(MarksObtained.infra));
        saveRequest.setMarksExecutiveCommittee(String.valueOf(MarksObtained.exccomitee));
        saveRequest.setMarksShelterManagement(String.valueOf(MarksObtained.shelter));
        saveRequest.setMarksSustainabilityAssessment(String.valueOf(MarksObtained.assessment));
        saveRequest.setMarksInteractionWithCollege(String.valueOf(MarksObtained.interaction));
        saveinitateddata(saveRequest);
        InspectionRequestMainBean inspectionRequestMainBean=new InspectionRequestMainBean();
        inspectionRequestMainBean.setInspectionDetails(saveRequest);
        String objectsting = new Gson().toJson(inspectionRequestMainBean);
        Log.e("request", objectsting);
        Log.e("save", saveRequest.toString());


    }

    private void saveinitateddata(inspectionrequest saveRequest) {

       /* pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();*/
//        if (CheckInternet.isOnline(OtherActiviesActivity.this)) {

//            progressbar.setVisibility(View.VISIBLE);
        if (CheckInternet.isOnline(getApplicationContext())) {
            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<InspectionResponse> call = apiInterface.InsertInspection(saveRequest);
            Log.i("retro_reguest", call.request().url() + "");

            call.enqueue(new Callback<InspectionResponse>() {
                @Override
                public void onResponse(Call<InspectionResponse> call, Response<InspectionResponse> response) {
//                    pDialog.dismiss();
//                    progressbar.setVisibility(View.GONE);
                    Log.i("retro_responce", String.valueOf(response.code()));

                    if (response.code()==200) {
                      showResponseAlert(response.body().getInspectionDetails().toString(),true);
                        //GlobalDeclaration.workcode = response.body().getWorkCode();
                    } else {
                       Toast.makeText(InspectionForm.this,"data not inserted",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<InspectionResponse> call, Throwable t) {
                //    pDialog.dismiss();
//                    progressbar.setVisibility(View.GONE);
                    Log.i("retro_error", t.toString());
//                    ShowRetroAlert.show(OtherActiviesActivity.this);
                }
            });
        }

    }
    private void showResponseAlert(String message, final Boolean Flag) {
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(InspectionForm.this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        if (Flag) {
                            Intent i = new Intent(InspectionForm.this, GradeReport.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(InspectionForm.this, "Please try again", Toast.LENGTH_LONG).show();
                        }
                    }
                });
        android.app.AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

}

