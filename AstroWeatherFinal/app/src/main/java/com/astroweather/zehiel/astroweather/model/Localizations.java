package com.astroweather.zehiel.astroweather.model;

import java.io.Serializable;
import java.util.HashSet;


/**
 * Created by grusz on 22.06.2017.
 */

public class Localizations implements Serializable {

    private HashSet<Localization> localizations = null;

    public Localizations(HashSet<Localization> localizations) {
        this.localizations = localizations;
    }

    public HashSet<Localization> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(HashSet<Localization> localizations) {
        this.localizations = localizations;
    }

    public void addLocalization(Localization localization){
        if (localizations == null){
            localizations = new HashSet<>();
        }
        localizations.add(localization);
    }

    public HashSet<String> getStringValues() {
        HashSet<String> strings = new HashSet<>(localizations.size());
        for(Localization localization : localizations){
            strings.add(localization.toString());
        }
        return strings;
    }

    public boolean contains(String string){
        if(localizations != null || localizations.size() != 0){
            if(getStringValues().contains(string)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
