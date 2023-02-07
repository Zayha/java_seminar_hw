import java.util.*;

public class hw6 {
    public static void main(String[] args) {
        Notebook nb1 = new Notebook(16, 1024, "Windows11", "black", 36000.5);
        Notebook nb2 = new Notebook(32, 1024, "Windows10", "white", 42000.0);
        Notebook nb3 = new Notebook(8, 512, "WOS", "metallic", 16500.0);
        Notebook nb4 = new Notebook(12, 128, "Ubuntu", "black", 22000.0);
        Notebook nb5 = new Notebook(32, 1024, "Windows10", "white", 42000.0);
        Notebook nb6 = new Notebook(16, 500, "Windows11", "yellow", 24900.0);
        Notebook nb7 = new Notebook(64, 10240, "Windows11", "orange", 167000.0);
        Notebook nb8 = new Notebook(32, 256, "WOS", "black", 29000.0);
        Notebook nb9 = new Notebook(16, 2048, "Windows10", "white", 59000.0);
        Notebook nb10 = new Notebook(32, 2048, "Windows10", "white", 67000.0);
        Map<Integer, Notebook> db = new LinkedHashMap<>();
        db.put(nb1.getId(), nb1);
        db.put(nb2.getId(), nb2);
        db.put(nb3.getId(), nb3);
        db.put(nb4.getId(), nb4);
        db.put(nb5.getId(), nb5);
        db.put(nb6.getId(), nb6);
        db.put(nb7.getId(), nb7);
        db.put(nb8.getId(), nb8);
        db.put(nb9.getId(), nb9);
        db.put(nb10.getId(), nb10);
        System.out.println(Notebook.Stat.counter);
        switcher(db);


    }

    public static Object getData(Map<Integer, Notebook> db, String param) {
        Map<Integer, Integer> ram = new LinkedHashMap<>();
        Map<Integer, Integer> hdd = new LinkedHashMap<>();
        Map<Integer, String> os = new LinkedHashMap<>();
        Map<Integer, String> color = new LinkedHashMap<>();
        for (Notebook n :
                db.values()) {
            ram.put(n.getId(), n.getRam());
            hdd.put(n.getId(), n.getStorageCapacity());
            os.put(n.getId(), n.getoS());
            color.put(n.getId(), n.getColor());
        }

        Set<String> colorU = new LinkedHashSet<>(color.values());
        Set<String> osU = new LinkedHashSet<>(os.values());

        ram = sortII((LinkedHashMap<Integer, Integer>) ram);
        hdd = sortII((LinkedHashMap<Integer, Integer>) hdd);

        if (Objects.equals(param, "ram")) return ram;
        if (Objects.equals(param, "hdd")) return hdd;
        if (Objects.equals(param, "color")) return color;
        if (Objects.equals(param, "os")) return os;
        if (Objects.equals(param, "colorUnique")) return colorU;
        if (Objects.equals(param, "osUnique")) return osU;
        else {
            return "";
        }
//    return Objects;
    }


    public static Map<Integer, Integer> sortII(LinkedHashMap<Integer, Integer> data) {
        Map<Integer, Integer> res = new LinkedHashMap<>();

        do {
            int max = 0;
            int maxKey = 0;
            for (Map.Entry<Integer, Integer> entry :
                    data.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (value > max) {
                    max = value;
                    maxKey = key;
                }
            }
            res.put(maxKey, max);
            data.remove(maxKey);
        } while (!data.isEmpty());
        return res;
    }


    public static void switcher(Map<Integer, Notebook> db) {
        HashMap<String, Integer> fil = new HashMap<>();
        fil.put("OZU", 0);
        fil.put("HDD", 0);
        String colorFilter, osFilter;
        Scanner sc = new Scanner(System.in);
        String[] menu = new String[]{"ОЗУ", "Объем ЖД", "Операционная система", "Цвет", "Закончить"};
        boolean flag = true;
        while(flag){
            for (int i = 1; i <= menu.length; i++) {
                System.out.printf("[%d] - %s\n", i, menu[i - 1]);
            }
            System.out.print("\nУкажите номер критерия фильтрации: ");
            int sw = sc.nextInt();
            switch (sw) {
                case (1):
                    System.out.print("Укажите минимальное значени оперативной памяти: ");
                    break;
                case (2):
                    System.out.print("Укажите минимальное значени объема накопителя HDD/SSD: ");
                    break;
                case (3):
                    LinkedHashSet<String> os = (LinkedHashSet<String>) getData(db, "osUnique");
                    System.out.println("Выберите операционную систему из доступных вариантов: ");
                    System.out.println(os);
//                    System.out.println(os.getClass().getName());
                    System.out.print("Введите наименование операционной системы: ");
                    String ossw = sc.next();
                    boolean f1 = false;
                    for (String n :
                            os) {
                        if(Objects.equals(ossw, n)) {
                            osFilter = n;
                            f1 = true;
                            break;
                        }
                    }
                    if(!f1){
                        System.out.println("\nЗначение фильтра указано некорректно и не будет примененно!");
                    }
                    break;
                case (4):
                    System.out.print("Выберите цвет: ");
                    break;
                case (5):
                    flag = false;
                    break;
            }
        }


//        return 1;
    }


//    public static HashMap<> getData(int sw) {
//        HashMap<Integer, String> n = new HashMap<>();
//        n.put(1, "ram");
//        n.put(2, "storageCapacity");
//        n.put(3, "oS");
//        n.put(4, "color");
//
//
//    }
}
