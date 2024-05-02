package DataObjects;

public class Type {
    public int typeID;
    public String typeName;
    public String typeDescription;

    public Type(int typeID, String typeName, String typeDescription) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.typeDescription = typeDescription;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }
}
