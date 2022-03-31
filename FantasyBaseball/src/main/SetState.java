package main;

public class SetState {
    private String SaveState;
    private String RestoreState;

    public SetState(String saveState, String restoreState) {
        SaveState = saveState;
        RestoreState = restoreState;
    }

    public String getSaveState() {
        return SaveState;
    }

    public void setSaveState(String saveState) {
        SaveState = saveState;
    }

    public String getRestoreState() {
        return RestoreState;
    }

    public void setRestoreState(String restoreState) {
        RestoreState = restoreState;
    }
}
