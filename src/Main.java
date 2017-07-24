//import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Employee,String> hashMap = new HashMap<>();
        //TreeMap treeMap = new TreeMap();


        Employee[] workers = new Employee[1000000];
        int[] numbers = {1,2,3,4,5};
        String[] firstNames = {"Ivan", "Petr", "Alex",
                "Jack", "Tim", "Tor", "Telo", "Doris",
                "John", "Bred", "Bob", "Alan"};
        String[] lastNames = {"Ivanov", "Petrov", "Turing",
                "Fox", "Chan", "Li", "Freeman", "Gold",
                "Watson", "Bing", "Green", "Potter"};
        long startTime = System.currentTimeMillis();
        {
            for (int i = 0; i < workers.length; i++) {
                int randomFirstName = (int) (Math.random() * firstNames.length);
                int randomLastName = (int) (Math.random() * lastNames.length);
                int[] randomGrages = {numbers[(int) (Math.random() * numbers.length)],
                        numbers[(int) (Math.random() * numbers.length)], numbers[(int) (Math.random() * numbers.length)],
                        numbers[(int) (Math.random() * numbers.length)]};
                workers[i] = new Employee((i + 1), firstNames[randomFirstName], lastNames[randomLastName], randomGrages);
                hashMap.put(workers[i], "Worker_" + (i + 1));
               // treeMap.put(workers[i], "Worker_" + (i + 1));
            }
        }
        long time = System.currentTimeMillis() - startTime;
        System.out.println(time);
       // System.out.println(hashMap.toString());

    }
}
