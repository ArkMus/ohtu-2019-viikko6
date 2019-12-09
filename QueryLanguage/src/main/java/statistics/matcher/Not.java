
package statistics.matcher;

import statistics.Player;

public class Not extends Matcher {
    
    private Matcher matcher;
    public Not(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Player p) {
        try {                                    
            return !matcher.matches(p);
        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field ");
        }       
        
    }    
    
}
