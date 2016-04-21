package car.tp4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    private Author author; 
    private String title; 
    
    public Book() {} 
    public Book(Author author, String title) { 
        this.author = author; 
        this.title = title; } 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
    @ManyToOne
    public Author getAuthor() { return author; } 
    public void setAuthor(Author author) { this.author = author; } 
    public String getTitle() { return title; } 
    public void setTitle(String title) { this.title = title; }
    
    public String toString(){
    	return title + " ("+author+")";
    }
}
