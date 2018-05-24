package application.model.action;

import application.model.enums.EActionType;

import java.util.List;

public class Action {

    private EActionType actionType;
    private List<ActionParameter> parametersList;

    public Action(EActionType actionType, List<ActionParameter> parametersList) {
        this.actionType = actionType;
        this.parametersList = parametersList;
    }

    public EActionType getActionType() {
        return actionType;
    }

    public List<ActionParameter> getParametersList() {
        return parametersList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----\n");
        sb.append(actionType.name() + "\n");
        for (ActionParameter x:this.parametersList)
            sb.append(x.getValue() + "\n");
        sb.append("-----\n");

        return sb.toString();
    }
}
