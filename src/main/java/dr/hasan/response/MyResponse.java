package dr.hasan.response;

public class MyResponse<T> extends BaseModel {

    private T items;

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }
}
