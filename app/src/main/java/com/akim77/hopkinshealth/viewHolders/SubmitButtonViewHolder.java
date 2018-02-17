package com.akim77.hopkinshealth.viewHolders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.akim77.hopkinshealth.R;
import com.akim77.hopkinshealth.SubmissionManager;
import com.akim77.hopkinshealth.WeightActivity;

/**
 * Created by anthony on 12/29/17.
 */

public class SubmitButtonViewHolder extends RecyclerView.ViewHolder {

    private Button submitButton;

    public SubmitButtonViewHolder(final View itemView) {
        super(itemView);

        submitButton = (Button) itemView.findViewById(R.id.surveySubmitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                if(SubmissionManager.instance.isFormComplete()) {
                    SharedPreferences sharedPref = context.getSharedPreferences("submissions", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    //saves a key-value set consisting of current time and submission data
                    editor.putString(System.currentTimeMillis() + "", SubmissionManager.instance.prettyMapToString());
                    editor.apply();
                    sendEmail(context);

                    SubmissionManager.instance.clearEntries();

                    /*
                    Intent i = new Intent(context, WeightActivity.class);
                    context.startActivity(i);
                    ((Activity)context).finish();
                    */
                } else {
                    Toast.makeText(context, "Please complete question " + SubmissionManager.instance.getNextUpQuestion() + ".", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }



    protected void sendEmail(Context context) {
        Log.i("Send email", "");

        String[] TO = {"anthonysunghoonkim@gmail.com"};
        String[] CC = {};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
//        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Survey results");
        emailIntent.putExtra(Intent.EXTRA_TEXT, SubmissionManager.instance.prettyMapToString());

        try {
            context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            Log.i("Finished sending email.", "");
            Toast.makeText(context, "Sent mail.", Toast.LENGTH_SHORT).show();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
