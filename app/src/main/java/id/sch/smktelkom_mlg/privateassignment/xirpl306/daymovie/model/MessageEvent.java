package id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.model;

/**
 * Created by Dayinta-PC on 6/13/2017.
 */

public class MessageEvent {
    private boolean update = false;

    public MessageEvent(boolean update) {
        this.update = update;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }
}
