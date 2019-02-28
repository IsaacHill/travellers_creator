import MyClasses.*;

public class Test
{
     public static void main(String[] args) {
        System.out.println("Hello from the matrix");
        basicBuilderTest();
    }

    public static void basicBuilderTest() {
        Traveller.TravellerBuilder builder = new Traveller.TravellerBuilder("Luke Skywalker");
        Traveller luke = builder.build();
        assert luke.getName().equals("Luke Skywalker") : "bad name";
 
    }
}