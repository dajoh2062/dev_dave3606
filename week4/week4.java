
public class week4 {
    public static void main(String[] args) {

        System.out.printf("char:         %d bytes%n", Character.BYTES);
        System.out.printf("short:        %d bytes%n", Short.BYTES);
        System.out.printf("int:          %d bytes%n", Integer.BYTES);
        System.out.printf("long:         %d bytes%n", Long.BYTES);
        System.out.printf("long long:    (not a Java type; use long = %d bytes)%n", Long.BYTES);
        System.out.printf("unsigned int: (not a Java primitive; use int = %d bytes)%n", Integer.BYTES);
        System.out.printf("float:        %d bytes%n", Float.BYTES);
        System.out.printf("double:       %d bytes%n", Double.BYTES);
        System.out.printf("bool:         %d bytes%n", Byte.BYTES); // closest primitive size 
    }
    
}
