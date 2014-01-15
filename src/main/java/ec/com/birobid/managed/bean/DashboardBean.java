package ec.com.birobid.managed.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
*
* @author Alexi
*/
@ManagedBean
@SessionScoped
public class DashboardBean implements Serializable {

        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private DashboardModel model;
        
        public DashboardBean() {
                model = new DefaultDashboardModel();
                DashboardColumn column1 = new DefaultDashboardColumn();
                DashboardColumn column2 = new DefaultDashboardColumn();
                DashboardColumn column3 = new DefaultDashboardColumn();
                
                column1.addWidget("sports");
                column1.addWidget("finance");
                
                column2.addWidget("lifestyle");
                column2.addWidget("weather");
                
                column3.addWidget("politics");
                column3.addWidget("calendar");

                model.addColumn(column1);
                model.addColumn(column2);
                model.addColumn(column3);
        }
        
        public void handleReorder(DashboardReorderEvent event) {
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_INFO);
                message.setSummary("Reordered: " + event.getWidgetId());
                message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());
                
                addMessage(message);
        }
        
        public void handleClose(CloseEvent event) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
                
                addMessage(message);
        }
        
        public void handleToggle(ToggleEvent event) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
                
                addMessage(message);
        }
        
        private void addMessage(FacesMessage message) {
                FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
        public DashboardModel getModel() {
                return model;
        }
}