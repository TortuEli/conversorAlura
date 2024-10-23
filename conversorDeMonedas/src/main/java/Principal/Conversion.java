/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author elizabeth.lavenant@dominio.semarnat.gob.mx
 */
public class Conversion {
    private double conversion_rate;
    private String base_code;
    private String target_code;
    
    public Conversion(double conversion_rate, String base_code, String target_code){
        this.conversion_rate = conversion_rate;
        this.base_code = base_code;
        this.target_code = target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }
    
    
    
    
}
