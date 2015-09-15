package StoreHouse;

public class Item {
	private int Number, Stock;
	private String Category, Name, Model;

	public int getNumber() {
		return Number;
	}

	public void setNumber(int Number) {
		this.Number = Number;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String Category) {
		this.Category = Category;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String Model) {
		this.Model = Model;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int Stock) {
		this.Stock = Stock;
	}

	// ¹¹Ôìº¯Êý
	public Item(int num, String ca, String na, String mo, int sto) {
		Number = num;
		Category = ca;
		Name = na;
		Model = mo;
		Stock = sto;
	}
}
