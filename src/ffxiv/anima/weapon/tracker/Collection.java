/*
 * This class is mostly used to collect all values
 * to save or load them into the app.
 */
package ffxiv.anima.weapon.tracker;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Workhorse
 */
public final class Collection implements Serializable {
    
    //if file version doesn't match, it wont load
    int majorVersion = 0;
    double saveFileVersion = 2.3;
    
    //which stage saved at
    private int stage_overall;
    
    //stage 1 values
    private int lum_fire_crystals;
    private int lum_wind_crystals;
    private int lum_lightning_crystals;
    private int lum_ice_crystals;
    private int lum_earth_crystals;
    private int lum_water_crystals;
    
    private int astral_nodules;
    private int umbral_nodules;
    
    //stage 2 values
    private boolean stage_01;
    private boolean stage_02;
    private boolean stage_03;
    private boolean stage_04;
    private boolean stage_05;
    private boolean stage_06;
    private boolean stage_07;
    private boolean stage_08;
    private boolean stage_09;
    private boolean stage_10;
    
    //stage 3 values
    private int ubone_value;
    private int ushell_value;
    private int uore_value;
    private int useed_value;
    private int adamantite_francesca_value;
    private int titanium_alloy_mirror_value;
    private int dispelling_arrow_value;
    private int kingcake_value;

    
    //stage 4 values
    
    private int aether_oils;
    
    //stage 5 values
    // still dont know what values are needed for this stage
    
    
    //tokens collection
    private int poetics;
    private int esoterics;
    private int lore;
    private int allied_seals;
    private int centurio_seals;
    
    private int amaljaaTokens;
    private int sylphTokens;
    private int koboldTokens;
    private int sahaginTokens;
    private int ixalTokens;
    
    private int vathTokens;
    private int vanuVanuTokens;
    private int moogleTokens;
    
    
    private Collection loadedData;
    private ArrayList<Integer> savedValues;

    //attempts to load saved values
    public Collection() throws ClassNotFoundException{
        LoadData();
    }
    
    public Collection(int stage){
        this.stage_overall = stage;
    }

    
    public void SaveData(){
        File filename = new File("data.save");
        try{
            ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(filename.toPath()));
            out.writeObject(this);
        } catch (IOException e){}
    }
    
    public void LoadData() throws ClassNotFoundException{
        File filename = new File("data.save");
        if (filename.exists()){
            try{
                ObjectInputStream in = new ObjectInputStream(Files.newInputStream(filename.toPath()));
                loadedData = (Collection) in.readObject();
            } catch (IOException e){}
            if (loadedData.saveFileVersion == 2.3 & loadedData.majorVersion == 0){
                
                this.stage_overall = loadedData.stage_overall;
                this.lum_fire_crystals = loadedData.lum_fire_crystals;
                this.lum_wind_crystals = loadedData.lum_wind_crystals;
                this.lum_lightning_crystals = loadedData.lum_lightning_crystals;
                this.lum_ice_crystals = loadedData.lum_ice_crystals;
                this.lum_earth_crystals = loadedData.lum_earth_crystals;
                this.lum_water_crystals = loadedData.lum_water_crystals;
                
                this.astral_nodules = loadedData.astral_nodules;
                this.umbral_nodules = loadedData.umbral_nodules;
                
                //booleans
                this.stage_01 = loadedData.stage_01;
                this.stage_02 = loadedData.stage_02;
                this.stage_03 = loadedData.stage_03;
                this.stage_04 = loadedData.stage_04;
                this.stage_05 = loadedData.stage_05;
                this.stage_06 = loadedData.stage_06;
                this.stage_07 = loadedData.stage_07;
                this.stage_08 = loadedData.stage_08;
                this.stage_09 = loadedData.stage_09;
                this.stage_10 = loadedData.stage_10;
                
                this.ubone_value = loadedData.ubone_value;
                this.ushell_value = loadedData.ushell_value;
                this.uore_value = loadedData.uore_value;
                this.useed_value = loadedData.useed_value;
                this.adamantite_francesca_value = loadedData.adamantite_francesca_value;
                this.titanium_alloy_mirror_value = loadedData.titanium_alloy_mirror_value;
                this.dispelling_arrow_value = loadedData.dispelling_arrow_value;
                this.kingcake_value = loadedData.kingcake_value;
                             
                this.aether_oils = loadedData.aether_oils;
                
                //stage 5 values should go here, not sure
                
                //tokens
                this.poetics        = loadedData.poetics;
                this.esoterics      = loadedData.esoterics;
                this.lore           = loadedData.lore;
                this.allied_seals   = loadedData.allied_seals;
                this.centurio_seals = loadedData.centurio_seals;
                
                this.amaljaaTokens  = loadedData.amaljaaTokens;
                this.koboldTokens   = loadedData.koboldTokens;
                this.sylphTokens    = loadedData.sylphTokens;
                this.sahaginTokens  = loadedData.sahaginTokens;
                this.ixalTokens     = loadedData.ixalTokens;
                
                this.vathTokens     = loadedData.vathTokens;
                this.vanuVanuTokens = loadedData.vanuVanuTokens;
                this.moogleTokens   = loadedData.moogleTokens;
            }
        } else {
            System.out.println("File did not load");
        }
    }
    
    public int getStageNumber(){
        return stage_overall;
    }
    
    public void setStageNumber(int stageNumber){
        this.stage_overall = stageNumber;
    }
    
    public void saveStage01(int fire, int wind, int lightning, int ice, int earth, int water, int astral, int umbral){
    this.lum_fire_crystals = fire;
    this.lum_wind_crystals = wind;
    this.lum_lightning_crystals = lightning;
    this.lum_ice_crystals = ice;
    this.lum_earth_crystals = earth;
    this.lum_water_crystals = water;
    
    this.astral_nodules = astral;
    this.umbral_nodules = umbral;
    }
    
    public Iterator<Integer> returnStage1Values(){
        savedValues = new ArrayList<>();
        savedValues.add(lum_fire_crystals);
        savedValues.add(lum_wind_crystals);
        savedValues.add(lum_lightning_crystals);
        savedValues.add(lum_ice_crystals);
        savedValues.add(lum_earth_crystals);
        savedValues.add(lum_water_crystals);
        
        savedValues.add(astral_nodules);
        savedValues.add(umbral_nodules);
        return savedValues.iterator();
    }
    
    public void saveStage02(int stageState01, int stageState02, int stageState03, int stageState04, int stageState05, 
            int stageState06, int stageState07, int stageState08, int stageState09, int stageState10){
        this.stage_01 = getStageState(stageState01);
        this.stage_02 = getStageState(stageState02);
        this.stage_03 = getStageState(stageState03);
        this.stage_04 = getStageState(stageState04);
        this.stage_05 = getStageState(stageState05);
        this.stage_06 = getStageState(stageState06);
        this.stage_07 = getStageState(stageState07);
        this.stage_08 = getStageState(stageState08);
        this.stage_09 = getStageState(stageState09);
        this.stage_10 = getStageState(stageState10);
    }
    
    public Iterator<Integer> returnStage2Values(){
        savedValues = new ArrayList<>();
        savedValues.add(getStageState(this.stage_01));
        savedValues.add(getStageState(this.stage_02));
        savedValues.add(getStageState(this.stage_03));
        savedValues.add(getStageState(this.stage_04));
        savedValues.add(getStageState(this.stage_05));
        savedValues.add(getStageState(this.stage_06));
        savedValues.add(getStageState(this.stage_07));
        savedValues.add(getStageState(this.stage_08));
        savedValues.add(getStageState(this.stage_09));
        savedValues.add(getStageState(this.stage_10));
        return savedValues.iterator();
    }
    
    public void saveStage03(int ubone, int ushell, int uore, int useed, int afran, int tallo, int darro, int kingcake){
        this.ubone_value = ubone;
        this.ushell_value = ushell;
        this.uore_value = uore;
        this.useed_value = useed;
        this.adamantite_francesca_value = afran;
        this.titanium_alloy_mirror_value = tallo;
        this.dispelling_arrow_value = darro;
        this.kingcake_value = kingcake;
    }
    
    public Iterator<Integer> returnStage3Values(){
        savedValues = new ArrayList<>();
        savedValues.add(ubone_value);
        savedValues.add(ushell_value);
        savedValues.add(uore_value);
        savedValues.add(useed_value);
        savedValues.add(adamantite_francesca_value);
        savedValues.add(titanium_alloy_mirror_value);
        savedValues.add(dispelling_arrow_value);
        savedValues.add(kingcake_value);
        return savedValues.iterator();
    }

    private int getStageState(boolean test) {
        return (test) ? 1 : 0;
    }
    
    private boolean getStageState(int test) {
        if (test == 1){
            return true;
        } else {
            return false;
        }
    }
}
