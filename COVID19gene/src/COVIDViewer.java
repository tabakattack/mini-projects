import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.Scrollable;

public class COVIDViewer extends JFrame{

	private JButton searchButt = new JButton("Search");
	private JScrollBar scroller = new JScrollBar();
//	private List<String> fullCodonList = new List<>();
	private JList<String> selectionList = new JList<String>();
	private JList<String> searchForList = new JList<String>();
	private JLabel instructions = new JLabel();
	
	private Dimension frameMin;
	
	COVIDViewer(){
		super("COVID Gene Sequencing");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMin = new Dimension(300, 100);
		this.setMinimumSize(frameMin.getSize());
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.add(selectionList);
		this.add(scrollBar);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		COVIDViewer view = new COVIDViewer();
	}
}

