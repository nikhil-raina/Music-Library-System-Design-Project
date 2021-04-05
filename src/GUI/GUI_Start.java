package GUI;

import Controller.RequestHandler;
import Model.Grouping;
import ObjectModules.Library;
import ObjectModules.Response;
import ObjectModules.User;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;

/**
 * GUI Implementation for the Start page. This is the first page that
 * appears when the GUI version of MMLS is initialized. The user signs
 * in by entering a specific username and clicking enter. The passed
 * in username is checked to see if it exists in persisted data, and
 * creates a user based on if it exists.
 *
 * @author Brandon
 */
public class GUI_Start extends javax.swing.JFrame {
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonSignIn;
    private javax.swing.JLabel header;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField userNameTextBox;

    /**
     * Creates new form GUI
     */
    public GUI_Start() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        userNameTextBox = new javax.swing.JTextField();
        buttonSignIn = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(18, 18, 18));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(400, 150));

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));

        header.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setText("Sign In");

        userNameTextBox.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        userNameTextBox.setText("Enter Username");
        userNameTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTextBoxActionPerformed(evt);
            }
        });

        buttonSignIn.setBackground(new java.awt.Color(8, 8, 8));
        buttonSignIn.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        buttonSignIn.setForeground(new java.awt.Color(255, 255, 255));
        buttonSignIn.setText("Enter");
        buttonSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    buttonSignInActionPerformed(evt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonCancel.setBackground(new java.awt.Color(24, 24, 24));
        buttonCancel.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        buttonCancel.setForeground(new java.awt.Color(255, 255, 255));
        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(userNameTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(header)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(buttonCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonSignIn)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(header)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonSignIn)
                                        .addComponent(buttonCancel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void buttonSignInActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException, ParseException {
        // TODO add your handling code here:
        FileReader reader = new FileReader("src/PersistedData/Libraries.json");

        GUI_Handler.user = null;
        boolean isOldUser = false;
        String username = userNameTextBox.getText();

        JsonElement jsonElement = new JsonParser().parse(reader);
        JsonArray users = new JsonArray();
        if( jsonElement == null || jsonElement instanceof JsonNull) {
            GUI_Handler.user = new User(0, username);
        }
        else {
            users = jsonElement.getAsJsonObject().getAsJsonArray("libraryData");
            for (int userIdx = 0; userIdx < users.size(); userIdx++){
                JsonObject userObj = users.get(userIdx).getAsJsonObject();
                if (userObj.get("userName").toString().replace("\"","").equalsIgnoreCase(username)) {
                    JsonArray libraryElements = userObj.get("library").getAsJsonObject().get("elements").getAsJsonArray();
                    GUI_Handler.library = new Library();
                    GUI_Handler.library.makeLibrary(libraryElements);
                    GUI_Handler.user = new User(Integer.parseInt(userObj.get("ID").toString()), username, GUI_Handler.library);
                    isOldUser = true;
                    break;
                }
            }
            if (!isOldUser)
                GUI_Handler.user = new User(users.size(), username); // new user
        }
        GUI_Handler.requestHandler = new RequestHandler(GUI_Handler.user.getLibrary(), new Grouping());

        this.setVisible(false);

        GUI_Handler.homePage = new GUI_Home();
        GUI_Handler.homePage.setVisible(true);
    }

    private void userNameTextBoxActionPerformed(java.awt.event.ActionEvent evt) {}

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
