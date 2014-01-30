package ec.com.birobid.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.model.DataModel;

/**
 * Custom lazy loading DataModel to deal with huge datasets
 */
public abstract class LazyDataModel<T> extends DataModel<T> implements SelectableDataModel<T>, Serializable {

        /**
	 * 
	 */
	private static final long serialVersionUID = -4200754752007058556L;

		private int rowIndex = -1;

        private int rowCount;

        private int pageSize;

        private List<T> data;

        public LazyDataModel() {
                super();
        }
        
        public boolean isRowAvailable() {
                if(data == null) {
            return false;
        }

                return rowIndex >= 0 && rowIndex < data.size();
        }

        public int getRowCount() {
                return rowCount;
        }

        public T getRowData() {
        return data.get(rowIndex);
        }

    public int getRowIndex() {
        return this.rowIndex;
    }
    
    public void setRowIndex(int rowIndex) {
        if(rowIndex == -1 || pageSize == 0)
            this.rowIndex = -1;
        else
            this.rowIndex = (rowIndex % pageSize);
    }

        public Object getWrappedData() {
                return data;
        }
        public void setWrappedData(Object list) {
                this.data = (List) list;
        }
        
        public int getPageSize() {
                return pageSize;
        }
        public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
        }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public List<Car> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        throw new UnsupportedOperationException("Lazy loading is not implemented.");
    }
    
    public List<Car> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String,String> filters) {
        throw new UnsupportedOperationException("Lazy loading is not implemented.");
    }

    public T getRowData(String rowKey) {
        throw new UnsupportedOperationException("getRowData(String rowKey) must be implemented when basic rowKey algorithm is not used.");
    }

    public Object getRowKey(Car object) {
        throw new UnsupportedOperationException("getRowKey(T object) must be implemented when basic rowKey algorithm is not used.");
    }
}