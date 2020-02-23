package org.techtown.travellet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;

public class PlanInitialSubItem implements Serializable {

    String placeTime, placeName, placeMemo, transBudgetText, transportText;
    int transportIc, transportBudget;

    public PlanInitialSubItem(String placeTime, String placeName, String placeMemo, String transBudgetText, String transportText, int transportIc, int transportBudget) {
        this.placeTime = placeTime;
        this.placeName = placeName;
        this.placeMemo = placeMemo;
        this.transBudgetText = transBudgetText;
        this.transportText = transportText;
        this.transportIc = transportIc;
        this.transportBudget = transportBudget;
    }

    public String getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(String placeTime) {
        this.placeTime = placeTime;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceMemo() {
        return placeMemo;
    }

    public void setPlaceMemo(String placeMemo) {
        this.placeMemo = placeMemo;
    }

    public String getTransBudgetText() {
        return transBudgetText;
    }

    public void setTransBudgetText(String transBudgetText) {
        this.transBudgetText = transBudgetText;
    }

    public String getTransportText() {
        return transportText;
    }

    public void setTransportText(String transportText) {
        this.transportText = transportText;
    }

    public int getTransportIc() {
        return transportIc;
    }

    public void setTransportIc(int transportIc) {
        this.transportIc = transportIc;
    }

    public int getTransportBudget() {
        return transportBudget;
    }

    public void setTransportBudget(int transportBudget) {
        this.transportBudget = transportBudget;
    }

    @Override
    public String toString() {
        return "PlanInitialSubItem{" +
                "placeTime='" + placeTime + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeMemo='" + placeMemo + '\'' +
                ", transBudgetText='" + transBudgetText + '\'' +
                ", transportText='" + transportText + '\'' +
                ", transportIc=" + transportIc +
                ", transportBudget=" + transportBudget +
                '}';
    }
}
