package accordionPanel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.tabview.Tab;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

@ManagedBean
@SessionScoped
public class panel {

	List<accordionpabel> accordionpabel;

	@PostConstruct
	public void init() {
		accordionpabel = new ArrayList<>();

		accordionpabel.add(new accordionpabel("title1", "body1"));
		accordionpabel.add(new accordionpabel("title2", "body2"));
		accordionpabel.add(new accordionpabel("title3", "body3"));

	}

	public List<accordionpabel> getAccordionpabel() {
		return accordionpabel;
	}

	public void setAccordionpabel(List<accordionpabel> accordionpabel) {
		this.accordionpabel = accordionpabel;
	}

	// when tab open ....
	public void onchange(TabChangeEvent event) {
		Tab tab = event.getTab();

		System.out.println(tab.getTitle() + "   ********** change ***********");

	}

	// when tab closed .....
	public void onclose(TabCloseEvent event) {
		Tab tab = event.getTab();

		System.out.println(tab.getTitle() + "   ******* close **************");

	}

}
