public class AplikasiTodoList {

        public static String[] model = new String[10];

        public static void main(String[] args) {
                testAddTodoList();;
        }

        //menampilakn todo list

        public static void showTodoList(){

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
                        model[number - 1] = null;
                        return true;
                }
        }

        //Menampilkan view todo list

        public static void viewShowTodoList(){

        }

        //Menampilkan view add todo list

        public static void viewAddTodoList(){

        }

        //menampilkan view menghapus todo list

        public static void viewRemoveTodoList(){

        }


}