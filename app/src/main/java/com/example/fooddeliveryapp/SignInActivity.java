package com.example.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.CallbackManager;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.truecaller.android.sdk.ITrueCallback;
import com.truecaller.android.sdk.TrueError;
import com.truecaller.android.sdk.TrueProfile;
import com.truecaller.android.sdk.TruecallerSDK;
import com.truecaller.android.sdk.TruecallerSdkScope;

public class SignInActivity extends AppCompatActivity {
    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN=100;
//    ImageView truecallerbtn;

    Button loginButton;
   private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
//        truecallerbtn = findViewById(R.id.truecaller_login);
//
//        TruecallerSdkScope trueScope = new TruecallerSdkScope.Builder(this, sdkCallback)
//                .consentMode(TruecallerSdkScope.CONSENT_MODE_BOTTOMSHEET)
////                .buttonColor(Color.parseColor(colorSpinner.getSelectedItem().toString()))
////                .buttonTextColor(Color.parseColor(colorTextSpinner.getSelectedItem().toString()))
//                .loginTextPrefix(TruecallerSdkScope.LOGIN_TEXT_PREFIX_TO_GET_STARTED)
//                .loginTextSuffix(TruecallerSdkScope.LOGIN_TEXT_SUFFIX_PLEASE_VERIFY_MOBILE_NO)
//                .ctaTextPrefix(TruecallerSdkScope.CTA_TEXT_PREFIX_USE)
//                .buttonShapeOptions(TruecallerSdkScope.BUTTON_SHAPE_ROUNDED)
//                .privacyPolicyUrl("<<YOUR_PRIVACY_POLICY_LINK>>")
//                .termsOfServiceUrl("<<YOUR_PRIVACY_POLICY_LINK>>")
//                .footerType(TruecallerSdkScope.FOOTER_TYPE_NONE)
//                .consentTitleOption(TruecallerSdkScope.SDK_CONSENT_TITLE_LOG_IN)
//                .sdkOptions(TruecallerSdkScope.SDK_OPTION_WITHOUT_OTP)
//                .build();
//
//        TruecallerSDK.init(trueScope);




        loginButton =  findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();



        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });


        findViewById(R.id.textCreateAccount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });
        findViewById(R.id.btn_sign_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TermsAndConditionActivity.class));
            }
        });
//        findViewById(R.id.fb_login).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignInActivity.this,FbLoginactivity.class));
//            }
//        });
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//        super.onActivityResult(requestCode, resultCode, data);
//    }



    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();
            }

            // Signed in successfully, show authenticated UI.

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.

        }
    }
//    private final ITrueCallback sdkCallback = new ITrueCallback() {
//
//        @Override
//        public void onSuccessProfileShared(@NonNull final TrueProfile trueProfile) {
//        }
//
//        @Override
//        public void onFailureProfileShared(@NonNull final TrueError trueError) {
//        }
//
//        @Override
//        public void onVerificationRequired(@Nullable final TrueError trueError) {
//        }
//
//    };
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == TruecallerSDK.SHARE_PROFILE_REQUEST_CODE) {
//            TruecallerSDK.getInstance().onActivityResultObtained(this, requestCode, resultCode, data);
//        }
//    }
//    @Override
//    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions,
//                                           @NonNull final int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        TruecallerSDK.clear();
//    }

}