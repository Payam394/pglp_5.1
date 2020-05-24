import java.util.ArrayList;

public interface DAO<T> {
	
	ArrayList<T> getAll();
	
	T getPersonel(int p);
    
    void add(T t);
     
    void delete(T t);
    
    void update(T p);
	

}
