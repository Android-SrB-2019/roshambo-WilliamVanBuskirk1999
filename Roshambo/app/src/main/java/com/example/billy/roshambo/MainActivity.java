package com.example.billy.roshambo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nbcc.models.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void roshambo_click(View view) {
        ImageView selected = (ImageView) view;
        String selectedItem = getResources().getResourceEntryName(selected.getId());

        String[] parts = selectedItem.split("B");
        String imageForButton = parts[0] + ".png";

        ImageView playersChoice = (ImageView) findViewById(R.id.playerMove_ImageView);

        Rochambo game = new Rochambo();

        //Setting up game image view
        ImageView gamesMove = (ImageView) findViewById(R.id.gamesMove_ImageView);

        if(imageForButton.equals("rock.png")){
            playersChoice.setImageResource(R.drawable.rock);
            game.playerMakesMove(0);
        }else if(imageForButton.equals("scissors.png")){
            playersChoice.setImageResource(R.drawable.scissors);
            game.playerMakesMove(2);

        }else{
            playersChoice.setImageResource(R.drawable.paper);
            game.playerMakesMove(1);
        }

        if(game.getGameMove() == 0){
            gamesMove.setImageResource(R.drawable.rock);
        }else if(game.getGameMove() == 1){
            gamesMove.setImageResource(R.drawable.paper);
        }else{
            gamesMove.setImageResource(R.drawable.scissors);
        }

        TextView result = (TextView)findViewById(R.id.result_TextView);
        result.setText(game.winLoseOrDraw());

    }
}
