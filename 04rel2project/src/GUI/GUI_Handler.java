package GUI;

import Controller.RequestHandler;
import ObjectModules.Library;
import ObjectModules.Response;
import ObjectModules.Song;
import ObjectModules.User;

public class GUI_Handler {
    static User user;
    static Library library;
    static RequestHandler requestHandler;
    static Response response;

    static GUI_Home homePage;
    static GUI_Search searchPage;
    static GUI_Library libraryPage;

    static String name;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        libraryPage = new GUI_Library();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Start().setVisible(true);
            }
        });
    }
}
