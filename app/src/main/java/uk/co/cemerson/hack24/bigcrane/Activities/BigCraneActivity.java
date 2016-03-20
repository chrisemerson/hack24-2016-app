package uk.co.cemerson.hack24.bigcrane.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import uk.co.cemerson.hack24.bigcrane.BigCrane.BoardState;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Function;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Game;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Level;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Levels.Level1;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Program;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Stack;
import uk.co.cemerson.hack24.bigcrane.R;

public class BigCraneActivity extends AppCompatActivity {
    private Game game;
    private Level level;
    private Program program;

    private int currentFunctionNo;
    private Function currentFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_crane);

        program = new Program(new Function(10), new Function(5), new Function(5));
        currentFunctionNo = 1;
        currentFunction = program.getFunction1();

        level = new Level1();
        game = new Game(program, level);

        renderCrateDisplay("start", level.getStart());
        renderCrateDisplay("goal", level.getGoal());

        renderProgram();

        initInstructionButtons();
    }

    private void renderCrateDisplay(String name, BoardState state) {
        for (int stack = 1; stack <= 5; stack++) {
            for (int crate = 1; crate <= 6; crate++) {
                Stack thisStack = state.getStack(stack);
                String gridName = name + "_" + stack + "_" + crate;
                int id = getResources().getIdentifier(gridName, "id", getApplicationContext().getPackageName());

                int crateColour = 0;

                try {
                    crateColour = thisStack.getCrateAt(crate).getColour();
                } catch (RuntimeException e) {
                    crateColour = 0;
                }

                int drawable = getResources().getIdentifier("block_colour_" + crateColour, "drawable", getApplicationContext().getPackageName());
                RelativeLayout layout = (RelativeLayout) findViewById(id);

                try {
                    layout.setBackground(getDrawable(drawable));
                } catch (NullPointerException e) {
                    //Erm... dunno? Hopefully you haven't got here
                }
            }
        }
    }

    private void renderProgram() {
    }

    private void initInstructionButtons() {
    }
}
