package mz.com.peach.inforgest.model.Archive;

public class ProductFamily {
	private Long _id;
	private String _description;
	
	public ProductFamily() {}
	
	public ProductFamily(Long _id, String _description) {
		super();
		this._id = _id;
		this._description = _description;
	}



	public Long getId() {
		return _id;
	}
	public void setId(Long id) {
		this._id = id;
	}
	public String getDescription() {
		return _description;
	}
	public void setDescription(String description) {
		this._description = description;
	}
}
