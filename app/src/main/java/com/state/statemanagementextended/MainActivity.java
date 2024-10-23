package com.state.statemanagementextended;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private TextView counter, option;
    private Button button;
    private EditText input;
    private CheckBox checkbox;
    private Switch switchButton;
    private StateViewModel stateViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Pobierz instancję ViewModel
        stateViewModel = new ViewModelProvider(this).get(StateViewModel.class);

        // Ustaw temat na podstawie stanu ViewModel
        if (stateViewModel.isSwitchState()) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizuj Id
        counter = findViewById(R.id.counter);
        button = findViewById(R.id.button);
        input = findViewById(R.id.input);
        checkbox = findViewById(R.id.checkbox);
        switchButton = findViewById(R.id.mySwitch);
        option = findViewById(R.id.option);

        // Przywróć dane z ViewModel
        counter.setText(String.valueOf(stateViewModel.getLicznik()));
        input.setText(stateViewModel.getText());
        checkbox.setChecked(stateViewModel.isCheckboxState());
        switchButton.setChecked(stateViewModel.isSwitchState());
        option.setVisibility(stateViewModel.isCheckboxState() ? View.VISIBLE : View.GONE);

        // Kliknięcie przycisku - zwiększ licznik
        button.setOnClickListener(v -> {
            int licznik = stateViewModel.getLicznik() + 1;
            stateViewModel.setLicznik(licznik);
            counter.setText(String.valueOf(licznik));
        });

        // Zmiana stanu checkboxa
        checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            stateViewModel.setCheckboxState(isChecked);
            option.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });

        // Zmiana stanu switcha - tryb ciemny
        switchButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            stateViewModel.setSwitchState(isChecked);
            if (isChecked) {
                setTheme(R.style.DarkTheme);
            } else {
                setTheme(R.style.AppTheme);
            }

            // Odśwież aktywność, żeby zastosować nowy temat
            recreate();
        });
    }
}