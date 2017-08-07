package Ajax;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ajaxBean {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void increment() {

		System.out.println("Done ajax ....");

	}

	public void uppercase() {

		this.text = text.toUpperCase();

	}

}
