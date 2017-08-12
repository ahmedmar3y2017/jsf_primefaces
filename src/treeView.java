import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean
@ViewScoped

public class treeView {

	private TreeNode root;

	@PostConstruct
	public void init() {
		root = new DefaultTreeNode("Root", null);
		TreeNode node0 = new DefaultTreeNode("Node 0", root);
		TreeNode node1 = new DefaultTreeNode("Node 1", root);

		TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
		TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);

		TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);

		node1.getChildren().add(new DefaultTreeNode("Node 1.1"));
		node00.getChildren().add(new DefaultTreeNode("Node 0.0.0"));
		node00.getChildren().add(new DefaultTreeNode("Node 0.0.1"));
		node01.getChildren().add(new DefaultTreeNode("Node 0.1.0"));
		node10.getChildren().add(new DefaultTreeNode("Node 1.0.0"));
		root.getChildren().add(new DefaultTreeNode("Node 2"));
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void handleToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled",
				"Visibility:" + event.getVisibility());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
