package application.controllers;

import application.model.RestartParameter.RestartParameterHBox;
import application.model.action.Action;
import application.model.action.ActionManager;
import application.model.action.ActionParameter;
import application.model.enums.*;
import application.model.generated.Parameter;
import application.model.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    private static MainController instance;
    public Slider valueSlider;
    public TilePane restartParamsTilePane;
    public Label sliderValueLabel;
    public Button submitButton;
    public Button checkSituationButton;
    public ChoiceBox<EActionType> actionChoiceBox;
    public ChoiceBox parameterChoiceBox;
    public ChoiceBox valueChoiceBox;
    public TextArea statusTextArea;
    public TextArea currentSituationTextArea;
    public RadioButton simulationModeRadioButton;
    public RadioButton chaarrModeRadioButton;
    public RestartParameterHBox chaarrHatredRestartParameter;
    public RestartParameterHBox knowledgeRestartParameter;
    public RestartParameterHBox crewDeathsRestartParameter;
    public RestartParameterHBox survivorDeathsRestartParameter;
    public RestartParameterHBox savedScienceRestartParameter;
    public RestartParameterHBox savedSurvivorsRestartParameter;
    public RestartParameterHBox poludnicaMatterRestartParameter;
    public RestartParameterHBox poludnicaEnergyRestartParameter;
    public RestartParameterHBox expeditionMatterRestartParameter;
    public RestartParameterHBox expeditionEnergyRestartParameter;
    private ToggleGroup worldChoice;
    private ActionManager actionManager;
    private Logger logger;

    public MainController() {
        actionManager = ActionManager.getInstance();
        logger = Logger.getInstance();
        instance = this;
    }

    public static MainController getInstance() {
        return instance;
    }

    private void initResetParameterForms() {
        chaarrHatredRestartParameter.initMembers(10, 180, 10);
        knowledgeRestartParameter.initMembers(0, 250);
        crewDeathsRestartParameter.initMembers(0, 250);
        survivorDeathsRestartParameter.initMembers(0, 500);
        savedScienceRestartParameter.initMembers(0, 250);
        savedSurvivorsRestartParameter.initMembers(0, 500);
        poludnicaMatterRestartParameter.initMembers(0, 1000, 308);
        poludnicaEnergyRestartParameter.initMembers(0, 1000, 301);
        expeditionMatterRestartParameter.initMembers(0, 1000);
        expeditionEnergyRestartParameter.initMembers(0, 1000);
    }

    private void assignFunctionsToComponents() {
        actionChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            restartParamsTilePane.getChildren().forEach(x -> {
                ((RestartParameterHBox) x).deactivateButton();
                ((RestartParameterHBox) x).deactivateSpinner();
            });
            parameterChoiceBox.setDisable(true);
            valueChoiceBox.setDisable(true);
            valueSlider.setDisable(true);

            switch (newValue) {
                case SCAN:
                    populateChoiceBox(parameterChoiceBox, FXCollections.observableArrayList(EParameterA.values()));
                    break;
                case ORDER:
                    populateChoiceBox(parameterChoiceBox, FXCollections.observableArrayList(EParameterD.values()));
                    populateChoiceBox(valueChoiceBox, FXCollections.observableArrayList(EParameterA.values()));
                    break;
                case MOVETO:
                    populateChoiceBox(parameterChoiceBox, FXCollections.observableArrayList(EParameterA.values()));
                    break;
                case REPAIR:
                    populateChoiceBox(parameterChoiceBox, FXCollections.observableArrayList(EParameterC.values()));
                    break;
                case HARVEST:
                    populateChoiceBox(parameterChoiceBox, FXCollections.observableArrayList(EParameterA.values()));
                    break;
                case PRODUCE:
                    populateChoiceBox(parameterChoiceBox, FXCollections.observableArrayList(EParameterB.values()));
                    break;
                case RESTARTSIMULATION:
                    restartParamsTilePane.getChildren().forEach(x -> ((RestartParameterHBox) x).activateButton());
                    break;
                case RESTART:
                    break;
            }
        });

        parameterChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            valueSlider.setDisable(true);
            if (newValue == null)
                return;
            if (newValue.equals(EParameterB.SUPPLIES))
                valueSlider.setDisable(false);
        });

        valueSlider.valueProperty().addListener((observable, oldValue, newValue) -> sliderValueLabel.setText(String.valueOf(newValue.intValue())));
    }

    private void initializeWorldChoiceSection() {
        worldChoice = new ToggleGroup();

        simulationModeRadioButton.setDisable(false);
        chaarrModeRadioButton.setDisable(false);

        simulationModeRadioButton.fire();
        simulationModeRadioButton.setToggleGroup(worldChoice);
        chaarrModeRadioButton.setToggleGroup(worldChoice);

        worldChoice.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<EActionType> items = actionChoiceBox.getItems();
            items.remove(EActionType.RESTARTSIMULATION);

            if (worldChoice.getSelectedToggle() == simulationModeRadioButton) {
                actionManager.setSimulationFlag(true);
                items.add(EActionType.RESTARTSIMULATION);

            } else {
                actionManager.setSimulationFlag(false);
                items.remove(EActionType.RESTARTSIMULATION);
            }

            actionChoiceBox.setItems(items);
        });
    }

    private void populateChoiceBox(ChoiceBox choiceBox, ObservableList collection) {
        choiceBox.setItems(collection);
        choiceBox.getSelectionModel().selectFirst();
        choiceBox.setDisable(false);
    }

    public void init() {
        initializeWorldChoiceSection();
        initResetParameterForms();
        assignFunctionsToComponents();

        actionChoiceBox.setDisable(false);
        submitButton.setDisable(false);
        checkSituationButton.setDisable(false);

        actionChoiceBox.setItems(FXCollections.observableArrayList(EActionType.values()));
        actionChoiceBox.getSelectionModel().selectFirst();
    }

    private Parameter getRestartParameter() {
        return new Parameter()
                .withChaarrHatred(chaarrHatredRestartParameter.getValue())
                .withKnowledge(knowledgeRestartParameter.getValue())
                .withCrewDeaths(crewDeathsRestartParameter.getValue())
                .withSurvivorDeaths(survivorDeathsRestartParameter.getValue())
                .withSavedScience(savedScienceRestartParameter.getValue())
                .withSavedSurvivors(savedSurvivorsRestartParameter.getValue())
                .withPoUdnicaMatter(poludnicaMatterRestartParameter.getValue())
                .withPoUdnicaEnergy(poludnicaEnergyRestartParameter.getValue())
                .withExpeditionMatter(expeditionMatterRestartParameter.getValue())
                .withExpeditionEnergy(expeditionEnergyRestartParameter.getValue());
    }

    public void executeAction(MouseEvent mouseEvent) throws IOException {
        Response response;
        List<ActionParameter> parameters = new ArrayList<>();

        switch (actionChoiceBox.getValue()) {
            case SCAN:
                parameters.add(new ActionParameter<>((EParameterA) parameterChoiceBox.getValue()));
                break;
            case MOVETO:
                parameters.add(new ActionParameter<>((EParameterA) parameterChoiceBox.getValue()));
                break;
            case HARVEST:
                parameters.add(new ActionParameter<>((EParameterA) parameterChoiceBox.getValue()));
                break;
            case REPAIR:
                parameters.add(new ActionParameter<>((EParameterC) parameterChoiceBox.getValue()));
                break;
            case ORDER:
                parameters.add(new ActionParameter<>((EParameterD) parameterChoiceBox.getValue()));
                parameters.add(new ActionParameter<>((EParameterA) valueChoiceBox.getValue()));
                break;
            case PRODUCE:
                parameters.add(new ActionParameter<>((EParameterB) parameterChoiceBox.getValue()));
                if (parameterChoiceBox.getValue().equals(EParameterB.SUPPLIES))
                    parameters.add(new ActionParameter<>(String.valueOf(((int) valueSlider.getValue()))));
                break;
            case RESTARTSIMULATION:
                parameters.add(new ActionParameter<>(getRestartParameter()));
                logger.newLog();
                break;
            case RESTART:
                logger.newLog();
                break;

        }
        Action action = new Action(actionChoiceBox.getValue(), parameters);
        response = actionManager.executeAction(action);

        checkSituation();
        if (response.code() == 200) {
            statusTextArea.setText(actionChoiceBox.getValue().name() + " command executed successfully");
            logger.LogAction(action);
            logger.LogCurrentSituation(actionManager.getCurrentSituation());

            if (actionManager.getCurrentSituation().getIsTerminated() && !actionChoiceBox.getValue().isRestart())
                logger.writeLog();
        } else
            statusTextArea.setText("ERROR");
    }

    public void checkSituation() {
        currentSituationTextArea.setText(actionManager.getCurrentSituation().toString());
    }
}