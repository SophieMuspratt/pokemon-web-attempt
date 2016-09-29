package pokemon.classes;

/**
 * Created by smusp on 26/08/2016.
 */
public class Type {
    private String elementType;
    private String elementTypeDesc;

    public Type(String elementType, String elementTypeDesc){
        this.elementType = elementType;
        this.elementTypeDesc = elementTypeDesc;
    }

    public String getElementType() {
        return elementType;
    }

    public String getElementTypeDesc() {
        return elementTypeDesc;
    }
}

