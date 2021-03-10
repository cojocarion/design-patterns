import java.util.HashMap;
import java.util.Map;


abstract class Engine implements Cloneable
{

    protected String type;

    abstract void addType();

    public Object clone()
    {

        Object clone = null;
        try
        {
            clone = super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return clone;
    }
}

class DieselEngine extends Engine
{
    public DieselEngine()
    {
        this.type = "diesel";
    }

    @Override
    void addType()
    {
        System.out.println("Diesel type added");
    }

}

class OilEngine extends Engine {

    public OilEngine()
    {
        this.type = "oil";
    }

    @Override
    void addType()
    {
        System.out.println("oil type added");
    }
}

class EngineStore {

    private static Map<String, Engine> typeMap = new HashMap<String, Engine>();

    static
    {
        typeMap.put("diesel", new DieselEngine());
        typeMap.put("oil", new OilEngine());
    }

    public static Engine getType(String typeName)
    {
        return (Engine) typeMap.get(typeName).clone();
    }
}


// Driver class
class Prototype
{
    public static void main (String[] args)
    {
        EngineStore.getType("oil").addType();
        EngineStore.getType("diesel").addType();
        EngineStore.getType("diesel").addType();
        EngineStore.getType("oil").addType();
    }
}
