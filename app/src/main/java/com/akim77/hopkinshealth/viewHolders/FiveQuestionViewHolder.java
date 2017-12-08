package com.akim77.hopkinshealth.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.akim77.hopkinshealth.R;
import com.akim77.hopkinshealth.SubmissionManager;

/**
 * Created by Anthony Kim on 12/7/2017.
 */

public class FiveQuestionViewHolder extends RecyclerView.ViewHolder {

    private TextView question;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4, rb5;

    public FiveQuestionViewHolder(View itemView) {
        super(itemView);

        question = (TextView) itemView.findViewById(R.id.surveyQuestion);
        radioGroup = (RadioGroup) itemView.findViewById(R.id.fiveQuestionRadiogroup);
        rb1 = (RadioButton) itemView.findViewById(R.id.optionOne);
        rb2 = (RadioButton) itemView.findViewById(R.id.optionTwo);
        rb3 = (RadioButton) itemView.findViewById(R.id.optionThree);
        rb4 = (RadioButton) itemView.findViewById(R.id.optionFour);
        rb5 = (RadioButton) itemView.findViewById(R.id.optionFive);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmissionManager.instance.updateEntry((Integer) radioGroup.getTag(), 0);
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmissionManager.instance.updateEntry((Integer) radioGroup.getTag(), 1);
            }
        });

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmissionManager.instance.updateEntry((Integer) radioGroup.getTag(), 2);
            }
        });

        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmissionManager.instance.updateEntry((Integer) radioGroup.getTag(), 3);
            }
        });

        rb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmissionManager.instance.updateEntry((Integer) radioGroup.getTag(), 4);
            }
        });

    }


    public TextView getQuestion() {
        return question;
    }

    public void setQuestion(TextView question) {
        this.question = question;
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    public void setRadioGroup(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    public RadioButton getRb1() {
        return rb1;
    }

    public void setRb1(RadioButton rb1) {
        this.rb1 = rb1;
    }

    public RadioButton getRb2() {
        return rb2;
    }

    public void setRb2(RadioButton rb2) {
        this.rb2 = rb2;
    }

    public RadioButton getRb3() {
        return rb3;
    }

    public void setRb3(RadioButton rb3) {
        this.rb3 = rb3;
    }

    public RadioButton getRb4() {
        return rb4;
    }

    public void setRb4(RadioButton rb4) {
        this.rb4 = rb4;
    }

    public RadioButton getRb5() {
        return rb5;
    }

    public void setRb5(RadioButton rb5) {
        this.rb5 = rb5;
    }
}
