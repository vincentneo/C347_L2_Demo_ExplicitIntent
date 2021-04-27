package sg.edu.rp.c347.id19007966.demoexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeroStatsActivity extends AppCompatActivity {

    TextView tvName, tvStrength, tvTechnicalProwess;
    Button btnLike, btnDislike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        Intent i = getIntent();
        Hero hero = (Hero) i.getSerializableExtra("hero");

        tvName = findViewById(R.id.textViewName);
        tvStrength = findViewById(R.id.textViewStrength);
        tvTechnicalProwess = findViewById(R.id.textViewTechnicalProwess);

        tvName.setText(hero.getName());
        tvStrength.setText("Strength: " + hero.getStrength());
        tvTechnicalProwess.setText("Technical: " + hero.getTechnicalProwess());

        btnLike = findViewById(R.id.buttonLike);
        btnDislike = findViewById(R.id.buttonDislike);

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDidClickWithLike(true);
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDidClickWithLike(false);
            }
        });
    }

    private void buttonDidClickWithLike(boolean like) {
        Intent i = new Intent();
        i.putExtra("like", like ? "like" : "dislike");
        setResult(RESULT_OK, i);
        finish();
    }
}