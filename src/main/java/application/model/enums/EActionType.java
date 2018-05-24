package application.model.enums;

public enum EActionType {
    SCAN(false),
    MOVETO(false),
    PRODUCE(false),
    HARVEST(false),
    REPAIR(false),
    ORDER(false),
    RESTART(true),
    RESTARTSIMULATION(true);

    private boolean isRestart;

    EActionType(boolean isRestart) {
        this.isRestart = isRestart;
    }

    public boolean isRestart() {
        return isRestart;
    }
}
