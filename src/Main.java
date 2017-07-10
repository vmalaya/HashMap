
public class Main {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Object[] workers = new Object[10000];
        int[] numbers = {1,2,3,4,5};
        String[] firstNames = {"Ivan", "Petr", "Alex",
                "Jack", "Tim", "Tor", "Telo", "Doris",
                "John", "Bred", "Bob", "Alan"};
        String[] lastNames = {"Ivanov", "Petrov", "Turing",
                "Fox", "Chan", "Li", "Freeman", "Gold",
                "Watson", "Bing", "Green", "Potter"};
        for (int i = 0; i < workers.length ; i++) {
            int randomFirstName =(int)(Math.random()* firstNames.length);
            int randomLastName =(int)(Math.random()* lastNames.length);
            int[] randomGrages = {numbers[(int)(Math.random()* numbers.length)],
                    numbers[(int)(Math.random()* numbers.length)], numbers[(int)(Math.random()* numbers.length)],
                    numbers[(int)(Math.random()* numbers.length)]};
            workers[i] = new Employee(firstNames[randomFirstName],lastNames[randomLastName], randomGrages );
            hashMap.put(workers[i], "Worker_"+(i+1));
        }
        System.out.println(true);
       // System.out.println(hashMap.toString());

    }
}
