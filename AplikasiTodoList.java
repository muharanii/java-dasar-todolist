public class AplikasiTodoList {

        public static String[] model = new String[10];

        public static java.util.Scanner scanner = new java.util.Scanner(System.in);

        public static void main(String[] args) {
                viewShowTodoList();
        }

        //menampilakn todo list

        public static void showTodoList(){
                System.out.println("TODOLIST");

                for (var i = 0; i < model.length ; i++){
                        var todo = model[i];
                        var no = i + 1;

                        if (todo != null){
                                System.out.println(no + ". " + todo);
                        }
                }

        }

        public static void testShowTodoList(){
                model[0] = "Ini adalah baris pertama";
                model[1] = "Ini adalah baris kediua";

                showTodoList();
        }

        //menambah todo dari list

        public static void addTodoList(String todo){

               // cek apakah model penuh?
                var isFull =  true;
                for(int i = 0; i < model.length; i++){
                        if (model[i] == null){
                                isFull = false;
                                break;
                        }
                }

                //Jika penuh, kita resize ukuran array 2x lipat
                if(isFull){ 
                        var temp = model;
                        model = new String[model.length * 2];

                        for(int i = 0; i < temp.length; i++){
                                model[i] = temp[i];
                        }

                }

                //tambahkan ke posisi datanya null
                for (var i = 0; i < model.length; i++){
                        if(model[i] ==  null){
                                model[i] = todo;
                                break;
                        }
                }
        }

        public static void testAddTodoList(){
                for(int i = 0; i < 25; i++){
                        addTodoList("Contoh todo ke- "+ i);
                }
                

                showTodoList();
        }

        //menghapus todo dari list

        public static boolean removeTodoList(Integer number){

                if((number-1) >= model.length){
                        return false;
                }else if(model[number - 1] == null){
                        return false;
                }else{
                        for(int i = (number -1); i < model.length; i++){
                                if(i ==  (model.length -1)){
                                        model[i] = null;
                                }else{
                                        model[i] = model[i +1];
                                }
                        }
                        return true;
                }
        }

        //Test remove todolist

        public static void testRemoveTodolist(){
                addTodoList("satu");
                addTodoList("dua");
                addTodoList("tiga");
                addTodoList("empat");
                addTodoList("lima");

                var result = removeTodoList(20);
                System.out.println(result);

                result = removeTodoList(7);
                System.out.println(result);

                result = removeTodoList(2);
                System.out.println(result);

                showTodoList();
        }


        public static String input(String info){
                System.out.print(info + " : ");

                String data = scanner.nextLine();
                return data;

        }

        public static void testInput(){
                var name = input("Nama");
                System.out.println("Hi " + name);

                var selamat = input("Selamat ");
                System.out.println("Hallo "+ selamat);
        }

        //Menampilkan view todo list

        public static void viewShowTodoList(){
                while(true){
                        showTodoList();

                        System.out.println("Menu :");
                        System.out.println("1. Tambah");
                        System.out.println("2. Hapus");
                        System.out.println("x. Keluar");
        
                        var input = input("pilih ");
                        if(input.equals("1")){
                                viewAddTodoList();
                        }else if(input.equals("2")){
                                viewRemoveTodoList();
                        }else if (input.equals("x")){
                                break;
                        }else{
                                System.out.println("Pilihan tidak ada di sistem");
                        }
                }
             
        }

        //Testing view todolist
        public static void testViewShowTodoList(){
                addTodoList("Satu");
                addTodoList("dua");
                addTodoList("Tiga");
                addTodoList("Lima");


                viewShowTodoList();
        }

        //Menampilkan view add todo list

        public static void viewAddTodoList(){
                System.out.println("MENAMBAH TODOLIST");

                var todo = input("Todo (x Jika Batal)");

                if (todo.equals("x")){
                        //batal
                }else{
                        addTodoList(todo);
                }
        }

        public static void testViewAddTodoList(){
                addTodoList("satu");
                addTodoList("Dua");

                viewAddTodoList();

                showTodoList();
        }

        //menampilkan view menghapus todo list

        public static void viewRemoveTodoList(){
                System.out.println("MENGHAPUS TODOLIST");

                var number = input("Nomor yang Dihapus(x Jika Batal)");

                if(number.equals("x")){
                        //batal
                }else{
                    boolean success = removeTodoList(Integer.valueOf(number));
                    if(!success){
                        System.out.println("Gagal mengapus todolist : " +number);
                    }
                }
        }

        //testing viewRemoveTodolist

        public static void testViewRemoveTodoList(){
                addTodoList("satu");
                addTodoList("dua");
                addTodoList("tiga");

                showTodoList();

                viewRemoveTodoList();

                showTodoList();
        }


}