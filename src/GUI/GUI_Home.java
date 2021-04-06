package GUI;

/**
 * GUI implementation for the Home page. After signing in, the user
 * is brought to this page. This page serves as a landing site for
 * all newly signed in users. It cannot be accessed at a later time
 * after querying a different site.The user can navigate to the
 * different pages using the buttons on the sidebar, or close the
 * program by signing out.
 *
 * @author Brandon Montijo
 */
public class GUI_Home extends javax.swing.JFrame {
    private javax.swing.JLabel header;
    private javax.swing.JButton libraryPageButton;
    private javax.swing.JDesktopPane mainPane;
    private javax.swing.JLabel pageTitle1;
    private javax.swing.JButton searchPageButton;
    private javax.swing.JPanel sidebar;
    private javax.swing.JButton signOutButton;
    private javax.swing.JLabel welcomeText;

    /**
     * Creates new form GUI_HOME
     */
    public GUI_Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        sidebar = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        searchPageButton = new javax.swing.JButton();
        libraryPageButton = new javax.swing.JButton();
        signOutButton = new javax.swing.JButton();
        mainPane = new javax.swing.JDesktopPane();
        welcomeText = new javax.swing.JLabel();
        pageTitle1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(99, 0, 3));

        sidebar.setBackground(new java.awt.Color(18, 18, 18));

        header.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setText("Home");

        searchPageButton.setBackground(new java.awt.Color(24, 24, 24));
        searchPageButton.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        searchPageButton.setForeground(new java.awt.Color(255, 255, 255));
        searchPageButton.setText("Search");
        searchPageButton.setToolTipText("");
        searchPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPageButtonActionPerformed(evt);
            }
        });

        libraryPageButton.setBackground(new java.awt.Color(24, 24, 24));
        libraryPageButton.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        libraryPageButton.setForeground(new java.awt.Color(255, 255, 255));
        libraryPageButton.setText("Your Library");
        libraryPageButton.setToolTipText("");
        libraryPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libraryPageButtonActionPerformed(evt);
            }
        });

        signOutButton.setBackground(new java.awt.Color(24, 24, 24));
        signOutButton.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        signOutButton.setForeground(new java.awt.Color(255, 255, 255));
        signOutButton.setText("Sign Out");
        signOutButton.setToolTipText("");
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
                sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(searchPageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(libraryPageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                        .addComponent(signOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        sidebarLayout.setVerticalGroup(
                sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(header)
                                .addGap(18, 18, 18)
                                .addComponent(searchPageButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libraryPageButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 464, Short.MAX_VALUE)
                                .addComponent(signOutButton)
                                .addContainerGap())
        );

        mainPane.setBackground(new java.awt.Color(24, 24, 24));

        welcomeText.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        welcomeText.setForeground(new java.awt.Color(255, 255, 255));
        welcomeText.setText("Welcome to the Muze Music Library System " + GUI_Handler.name);

        pageTitle1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        pageTitle1.setForeground(new java.awt.Color(255, 255, 255));
        pageTitle1.setText("Welcome");

        mainPane.setLayer(welcomeText, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainPane.setLayer(pageTitle1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
                mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pageTitle1)
                                        .addComponent(welcomeText))
                                .addContainerGap(393, Short.MAX_VALUE))
        );
        mainPaneLayout.setVerticalGroup(
                mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pageTitle1)
                                .addGap(18, 18, 18)
                                .addComponent(welcomeText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainPane))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainPane)
        );

        pack();
    }

    private void searchPageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GUI_Handler.searchPage = new GUI_Search();
        GUI_Handler.searchPage.setVisible(true);
    }

    private void libraryPageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GUI_Handler.libraryPage.setVisible(true);
    }

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(GUI_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Home().setVisible(true);
            }
        });
    }
}
