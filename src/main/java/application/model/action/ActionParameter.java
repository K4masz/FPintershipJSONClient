package application.model.action;

public class ActionParameter<T>{

    T value;

    public ActionParameter(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
