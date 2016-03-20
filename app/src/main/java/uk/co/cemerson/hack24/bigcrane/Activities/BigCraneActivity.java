package uk.co.cemerson.hack24.bigcrane.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import uk.co.cemerson.hack24.bigcrane.BigCrane.BoardState;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Function;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Game;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions.CallFunction1Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions.CallFunction2Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions.CallFunction3Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions.GrabOrReleaseCrateInstruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions.MoveLeftInstruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions.MoveRightInstruction;
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

    private boolean allowModification = true;
    private boolean gamePlaying = false;

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

        setFunctionMarkerOnClickListeners();
        renderProgram();

        initInstructionButtons();

        initBigButton();
    }

    private void setFunctionMarkerOnClickListeners() {
        TextView function1Marker = (TextView) findViewById(R.id.function_1_button);
        function1Marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFunctionNo = 1;
                currentFunction = program.getFunction1();
                renderProgram();
            }
        });

        TextView function2Marker = (TextView) findViewById(R.id.function_2_button);
        function2Marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFunctionNo = 2;
                currentFunction = program.getFunction2();
                renderProgram();
            }
        });

        TextView function3Marker = (TextView) findViewById(R.id.function_3_button);
        function3Marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFunctionNo = 3;
                currentFunction = program.getFunction3();
                renderProgram();
            }
        });
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
        TextView function1Button = (TextView) findViewById(R.id.function_1_button);
        function1Button.setBackgroundColor(Color.parseColor("#333333"));

        TextView function2Button = (TextView) findViewById(R.id.function_2_button);
        function2Button.setBackgroundColor(Color.parseColor("#333333"));

        TextView function3Button = (TextView) findViewById(R.id.function_3_button);
        function3Button.setBackgroundColor(Color.parseColor("#333333"));

        String activeFunction = "function_" + currentFunctionNo + "_button";
        int activeFunctionMarker = getResources().getIdentifier(activeFunction, "id", getApplicationContext().getPackageName());
        TextView activeFunctionLabel = (TextView) findViewById(activeFunctionMarker);

        activeFunctionLabel.setBackgroundColor(Color.parseColor("#999999"));

        List<Instruction> function1Instructions = program.getFunction1().getInstructions();
        List<Instruction> function2Instructions = program.getFunction2().getInstructions();
        List<Instruction> function3Instructions = program.getFunction3().getInstructions();

        int i = 1;

        for (Instruction instruction : function1Instructions) {
            int image = instruction.getIconResourceId();
            String imageViewID = "function_1_" + i;
            ImageView imageView = (ImageView) findViewById(getResources().getIdentifier(imageViewID, "id", getApplicationContext().getPackageName()));
            imageView.setImageResource(image);

            i++;
        }

        for (; i <= 10; i++) {
            String imageViewID = "function_1_" + i;
            ImageView imageView = (ImageView) findViewById(getResources().getIdentifier(imageViewID, "id", getApplicationContext().getPackageName()));
            imageView.setImageResource(0);
        }

        i = 1;

        for (Instruction instruction : function2Instructions) {
            int image = instruction.getIconResourceId();
            String imageViewID = "function_2_" + i;
            ImageView imageView = (ImageView) findViewById(getResources().getIdentifier(imageViewID, "id", getApplicationContext().getPackageName()));
            imageView.setImageResource(image);

            i++;
        }

        for (; i <= 5; i++) {
            String imageViewID = "function_2_" + i;
            ImageView imageView = (ImageView) findViewById(getResources().getIdentifier(imageViewID, "id", getApplicationContext().getPackageName()));
            imageView.setImageResource(0);
        }

        i = 1;

        for (Instruction instruction : function3Instructions) {
            int image = instruction.getIconResourceId();
            String imageViewID = "function_3_" + i;
            ImageView imageView = (ImageView) findViewById(getResources().getIdentifier(imageViewID, "id", getApplicationContext().getPackageName()));
            imageView.setImageResource(image);

            i++;
        }

        for (; i <= 5; i++) {
            String imageViewID = "function_3_" + i;
            ImageView imageView = (ImageView) findViewById(getResources().getIdentifier(imageViewID, "id", getApplicationContext().getPackageName()));
            imageView.setImageResource(0);
        }
    }

    private void initInstructionButtons() {
        ImageView leftInstruction = (ImageView) findViewById(R.id.instruction_left);
        leftInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allowModification) {
                    currentFunction.addInstruction(new MoveLeftInstruction(program));
                    renderProgram();
                }
            }
        });

        ImageView downInstruction = (ImageView) findViewById(R.id.instruction_down);
        downInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allowModification) {
                    currentFunction.addInstruction(new GrabOrReleaseCrateInstruction(program));
                    renderProgram();
                }
            }
        });

        ImageView rightInstruction = (ImageView) findViewById(R.id.instruction_right);
        rightInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allowModification) {
                    currentFunction.addInstruction(new MoveRightInstruction(program));
                    renderProgram();
                }
            }
        });

        ImageView call1Instruction = (ImageView) findViewById(R.id.instruction_1);
        call1Instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allowModification) {
                    currentFunction.addInstruction(new CallFunction1Instruction(program));
                    renderProgram();
                }
            }
        });

        ImageView call2Instruction = (ImageView) findViewById(R.id.instruction_2);
        call2Instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allowModification) {
                    currentFunction.addInstruction(new CallFunction2Instruction(program));
                    renderProgram();
                }
            }
        });

        ImageView call3Instruction = (ImageView) findViewById(R.id.instruction_3);
        call3Instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allowModification) {
                    currentFunction.addInstruction(new CallFunction3Instruction(program));
                    renderProgram();
                }
            }
        });

        ImageView backspaceInstruction = (ImageView) findViewById(R.id.instruction_backspace);
        backspaceInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allowModification) {
                    currentFunction.removeLastInstruction();
                    renderProgram();
                }
            }
        });
    }

    private void initBigButton() {
        LinearLayout bigButton = (LinearLayout) findViewById(R.id.big_button);

        bigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView bigButtonText = (TextView) findViewById(R.id.big_button_text);
                ImageView bigButtonImage = (ImageView) findViewById(R.id.big_button_image);

                if (gamePlaying) {
                    allowModification = true;
                    bigButtonText.setText("RUN");

                    bigButtonImage.setImageResource(android.R.drawable.ic_media_play);

                    game.playGame();
                    gamePlaying = false;
                } else {
                    allowModification = false;
                    bigButtonText.setText("STOP");

                    bigButtonImage.setImageResource(android.R.drawable.ic_media_pause);

                    game.stopGame();
                    gamePlaying = true;
                }

            }
        });
    }
}
