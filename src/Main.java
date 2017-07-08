
public class Main {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Employee ivanov = new Employee("Ivanov");
        Employee petrov = new Employee("Petr");
        hashMap.put("ivanov", ivanov);
        System.out.println(hashMap.toString());
        System.out.println(hashMap.get("ivanov"));
        hashMap.put("petr", petrov);
        System.out.println(hashMap.toString());
    }
}
