package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book extends Media implements Comparable<Book> {

		private ArrayList<String> authors = new ArrayList<String>();
		private String content;
		
		// constructor
		public Book() {
			super();
		}
		
		public Book(String title,String category,float cost) {
			super(title,category,cost);
		}
		
		public Book(String title, String category,float cost, ArrayList<String> authors) {
			super(title,category,cost);
			this.authors = authors;
		}
		
		public Book(int idBook, String titleBook, String categoryBook, float costBook, ArrayList<String> authors) {
			this(titleBook,categoryBook,costBook);
			this.id = idBook;
			this.authors = authors;
		}
		public Book(int id, String title, String category, float cost) {
			super(id, title, category, cost);
		}
		
		// get, set
		public ArrayList<String> getAuthors() {
			return authors;
		}

		public void setAuthors(ArrayList<String> authors) {
			this.authors = authors;
		}
		
		// other
		public void addAuthor(String authorName) {
			if(!authors.contains(authorName))
				authors.add(authorName);
		}
		
		public void removeAuthor(String authorName) {
			if(authors.contains(authorName))
				authors.remove(authorName);
		}
		
		public List<String> contentTokens() {
			List<String> list = new ArrayList<>(List.of(this.content.split(",./")));
			Collections.sort(list);
			return list;
		}
		
		public Map<String, Integer> wordFrequency() {
			List <String> list = contentTokens();
			Map<String, Integer> wordFrequency = new HashMap<>();
			list.forEach(t -> {
				if(wordFrequency.containsKey(t))
					wordFrequency.replace(t, wordFrequency.get(t) +1 );
				else wordFrequency.put(t, 1);
			});
			return wordFrequency;
		}
		
		@Override 
		public int compareTo(Book obj) {
			return this.id - obj.getId();
		}
}
