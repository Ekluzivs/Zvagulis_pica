import javax.swing.JOptionPane;

public class Pica {
    public static void main(String[] args) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        if (JOptionPane.showConfirmDialog(null, "vai vēlaties pasūtīt picu?", "Picērija",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    // yes option
} else {
    // no option
}
    }
}