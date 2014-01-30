package ec.com.birobid.web;

import javax.el.MethodExpression;
import org.primefaces.component.api.UIColumn;

public class SortMeta {
    
    private UIColumn column;
    
    private String sortField;
    
    private SortOrder sortOrder;
    
    private MethodExpression sortFunction;

    public SortMeta() {}
    
    public SortMeta(UIColumn column, String sortField, SortOrder sortOrder, MethodExpression sortFunction) {
        this.column = column;
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public UIColumn getColumn() {
        return column;
    }

    public void setSortBy(UIColumn column) {
        this.column = column;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public MethodExpression getSortFunction() {
        return sortFunction;
    }

    public void setSortFunction(MethodExpression sortFunction) {
        this.sortFunction = sortFunction;
    }
}