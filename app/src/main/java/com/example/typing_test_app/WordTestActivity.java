package com.example.typing_test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class WordTestActivity extends AppCompatActivity {

    ImageButton backButton;
    TextView originalText;
    TextView typedText;
    TextView difficultyText;
    TextView wordShow;
    EditText wordEditText;
    Spinner difficultySpin;
    int difficulty = 0;//word difficulty default is 0 easy
    final int GameType = 1; //word
    String[] difficultyString = {"easy", "normal","hard","nightmare"};
    String word; //word show
    StringBuilder originalStringBuilder = new StringBuilder();
    StringBuilder typedStringBuilder = new StringBuilder();
    TextGenerator wordGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_test);
        initializeViews();

        //set listener
        backButton.setOnClickListener(onClickListener);
        difficultySpin.setOnItemSelectedListener(onItemSelectedListener);
        wordEditText.addTextChangedListener(textWatcher);


        //spin adapter
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, difficultyString);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpin.setAdapter(aa);

    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(WordTestActivity.this,MainScreenActivity.class);
            startActivity(i);
        }
    };
    private AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            difficultyText.setText(difficultyString[position]);
            difficulty = position;
            wordBuilder(); //create a new word builder
            getAndSetWord();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            /*try {
                Log.d("Kenneth","edittext"+typedText.getText().toString());
                if (charSequence.charAt(charSequence.length()-1) == 32 ) {
                    if (charSequence.length() == 0){
                        Log.d("Kenneth","not type anything");
                    }
                    Log.d("Kenneth", "press space");
                    setOriginalText();
                    setTypedText();
                    getWord();
                    setWordShow();
                }
                Log.d("Kenneth", charSequence.toString());
            } catch(IndexOutOfBoundsException ex) {
                ex.printStackTrace();
                Log.d("Kenneth","Index out of bound");
            }*/
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String result = editable.toString().replaceAll(" ", "");
            Log.d("Kenneth",result);
            if (!editable.toString().equals(result)) {
                wordEditText.setText(result);
                wordEditText.setSelection(result.length());
                // alert the user
            }
            if (editable.toString().indexOf(" ") >0 ){
                setOriginalText();
                setTypedText();
                getAndSetWord();
                wordEditText.setText("");
                Log.d("Kenneth","string is >0");
            }
        }
    };

    public void initializeViews(){
        originalText = findViewById(R.id.WT_original_text);
        backButton = findViewById(R.id.back_button_word_test);
        difficultySpin = findViewById(R.id.difficultySpinner);
        difficultyText = findViewById(R.id.difficultytext);
        wordShow = findViewById(R.id.word_show);
        typedText = findViewById(R.id.WT_typed_text);
        wordEditText = findViewById(R.id.word_type_view);
    }


    public void wordBuilder(){
        wordGenerator = new TextGenerator(this,GameType, difficulty);
    }

    public void getAndSetWord(){
        word = wordGenerator.getTextInRandom();
        wordShow.setText(word);
    }

    public void setOriginalText(){
        originalStringBuilder.append(word).append(" ");
        originalText.setText(originalStringBuilder.toString());
    }

    public void setTypedText(){
        typedStringBuilder.append(wordEditText.getText().toString()).append(" ");
        typedText.setText(typedStringBuilder.toString());
    }
}