/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

/**
 *
 * @author jakob
 */
public class DomainTest {

    public static void main(String[] args) {
        
        DomainFacade df = DomainFacade.getInstance();
        sensum_bosted.PrintHandler.println(df.login("erso", "zzz"));
        
        
        
    }
    
}
