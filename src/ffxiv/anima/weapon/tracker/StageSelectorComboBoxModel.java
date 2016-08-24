/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ffxiv.anima.weapon.tracker;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Workhorse
 */
public class StageSelectorComboBoxModel extends AbstractListModel implements ComboBoxModel {
    String[] stageSelect = {"Stage 1", "Stage 2", "Stage 3", "Stage 4", "Stage 5", "Tokens"};
    
    String selection = null;
    
    @Override
    public int getSize() {
        return stageSelect.length;
    }

    @Override
    public String getElementAt(int index) {
        return stageSelect[index];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    @Override
    public String getSelectedItem() {
        return selection;
    }
    
}
