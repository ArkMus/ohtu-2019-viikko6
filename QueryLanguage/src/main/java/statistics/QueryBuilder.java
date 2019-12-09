package statistics;

import java.util.ArrayList;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {

    Matcher matcher;
    ArrayList<Matcher> matchers;
    
    public QueryBuilder(){
        matcher = new Matcher();
        matchers = new ArrayList<>();
    }

    public Matcher build(){
        return new And(matchers.toArray(new Matcher[matchers.size()]));
    }
    
    public QueryBuilder oneOf(Matcher... matchers){
        ArrayList<Matcher> ms = new ArrayList<>();
        for(Matcher m : matchers){
            ms.add(m);
            System.out.println(m);
        }
        this.matcher = new Or(ms.toArray(new Matcher[ms.size()]));
        return this;
    }

    public QueryBuilder all(){
        this.matcher = new All();
        matchers.add(this.matcher);
        return this;
    }

    public QueryBuilder and(Matcher[] matchers){
        this.matcher = new And(matchers);
        this.matchers.add(this.matcher);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category){
        this.matcher = new HasAtLeast(value, category);
        matchers.add(this.matcher);
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category){
        this.matcher = new HasFewerThan(value, category);
        matchers.add(this.matcher);
        return this;
    }

    public QueryBuilder not(Matcher matcher){
        this.matcher = new Not(matcher);
        matchers.add(this.matcher);
        return this;
    }

    public QueryBuilder or(Matcher[] matchers){
        this.matcher = new Or(matchers);
        this.matchers.add(this.matcher);
        return this;
    }

    public QueryBuilder playsIn(String team){
        this.matcher = new PlaysIn(team);
        matchers.add(this.matcher);
        return this;
    }

}
