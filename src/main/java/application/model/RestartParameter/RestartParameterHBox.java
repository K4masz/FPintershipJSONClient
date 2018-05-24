package application.model.RestartParameter;

import javafx.scene.Node;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

public class RestartParameterHBox extends HBox {

    private ToggleButton toggleButton;
    private Spinner<Integer> spinner;
    private int defaultValue;

    public RestartParameterHBox() {
        retriveMembers();
    }

    public RestartParameterHBox(double spacing) {
        super(spacing);
        retriveMembers();
    }

    public RestartParameterHBox(Node... children) {
        super(children);
        retriveMembers();
    }

    public RestartParameterHBox(double spacing, Node... children) {
        super(spacing, children);
        retriveMembers();
    }

    public void initMembers(int minValue, int maxValue, int initValue) {
        if (toggleButton == null || spinner == null)
            retriveMembers();

        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(minValue, maxValue, initValue));
        spinner.setEditable(true);
        spinner.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue)
                spinner.increment(0);
        });
        toggleButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) activateSpinner();
            else deactivateSpinner();
        });
        defaultValue = initValue;
    }

    public void initMembers(int minValue, int maxValue) {
        if (toggleButton == null || spinner == null)
            retriveMembers();

        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(minValue, maxValue));
        spinner.setEditable(true);
        spinner.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue)
                spinner.increment(0);
        });
        toggleButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) activateSpinner();
            else deactivateSpinner();
        });
        defaultValue = minValue;
    }

    public void activateButton() {
        this.toggleButton.setDisable(false);
    }

    public void deactivateSpinner() {
        this.spinner.setDisable(true);
    }

    public void activateSpinner() {
        this.spinner.setDisable(false);
    }

    public void deactivateButton() {
        if (this.isButtonActive())
            this.toggleButton.fire();
        this.toggleButton.setDisable(true);
    }

    public boolean isButtonActive() {
        return toggleButton.isSelected();
    }

    public int getValue() {
        if (this.isButtonActive())
            return spinner.getValue();
        else
            return this.defaultValue;
    }

    private void retriveMembers() {
        this.getChildren().forEach(x -> {
            if (x instanceof ToggleButton)
                this.toggleButton = (ToggleButton) x;
            if (x instanceof Spinner)
                this.spinner = (Spinner<Integer>) x;
        });
    }
}
