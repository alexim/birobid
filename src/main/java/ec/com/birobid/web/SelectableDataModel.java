package ec.com.birobid.web;

public interface SelectableDataModel<T> {
    
    public Object getRowKey(T object);
    
    public T getRowData(String rowKey);
}