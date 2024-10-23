package com.state.statemanagementextended;

import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel {
    private int licznik = 0;
    private String text = "";
    private boolean checkboxState = false;
    private boolean switchState = false;

    public int getLicznik() {
        return licznik;
    }

    public void setLicznik(int licznik) {
        this.licznik = licznik;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCheckboxState() {
        return checkboxState;
    }

    public void setCheckboxState(boolean checkboxState) {
        this.checkboxState = checkboxState;
    }

    public boolean isSwitchState() {
        return switchState;
    }

    public void setSwitchState(boolean switchState) {
        this.switchState = switchState;
    }
}
