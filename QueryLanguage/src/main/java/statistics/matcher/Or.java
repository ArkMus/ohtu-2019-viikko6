
package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {
    
    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        try {
            for(Matcher m : matchers){
                if(m.matches(p)){
                    return true;
                }
            }
            return false;      
        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field ");
        }       
        
    }    
    
}
