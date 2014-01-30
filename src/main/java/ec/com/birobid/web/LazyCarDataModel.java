package ec.com.birobid.web;

import java.util.ArrayList;  
import java.util.Collections;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Map;  
import ec.com.birobid.web.Car;  
import ec.com.birobid.web.LazyDataModel;  
import ec.com.birobid.web.SortOrder;  
  
/** 
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database. 
 */  
public class LazyCarDataModel extends LazyDataModel<Car> {  
      
    /**
	 * 
	 */
	private static final long serialVersionUID = 5992739064001915958L;
	private List<Car> datasource;  
      
    public LazyCarDataModel(List<Car> datasource) {  
        this.datasource = datasource;  
    }  
      
    @Override  
    public Car getRowData(String rowKey) {  
        for(Car car : datasource) {  
            if(car.getModel().equals(rowKey))  
                return car;  
        }  
  
        return null;  
    }  
  
    @Override  
    public Object getRowKey(Car car) {  
        return car.getModel();  
    }  
  
    @Override  
    public List<Car> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {  
        List<Car> data = new ArrayList<Car>();  
  
        //filter  
        for(Car car : datasource) {  
            boolean match = true;  
  
            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    String filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(car.getClass().getField(filterProperty).get(car));  
  
                    if(filterValue == null || fieldValue.startsWith(filterValue)) {  
                        match = true;  
                    }  
                    else {  
                        match = false;  
                        break;  
                    }  
                } catch(Exception e) {  
                    match = false;  
                }   
            }  
  
            if(match) {  
                data.add(car);  
            }  
        }  
  
        //sort  
        if(sortField != null) {  
            Collections.sort(data, new LazySorter(sortField, sortOrder));  
        }  
  
        //rowCount  
        int dataSize = data.size();  
        this.setRowCount(dataSize);  
  
        //paginate  
        if(dataSize > pageSize) {  
            try {  
                return data.subList(first, first + pageSize);  
            }  
            catch(IndexOutOfBoundsException e) {  
                return data.subList(first, first + (dataSize % pageSize));  
            }  
        }  
        else {  
            return data;  
        }  
    }  
}  