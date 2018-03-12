package basic.oop.dip;

public class Grandpa {
	
	public IBook book;
	
	public void setBook (IBook book) {
		this.book = book;
	}
	
	public void read() {
		/*Novel novel = new Novel();
		novel.story();*/
		//Newspaper newspaper = new Newspaper();
		book.story();
	}
	
	public static void main(String[] args) {
		Grandpa grandpa = new Grandpa();
		grandpa.setBook(new Newspaper());
		grandpa.read();
	}

}
