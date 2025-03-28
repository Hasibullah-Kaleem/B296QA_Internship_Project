package getlandestate.pojos;

;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryPropertyKeyPojo implements Serializable {
	private String keyType;
	private String name;
	private String prefix;
	private String suffix;

	public CategoryPropertyKeyPojo() {
	}

	public CategoryPropertyKeyPojo(String keyType, String name, String prefix, String suffix) {
		this.keyType = keyType;
		this.name = name;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public void setKeyType(String keyType){
		this.keyType = keyType;
	}

	public String getKeyType(){
		return keyType;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPrefix(String prefix){
		this.prefix = prefix;
	}

	public String getPrefix(){
		return prefix;
	}

	public void setSuffix(String suffix){
		this.suffix = suffix;
	}

	public String getSuffix(){
		return suffix;
	}

	@Override
 	public String toString(){
		return 
			"getlandestate.pojos.CategoryPropertyKeyPojo{" +
			"keyType = '" + keyType + '\'' + 
			",name = '" + name + '\'' + 
			",prefix = '" + prefix + '\'' + 
			",suffix = '" + suffix + '\'' + 
			"}";
		}
}