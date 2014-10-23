package mz.com.peach.inforgest.model;

public class Product {
	private Long _id, _familyId, _groupId, _typeId;
	private String _description;
	
	public Product() {}
	
	
	
	public Product(Long _id, Long _familyId, Long _groupId, Long _typeId,
			String _description) {
		super();
		this._id = _id;
		this._familyId = _familyId;
		this._groupId = _groupId;
		this._typeId = _typeId;
		this._description = _description;
	}



	public Long getId() {
		return _id;
	}
	public void setId(Long id) {
		this._id = id;
	}
	public Long getFamilyId() {
		return _familyId;
	}
	public void setFamilyId(Long familyId) {
		this._familyId = familyId;
	}
	public Long getGroupId() {
		return _groupId;
	}
	public void setGroupId(Long groupId) {
		this._groupId = groupId;
	}
	public Long getTypeId() {
		return _typeId;
	}
	public void setTypeId(Long typeId) {
		this._typeId = typeId;
	}
	public String getDescription() {
		return _description;
	}
	public void setDescription(String description) {
		_description = description;
	}
}
