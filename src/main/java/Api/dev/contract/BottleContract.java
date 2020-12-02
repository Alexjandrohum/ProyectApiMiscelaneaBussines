/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.contract;

import Api.dev.entities.Bottle;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface BottleContract {

    List<Bottle> getListBottle();

    Bottle getBottle(int id);

    int updateBottle(Bottle bottle);

    int deleteBottle(int id);
    
    Bottle createBottle(Bottle bottle);

}
