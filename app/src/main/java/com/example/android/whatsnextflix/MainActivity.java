package com.example.android.whatsnextflix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int genreNumber;
    private int settingNumber;
    private int moodNumber;
    private int subjectNumber;
    private int questionThree;
    private boolean quizOne = false;
    private boolean quizTwo = false;
    private boolean quizThree = false;
    private boolean quizFour = false;
    private boolean quizFive = false;

    private static final String KEY_INFO_VIEW_VISIBILITY_ = "infoViewVisibility";
    private static final String KEY_QUIZ_VIEW_VISIBILITY_ = "quizViewVisibility";
    private static final String KEY_PREFERENCE_VIEW_VISIBILITY_ = "preferenceViewVisibility";
    private static final String KEY_SUGGESTION_VIEW_VISIBILITY_ = "suggestionViewVisibility";

    LinearLayout infoViewGroup;
    LinearLayout quizViewGroup;
    GridLayout preferenceViewGroup;
    LinearLayout suggestionViewGroup;
    TextView wellDoneTextView;
    EditText nameField;
    CheckBox quizOneRightAnswer;
    CheckBox quizOneWrongAnswer;
    CheckBox quizOneRightAnswerTwo;
    CheckBox quizTwoRightAnswer;
    CheckBox quizTwoRightAnswerTwo;
    CheckBox quizTwoWrongAnswer;
    RadioGroup quizThreeRadioGroup;
    EditText quizFourEditText;
    EditText quizFiveEditText;
    ImageView poster;
    TextView final_suggestion_message;
    TextView title_suggestion;
    RadioGroup genre;
    RadioGroup setting;
    RadioGroup mood;
    RadioGroup subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        infoViewGroup = findViewById(R.id.info_view);
        quizViewGroup = findViewById(R.id.quiz_view_group);
        preferenceViewGroup = findViewById(R.id.preference_view_group);
        suggestionViewGroup = findViewById(R.id.suggestion_view);
        wellDoneTextView = findViewById(R.id.well_done_text);
        nameField = findViewById(R.id.name_field);
        quizOneRightAnswer = findViewById(R.id.question_one_right_answer_check_box);
        quizOneWrongAnswer = findViewById(R.id.question_one_wrong_answer_check_box);
        quizOneRightAnswerTwo = findViewById(R.id.question_one_right_answer_two_check_box);
        quizTwoRightAnswer = findViewById(R.id.question_two_right_answer_check_box);
        quizTwoRightAnswerTwo = findViewById(R.id.question_two_right_answer_two_check_box);
        quizTwoWrongAnswer = findViewById(R.id.question_two_wrong_answer_check_box);
        quizThreeRadioGroup = findViewById(R.id.quiz_view_3);
        quizFourEditText = findViewById(R.id.question_four_edit_text);
        quizFiveEditText = findViewById(R.id.question_five_edit_text);
        poster = findViewById(R.id.poster_image_view);
        final_suggestion_message = findViewById(R.id.final_message_text_view);
        title_suggestion = findViewById(R.id.title_text_view);
        genre = findViewById(R.id.genre_preference_group);
        setting = findViewById(R.id.setting_preference_group);
        mood = findViewById(R.id.mood_preference_group);
        subject = findViewById(R.id.subject_preference_group);
        preferenceViewGroup = findViewById(R.id.preference_view_group);
    }

    /**
     * Methods to save and restore app state when screen rotates
     * @param savedInstanceState is used to collect info
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (infoViewGroup != null) {
            savedInstanceState.putInt(KEY_INFO_VIEW_VISIBILITY_, infoViewGroup.getVisibility());
        }
        if (quizViewGroup != null) {
            savedInstanceState.putInt(KEY_QUIZ_VIEW_VISIBILITY_, quizViewGroup.getVisibility());
        }
        if (preferenceViewGroup != null) {
            savedInstanceState.putInt(KEY_PREFERENCE_VIEW_VISIBILITY_, preferenceViewGroup.getVisibility());
        }
        if (suggestionViewGroup != null) {
            savedInstanceState.putInt(KEY_SUGGESTION_VIEW_VISIBILITY_, suggestionViewGroup.getVisibility());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        infoViewGroup.setVisibility(savedInstanceState.getInt(KEY_INFO_VIEW_VISIBILITY_, infoViewGroup.getVisibility()));
        quizViewGroup.setVisibility(savedInstanceState.getInt(KEY_QUIZ_VIEW_VISIBILITY_, quizViewGroup.getVisibility()));
        preferenceViewGroup.setVisibility(savedInstanceState.getInt(KEY_PREFERENCE_VIEW_VISIBILITY_, preferenceViewGroup.getVisibility()));
        suggestionViewGroup.setVisibility(savedInstanceState.getInt(KEY_SUGGESTION_VIEW_VISIBILITY_, suggestionViewGroup.getVisibility()));
    }

    /**
     * Method for the click event on RadioGroup 1
     */
    public void onGenreButtonClick(View view) {
        // is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //check which radio button was clicked

        switch (view.getId()) {
            case R.id.genre_action:
                if (checked)
                    genreNumber = 1;
                break;

            case R.id.genre_comedy:
                if (checked)
                    genreNumber = 2;
                break;

            case R.id.genre_thriller:
                if (checked)
                    genreNumber = 3;
                break;

        }
    }

    /**
     * Method for the click event on RadioGroup 2
     */
    public void onSettingButtonClick(View view) {
        // is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //check which radio button was clicked

        switch (view.getId()) {
            case R.id.setting_past:
                if (checked)
                    settingNumber = 1;
                break;

            case R.id.setting_present:
                if (checked)
                    settingNumber = 2;
                break;

            case R.id.setting_future:
                if (checked)
                    settingNumber = 3;
                break;

        }
    }

    /**
     * Method for the click event on RadioGroup 3
     */
    public void onMoodButtonClick(View view) {
        // is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //check which radio button was clicked

        switch (view.getId()) {
            case R.id.mood_adrenalinic:
                if (checked)
                    moodNumber = 1;
                break;

            case R.id.mood_relaxing:
                if (checked)
                    moodNumber = 2;
                break;

            case R.id.mood_intriguing:
                if (checked)
                    moodNumber = 3;
                break;

            case R.id.mood_amusing:
                if (checked)
                    moodNumber = 4;
                break;

        }
    }

    /**
     * Method for the click event on RadioGroup 4
     */
    public void onSubjectButtonClick(View view) {
        // is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //check which radio button was clicked

        switch (view.getId()) {
            case R.id.subject_power:
                if (checked)
                    subjectNumber = 1;
                break;

            case R.id.subject_youth:
                if (checked)
                    subjectNumber = 2;
                break;

            case R.id.subject_justice:
                if (checked)
                    subjectNumber = 3;
                break;

            case R.id.subject_love_friendship:
                if (checked)
                    subjectNumber = 4;
                break;

        }
    }

    /**
     * Method to check the answers and let the user go to the preference view
     *
     * @param view is the Start Quiz button view
     */
    public void onStartQuizButtonClick(View view) {
        String name = nameField.getText().toString();

        if (name.matches("")) {
            Toast.makeText(this, "Please, enter you name.", Toast.LENGTH_LONG).show();
        } else {
            infoViewGroup.setVisibility(View.GONE);
            quizViewGroup.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Method for the click event on Question 3 RadioGroup
     */
    public void onQuizThreeClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        //check which radio button was clicked

        switch (view.getId()) {
            case R.id.question_three_right_answer_radio:
                if (checked)
                    questionThree = 1;
                break;

            case R.id.question_three_wrong_answer_radio:
                if (checked)
                    questionThree = 0;
                break;

            case R.id.question_three_wrong_answer_two_radio:
                if (checked)
                    questionThree = 0;
                break;

        }
    }

    /**
     * Method to create the final message with the suggestion
     *
     * @return string
     */
    private String createQuizDoneMessage() {
        String name = nameField.getText().toString();
        String wellDoneText = getString(R.string.well_done_message);
        wellDoneText += " " + name;
        wellDoneText += getString(R.string.well_done_message_2);
        return wellDoneText;
    }

    /**
     * Method to calculate quiz score
     *
     * @return quizScore number
     */
    private int calculateQuizScore() {

        boolean questionOneIsRight = quizOneRightAnswer.isChecked();
        boolean questionOneIsWrong = quizOneWrongAnswer.isChecked();
        boolean questionOneIsRightTwo = quizOneRightAnswerTwo.isChecked();
        boolean questionTwoIsRight = quizTwoRightAnswer.isChecked();
        boolean questionTwoIsRightTwo = quizTwoRightAnswerTwo.isChecked();
        boolean questionTwoIsWrong = quizTwoWrongAnswer.isChecked();

        int quizScore = 0;
        String quizFourAnswer = quizFourEditText.getText().toString();
        String quizFiveAnswer = quizFiveEditText.getText().toString();


        if (questionOneIsRight && questionOneIsRightTwo && !questionOneIsWrong) {
            quizScore += 1;
            quizOne = true;
        }
        if (questionTwoIsRight && questionTwoIsRightTwo && !questionTwoIsWrong) {

            quizScore += 1;
            quizTwo = true;
        }
        if (questionThree > 0) {
            quizScore += 1;
            quizThree = true;
        }
        if (quizFourAnswer.equals(getString(R.string.quiz_four_right_answer))) {
            quizScore += 1;
            quizFour = true;
        }
        if (quizFiveAnswer.equals(getString(R.string.quiz_five_right_answer))) {
            quizScore += 1;
            quizFive = true;
        }
        return quizScore;
    }

    /**
     * Method that create a toast message with the results of the quiz
     *
     * @param view is the button
     */
    public void onQuizSubmitButtonClick(View view) {

        int quizScore = calculateQuizScore();
        wellDoneTextView.setText(createQuizDoneMessage());

        String pointMessage = getText(R.string.quiz_done_message_one).toString();
        pointMessage += quizScore;
        pointMessage += getText(R.string.quiz_done_message_three).toString();
        String QuestionsReport = "";

        if (quizOne) {
            QuestionsReport += "\n\n" + getString(R.string.question_answer_one) + getString(R.string.correct);
        } else {
            QuestionsReport += "\n" + getString(R.string.question_answer_one) + getString(R.string.wrong);
        }
        if (quizTwo) {
            QuestionsReport += "\n" + getString(R.string.question_answer_two) + getString(R.string.correct);
        } else {
            QuestionsReport += "\n" + getString(R.string.question_answer_two) + getString(R.string.wrong);
        }
        if (quizThree) {
            QuestionsReport += "\n" + getString(R.string.question_answer_three) + getString(R.string.correct);
        } else {
            QuestionsReport += "\n" + getString(R.string.question_answer_three) + getString(R.string.wrong);
        }
        if (quizFour) {
            QuestionsReport += "\n" + getString(R.string.question_answer_four) + getString(R.string.correct);
        } else {
            QuestionsReport += "\n" + getString(R.string.question_answer_four) + getString(R.string.wrong);
        }
        if (quizFive) {
            QuestionsReport += "\n" + getString(R.string.question_answer_five) + getString(R.string.correct);
        } else {
            QuestionsReport += "\n" + getString(R.string.question_answer_five) + getString(R.string.wrong);
        }
        if (quizScore == 0) {
            Toast.makeText(this, "Whhooops! Wrong answers. Try again!" + QuestionsReport, Toast.LENGTH_LONG).show();
            quizViewGroup.setVisibility(View.GONE);
            preferenceViewGroup.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, pointMessage + QuestionsReport, Toast.LENGTH_LONG).show();
            quizViewGroup.setVisibility(View.GONE);
            preferenceViewGroup.setVisibility(View.VISIBLE);
        }
    }

    /**
     * This method collects the preferences and returns a String with the right show to suggest
     *
     * @param view is the submit preferences view
     */
    public void onPreferenceSubmitButtonClick(View view) {

        //Creates a message for every combination of the selected preferences

        int suggestedMovie = (genreNumber * 1000) + (settingNumber * 100) + (moodNumber * 10) + subjectNumber;

        String movieName = "";
        String error_message = "Please, make a choice for any field.";


        if (genreNumber == 0 || settingNumber == 0 || moodNumber == 0 || subjectNumber == 0) {
            Toast.makeText(this, error_message, Toast.LENGTH_LONG).show();

        } else {
            preferenceViewGroup.setVisibility(View.GONE);
            suggestionViewGroup.setVisibility(View.VISIBLE);

            if (suggestedMovie == 1111) {
                poster.setImageResource(R.drawable.vikings);
                movieName = "Vikings";
            }
            if (suggestedMovie == 1112) {
                poster.setImageResource(R.drawable.wolfblood);
                movieName = "Wolfblood";
            }
            if (suggestedMovie == 1114) {
                poster.setImageResource(R.drawable.godless);
                movieName = "Godless";
            }
            if (suggestedMovie == 1121) {
                poster.setImageResource(R.drawable.downton_abbey);
                movieName = "Downton Abbey";
            }
            if (suggestedMovie == 1122) {
                poster.setImageResource(R.drawable.a_series_of_unfortunate_events);
                movieName = "A Series of Unfortunate Events";
            }
            if (suggestedMovie == 1123) {
                poster.setImageResource(R.drawable.miss_fisher);
                movieName = "Miss Fisher";
            }
            if (suggestedMovie == 1124) {
                poster.setImageResource(R.drawable.cable_girls);
                movieName = "Cable Girls";
            }
            if (suggestedMovie == 1131) {
                poster.setImageResource(R.drawable.madmen);
                movieName = "MadMen";
            }
            if (suggestedMovie == 1132) {
                poster.setImageResource(R.drawable.erased);
                movieName = "Erased";
            }
            if (suggestedMovie == 1133) {
                poster.setImageResource(R.drawable.alias_grace);
                movieName = "Alias Grace";
            }
            if (suggestedMovie == 1134) {
                poster.setImageResource(R.drawable.the_duchess);
                movieName = "The Duchess";
            }
            if (suggestedMovie == 1141) {
                poster.setImageResource(R.drawable.the_windsors);
                movieName = "The Windsors";
            }
            if (suggestedMovie == 1142) {
                poster.setImageResource(R.drawable.a_series_of_unfortunate_events);
                movieName = "A Series of Unfortunate Events";
            }
            if (suggestedMovie == 1143) {
                poster.setImageResource(R.drawable.sherlock);
                movieName = "Sherlock";
            }
            if (suggestedMovie == 1144) {
                poster.setImageResource(R.drawable.wet_hot_american_summer);
                movieName = "Wet Hot american summer";
            }
            if (suggestedMovie == 1211) {
                poster.setImageResource(R.drawable.narcos);
                movieName = "Narcos";
            }
            if (suggestedMovie == 1212) {
                poster.setImageResource(R.drawable.pretty_little_liars);
                movieName = "Pretty Little Liars";
            }
            if (suggestedMovie == 1213) {
                poster.setImageResource(R.drawable.lie_to_me);
                movieName = "Lie To Me";
            }
            if (suggestedMovie == 1214) {
                poster.setImageResource(R.drawable.thirteen_reasons_why);
                movieName = "13 reasons why";
            }
            if (suggestedMovie == 1221) {
                poster.setImageResource(R.drawable.dinasty);
                movieName = "Dinasty";
            }
            if (suggestedMovie == 1222) {
                poster.setImageResource(R.drawable.the_end_of_the_fucking_world);
                movieName = "The End of The Fu**ing World";
            }
            if (suggestedMovie == 1223) {
                poster.setImageResource(R.drawable.how_to_get_away_with_murder);
                movieName = "How to Get Away with Murder";
            }
            if (suggestedMovie == 1224) {
                poster.setImageResource(R.drawable.new_girl);
                movieName = "New Girl";
            }
            if (suggestedMovie == 1231) {
                poster.setImageResource(R.drawable.black_mirror);
                movieName = "Black Mirror";
            }
            if (suggestedMovie == 1232) {
                poster.setImageResource(R.drawable.the_100);
                movieName = "The 100";
            }
            if (suggestedMovie == 1233) {
                poster.setImageResource(R.drawable.the_good_wife);
                movieName = "The good wife";
            }
            if (suggestedMovie == 1234) {
                poster.setImageResource(R.drawable.thirteen_reasons_why);
                movieName = "13 reasons why";
            }
            if (suggestedMovie == 1241) {
                poster.setImageResource(R.drawable.white_gold);
                movieName = "White Gold";
            }
            if (suggestedMovie == 1242) {
                poster.setImageResource(R.drawable.fresh_meat);
                movieName = "Fresh Meat";
            }
            if (suggestedMovie == 1243) {
                poster.setImageResource(R.drawable.suits);
                movieName = "Suits";
            }
            if (suggestedMovie == 1311) {
                poster.setImageResource(R.drawable.travelers);
                movieName = "Travelers";
            }
            if (suggestedMovie == 1312) {
                poster.setImageResource(R.drawable.threepercent);
                movieName = "3%";
            }
            if (suggestedMovie == 1313) {
                poster.setImageResource(R.drawable.bright);
                movieName = "Bright";
            }
            if (suggestedMovie == 1314) {
                poster.setImageResource(R.drawable.threepercent);
                movieName = "3%";
            }
            if (suggestedMovie == 1321) {
                poster.setImageResource(R.drawable.star_trek_deep_space_nine);
                movieName = "Star Trek: Deep Space Nine";
            }
            if (suggestedMovie == 1322) {
                poster.setImageResource(R.drawable.stranger_things);
                movieName = "Stranger Things";
            }
            if (suggestedMovie == 1323) {
                poster.setImageResource(R.drawable.the_100);
                movieName = "The 100";
            }
            if (suggestedMovie == 1324) {
                poster.setImageResource(R.drawable.under_the_dome);
                movieName = "Under the dome";
            }
            if (suggestedMovie == 1331) {
                poster.setImageResource(R.drawable.star_trek_deep_space_nine);
                movieName = "Star Trek: Deep Space Nine";
            }
            if (suggestedMovie == 1332) {
                poster.setImageResource(R.drawable.the_oa);
                movieName = "The OA";
            }
            if (suggestedMovie == 1333) {
                poster.setImageResource(R.drawable.bright);
                movieName = "Bright";
            }
            if (suggestedMovie == 1334) {
                poster.setImageResource(R.drawable.under_the_dome);
                movieName = "Under the dome";
            }
            if (suggestedMovie == 1341) {
                poster.setImageResource(R.drawable.shadow_hunters);
                movieName = "Shadow Hunters";
            }
            if (suggestedMovie == 1342) {
                poster.setImageResource(R.drawable.teen_wolf);
                movieName = "Teen Wolf";
            }
            if (suggestedMovie == 1343) {
                poster.setImageResource(R.drawable.shadow_hunters);
                movieName = "Shadow Hunters";
            }
            if (suggestedMovie == 1344) {
                poster.setImageResource(R.drawable.teen_wolf);
                movieName = "Teen Wolf";
            }
            if (suggestedMovie == 2111) {
                poster.setImageResource(R.drawable.the_windsors);
                movieName = "The Windsors";
            }
            if (suggestedMovie == 2112) {
                poster.setImageResource(R.drawable.wet_hot_american_summer);
                movieName = "Wet Hot american summer";
            }
            if (suggestedMovie == 2113) {
                poster.setImageResource(R.drawable.sherlock);
                movieName = "Sherlock";
            }
            if (suggestedMovie == 2114) {
                poster.setImageResource(R.drawable.the_ranch);
                movieName = "The Ranch";
            }
            if (suggestedMovie == 2121) {
                poster.setImageResource(R.drawable.downton_abbey);
                movieName = "Downton Abbey";
            }
            if (suggestedMovie == 2122) {
                poster.setImageResource(R.drawable.a_series_of_unfortunate_events);
                movieName = "A series of unfortunate events";
            }
            if (suggestedMovie == 2123) {
                poster.setImageResource(R.drawable.miss_fisher);
                movieName = "Miss Fisher";
            }
            if (suggestedMovie == 2124) {
                poster.setImageResource(R.drawable.cable_girls);
                movieName = "Cable girls";
            }
            if (suggestedMovie == 2131) {
                poster.setImageResource(R.drawable.madmen);
                movieName = "MadMen";
            }
            if (suggestedMovie == 2132) {
                poster.setImageResource(R.drawable.erased);
                movieName = "Erased";
            }
            if (suggestedMovie == 2133) {
                poster.setImageResource(R.drawable.sherlock);
                movieName = "Sherlock";
            }
            if (suggestedMovie == 2134) {
                poster.setImageResource(R.drawable.the_duchess);
                movieName = "The Duchess";
            }
            if (suggestedMovie == 2141) {
                poster.setImageResource(R.drawable.the_windsors);
                movieName = "The Windsors";
            }
            if (suggestedMovie == 2142) {
                poster.setImageResource(R.drawable.wet_hot_american_summer);
                movieName = "Wet Hot american summer";
            }
            if (suggestedMovie == 2143) {
                poster.setImageResource(R.drawable.that_70s_show);
                movieName = "That 70's Show";
            }
            if (suggestedMovie == 2144) {
                poster.setImageResource(R.drawable.wet_hot_american_summer);
                movieName = "Wet Hot american summer";
            }
            if (suggestedMovie == 2211) {
                poster.setImageResource(R.drawable.dinasty);
                movieName = "Dynasty";
            }
            if (suggestedMovie == 2212) {
                poster.setImageResource(R.drawable.the_end_of_the_fucking_world);
                movieName = "The end of the F***ing world";
            }
            if (suggestedMovie == 2213) {
                poster.setImageResource(R.drawable.better_call_saul);
                movieName = "Better Call Saul";
            }
            if (suggestedMovie == 2214) {
                poster.setImageResource(R.drawable.friends);
                movieName = "Friends";
            }
            if (suggestedMovie == 2221) {
                poster.setImageResource(R.drawable.dinasty);
                movieName = "Dynasty";
            }
            if (suggestedMovie == 2222) {
                poster.setImageResource(R.drawable.adventureland);
                movieName = "Adventureland";
            }
            if (suggestedMovie == 2223) {
                poster.setImageResource(R.drawable.lie_to_me);
                movieName = "Lie To Me";
            }
            if (suggestedMovie == 2224) {
                poster.setImageResource(R.drawable.modern_family);
                movieName = "Modern Family";
            }
            if (suggestedMovie == 2231) {
                poster.setImageResource(R.drawable.shes_gotta_have_it);
                movieName = "She’s gotta have it";
            }
            if (suggestedMovie == 2232) {
                poster.setImageResource(R.drawable.step_sisters);
                movieName = "Step Sisters";
            }
            if (suggestedMovie == 2233) {
                poster.setImageResource(R.drawable.lucifer);
                movieName = "Lucifer";
            }
            if (suggestedMovie == 2234) {
                poster.setImageResource(R.drawable.crazy_ex_girlfriend);
                movieName = "Crazy ex_girlfriend";
            }
            if (suggestedMovie == 2241) {
                poster.setImageResource(R.drawable.haters_back_off);
                movieName = "Haters Back Off";
            }
            if (suggestedMovie == 2242) {
                poster.setImageResource(R.drawable.big_mouth);
                movieName = "Big Mouth";
            }
            if (suggestedMovie == 2243) {
                poster.setImageResource(R.drawable.dirk_gently);
                movieName = "Dirk Gently";
            }
            if (suggestedMovie == 2244) {
                poster.setImageResource(R.drawable.love);
                movieName = "Love";
            }
            if (suggestedMovie == 2311) {
                poster.setImageResource(R.drawable.lost);
                movieName = "Lost";
            }
            if (suggestedMovie == 2312) {
                poster.setImageResource(R.drawable.misfits);
                movieName = "Misfits";
            }
            if (suggestedMovie == 2313) {
                poster.setImageResource(R.drawable.crazyhead);
                movieName = "Crazyhead";
            }
            if (suggestedMovie == 2314) {
                poster.setImageResource(R.drawable.nowhere_boys);
                movieName = "Nowhere Boys";
            }
            if (suggestedMovie == 2321) {
                poster.setImageResource(R.drawable.the_man_from_the_future);
                movieName = "The man from the future";
            }
            if (suggestedMovie == 2322) {
                poster.setImageResource(R.drawable.the_mars_generation);
                movieName = "The Mars generation";
            }
            if (suggestedMovie == 2323) {
                poster.setImageResource(R.drawable.osmosis);
                movieName = "Osmosis";
            }
            if (suggestedMovie == 2324) {
                poster.setImageResource(R.drawable.the_man_from_the_future);
                movieName = "The man from the future";
            }
            if (suggestedMovie == 2331) {
                poster.setImageResource(R.drawable.lost);
                movieName = "Lost";
            }
            if (suggestedMovie == 2332) {
                poster.setImageResource(R.drawable.misfits);
                movieName = "Misfits";
            }
            if (suggestedMovie == 2333) {
                poster.setImageResource(R.drawable.crazyhead);
                movieName = "Crazyhead";
            }
            if (suggestedMovie == 2334) {
                poster.setImageResource(R.drawable.nowhere_boys);
                movieName = "Nowhere Boys";
            }
            if (suggestedMovie == 2341) {
                poster.setImageResource(R.drawable.lucifer);
                movieName = "Lucifer";
            }
            if (suggestedMovie == 2342) {
                poster.setImageResource(R.drawable.the_mars_generation);
                movieName = "The Mars generation";
            }
            if (suggestedMovie == 2343) {
                poster.setImageResource(R.drawable.osmosis);
                movieName = "Osmosis";
            }
            if (suggestedMovie == 2344) {
                poster.setImageResource(R.drawable.the_man_from_the_future);
                movieName = "The man from the future";
            }
            if (suggestedMovie == 3111) {
                poster.setImageResource(R.drawable.the_last_kingdom);
                movieName = "The Last Kingdom";
            }
            if (suggestedMovie == 3112) {
                poster.setImageResource(R.drawable.stranger_things);
                movieName = "Stranger Things";
            }
            if (suggestedMovie == 3113) {
                poster.setImageResource(R.drawable.nineteentwentytwo);
                movieName = "1922";
            }
            if (suggestedMovie == 3114) {
                poster.setImageResource(R.drawable.the_returned);
                movieName = "The returned";
            }
            if (suggestedMovie == 3121) {
                poster.setImageResource(R.drawable.the_musketeers);
                movieName = "The Musketeers";
            }
            if (suggestedMovie == 3122) {
                poster.setImageResource(R.drawable.stranger_things);
                movieName = "Stranger Things";
            }
            if (suggestedMovie == 3123) {
                poster.setImageResource(R.drawable.sherlock);
                movieName = "Sherlock";
            }
            if (suggestedMovie == 3124) {
                poster.setImageResource(R.drawable.rebellion);
                movieName = "Rebellion";
            }
            if (suggestedMovie == 3131) {
                poster.setImageResource(R.drawable.versailles);
                movieName = "Versailles";
            }
            if (suggestedMovie == 3132) {
                poster.setImageResource(R.drawable.thirteen_reasons_why);
                movieName = "13 reasons why";
            }
            if (suggestedMovie == 3133) {
                poster.setImageResource(R.drawable.penny_dreadful);
                movieName = "Penny Dreadful";
            }
            if (suggestedMovie == 3134) {
                poster.setImageResource(R.drawable.bates_motel);
                movieName = "Bates Motel";
            }
            if (suggestedMovie == 3141) {
                poster.setImageResource(R.drawable.reign);
                movieName = "Reign";
            }
            if (suggestedMovie == 3142) {
                poster.setImageResource(R.drawable.stranger_things);
                movieName = "Stranger Things";
            }
            if (suggestedMovie == 3143) {
                poster.setImageResource(R.drawable.fargo);
                movieName = "Fargo";
            }
            if (suggestedMovie == 3144) {
                poster.setImageResource(R.drawable.bates_motel);
                movieName = "Bates Motel";
            }
            if (suggestedMovie == 3211) {
                poster.setImageResource(R.drawable.designated_survivor);
                movieName = "Designated Survivor";
            }
            if (suggestedMovie == 3212) {
                poster.setImageResource(R.drawable.between);
                movieName = "Between";
            }
            if (suggestedMovie == 3213) {
                poster.setImageResource(R.drawable.american_odissey);
                movieName = "American Odissey";
            }
            if (suggestedMovie == 3214) {
                poster.setImageResource(R.drawable.pretty_little_liars);
                movieName = "Pretty Little Liars";
            }
            if (suggestedMovie == 3221) {
                poster.setImageResource(R.drawable.marseille);
                movieName = "Marseille";
            }
            if (suggestedMovie == 3222) {
                poster.setImageResource(R.drawable.death_note);
                movieName = "Death Note";
            }
            if (suggestedMovie == 3223) {
                poster.setImageResource(R.drawable.la_mante);
                movieName = "La Mante";
            }
            if (suggestedMovie == 3224) {
                poster.setImageResource(R.drawable.doctor_foster);
                movieName = "Doctor Foster";
            }
            if (suggestedMovie == 3231) {
                poster.setImageResource(R.drawable.breaking_bad);
                movieName = "Breaking Bad";
            }
            if (suggestedMovie == 3232) {
                poster.setImageResource(R.drawable.threepercent);
                movieName = "3%";
            }
            if (suggestedMovie == 3233) {
                poster.setImageResource(R.drawable.dexter);
                movieName = "Dexter";
            }
            if (suggestedMovie == 3234) {
                poster.setImageResource(R.drawable.thirteen_reasons_why);
                movieName = "13 reasons why";
            }
            if (suggestedMovie == 3241) {
                poster.setImageResource(R.drawable.the_undertaker);
                movieName = "The undertaker";
            }
            if (suggestedMovie == 3242) {
                poster.setImageResource(R.drawable.pretty_little_liars);
                movieName = "Pretty Little Liars";
            }
            if (suggestedMovie == 3243) {
                poster.setImageResource(R.drawable.the_punisher);
                movieName = "The Punisher";
            }
            if (suggestedMovie == 3244) {
                poster.setImageResource(R.drawable.the_indian_detective);
                movieName = "The indian detective";
            }
            if (suggestedMovie == 3311) {
                poster.setImageResource(R.drawable.residue);
                movieName = "Residue";
            }
            if (suggestedMovie == 3312) {
                poster.setImageResource(R.drawable.orphan_black);
                movieName = "Orphan black";
            }
            if (suggestedMovie == 3313) {
                poster.setImageResource(R.drawable.continuum);
                movieName = "Continuum";
            }
            if (suggestedMovie == 3314) {
                poster.setImageResource(R.drawable.the_mist);
                movieName = "The Mist";
            }
            if (suggestedMovie == 3321) {
                poster.setImageResource(R.drawable.killjoys);
                movieName = "KillJoys";
            }
            if (suggestedMovie == 3322) {
                poster.setImageResource(R.drawable.steins_gate);
                movieName = "Steins;Gate";
            }
            if (suggestedMovie == 3323) {
                poster.setImageResource(R.drawable.river);
                movieName = "River";
            }
            if (suggestedMovie == 3324) {
                poster.setImageResource(R.drawable.santa_clarita_diet);
                movieName = "Santa Clarita Diet";
            }
            if (suggestedMovie == 3331) {
                poster.setImageResource(R.drawable.gotham);
                movieName = "Gotham";
            }
            if (suggestedMovie == 3332) {
                poster.setImageResource(R.drawable.izombie);
                movieName = "iZombie";
            }
            if (suggestedMovie == 3333) {
                poster.setImageResource(R.drawable.gotham);
                movieName = "Gotham";
            }
            if (suggestedMovie == 3334) {
                poster.setImageResource(R.drawable.terra_nova);
                movieName = "Terra Nova";
            }
            if (suggestedMovie == 3341) {
                poster.setImageResource(R.drawable.shadow_hunters);
                movieName = "Shadow Hunters";
            }
            if (suggestedMovie == 3342) {
                poster.setImageResource(R.drawable.the_oa);
                movieName = "The OA";
            }
            if (suggestedMovie == 3343) {
                poster.setImageResource(R.drawable.izombie);
                movieName = "iZombie";
            }
            if (suggestedMovie == 3344) {
                poster.setImageResource(R.drawable.santa_clarita_diet);
                movieName = "Santa Clarita Diet";
            }
        }
        String name = nameField.getText().toString();

        String finalMessage = getString(R.string.final_string_message_one) + name + getString(R.string.final_string_message_two);
        final_suggestion_message.setText(finalMessage);

        String titleMessage = movieName;
        title_suggestion.setText(titleMessage);
    }

    /**
     * This method resets the preference fields and brings the user back to the preferences radioGroups
     *
     * @param view is the button
     */
    public void onResetButtonClick(View view) {
        genre.clearCheck();
        setting.clearCheck();
        mood.clearCheck();
        subject.clearCheck();
        suggestionViewGroup.setVisibility(View.GONE);
        preferenceViewGroup.setVisibility(View.VISIBLE);
    }
}
