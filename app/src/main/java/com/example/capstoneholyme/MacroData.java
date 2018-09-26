package com.example.capstoneholyme;

import android.os.Parcel;
import android.os.Parcelable;

class MacroData implements Parcelable {
    private String macroPlace;
    private String macroCondition;
    private String macroAction;
    private String macroTime;

    public MacroData() { } //test

    public MacroData(Parcel in) {
        readFromParcel(in);
    }

    public MacroData(String macroPlace, String macroCondition, String macroAction, String macroTime) {
        this.macroPlace = macroPlace;
        this.macroCondition = macroCondition;
        this.macroAction = macroAction;
        this.macroTime = macroTime;
    }

    public static final Creator<MacroData> CREATOR = new Creator<MacroData>() {
        public MacroData createFromParcel(Parcel in) {
            return new MacroData(in);
        }

        public MacroData[] newArray (int size) {
            return new MacroData[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public String getMacroPlace() {
        return macroPlace;
    }
    public String getMacroCondition() {
        return macroCondition;
    }
    public String getMacroAction() {
        return macroAction;
    }
    public String getMacroTime() {
        return macroTime;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.macroPlace);
        dest.writeString(this.macroCondition);
        dest.writeString(this.macroAction);
        dest.writeString(this.macroTime);
    }
    void readFromParcel(Parcel in) {
        macroPlace = in.readString();
        macroCondition = in.readString();
        macroAction = in.readString();
        macroTime = in.readString();
    }
}