// TO WORK ON
//TODO: fix stage1 image icon sizes, resize to 32x32


// COMPLETED 
//TODO: Clear Button doesn't reset progress bars on stage3          DONE
//TODO: update progress bars, on load and clear -                   DONE
//TODO: rework save data, to save stages 1 and 2, and current stage DONE
//TODO: set other progress bars under setProgressBars()             DONE

/*
 * Main window, holds the GUI and functionality coding
 */
package ffxiv.anima.weapon.tracker;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
/**
 *
 * @author Workhorse
 */
public class MainWin extends javax.swing.JFrame {

    
    //title is combined in JFrames's properties under Title <user code>
    String appTitle = "FFXIV: Anima Weapon Tracker ";
    String majorVersion = "0";
    String minorVersion = "2";
    String buildVersion = "3";
    String forPatch = "Patch 3.38";
    
    // Directory paths.
    static final String MEDIA_DIRECTORY = "." + File.separator + "media" + File.separator;
    static final String CURRENCY_DIRECTORY = MEDIA_DIRECTORY + "currency" + File.separator;
    static final String CRYSTALS_DIRECTORY = MEDIA_DIRECTORY + "crystals" + File.separator;
    
    //UI icons stuffs
    String ubone_icon = MEDIA_DIRECTORY + "Unidentifiable_Bone_Icon.png";
    String ushell_icon = MEDIA_DIRECTORY +  "Unidentifiable_Shell_Icon.png";
    String uore_icon = MEDIA_DIRECTORY + "Unidentifiable_Ore_Icon.png";
    String useed_icon = MEDIA_DIRECTORY + "Unidentifiable_Seeds_Icon.png";
    String adamantite_francesca_icon = MEDIA_DIRECTORY + "Adamantite_Francesca_Icon.png";
    String titanium_alloy_mirror_icon = MEDIA_DIRECTORY + "Titanium_Alloy_Mirror_Icon.png";
    String dispelling_arrow_icon = MEDIA_DIRECTORY + "Dispelling_Arrow_Icon.png";
    String kingcake_icon = MEDIA_DIRECTORY + "Kingcake_Icon.png";
    String poetics_icon = CURRENCY_DIRECTORY + "poetics_icon.png";
    String esoterics_icon = CURRENCY_DIRECTORY + "esoterics_icon.png";
    String lore_icon = CURRENCY_DIRECTORY + "lore_icon.png";
    String allied_seals_icon = CURRENCY_DIRECTORY + "allied_seal_icon.png";
    String centurio_seals_icon = CURRENCY_DIRECTORY + "centurio_seal_icon.png";
    
    String steel_amaljok_icon = CURRENCY_DIRECTORY + "steel_amalj'ok_icon.png";
    String sylphic_goldleaf_icon = CURRENCY_DIRECTORY + "sylphic_goldleaf_icon.png";
    String titan_cobaltpiece_icon = CURRENCY_DIRECTORY + "titan_cobaltpiece_icon.png";
    String rainbowtide_psashp_icon = CURRENCY_DIRECTORY + "rainbowtide_psashp_icon.png";
    String ixali_oaknot_icon = CURRENCY_DIRECTORY + "ixali_oaknot_icon.png";
    
    String luminous_fire_crystal_icon = CRYSTALS_DIRECTORY + "luminous_fire_crystal_icon.png";
    String luminous_wind_crystal_icon = CRYSTALS_DIRECTORY + "luminous_wind_crystal_icon.png";
    String luminous_lightning_crystal_icon = CRYSTALS_DIRECTORY + "luminous_lightning_crystal_icon.png";
    String luminous_ice_crystal_icon = CRYSTALS_DIRECTORY + "luminous_ice_crystal_icon.png";
    String luminous_earth_crystal_icon = CRYSTALS_DIRECTORY + "luminous_earth_crystal_icon.png";
    String luminous_water_crystal_icon = CRYSTALS_DIRECTORY + "luminous_water_crystal_icon.png";
    
    
    // used for collectin all the values
    // only declared at a global level, not instanciated
    Collection collection;
    ArrayList<Integer> allValues;
    
    // Collection object saved in "data.save"
    String saveFilename = "data.save";
    Boolean file_exist = false;
    
    //to track completed stages //NOT USED //will remove in next version if not used
    List<Boolean> stageCompleted = Arrays.asList(false, false, false, false, false);
    
    /**
     * Creates new form MainWin
     */
    public MainWin() {
        initComponents();
        
        //sets up icons
        unidentifiable_bone_pic.setIcon(new ImageIcon(ubone_icon));
        unidentifiable_shell_pic.setIcon(new ImageIcon(ushell_icon));
        unidentifiable_ore_pic.setIcon(new ImageIcon(uore_icon));
        unidentifiable_seed_pic.setIcon(new ImageIcon(useed_icon));
        adamantite_francesca_pic.setIcon(new ImageIcon(adamantite_francesca_icon));
        titanium_alloy_mirror_pic.setIcon(new ImageIcon(titanium_alloy_mirror_icon));
        dispelling_arrow_pic.setIcon(new ImageIcon(dispelling_arrow_icon));
        kingcake_pic.setIcon(new ImageIcon(kingcake_icon));
        poetic_tomestones_pic.setIcon(new ImageIcon(poetics_icon));
        esoterics_tomestones_pic.setIcon(new ImageIcon(esoterics_icon));
        lore_tomestones_pic.setIcon(new ImageIcon(lore_icon));
        allied_seals_pic.setIcon(new ImageIcon(allied_seals_icon));
        centurio_seals_pic.setIcon(new ImageIcon(centurio_seals_icon));
        
        //tokens tab icon
        steel_amaljok_pic.setIcon(new ImageIcon(steel_amaljok_icon));
        sylphic_goldleaf_pic.setIcon(new ImageIcon(sylphic_goldleaf_icon));
        titan_cobaltpiece_pic.setIcon(new ImageIcon(titan_cobaltpiece_icon));
        rainbowtide_psashp_pic.setIcon(new ImageIcon(rainbowtide_psashp_icon));
        ixali_oaknot_pic.setIcon(new ImageIcon(ixali_oaknot_icon));
        
        //stage 1 tab icons
        luminous_fire_crystal_pic.setIcon(new ImageIcon(luminous_fire_crystal_icon));
        luminous_wind_crystal_pic.setIcon(new ImageIcon(luminous_wind_crystal_icon));
        luminous_lightning_crystal_pic.setIcon(new ImageIcon(luminous_lightning_crystal_icon));
        luminous_ice_crystal_pic.setIcon(new ImageIcon(luminous_ice_crystal_icon));
        luminous_earth_crystal_pic.setIcon(new ImageIcon(luminous_earth_crystal_icon));
        luminous_water_crystal_pic.setIcon(new ImageIcon(luminous_water_crystal_icon));
        
        //currently not used Boolean 'file_exist', but the method does load saved data.
        file_exist = fileExists();
        
        //set app to center screen
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int appHeight = this.getHeight();
        int appWidth = this.getWidth();
        this.setBounds(
                (screenWidth/2)-(appWidth/2), 
                (screenHeight/2)-(appHeight/2), 
                appWidth, 
                appHeight);
        
        // sets app Icon
        this.setIconImage(new ImageIcon(MEDIA_DIRECTORY + "moogle_icon.png").getImage());
        
        stage_selector.setModel(new StageSelectorComboBoxModel());
        
        //hide some components
        stage_selector.setVisible(false);
        testButton.setVisible(false);
        tabs_stages.remove(5); //removes tokens tab for now
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        save_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        load_button = new javax.swing.JButton();
        status_text = new javax.swing.JLabel();
        tabs_stages = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        astral_nodule_panel = new javax.swing.JPanel();
        luminous_fire_crystal_pic = new javax.swing.JLabel();
        luminous_fire_crystal_text = new javax.swing.JLabel();
        luminous_fire_crystal_value = new javax.swing.JLabel();
        luminous_wind_crystal_pic = new javax.swing.JLabel();
        luminous_wind_crystal_text = new javax.swing.JLabel();
        luminous_wind_crystal_value = new javax.swing.JLabel();
        luminous_lightning_crystal_pic = new javax.swing.JLabel();
        luminous_lightning_crystal_text = new javax.swing.JLabel();
        luminous_lightning_crystal_value = new javax.swing.JLabel();
        astral_nodule_pbar = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        astral_nodule_acquire_button = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        astral_nodules_value = new javax.swing.JLabel();
        umbral_nodule_panel = new javax.swing.JPanel();
        luminous_ice_crystal_pic = new javax.swing.JLabel();
        luminous_earth_crystal_pic = new javax.swing.JLabel();
        luminous_water_crystal_pic = new javax.swing.JLabel();
        luminous_water_crystal_text = new javax.swing.JLabel();
        luminous_earth_crystal_text = new javax.swing.JLabel();
        luminous_ice_crystal_text = new javax.swing.JLabel();
        luminous_ice_crystal_value = new javax.swing.JLabel();
        luminous_earth_crystal_value = new javax.swing.JLabel();
        luminous_water_crystal_value = new javax.swing.JLabel();
        umbral_nodule_pbar = new javax.swing.JProgressBar();
        umbral_nodule_acquire_button = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        umbral_nodules_value = new javax.swing.JLabel();
        stage1CompleteButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        stage2_stage01 = new javax.swing.JLabel();
        stage2_stage02 = new javax.swing.JLabel();
        stage2_stage03 = new javax.swing.JLabel();
        stage2_stage04 = new javax.swing.JLabel();
        stage2_stage05 = new javax.swing.JLabel();
        stage2_stage06 = new javax.swing.JLabel();
        stage2_stage07 = new javax.swing.JLabel();
        stage2_stage08 = new javax.swing.JLabel();
        stage2_stage09 = new javax.swing.JLabel();
        stage2_stage10 = new javax.swing.JLabel();
        stage2_pbar = new javax.swing.JProgressBar();
        stage2CompleteButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        unidentifiable_bone_pic = new javax.swing.JLabel();
        u_bone_text = new javax.swing.JLabel();
        ubone_value = new javax.swing.JLabel();
        adamantite_francesca_pic = new javax.swing.JLabel();
        adamantite_francesca_text = new javax.swing.JLabel();
        adamantite_francesca_value = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dispelling_arrow_pic = new javax.swing.JLabel();
        dispelling_arrow_text = new javax.swing.JLabel();
        dispelling_arrow_value = new javax.swing.JLabel();
        unidentifiable_ore_pic = new javax.swing.JLabel();
        u_ore_text = new javax.swing.JLabel();
        uore_value = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        unidentifiable_shell_pic = new javax.swing.JLabel();
        u_shell_text = new javax.swing.JLabel();
        ushell_value = new javax.swing.JLabel();
        titanium_alloy_mirror_text = new javax.swing.JLabel();
        titanium_alloy_mirror_pic = new javax.swing.JLabel();
        titanium_alloy_value = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        unidentifiable_seed_pic = new javax.swing.JLabel();
        u_seed_text = new javax.swing.JLabel();
        useed_value = new javax.swing.JLabel();
        kingcake_pic = new javax.swing.JLabel();
        kingcake_text = new javax.swing.JLabel();
        kingcake_value = new javax.swing.JLabel();
        enchanted_rubber_pbar = new javax.swing.JProgressBar();
        divine_water_pbar = new javax.swing.JProgressBar();
        fast_drying_carboncoat_pbar = new javax.swing.JProgressBar();
        fast_acting_allagan_catalyst_pbar = new javax.swing.JProgressBar();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        poetic_tomestones_pic = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        esoterics_tomestones_pic = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lore_tomestones_pic = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        allied_seals_pic = new javax.swing.JLabel();
        centurio_seals_pic = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        steel_amaljok_pic = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        sylphic_goldleaf_pic = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        titan_cobaltpiece_pic = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rainbowtide_psashp_pic = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ixali_oaknot_pic = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        poetic_tomestones_pic8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        poetic_tomestones_pic9 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        poetic_tomestones_pic10 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        stage_selector = new javax.swing.JComboBox<>();
        testButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(appTitle +"v" +majorVersion +"." + minorVersion +"."+ buildVersion + " - For " + forPatch);
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(600, 530));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 530));

        save_button.setText("Save");
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                save_buttonMousePressed(evt);
            }
        });

        clear_button.setText("Clear");
        clear_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clear_buttonMousePressed(evt);
            }
        });

        load_button.setText("Load");
        load_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                load_buttonMousePressed(evt);
            }
        });

        status_text.setText(" ");

        tabs_stages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabs_stagesMousePressed(evt);
            }
        });

        jPanel3.setPreferredSize(new java.awt.Dimension(550, 420));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Soul without Life");

        astral_nodule_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Astral Nodule"));
        astral_nodule_panel.setPreferredSize(new java.awt.Dimension(270, 300));

        luminous_fire_crystal_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        luminous_fire_crystal_pic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        luminous_fire_crystal_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        luminous_fire_crystal_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        luminous_fire_crystal_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        luminous_fire_crystal_pic.setRequestFocusEnabled(false);

        luminous_fire_crystal_text.setText("Fire Crystal:");
        luminous_fire_crystal_text.setToolTipText("");

        luminous_fire_crystal_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        luminous_fire_crystal_value.setForeground(new java.awt.Color(102, 0, 0));
        luminous_fire_crystal_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        luminous_fire_crystal_value.setText("00 / 03");
        luminous_fire_crystal_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        luminous_fire_crystal_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                luminous_fire_crystal_valueMousePressed(evt);
            }
        });

        luminous_wind_crystal_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        luminous_wind_crystal_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        luminous_wind_crystal_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        luminous_wind_crystal_pic.setOpaque(true);
        luminous_wind_crystal_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        luminous_wind_crystal_pic.setRequestFocusEnabled(false);

        luminous_wind_crystal_text.setText("Wind Crystal:");

        luminous_wind_crystal_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        luminous_wind_crystal_value.setForeground(new java.awt.Color(102, 0, 0));
        luminous_wind_crystal_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        luminous_wind_crystal_value.setText("00 / 03");
        luminous_wind_crystal_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        luminous_wind_crystal_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                luminous_wind_crystal_valueMousePressed(evt);
            }
        });

        luminous_lightning_crystal_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        luminous_lightning_crystal_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        luminous_lightning_crystal_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        luminous_lightning_crystal_pic.setOpaque(true);
        luminous_lightning_crystal_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        luminous_lightning_crystal_pic.setRequestFocusEnabled(false);

        luminous_lightning_crystal_text.setText("Lightning Crystal:");

        luminous_lightning_crystal_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        luminous_lightning_crystal_value.setForeground(new java.awt.Color(102, 0, 0));
        luminous_lightning_crystal_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        luminous_lightning_crystal_value.setText("00 / 03");
        luminous_lightning_crystal_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        luminous_lightning_crystal_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                luminous_lightning_crystal_valueMousePressed(evt);
            }
        });

        astral_nodule_pbar.setMaximum(9);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Acquire from: Azys Lla");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Acquire from: Sea of Clouds");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Acquire from: Churning Mists");

        astral_nodule_acquire_button.setText("Acquire Nodule");
        astral_nodule_acquire_button.setToolTipText("Will subtract 3 crystals from each of the above");
        astral_nodule_acquire_button.setEnabled(false);
        astral_nodule_acquire_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                astral_nodule_acquire_buttonMousePressed(evt);
            }
        });

        jLabel47.setText("Nodules:");

        astral_nodules_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        astral_nodules_value.setForeground(new java.awt.Color(102, 0, 0));
        astral_nodules_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        astral_nodules_value.setText("00");

        javax.swing.GroupLayout astral_nodule_panelLayout = new javax.swing.GroupLayout(astral_nodule_panel);
        astral_nodule_panel.setLayout(astral_nodule_panelLayout);
        astral_nodule_panelLayout.setHorizontalGroup(
            astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(astral_nodule_panelLayout.createSequentialGroup()
                .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(astral_nodule_pbar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(astral_nodule_panelLayout.createSequentialGroup()
                        .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(astral_nodule_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(astral_nodule_panelLayout.createSequentialGroup()
                                        .addComponent(luminous_fire_crystal_pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(astral_nodule_panelLayout.createSequentialGroup()
                                                .addComponent(luminous_fire_crystal_text, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(luminous_fire_crystal_value, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, astral_nodule_panelLayout.createSequentialGroup()
                                        .addComponent(luminous_wind_crystal_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(astral_nodule_panelLayout.createSequentialGroup()
                                                .addComponent(luminous_wind_crystal_text, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(luminous_wind_crystal_value, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(astral_nodule_panelLayout.createSequentialGroup()
                                        .addComponent(luminous_lightning_crystal_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(astral_nodule_panelLayout.createSequentialGroup()
                                                .addComponent(luminous_lightning_crystal_text)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(luminous_lightning_crystal_value, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(astral_nodule_panelLayout.createSequentialGroup()
                                .addComponent(astral_nodule_acquire_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(astral_nodules_value)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(147, 147, 147))
        );
        astral_nodule_panelLayout.setVerticalGroup(
            astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(astral_nodule_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(luminous_fire_crystal_text)
                        .addComponent(luminous_fire_crystal_value))
                    .addComponent(luminous_fire_crystal_pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(luminous_wind_crystal_text)
                        .addComponent(luminous_wind_crystal_value))
                    .addComponent(luminous_wind_crystal_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(luminous_lightning_crystal_text)
                        .addComponent(luminous_lightning_crystal_value))
                    .addComponent(luminous_lightning_crystal_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(astral_nodule_pbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(astral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(astral_nodule_acquire_button)
                    .addComponent(jLabel47)
                    .addComponent(astral_nodules_value))
                .addContainerGap())
        );

        umbral_nodule_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Umbral Nodule"));
        umbral_nodule_panel.setPreferredSize(new java.awt.Dimension(270, 300));

        luminous_ice_crystal_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        luminous_ice_crystal_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        luminous_ice_crystal_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        luminous_ice_crystal_pic.setOpaque(true);
        luminous_ice_crystal_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        luminous_ice_crystal_pic.setRequestFocusEnabled(false);

        luminous_earth_crystal_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        luminous_earth_crystal_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        luminous_earth_crystal_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        luminous_earth_crystal_pic.setOpaque(true);
        luminous_earth_crystal_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        luminous_earth_crystal_pic.setRequestFocusEnabled(false);

        luminous_water_crystal_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        luminous_water_crystal_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        luminous_water_crystal_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        luminous_water_crystal_pic.setOpaque(true);
        luminous_water_crystal_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        luminous_water_crystal_pic.setRequestFocusEnabled(false);

        luminous_water_crystal_text.setText("Water Crystal:");

        luminous_earth_crystal_text.setText("Earth Crystal:");

        luminous_ice_crystal_text.setText("Ice Crystal:");

        luminous_ice_crystal_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        luminous_ice_crystal_value.setForeground(new java.awt.Color(102, 0, 0));
        luminous_ice_crystal_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        luminous_ice_crystal_value.setText("00 / 03");
        luminous_ice_crystal_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        luminous_ice_crystal_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                luminous_ice_crystal_valueMousePressed(evt);
            }
        });

        luminous_earth_crystal_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        luminous_earth_crystal_value.setForeground(new java.awt.Color(102, 0, 0));
        luminous_earth_crystal_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        luminous_earth_crystal_value.setText("00 / 03");
        luminous_earth_crystal_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        luminous_earth_crystal_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                luminous_earth_crystal_valueMousePressed(evt);
            }
        });

        luminous_water_crystal_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        luminous_water_crystal_value.setForeground(new java.awt.Color(102, 0, 0));
        luminous_water_crystal_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        luminous_water_crystal_value.setText("00 / 03");
        luminous_water_crystal_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        luminous_water_crystal_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                luminous_water_crystal_valueMousePressed(evt);
            }
        });

        umbral_nodule_pbar.setMaximum(9);

        umbral_nodule_acquire_button.setText("Acquire Nodule");
        umbral_nodule_acquire_button.setToolTipText("Will subtract 3 crystals from each of the above");
        umbral_nodule_acquire_button.setEnabled(false);
        umbral_nodule_acquire_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                umbral_nodule_acquire_buttonMousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Acquire from:Coerthas Western Highlands");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setText("Acquire from: Dravanian Forelands");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("Acquire from: Dravanian Hinterlands");

        jLabel48.setText("Nodules:");

        umbral_nodules_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        umbral_nodules_value.setForeground(new java.awt.Color(102, 0, 0));
        umbral_nodules_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        umbral_nodules_value.setText("00");

        javax.swing.GroupLayout umbral_nodule_panelLayout = new javax.swing.GroupLayout(umbral_nodule_panel);
        umbral_nodule_panel.setLayout(umbral_nodule_panelLayout);
        umbral_nodule_panelLayout.setHorizontalGroup(
            umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(umbral_nodule_pbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(umbral_nodule_panelLayout.createSequentialGroup()
                .addGroup(umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(umbral_nodule_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(umbral_nodule_panelLayout.createSequentialGroup()
                                .addComponent(luminous_water_crystal_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(luminous_water_crystal_text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(luminous_water_crystal_value, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, umbral_nodule_panelLayout.createSequentialGroup()
                                .addComponent(luminous_earth_crystal_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(luminous_earth_crystal_text, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(luminous_earth_crystal_value, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(umbral_nodule_panelLayout.createSequentialGroup()
                                .addComponent(luminous_ice_crystal_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(umbral_nodule_panelLayout.createSequentialGroup()
                                        .addComponent(luminous_ice_crystal_text, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(luminous_ice_crystal_value, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 7, Short.MAX_VALUE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(umbral_nodule_panelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(umbral_nodule_panelLayout.createSequentialGroup()
                        .addComponent(umbral_nodule_acquire_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(umbral_nodules_value)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        umbral_nodule_panelLayout.setVerticalGroup(
            umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(umbral_nodule_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(luminous_ice_crystal_text)
                        .addComponent(luminous_ice_crystal_value))
                    .addComponent(luminous_ice_crystal_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(luminous_earth_crystal_text)
                        .addComponent(luminous_earth_crystal_value))
                    .addComponent(luminous_earth_crystal_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(luminous_water_crystal_text)
                        .addComponent(luminous_water_crystal_value))
                    .addComponent(luminous_water_crystal_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(umbral_nodule_pbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(umbral_nodule_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(umbral_nodule_acquire_button)
                    .addComponent(jLabel48)
                    .addComponent(umbral_nodules_value))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        stage1CompleteButton.setText("Complete Stage 1");
        stage1CompleteButton.setEnabled(false);
        stage1CompleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage1CompleteButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(stage1CompleteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(astral_nodule_panel, 262, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(umbral_nodule_panel, 261, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 16, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(umbral_nodule_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(astral_nodule_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stage1CompleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs_stages.addTab("Stage 1", jPanel3);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Toughening Up");

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Dungeons Checklist"));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setText("1.");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setText("2.");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setText("3.");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel40.setText("4.");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setText("5.");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel42.setText("6.");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel43.setText("7.");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setText("8.");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel45.setText("9.");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel46.setText("10.");

        stage2_stage01.setBackground(new java.awt.Color(204, 204, 204));
        stage2_stage01.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stage2_stage01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stage2_stage01.setText("Snowcloack");
        stage2_stage01.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stage2_stage01.setOpaque(true);
        stage2_stage01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage2_stage01MousePressed(evt);
            }
        });

        stage2_stage02.setBackground(new java.awt.Color(204, 204, 204));
        stage2_stage02.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stage2_stage02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stage2_stage02.setText("Sastasha (Hard)");
        stage2_stage02.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stage2_stage02.setOpaque(true);
        stage2_stage02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage2_stage02MousePressed(evt);
            }
        });

        stage2_stage03.setBackground(new java.awt.Color(204, 204, 204));
        stage2_stage03.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stage2_stage03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stage2_stage03.setText("The Temple of Qarn (Hard)");
        stage2_stage03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stage2_stage03.setOpaque(true);
        stage2_stage03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage2_stage03MousePressed(evt);
            }
        });

        stage2_stage04.setBackground(new java.awt.Color(204, 204, 204));
        stage2_stage04.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stage2_stage04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stage2_stage04.setText("Keeper of the Lake");
        stage2_stage04.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stage2_stage04.setOpaque(true);
        stage2_stage04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage2_stage04MousePressed(evt);
            }
        });

        stage2_stage05.setBackground(new java.awt.Color(204, 204, 204));
        stage2_stage05.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stage2_stage05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stage2_stage05.setText("Wanderer's Palace (Hard)");
        stage2_stage05.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stage2_stage05.setOpaque(true);
        stage2_stage05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage2_stage05MousePressed(evt);
            }
        });

        stage2_stage06.setBackground(new java.awt.Color(204, 204, 204));
        stage2_stage06.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stage2_stage06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stage2_stage06.setText("Amdapor Keep (Hard)");
        stage2_stage06.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stage2_stage06.setOpaque(true);
        stage2_stage06.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage2_stage06MousePressed(evt);
            }
        });

        stage2_stage07.setBackground(new java.awt.Color(204, 204, 204));
        stage2_stage07.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stage2_stage07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stage2_stage07.setText("Dusk Vigil");
        stage2_stage07.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stage2_stage07.setOpaque(true);
        stage2_stage07.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage2_stage07MousePressed(evt);
            }
        });

        stage2_stage08.setBackground(new java.awt.Color(204, 204, 204));
        stage2_stage08.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stage2_stage08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stage2_stage08.setText("Sohm Al");
        stage2_stage08.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stage2_stage08.setOpaque(true);
        stage2_stage08.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage2_stage08MousePressed(evt);
            }
        });

        stage2_stage09.setBackground(new java.awt.Color(204, 204, 204));
        stage2_stage09.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stage2_stage09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stage2_stage09.setText("The Aery");
        stage2_stage09.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stage2_stage09.setOpaque(true);
        stage2_stage09.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage2_stage09MousePressed(evt);
            }
        });

        stage2_stage10.setBackground(new java.awt.Color(204, 204, 204));
        stage2_stage10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stage2_stage10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stage2_stage10.setText("The Vault");
        stage2_stage10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stage2_stage10.setOpaque(true);
        stage2_stage10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage2_stage10MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stage2_stage03, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addComponent(stage2_stage02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stage2_stage04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stage2_stage05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stage2_stage06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stage2_stage07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stage2_stage08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stage2_stage09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stage2_stage10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stage2_stage01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(stage2_stage01))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(stage2_stage02))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(stage2_stage03))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(stage2_stage04))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(stage2_stage05))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(stage2_stage06))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(stage2_stage07))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(stage2_stage08))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(stage2_stage09))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(stage2_stage10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        stage2_pbar.setMaximum(10);

        stage2CompleteButton.setText("Next Stage");
        stage2CompleteButton.setEnabled(false);
        stage2CompleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stage2CompleteButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(stage2_pbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(stage2CompleteButton)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stage2_pbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stage2CompleteButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs_stages.addTab("Stage 2", jPanel4);

        jPanel5.setMaximumSize(new java.awt.Dimension(520, 420));
        jPanel5.setPreferredSize(new java.awt.Dimension(520, 420));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Enchanted Rubber"));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(220, 102));

        unidentifiable_bone_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unidentifiable_bone_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        unidentifiable_bone_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        unidentifiable_bone_pic.setOpaque(true);
        unidentifiable_bone_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        unidentifiable_bone_pic.setRequestFocusEnabled(false);

        u_bone_text.setText("Unidentifiable Bones:");

        ubone_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ubone_value.setForeground(new java.awt.Color(102, 0, 0));
        ubone_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ubone_value.setText("00 / 10");
        ubone_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ubone_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ubone_valueMousePressed(evt);
            }
        });

        adamantite_francesca_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adamantite_francesca_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        adamantite_francesca_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        adamantite_francesca_pic.setOpaque(true);
        adamantite_francesca_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        adamantite_francesca_pic.setRequestFocusEnabled(false);

        adamantite_francesca_text.setText("Adamantite Francesca:");

        adamantite_francesca_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        adamantite_francesca_value.setForeground(new java.awt.Color(102, 0, 0));
        adamantite_francesca_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        adamantite_francesca_value.setText("00 / 04");
        adamantite_francesca_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adamantite_francesca_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adamantite_francesca_valueMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(unidentifiable_bone_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(u_bone_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ubone_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(adamantite_francesca_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adamantite_francesca_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adamantite_francesca_value, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(unidentifiable_bone_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(u_bone_text)
                        .addComponent(ubone_value)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adamantite_francesca_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adamantite_francesca_text)
                        .addComponent(adamantite_francesca_value)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Divine Water"));
        jPanel2.setPreferredSize(new java.awt.Dimension(220, 95));

        dispelling_arrow_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dispelling_arrow_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        dispelling_arrow_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        dispelling_arrow_pic.setOpaque(true);
        dispelling_arrow_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        dispelling_arrow_pic.setRequestFocusEnabled(false);

        dispelling_arrow_text.setText("Dispelling Arrow:");

        dispelling_arrow_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dispelling_arrow_value.setForeground(new java.awt.Color(102, 0, 0));
        dispelling_arrow_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dispelling_arrow_value.setText("00 / 04");
        dispelling_arrow_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dispelling_arrow_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dispelling_arrow_valueMousePressed(evt);
            }
        });

        unidentifiable_ore_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unidentifiable_ore_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        unidentifiable_ore_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        unidentifiable_ore_pic.setOpaque(true);
        unidentifiable_ore_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        unidentifiable_ore_pic.setRequestFocusEnabled(false);

        u_ore_text.setText("Unidentifiable Ores:");

        uore_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        uore_value.setForeground(new java.awt.Color(102, 0, 0));
        uore_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        uore_value.setText("00 / 10");
        uore_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uore_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                uore_valueMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(dispelling_arrow_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dispelling_arrow_text)
                .addGap(18, 18, 18)
                .addComponent(dispelling_arrow_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(unidentifiable_ore_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(u_ore_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uore_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(u_ore_text)
                        .addComponent(uore_value))
                    .addComponent(unidentifiable_ore_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dispelling_arrow_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dispelling_arrow_text)
                        .addComponent(dispelling_arrow_value)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Coming into its Own");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fast-Drying Carboncoat"));
        jPanel8.setPreferredSize(new java.awt.Dimension(260, 102));

        unidentifiable_shell_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unidentifiable_shell_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        unidentifiable_shell_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        unidentifiable_shell_pic.setOpaque(true);
        unidentifiable_shell_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        unidentifiable_shell_pic.setRequestFocusEnabled(false);

        u_shell_text.setText("Unidentifiable Shells:");

        ushell_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ushell_value.setForeground(new java.awt.Color(102, 0, 0));
        ushell_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ushell_value.setText("00 / 10");
        ushell_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ushell_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ushell_valueMousePressed(evt);
            }
        });

        titanium_alloy_mirror_text.setText("Titanium Alloy Mirror:");

        titanium_alloy_mirror_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titanium_alloy_mirror_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        titanium_alloy_mirror_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        titanium_alloy_mirror_pic.setOpaque(true);
        titanium_alloy_mirror_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        titanium_alloy_mirror_pic.setRequestFocusEnabled(false);

        titanium_alloy_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        titanium_alloy_value.setForeground(new java.awt.Color(102, 0, 0));
        titanium_alloy_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        titanium_alloy_value.setText("00 / 04");
        titanium_alloy_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        titanium_alloy_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titanium_alloy_valueMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(unidentifiable_shell_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(u_shell_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ushell_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(titanium_alloy_mirror_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titanium_alloy_mirror_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titanium_alloy_value, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(unidentifiable_shell_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(u_shell_text)
                        .addComponent(ushell_value)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titanium_alloy_mirror_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(titanium_alloy_mirror_text)
                        .addComponent(titanium_alloy_value))))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fast-acting Allagan Catalyst"));
        jPanel9.setPreferredSize(new java.awt.Dimension(260, 102));

        unidentifiable_seed_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unidentifiable_seed_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        unidentifiable_seed_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        unidentifiable_seed_pic.setOpaque(true);
        unidentifiable_seed_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        unidentifiable_seed_pic.setRequestFocusEnabled(false);

        u_seed_text.setText("Unidentifiable Seeds:");

        useed_value.setBackground(new java.awt.Color(255, 255, 255));
        useed_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        useed_value.setForeground(new java.awt.Color(102, 0, 0));
        useed_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        useed_value.setText("00 / 10");
        useed_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        useed_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                useed_valueMousePressed(evt);
            }
        });

        kingcake_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kingcake_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        kingcake_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        kingcake_pic.setOpaque(true);
        kingcake_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        kingcake_pic.setRequestFocusEnabled(false);

        kingcake_text.setText("Kingcake:");

        kingcake_value.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        kingcake_value.setForeground(new java.awt.Color(102, 0, 0));
        kingcake_value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        kingcake_value.setText("00 / 04");
        kingcake_value.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kingcake_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kingcake_valueMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(unidentifiable_seed_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(u_seed_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(useed_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(kingcake_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kingcake_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kingcake_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(unidentifiable_seed_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(u_seed_text)
                        .addComponent(useed_value)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kingcake_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kingcake_text)
                        .addComponent(kingcake_value))))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fast_drying_carboncoat_pbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enchanted_rubber_pbar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(fast_acting_allagan_catalyst_pbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(divine_water_pbar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enchanted_rubber_pbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fast_drying_carboncoat_pbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fast_acting_allagan_catalyst_pbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20))
                                .addComponent(divine_water_pbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20))))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        tabs_stages.addTab("Stage 3", jPanel5);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Finding Your Voice");

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Aether Oils"));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 427, Short.MAX_VALUE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        tabs_stages.addTab("Stage 4", jPanel6);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("A Dream Fulfilled");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(447, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(384, Short.MAX_VALUE))
        );

        tabs_stages.addTab("Stage 5", jPanel7);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Tomestones / Seals"));

        poetic_tomestones_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poetic_tomestones_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic.setOpaque(true);
        poetic_tomestones_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic.setRequestFocusEnabled(false);

        jLabel10.setText("Poetics:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("510");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        esoterics_tomestones_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        esoterics_tomestones_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        esoterics_tomestones_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        esoterics_tomestones_pic.setOpaque(true);
        esoterics_tomestones_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        esoterics_tomestones_pic.setRequestFocusEnabled(false);

        jLabel12.setText("Esoterics:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("120");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lore_tomestones_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lore_tomestones_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        lore_tomestones_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        lore_tomestones_pic.setOpaque(true);
        lore_tomestones_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        lore_tomestones_pic.setRequestFocusEnabled(false);

        jLabel14.setText("Lore:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(120, 0, 2000, 1));

        allied_seals_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        allied_seals_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        allied_seals_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        allied_seals_pic.setOpaque(true);
        allied_seals_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        allied_seals_pic.setRequestFocusEnabled(false);

        centurio_seals_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        centurio_seals_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        centurio_seals_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        centurio_seals_pic.setOpaque(true);
        centurio_seals_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        centurio_seals_pic.setRequestFocusEnabled(false);

        jLabel15.setText("Allied Seals:");

        jLabel30.setText("Centurio Seals:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 0, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel31.setText("120");
        jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 0, 0));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel32.setText("120");
        jLabel32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(poetic_tomestones_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(esoterics_tomestones_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(lore_tomestones_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner1)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(centurio_seals_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(allied_seals_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addComponent(poetic_tomestones_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(esoterics_tomestones_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lore_tomestones_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(allied_seals_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(centurio_seals_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jLabel32)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Beast Tribe Tokens"));

        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        steel_amaljok_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        steel_amaljok_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        steel_amaljok_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        steel_amaljok_pic.setOpaque(true);
        steel_amaljok_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        steel_amaljok_pic.setRequestFocusEnabled(false);

        jLabel16.setText("Amalj'aa:");

        sylphic_goldleaf_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sylphic_goldleaf_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        sylphic_goldleaf_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        sylphic_goldleaf_pic.setOpaque(true);
        sylphic_goldleaf_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        sylphic_goldleaf_pic.setRequestFocusEnabled(false);

        jLabel17.setText("Sylphs:");

        titan_cobaltpiece_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titan_cobaltpiece_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        titan_cobaltpiece_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        titan_cobaltpiece_pic.setOpaque(true);
        titan_cobaltpiece_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        titan_cobaltpiece_pic.setRequestFocusEnabled(false);

        jLabel18.setText("Kobolds:");

        rainbowtide_psashp_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rainbowtide_psashp_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        rainbowtide_psashp_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        rainbowtide_psashp_pic.setOpaque(true);
        rainbowtide_psashp_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        rainbowtide_psashp_pic.setRequestFocusEnabled(false);

        jLabel19.setText("Sahagin:");

        ixali_oaknot_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ixali_oaknot_pic.setMaximumSize(new java.awt.Dimension(32, 32));
        ixali_oaknot_pic.setMinimumSize(new java.awt.Dimension(32, 32));
        ixali_oaknot_pic.setOpaque(true);
        ixali_oaknot_pic.setPreferredSize(new java.awt.Dimension(32, 32));
        ixali_oaknot_pic.setRequestFocusEnabled(false);

        jLabel20.setText("Ixal:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel25.setText("10");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel26.setText("10");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel27.setText("10");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel28.setText("10");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 0, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel29.setText("10");
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(ixali_oaknot_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(steel_amaljok_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(sylphic_goldleaf_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                .addComponent(rainbowtide_psashp_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                .addComponent(titan_cobaltpiece_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel25))
                    .addComponent(steel_amaljok_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sylphic_goldleaf_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titan_cobaltpiece_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rainbowtide_psashp_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(jLabel28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel29))
                    .addComponent(ixali_oaknot_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("A Realm Reborn", jPanel13);

        poetic_tomestones_pic8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poetic_tomestones_pic8.setMaximumSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic8.setMinimumSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic8.setOpaque(true);
        poetic_tomestones_pic8.setPreferredSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic8.setRequestFocusEnabled(false);

        jLabel21.setText("Vath:");

        poetic_tomestones_pic9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poetic_tomestones_pic9.setMaximumSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic9.setMinimumSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic9.setOpaque(true);
        poetic_tomestones_pic9.setPreferredSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic9.setRequestFocusEnabled(false);

        jLabel22.setText("Vanu Vanu:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel23.setText("10");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel24.setText("14");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        poetic_tomestones_pic10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poetic_tomestones_pic10.setMaximumSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic10.setMinimumSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic10.setOpaque(true);
        poetic_tomestones_pic10.setPreferredSize(new java.awt.Dimension(32, 32));
        poetic_tomestones_pic10.setRequestFocusEnabled(false);

        jLabel33.setText("Moogle:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel34.setText("14");
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(poetic_tomestones_pic8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(poetic_tomestones_pic9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(poetic_tomestones_pic10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel23))
                    .addComponent(poetic_tomestones_pic8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(poetic_tomestones_pic9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(jLabel24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(poetic_tomestones_pic10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(jLabel34)))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Heavensward", jPanel14);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
        );

        jCheckBox1.setText("Notify when able to purchase");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)))
                .addContainerGap())
        );

        tabs_stages.addTab("Tokens", jPanel10);

        stage_selector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        stage_selector.setToolTipText("Select which tab to save at");
        stage_selector.setEnabled(false);

        testButton.setText("TestButton");
        testButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                testButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabs_stages, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clear_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(testButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status_text, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stage_selector, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(load_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save_button)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs_stages, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_button)
                    .addComponent(clear_button)
                    .addComponent(load_button)
                    .addComponent(status_text)
                    .addComponent(stage_selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(testButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMousePressed
        allValues = new ArrayList<>();
        
        //load values into Iterator i
        getAllValues();
        Iterator i = allValues.iterator();
        
        collection = new Collection((int)i.next());
        
        collection.saveStage01(
                (int)i.next(),(int)i.next(),(int)i.next(),
                (int)i.next(),(int)i.next(),(int)i.next(),
                (int)i.next(),(int)i.next());
        
        collection.saveStage02(
                (int)i.next(), (int)i.next(), 
                (int)i.next(), (int)i.next(), 
                (int)i.next(), (int)i.next(), 
                (int)i.next(), (int)i.next(), 
                (int)i.next(), (int)i.next());
        
        collection.saveStage03(
                (int)i.next(), (int)i.next(), (int)i.next(), (int)i.next(), 
                (int)i.next(), (int)i.next(), (int)i.next(), (int)i.next());
        
        collection.SaveData();
        
        status_text.setText("saved...");
        status_reset(); //starts new thread, sleeps for a second, and wipes status message
    }//GEN-LAST:event_save_buttonMousePressed

    private void load_buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_load_buttonMousePressed
        load_saved_data();
        
        status_text.setText("loaded...");
        status_reset();
    }//GEN-LAST:event_load_buttonMousePressed

    private void clear_buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_buttonMousePressed
        luminous_fire_crystal_value.setText("00 / 03");
        luminous_wind_crystal_value.setText("00 / 03");
        luminous_lightning_crystal_value.setText("00 / 03");
        luminous_ice_crystal_value.setText("00 / 03");
        luminous_earth_crystal_value.setText("00 / 03");
        luminous_water_crystal_value.setText("00 / 03");
        
        astral_nodules_value.setText("00");
        umbral_nodules_value.setText("00");
        
        clearStage2Progress(stage2_pbar);
        
        ubone_value.setText("00 / 10");
        uore_value.setText("00 / 10");
        useed_value.setText("00 / 10");
        ushell_value.setText("00 / 10");
        adamantite_francesca_value.setText("00 / 04");
        dispelling_arrow_value.setText("00 / 04");
        titanium_alloy_value.setText("00 / 04");
        kingcake_value.setText("00 / 04");
        
        
        
        updateAllProgressBars();
    }//GEN-LAST:event_clear_buttonMousePressed

    private void luminous_fire_crystal_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_luminous_fire_crystal_valueMousePressed
        int mouseButton = evt.getButton();
        String value = luminous_fire_crystal_value.getText();
        luminous_fire_crystal_value.setText(changeValue(value, mouseButton, 2, 99));
        // set progress bar
        progressbar_change_stage1(astral_nodule_pbar, luminous_fire_crystal_value, luminous_wind_crystal_value, luminous_lightning_crystal_value, astral_nodule_acquire_button);
    }//GEN-LAST:event_luminous_fire_crystal_valueMousePressed

    private void luminous_wind_crystal_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_luminous_wind_crystal_valueMousePressed
        int mouseButton = evt.getButton();
        String value = luminous_wind_crystal_value.getText();
        luminous_wind_crystal_value.setText(changeValue(value, mouseButton, 2, 99));
        // set progress bar
        progressbar_change_stage1(astral_nodule_pbar, luminous_fire_crystal_value, luminous_wind_crystal_value, luminous_lightning_crystal_value, astral_nodule_acquire_button);
    }//GEN-LAST:event_luminous_wind_crystal_valueMousePressed

    private void luminous_lightning_crystal_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_luminous_lightning_crystal_valueMousePressed
        int mouseButton = evt.getButton();
        String value = luminous_lightning_crystal_value.getText();
        luminous_lightning_crystal_value.setText(changeValue(value, mouseButton, 2, 99));
        // set progress bar
        progressbar_change_stage1(astral_nodule_pbar, luminous_fire_crystal_value, luminous_wind_crystal_value, luminous_lightning_crystal_value, astral_nodule_acquire_button);
    }//GEN-LAST:event_luminous_lightning_crystal_valueMousePressed

    private void luminous_ice_crystal_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_luminous_ice_crystal_valueMousePressed
        int mouseButton = evt.getButton();
        String value = luminous_ice_crystal_value.getText();
        luminous_ice_crystal_value.setText(changeValue(value, mouseButton, 2, 99));
        // set progress bar
        progressbar_change_stage1(umbral_nodule_pbar, luminous_ice_crystal_value, luminous_earth_crystal_value, luminous_water_crystal_value, umbral_nodule_acquire_button);
    }//GEN-LAST:event_luminous_ice_crystal_valueMousePressed

    private void luminous_earth_crystal_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_luminous_earth_crystal_valueMousePressed
        int mouseButton = evt.getButton();
        String value = luminous_earth_crystal_value.getText();
        luminous_earth_crystal_value.setText(changeValue(value, mouseButton, 2, 99));
        // set progress bar
        progressbar_change_stage1(umbral_nodule_pbar, luminous_ice_crystal_value, luminous_earth_crystal_value, luminous_water_crystal_value, umbral_nodule_acquire_button);
    }//GEN-LAST:event_luminous_earth_crystal_valueMousePressed

    private void luminous_water_crystal_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_luminous_water_crystal_valueMousePressed
        int mouseButton = evt.getButton();
        String value = luminous_water_crystal_value.getText();
        luminous_water_crystal_value.setText(changeValue(value, mouseButton, 2, 99));
        // set progress bar
        progressbar_change_stage1(umbral_nodule_pbar, luminous_ice_crystal_value, luminous_earth_crystal_value, luminous_water_crystal_value, umbral_nodule_acquire_button);
    }//GEN-LAST:event_luminous_water_crystal_valueMousePressed

    private void kingcake_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kingcake_valueMousePressed
        int mouseButton = evt.getButton();
        String value = kingcake_value.getText();
        kingcake_value.setText(changeValue(value, mouseButton, 2, 99));
        progressbar_change_stage3(fast_acting_allagan_catalyst_pbar, useed_value, kingcake_value);
    }//GEN-LAST:event_kingcake_valueMousePressed

    private void useed_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_useed_valueMousePressed
        int mouseButton = evt.getButton();
        String value = useed_value.getText();
        useed_value.setText(changeValue(value, mouseButton, 2, 99));
        progressbar_change_stage3(fast_acting_allagan_catalyst_pbar, useed_value, kingcake_value);
    }//GEN-LAST:event_useed_valueMousePressed

    private void titanium_alloy_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titanium_alloy_valueMousePressed
        int mouseButton = evt.getButton();
        String value = titanium_alloy_value.getText();
        titanium_alloy_value.setText(changeValue(value, mouseButton, 2, 99));
        progressbar_change_stage3(fast_drying_carboncoat_pbar, ushell_value, titanium_alloy_value);
    }//GEN-LAST:event_titanium_alloy_valueMousePressed

    private void ushell_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ushell_valueMousePressed
        int mouseButton = evt.getButton();
        String value = ushell_value.getText();
        ushell_value.setText(changeValue(value, mouseButton, 2, 99));
        progressbar_change_stage3(fast_drying_carboncoat_pbar, ushell_value, titanium_alloy_value);
    }//GEN-LAST:event_ushell_valueMousePressed

    private void uore_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uore_valueMousePressed
        int mouseButton = evt.getButton();
        String value = uore_value.getText();
        uore_value.setText(changeValue(value, mouseButton, 2, 99));
        progressbar_change_stage3(divine_water_pbar, uore_value, dispelling_arrow_value);
    }//GEN-LAST:event_uore_valueMousePressed

    private void dispelling_arrow_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dispelling_arrow_valueMousePressed
        int mouseButton = evt.getButton();
        String value = dispelling_arrow_value.getText();
        dispelling_arrow_value.setText(changeValue(value, mouseButton, 2, 99));
        progressbar_change_stage3(divine_water_pbar, uore_value, dispelling_arrow_value);
    }//GEN-LAST:event_dispelling_arrow_valueMousePressed

    private void adamantite_francesca_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adamantite_francesca_valueMousePressed
        int mouseButton = evt.getButton();
        String value = adamantite_francesca_value.getText();
        adamantite_francesca_value.setText(changeValue(value, mouseButton, 2, 99));
        progressbar_change_stage3(enchanted_rubber_pbar, ubone_value, adamantite_francesca_value);
    }//GEN-LAST:event_adamantite_francesca_valueMousePressed

    private void ubone_valueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubone_valueMousePressed
        int mouseButton = evt.getButton();
        String value = ubone_value.getText();
        ubone_value.setText(changeValue(value, mouseButton, 2, 99));
        // set progress bar
        progressbar_change_stage3(enchanted_rubber_pbar, ubone_value, adamantite_francesca_value);
    }//GEN-LAST:event_ubone_valueMousePressed

    private void stage2_stage01MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage2_stage01MousePressed
        stage2ChangeStatus(stage2_stage01);
    }//GEN-LAST:event_stage2_stage01MousePressed

    private void stage2_stage02MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage2_stage02MousePressed
        stage2ChangeStatus(stage2_stage02);
    }//GEN-LAST:event_stage2_stage02MousePressed

    private void stage2_stage03MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage2_stage03MousePressed
        stage2ChangeStatus(stage2_stage03);
    }//GEN-LAST:event_stage2_stage03MousePressed

    private void stage2_stage04MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage2_stage04MousePressed
        stage2ChangeStatus(stage2_stage04);
    }//GEN-LAST:event_stage2_stage04MousePressed

    private void stage2_stage05MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage2_stage05MousePressed
        stage2ChangeStatus(stage2_stage05);
    }//GEN-LAST:event_stage2_stage05MousePressed

    private void stage2_stage06MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage2_stage06MousePressed
        stage2ChangeStatus(stage2_stage06);
    }//GEN-LAST:event_stage2_stage06MousePressed

    private void stage2_stage07MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage2_stage07MousePressed
        stage2ChangeStatus(stage2_stage07);
    }//GEN-LAST:event_stage2_stage07MousePressed

    private void stage2_stage08MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage2_stage08MousePressed
        stage2ChangeStatus(stage2_stage08);
    }//GEN-LAST:event_stage2_stage08MousePressed

    private void stage2_stage09MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage2_stage09MousePressed
        stage2ChangeStatus(stage2_stage09);
    }//GEN-LAST:event_stage2_stage09MousePressed

    private void stage2_stage10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage2_stage10MousePressed
        stage2ChangeStatus(stage2_stage10);
    }//GEN-LAST:event_stage2_stage10MousePressed

    private void astral_nodule_acquire_buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_astral_nodule_acquire_buttonMousePressed
        if (astral_nodule_acquire_button.isEnabled()){
            acquiredNodule(luminous_fire_crystal_value, luminous_wind_crystal_value, luminous_lightning_crystal_value, astral_nodules_value);
            progressbar_change_stage1(astral_nodule_pbar, luminous_fire_crystal_value, luminous_wind_crystal_value, luminous_lightning_crystal_value, astral_nodule_acquire_button);   
            checkNodules(astral_nodules_value,umbral_nodules_value);
        }
    }//GEN-LAST:event_astral_nodule_acquire_buttonMousePressed

    private void umbral_nodule_acquire_buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_umbral_nodule_acquire_buttonMousePressed
        if (umbral_nodule_acquire_button.isEnabled()){
            acquiredNodule(luminous_ice_crystal_value, luminous_earth_crystal_value, luminous_water_crystal_value, umbral_nodules_value);
            progressbar_change_stage1(umbral_nodule_pbar, luminous_ice_crystal_value, luminous_earth_crystal_value, luminous_water_crystal_value, umbral_nodule_acquire_button);
            checkNodules(astral_nodules_value,umbral_nodules_value);
        }
    }//GEN-LAST:event_umbral_nodule_acquire_buttonMousePressed

    private void stage2CompleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage2CompleteButtonMousePressed
        if (stage2CompleteButton.isEnabled()){
            tabs_stages.setSelectedIndex(2);
            clearStage2Progress(stage2_pbar);
            stage2CompleteButton.setEnabled(false);
        }
    }//GEN-LAST:event_stage2CompleteButtonMousePressed

    private void tabs_stagesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabs_stagesMousePressed
        stage_selector.setSelectedIndex(tabs_stages.getSelectedIndex());
    }//GEN-LAST:event_tabs_stagesMousePressed

    private void testButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testButtonMousePressed
        // this is just a System.out.println test, to test for values
    }//GEN-LAST:event_testButtonMousePressed

    private void stage1CompleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stage1CompleteButtonMousePressed
        if(stage1CompleteButton.isEnabled()){
            consumeNodules(astral_nodules_value,umbral_nodules_value);
            checkNodules(astral_nodules_value,umbral_nodules_value);
        }
    }//GEN-LAST:event_stage1CompleteButtonMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adamantite_francesca_pic;
    private javax.swing.JLabel adamantite_francesca_text;
    private javax.swing.JLabel adamantite_francesca_value;
    private javax.swing.JLabel allied_seals_pic;
    private javax.swing.JButton astral_nodule_acquire_button;
    private javax.swing.JPanel astral_nodule_panel;
    private javax.swing.JProgressBar astral_nodule_pbar;
    private javax.swing.JLabel astral_nodules_value;
    private javax.swing.JLabel centurio_seals_pic;
    private javax.swing.JButton clear_button;
    private javax.swing.JLabel dispelling_arrow_pic;
    private javax.swing.JLabel dispelling_arrow_text;
    private javax.swing.JLabel dispelling_arrow_value;
    private javax.swing.JProgressBar divine_water_pbar;
    private javax.swing.JProgressBar enchanted_rubber_pbar;
    private javax.swing.JLabel esoterics_tomestones_pic;
    private javax.swing.JProgressBar fast_acting_allagan_catalyst_pbar;
    private javax.swing.JProgressBar fast_drying_carboncoat_pbar;
    private javax.swing.JLabel ixali_oaknot_pic;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel kingcake_pic;
    private javax.swing.JLabel kingcake_text;
    private javax.swing.JLabel kingcake_value;
    private javax.swing.JButton load_button;
    private javax.swing.JLabel lore_tomestones_pic;
    private javax.swing.JLabel luminous_earth_crystal_pic;
    private javax.swing.JLabel luminous_earth_crystal_text;
    private javax.swing.JLabel luminous_earth_crystal_value;
    private javax.swing.JLabel luminous_fire_crystal_pic;
    private javax.swing.JLabel luminous_fire_crystal_text;
    private javax.swing.JLabel luminous_fire_crystal_value;
    private javax.swing.JLabel luminous_ice_crystal_pic;
    private javax.swing.JLabel luminous_ice_crystal_text;
    private javax.swing.JLabel luminous_ice_crystal_value;
    private javax.swing.JLabel luminous_lightning_crystal_pic;
    private javax.swing.JLabel luminous_lightning_crystal_text;
    private javax.swing.JLabel luminous_lightning_crystal_value;
    private javax.swing.JLabel luminous_water_crystal_pic;
    private javax.swing.JLabel luminous_water_crystal_text;
    private javax.swing.JLabel luminous_water_crystal_value;
    private javax.swing.JLabel luminous_wind_crystal_pic;
    private javax.swing.JLabel luminous_wind_crystal_text;
    private javax.swing.JLabel luminous_wind_crystal_value;
    private javax.swing.JLabel poetic_tomestones_pic;
    private javax.swing.JLabel poetic_tomestones_pic10;
    private javax.swing.JLabel poetic_tomestones_pic8;
    private javax.swing.JLabel poetic_tomestones_pic9;
    private javax.swing.JLabel rainbowtide_psashp_pic;
    private javax.swing.JButton save_button;
    private javax.swing.JButton stage1CompleteButton;
    private javax.swing.JButton stage2CompleteButton;
    private javax.swing.JProgressBar stage2_pbar;
    private javax.swing.JLabel stage2_stage01;
    private javax.swing.JLabel stage2_stage02;
    private javax.swing.JLabel stage2_stage03;
    private javax.swing.JLabel stage2_stage04;
    private javax.swing.JLabel stage2_stage05;
    private javax.swing.JLabel stage2_stage06;
    private javax.swing.JLabel stage2_stage07;
    private javax.swing.JLabel stage2_stage08;
    private javax.swing.JLabel stage2_stage09;
    private javax.swing.JLabel stage2_stage10;
    private javax.swing.JComboBox<String> stage_selector;
    private javax.swing.JLabel status_text;
    private javax.swing.JLabel steel_amaljok_pic;
    private javax.swing.JLabel sylphic_goldleaf_pic;
    private javax.swing.JTabbedPane tabs_stages;
    private javax.swing.JButton testButton;
    private javax.swing.JLabel titan_cobaltpiece_pic;
    private javax.swing.JLabel titanium_alloy_mirror_pic;
    private javax.swing.JLabel titanium_alloy_mirror_text;
    private javax.swing.JLabel titanium_alloy_value;
    private javax.swing.JLabel u_bone_text;
    private javax.swing.JLabel u_ore_text;
    private javax.swing.JLabel u_seed_text;
    private javax.swing.JLabel u_shell_text;
    private javax.swing.JLabel ubone_value;
    private javax.swing.JButton umbral_nodule_acquire_button;
    private javax.swing.JPanel umbral_nodule_panel;
    private javax.swing.JProgressBar umbral_nodule_pbar;
    private javax.swing.JLabel umbral_nodules_value;
    private javax.swing.JLabel unidentifiable_bone_pic;
    private javax.swing.JLabel unidentifiable_ore_pic;
    private javax.swing.JLabel unidentifiable_seed_pic;
    private javax.swing.JLabel unidentifiable_shell_pic;
    private javax.swing.JLabel uore_value;
    private javax.swing.JLabel useed_value;
    private javax.swing.JLabel ushell_value;
    // End of variables declaration//GEN-END:variables

    //digits not used anymore, needs refactoring
    private String changeValue(String inputString, int mouseButton, int digits, int limit) {
        Integer int_value = Integer.valueOf(inputString.substring(0,digits));
        
        // checks which buttons was pressed
        switch(mouseButton){
            case 1:
                if (int_value < limit){
                    int_value++;
                }
                break;
            case 3:
                if (int_value > 0){
                    int_value--;
                }
                break;
            default:
                break;
        }
        
        String formattedVal;
        
        if (digits>1){
            formattedVal = String.format("%02d",int_value);
        } else {
            formattedVal = String.format("%1d",int_value); //not used anymore
        }
        
        return formattedVal+inputString.substring(digits);
    }

    private void setStage1Values(){
        Iterator i = collection.returnStage1Values();
        String value;
        
        value = luminous_fire_crystal_value.getText().substring(2);
        luminous_fire_crystal_value.setText(returnValue((int)i.next(),2)+value);
        value = luminous_wind_crystal_value.getText().substring(2);
        luminous_wind_crystal_value.setText(returnValue((int)i.next(),2)+value);
        value = luminous_lightning_crystal_value.getText().substring(2);
        luminous_lightning_crystal_value.setText(returnValue((int)i.next(),2)+value);
        
        value = luminous_ice_crystal_value.getText().substring(2);
        luminous_ice_crystal_value.setText(returnValue((int)i.next(),2)+value);
        value = luminous_earth_crystal_value.getText().substring(2);
        luminous_earth_crystal_value.setText(returnValue((int)i.next(),2)+value);
        value = luminous_water_crystal_value.getText().substring(2);
        luminous_water_crystal_value.setText(returnValue((int)i.next(),2)+value);
        
        value = astral_nodules_value.getText().substring(2);
        astral_nodules_value.setText(returnValue((int)i.next(),2)+value);
        value = umbral_nodules_value.getText().substring(2);
        umbral_nodules_value.setText(returnValue((int)i.next(),2)+value);
    }
    
    private void setStage2Values(){
        Iterator i = collection.returnStage2Values();
        Color background;
        
        background = (((int)i.next() == 1) ? Color.DARK_GRAY : new Color(204, 204, 204));
        stage2_stage01.setBackground(background);
        
        background = (((int)i.next() == 1) ? Color.DARK_GRAY : new Color(204, 204, 204));
        stage2_stage02.setBackground(background);
        
        background = (((int)i.next() == 1) ? Color.DARK_GRAY : new Color(204, 204, 204));
        stage2_stage03.setBackground(background);
        
        background = (((int)i.next() == 1) ? Color.DARK_GRAY : new Color(204, 204, 204));
        stage2_stage04.setBackground(background);
        
        background = (((int)i.next() == 1) ? Color.DARK_GRAY : new Color(204, 204, 204));
        stage2_stage05.setBackground(background);
        
        background = (((int)i.next() == 1) ? Color.DARK_GRAY : new Color(204, 204, 204));
        stage2_stage06.setBackground(background);
        
        background = (((int)i.next() == 1) ? Color.DARK_GRAY : new Color(204, 204, 204));
        stage2_stage07.setBackground(background);
        
        background = (((int)i.next() == 1) ? Color.DARK_GRAY : new Color(204, 204, 204));
        stage2_stage08.setBackground(background);
        
        background = (((int)i.next() == 1) ? Color.DARK_GRAY : new Color(204, 204, 204));
        stage2_stage09.setBackground(background);
        
        background = (((int)i.next() == 1) ? Color.DARK_GRAY : new Color(204, 204, 204));
        stage2_stage10.setBackground(background);
    }
    
    private void setStage3Values() {
        Iterator i = collection.returnStage3Values();
        String value;
        
        value = ubone_value.getText().substring(2);
        ubone_value.setText(returnValue((int)i.next(),2)+value);
        value = ushell_value.getText().substring(2);
        ushell_value.setText(returnValue((int)i.next(),2)+value);
        value = uore_value.getText().substring(2);
        uore_value.setText(returnValue((int)i.next(),2)+value);
        value = useed_value.getText().substring(2);
        useed_value.setText(returnValue((int)i.next(),2)+value);
        
        value = adamantite_francesca_value.getText().substring(2);
        adamantite_francesca_value.setText(returnValue((int)i.next(),2)+value);
        value = titanium_alloy_value.getText().substring(2);
        titanium_alloy_value.setText(returnValue((int)i.next(),2)+value);
        value = dispelling_arrow_value.getText().substring(2);
        dispelling_arrow_value.setText(returnValue((int)i.next(),2)+value);
        value = kingcake_value.getText().substring(2);
        kingcake_value.setText(returnValue((int)i.next(),2)+value);
    }

    private void getAllValues() {
        //stage
        allValues.add(getStage());
        //stage 1 values
        allValues.add(Integer.valueOf(luminous_fire_crystal_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(luminous_wind_crystal_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(luminous_lightning_crystal_value.getText().substring(0, 2)));
        
        allValues.add(Integer.valueOf(luminous_ice_crystal_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(luminous_earth_crystal_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(luminous_water_crystal_value.getText().substring(0, 2)));
        
        allValues.add(Integer.valueOf(astral_nodules_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(umbral_nodules_value.getText().substring(0, 2)));
        
        
        //stage 2 values
        allValues.add(getStateOfStage(stage2_stage01));
        allValues.add(getStateOfStage(stage2_stage02));
        allValues.add(getStateOfStage(stage2_stage03));
        allValues.add(getStateOfStage(stage2_stage04));
        allValues.add(getStateOfStage(stage2_stage05));
        allValues.add(getStateOfStage(stage2_stage06));
        allValues.add(getStateOfStage(stage2_stage07));
        allValues.add(getStateOfStage(stage2_stage08));
        allValues.add(getStateOfStage(stage2_stage09));
        allValues.add(getStateOfStage(stage2_stage10));
        
        //stage 3 values
        allValues.add(Integer.valueOf(ubone_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(ushell_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(uore_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(useed_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(adamantite_francesca_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(titanium_alloy_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(dispelling_arrow_value.getText().substring(0, 2)));
        allValues.add(Integer.valueOf(kingcake_value.getText().substring(0, 2)));
        
        //stage 4 values
        
        //stage 5 values'
        
        //tokens
        
    }

    private String returnValue(int input, int digits) {
        String returnValue;
        if (digits>1){
            returnValue = String.format("%02d", input);
        } else {
            returnValue = String.format("%1d", input);
        }
        return returnValue;
    }

    private void status_reset() {
        //New thread to run Inner class reset_text
        Thread t = new Thread(new ResetText());
        t.start();
    }

    private Boolean fileExists() {
        // was going to use 'exists' for something, but i forgot :/
        Boolean exists = false;
        
        //if "save.data" exists, it attempts to load it into the app
        File f = new File(saveFilename);
        if(f.exists()){
            exists = true;
            load_saved_data();
        }
        
        return exists;
    }

    private void load_saved_data() {
        try {
            collection = new Collection();
            
            tabs_stages.setSelectedIndex(collection.getStageNumber());
            
            setStage1Values();
            setStage2Values();
            setStage3Values();
            
            updateAllProgressBars();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setProgressBars();
        
    }

    private void progressbar_change_stage3(JProgressBar pbar, JLabel tokens, JLabel crafts) {
        
        int value_max = 14;
        int value1 = Integer.valueOf(tokens.getText().substring(0, 2));      
        int value2 = Integer.valueOf(crafts.getText().substring(0, 2));
        
        //limit progress bar on each value 10 and 4 respectively
        if (value1 >= 10){
            value1 = 10;
        }
        if (value2 >= 4){
            value2 = 4;
        }
        
        double progress_double = (((double)value1 + (double)value2)/(double)value_max)*100;
        int progress_int = (int)progress_double;
        
        pbar.setValue(progress_int);
        if (pbar.getValue() != 100){
            pbar.setForeground(Color.LIGHT_GRAY);
        } else {
            pbar.setForeground(Color.BLUE);
        }
        
    }

    private void setProgressBars() {
        
        progressbar_change_stage3(enchanted_rubber_pbar, ubone_value, adamantite_francesca_value);
        progressbar_change_stage3(fast_acting_allagan_catalyst_pbar, useed_value, kingcake_value);
        progressbar_change_stage3(divine_water_pbar, uore_value, dispelling_arrow_value);
        progressbar_change_stage3(fast_drying_carboncoat_pbar, ushell_value, titanium_alloy_value);        
    }

    private void stage2ChangeStatus(JLabel jlabel) {
        
        if (204 == jlabel.getBackground().getRed()){
        jlabel.setBackground(Color.DARK_GRAY);
    } else {
            jlabel.setBackground(new Color(204,204,204));
        }
        
        checkStatus();
        
    }

    private void checkStatus() {
        ArrayList<Integer> stage2Labels = new ArrayList<>();
        stage2Labels.add(stage2_stage01.getBackground().getBlue());
        stage2Labels.add(stage2_stage02.getBackground().getBlue());
        stage2Labels.add(stage2_stage03.getBackground().getBlue());
        stage2Labels.add(stage2_stage04.getBackground().getBlue());
        stage2Labels.add(stage2_stage05.getBackground().getBlue());
        stage2Labels.add(stage2_stage06.getBackground().getBlue());
        stage2Labels.add(stage2_stage07.getBackground().getBlue());
        stage2Labels.add(stage2_stage08.getBackground().getBlue());
        stage2Labels.add(stage2_stage09.getBackground().getBlue());
        stage2Labels.add(stage2_stage10.getBackground().getBlue());
        
        int stage2_progress = 0;
        
        for (Integer i : stage2Labels){
            if (i == 64){
                stage2_progress++;
            }
        if(stage2_progress >= 10){
            stage2CompleteButton.setEnabled(true);
        } else {
            stage2CompleteButton.setEnabled(false);
        }
        
        };
        
        // TODO: make into a method, Duplicate code
        
        stage2_pbar.setValue(stage2_progress);
        if (stage2_pbar.getValue() != 10){
            stage2_pbar.setForeground(Color.LIGHT_GRAY);
        } else {
            stage2_pbar.setForeground(Color.BLUE);
        }
        
        stage2_pbar.setValue(stage2_progress);
        
    }

    private void progressbar_change_stage1(JProgressBar pbar, JLabel crystal_value1, JLabel crystal_value2, JLabel crystal_value3, JButton button) {
        
        int crystal1 = Integer.valueOf(crystal_value1.getText().substring(0, 2));
        int crystal2 = Integer.valueOf(crystal_value2.getText().substring(0, 2));
        int crystal3 = Integer.valueOf(crystal_value3.getText().substring(0, 2));
        
        // limits each value to 3 in whole progress
        if (crystal1 > 3){
            crystal1 = 3;
        }
        if (crystal2 > 3){
            crystal2 = 3;
        } 
        if (crystal3 > 3){
            crystal3 = 3;
        }
        int progress = crystal1+crystal2+crystal3;


        pbar.setValue(progress);
        
        if (pbar.getValue() != 9){
            pbar.setForeground(Color.LIGHT_GRAY);
        } else {
            pbar.setForeground(Color.BLUE);
        }
        if(progress >= 9){
            button.setEnabled(true);
        } else {
            button.setEnabled(false);
        }
        
    }

    private void acquiredNodule(JLabel crystal1Label, JLabel crystal2Label, JLabel crystal3Label, JLabel nodules_value) {
        String crystal1Text = crystal1Label.getText().substring(2);
        String crystal2Text = crystal2Label.getText().substring(2);
        String crystal3Text = crystal3Label.getText().substring(2);
        
        int crystal1 = Integer.valueOf(crystal1Label.getText().substring(0, 2));
        int crystal2 = Integer.valueOf(crystal2Label.getText().substring(0, 2));
        int crystal3 = Integer.valueOf(crystal3Label.getText().substring(0, 2));
        int nodule = Integer.valueOf(nodules_value.getText());
        
        crystal1 -= 3;
        crystal2 -= 3;
        crystal3 -= 3;
        nodule++;
        
        crystal1Label.setText(String.format("%02d", crystal1) + crystal1Text);
        crystal2Label.setText(String.format("%02d", crystal2) + crystal2Text);
        crystal3Label.setText(String.format("%02d", crystal3) + crystal3Text);
        nodules_value.setText(String.format("%02d", nodule));
    }

    private void clearStage2Progress(JProgressBar pbar) {
        stage2_stage01.setBackground(new Color(204,204,204));
        stage2_stage02.setBackground(new Color(204,204,204));
        stage2_stage03.setBackground(new Color(204,204,204));
        stage2_stage04.setBackground(new Color(204,204,204));
        stage2_stage05.setBackground(new Color(204,204,204));
        stage2_stage06.setBackground(new Color(204,204,204));
        stage2_stage07.setBackground(new Color(204,204,204));
        stage2_stage08.setBackground(new Color(204,204,204));
        stage2_stage09.setBackground(new Color(204,204,204));
        stage2_stage10.setBackground(new Color(204,204,204));
        pbar.setValue(0);
                
    }

    private Integer getStage() {
        return stage_selector.getSelectedIndex();
    }

    private int getStateOfStage(JLabel stage) {
        int blue = stage.getBackground().getBlue();
        if (blue == 204){
            blue = 0;
        } else {
            blue = 1;
        }
     return blue;   
    }

    private void updateAllProgressBars() {
        progressbar_change_stage1(astral_nodule_pbar, luminous_fire_crystal_value, luminous_wind_crystal_value, luminous_lightning_crystal_value, astral_nodule_acquire_button);
        progressbar_change_stage1(umbral_nodule_pbar, luminous_ice_crystal_value, luminous_earth_crystal_value, luminous_water_crystal_value, umbral_nodule_acquire_button);
        
        checkStatus();
        
        progressbar_change_stage3(fast_acting_allagan_catalyst_pbar, useed_value, kingcake_value);
        progressbar_change_stage3(divine_water_pbar, uore_value, dispelling_arrow_value);
        progressbar_change_stage3(fast_drying_carboncoat_pbar, ushell_value, titanium_alloy_value);
        progressbar_change_stage3(enchanted_rubber_pbar, ubone_value, adamantite_francesca_value);
        
    }

    private void checkNodules(JLabel astral_nodule, JLabel umbral_nodule) {
        int a_nodule = Integer.valueOf(astral_nodule.getText());
        int u_nodule = Integer.valueOf(umbral_nodule.getText());
        
        if (a_nodule > 0 & u_nodule > 0){
            stage1CompleteButton.setEnabled(true);
        } else {
            stage1CompleteButton.setEnabled(false);
        }
    }

    private void consumeNodules(JLabel astral_nodule, JLabel umbral_nodule) {
        int a_nodule = Integer.valueOf(astral_nodule.getText());
        int u_nodule = Integer.valueOf(umbral_nodule.getText());
        
        a_nodule--;
        u_nodule--;
        
        astral_nodule.setText(String.format("%02d", a_nodule));
        umbral_nodule.setText(String.format("%02d", u_nodule));
    }


    private class ResetText implements Runnable{
        //Just a delayed thread to clear status text
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainWin.class.getName()).log(Level.SEVERE, null, ex);
            }
            status_text.setText("");
        }
        
    }
}
