package OOP_Eksplorasi;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Book {
    public static void main(String[] args) throws IOException {

        Scanner userInput = new Scanner(System.in);
        String optionUser;
        boolean isContinue = true;

        while (isContinue) {

            System.out.println("Welcome to book management app");
            System.out.println("Please choose your menu");
            System.out.println("1. Create a new book");
            System.out.println("2. Get all books");
            System.out.println("3. Get book by ID");
            System.out.println("4. Update book");
            System.out.println("5. Delete book");
            System.out.println("6. Exit");

            System.out.print("\n\nYour Choose ");
            optionUser = userInput.next();

            switch (optionUser) {
                case "1":
                    System.out.println("\n=================");
                    System.out.println("Add data book");
                    System.out.println("=================");
                    addData();
                    viewData();
                    break;
                case "2":
                    System.out.println("\n=========");
                    System.out.println("All Book");
                    System.out.println("=========");
                    viewData();
                    break;
                case "3":
                    System.out.println("\n================");
                    System.out.println("Search book by ID");
                    System.out.println("================");
                    searchData();
                    break;
                case "4":
                    System.out.println("\n==============");
                    System.out.println("Update data book");
                    System.out.println("==============");
                    updateData();
                    break;
                case "5":
                    System.out.println("\n===============");
                    System.out.println("Delete data book");
                    System.out.println("===============");
                    deleteData();
                    break;
                case "6":
                    System.out.println("\n===============");
                    System.out.println("Bye....");
                    System.out.println("===============");
                    System.exit(0);
                    break;
                default:
                    System.err.println("\nInput invalid choice [1-6]");
            }

            isContinue = getYesorNo("Would you like to continue?");
        }
    }

    private static void addData() throws IOException{


        FileWriter fileOutput = new FileWriter("database.txt",true);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);


        // mengambil input dari user
        Scanner terminalInput = new Scanner(System.in);
        String id, author, title, category;
        System.out.print("Enter ID: ");
        id = terminalInput.nextLine();
        System.out.print("Enter title: ");
        title = terminalInput.nextLine();
        System.out.print("Enter author: ");
        author = terminalInput.nextLine();
        System.out.print("Enter category: ");
        category = terminalInput.nextLine();

        // cek buku di database

        String[] keywords = {id+","+author+","+category+","+title};
        System.out.println(Arrays.toString(keywords));

        boolean isExist = cekBukuDiDatabase(keywords,false);

        // menulis buku di databse
        if (!isExist){

            System.out.println(ambilEntryPerTahun(category, id));
            long nomorEntry = ambilEntryPerTahun(author, id) + 1;

            String punulisTanpaSpasi = author.replaceAll("\\s+","");
            String primaryKey = punulisTanpaSpasi+"_"+id+"_"+nomorEntry;
            System.out.println("\nBook Created");
            System.out.println("----------------------------------------");
            System.out.println("primary key      : " + primaryKey);
            System.out.println("ID               : " + id);
            System.out.println("author           : " + author);
            System.out.println("title            : " + title);
            System.out.println("category         : " + category);

            boolean isTambah = getYesorNo("Will you want to add to the data? ");

            if(isTambah){
                bufferOutput.write(primaryKey + "," + id + ","+ author +"," + category + ","+title);
                bufferOutput.newLine();
                bufferOutput.flush();
            }

        } else {
            System.out.println("data book is already:");
            cekBukuDiDatabase(keywords,true);
        }


        bufferOutput.close();
    }

    private static void viewData() throws IOException{

        FileReader fileInput;
        BufferedReader bufferInput;

        try {
            fileInput = new FileReader("database.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e){
            System.err.println("Database not found");
            System.err.println("Please add data first");
            addData();
            return;
        }

        System.out.println("|\tID                                    |\tAuthor                 |\tCategory               |\tBook Title");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");

        String data = bufferInput.readLine();
        while(data != null) {

            StringTokenizer stringToken = new StringTokenizer(data, ",");

            stringToken.nextToken();

            System.out.printf("|\t%4s  ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%s   ", stringToken.nextToken());
            System.out.print("\n");

            data = bufferInput.readLine();
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------");
    }

    private static void searchData() throws IOException{

        // membaca database ada atau tidak

        try {
            File file = new File("database.txt");
        } catch (Exception e){
            System.err.println("Database not found");
            System.err.println("Please add data first");
            addData();
            return;
        }

        // kita ambil keyword dari user

        Scanner terminalInput = new Scanner(System.in);
        System.out.print("Search book by ID: ");
        String cariString = terminalInput.nextLine();
        String[] keywords = cariString.split("\\s+");

        // kita cek keyword di database
        cekBukuDiDatabase(keywords,true);

    }

    private static long ambilEntryPerTahun(String author, String id) throws IOException {
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        long entry = 0;
        String data = bufferInput.readLine();
        Scanner dataScanner;
        String primaryKey;

        while(data != null){
            dataScanner = new Scanner(data);
            dataScanner.useDelimiter(",");
            primaryKey = dataScanner.next();
            dataScanner = new Scanner(primaryKey);
            dataScanner.useDelimiter("_");

            author = author.replaceAll("\\s+","");

            if (author.equalsIgnoreCase(dataScanner.next()) && author.equalsIgnoreCase(dataScanner.next()) ) {
                entry = dataScanner.nextInt();
            }

            data = bufferInput.readLine();
        }

        return entry;
    }

    private static void updateData() throws IOException{
        // ambil database original
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // buat database sementara
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        // tampilkan data
        System.out.println("List Buku");
        viewData();

        // ambil user input / pilihan data
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\nEnter book ID to be updated: ");
        int updateNum = terminalInput.nextInt();

        // tampilkan data yang ingin diupdate

        String data = bufferedInput.readLine();
        int entryCounts = 0;

        while (data != null){
            entryCounts++;

            StringTokenizer st = new StringTokenizer(data,",");

            // tampilkan entrycounts == updateNum
            if (updateNum == entryCounts){
                System.out.println("\nThe data you want to update is:");
                System.out.println("---------------------------------------");
                System.out.println("Referensi           : " + st.nextToken());
                System.out.println("ID                  : " + st.nextToken());
                System.out.println("Author              : " + st.nextToken());
                System.out.println("Category            : " + st.nextToken());
                System.out.println("Title               : " + st.nextToken());

                // mengambil input dari user

                String[] fieldData = {"id","author","category","title"};
                String[] tempData = new String[4];

                st = new StringTokenizer(data,",");
                String originalData = st.nextToken();

                for(int i=0; i < fieldData.length ; i++) {
                    boolean isUpdate = getYesorNo("do you want to change " + fieldData[i]);
                    originalData = st.nextToken();
                    if (isUpdate){
                        //user input

                         if (isUpdate){
                            terminalInput = new Scanner(System.in);
                            System.out.print("\nInsert new " + fieldData[i] + ":");
                            tempData[i] = terminalInput.nextLine();
                        }

                    } else {
                        tempData[i] = originalData;
                    }
                }

                // tampilkan data baru ke layar
                st = new StringTokenizer(data,",");
                st.nextToken();
                System.out.println("\nYour new data is ");
                System.out.println("---------------------------------------");
                System.out.println("ID                  : " + st.nextToken() + " --> " + tempData[0]);
                System.out.println("Author              : " + st.nextToken() + " --> " + tempData[1]);
                System.out.println("Category            : " + st.nextToken() + " --> " + tempData[2]);
                System.out.println("Title               : " + st.nextToken() + " --> " + tempData[3]);


                boolean isUpdate = getYesorNo("Are you sure you want to update the data?");

                if (isUpdate){

                    // cek data baru di database
                    boolean isExist = cekBukuDiDatabase(tempData,false);

                    if(isExist){
                        System.err.println("the book data already exists in the database, the update process is cancelled, \nPlease delete the data in question");
                        // copy data
                        bufferedOutput.write(data);

                    } else {

                        // format data baru kedalam database
                        String id = tempData[0];
                        String author = tempData[1];
                        String category = tempData[2];
                        String title = tempData[3];

                        // bikin primary key
                        long nomorEntry = ambilEntryPerTahun(author, id) + 1;

                        String punulisTanpaSpasi = author.replaceAll("\\s+","");
                        String primaryKey = punulisTanpaSpasi+"_"+id+"_"+nomorEntry;

                        // tulis data ke database
                        bufferedOutput.write(primaryKey + "," + id + ","+ author +"," + category + ","+title);
                    }
                } else {
                    // copy data
                    bufferedOutput.write(data);
                }
            } else {
                // copy data
                bufferedOutput.write(data);
            }
            bufferedOutput.newLine();

            data = bufferedInput.readLine();
        }

        // menulis data ke file
        bufferedOutput.flush();

        // delete original database
        database.delete();
        // rename file tempDB menjadi database
        tempDB.renameTo(database);

    }

    private static void deleteData() throws  IOException{
        // ambil database original
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // buat database sementara
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        // tampilkan data
        System.out.println("List Buku");
        viewData();

        // ambil user input untuk mendelete data
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\nEnter book ID to be deleted: ");
        int deleteNum = terminalInput.nextInt();

        // looping untuk membaca tiap data baris dan skip data yang akan didelete

        boolean isFound = false;
        int entryCounts = 0;

        String data = bufferedInput.readLine();

        while (data != null){
            entryCounts++;
            boolean isDelete = false;

            StringTokenizer st = new StringTokenizer(data,",");

            // tampilkan data yang ingin di hapus
            if (deleteNum == entryCounts){
                System.out.println("\nThe data you want to delete is::");
                System.out.println("-----------------------------------");
                System.out.println("Reference      : " + st.nextToken());
                System.out.println("ID             : " + st.nextToken());
                System.out.println("Author         : " + st.nextToken());
                System.out.println("Category       : " + st.nextToken());
                System.out.println("Title          : " + st.nextToken());

                isDelete = getYesorNo("Are you sure you want to delete the data?");
                isFound = true;
            }

            if(isDelete){
                //skip pindahkan data dari original ke sementara
                System.out.println("Data deleted susscessfully");
            } else {
                // kita pindahkan data dari original ke sementara
                bufferedOutput.write(data);
                bufferedOutput.newLine();
            }
            data = bufferedInput.readLine();
        }

        if(!isFound){
            System.err.println("Buku not found");
        }

        // menulis data ke file
        bufferedOutput.flush();
        // delete original file
        database.delete();
        // rename file sementara ke database
        tempDB.renameTo(database);

    }

    private static boolean cekBukuDiDatabase(String[] keywords, boolean isDisplay) throws IOException{

        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        String data = bufferInput.readLine();
        boolean isExist = false;
        int nomorData = 0;

        if (isDisplay) {
            System.out.println("|\tID                                   |\tAuthor                 |\tCategory               |\tBook Title");
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }

        while(data != null){

            // cek keywords didalam baris
            isExist = true;

            for(String keyword:keywords){
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
            }

            // jika keywordsnya cocok maka tampilkan

            if(isExist){
                if(isDisplay) {

                    StringTokenizer stringToken = new StringTokenizer(data, ",");

                    stringToken.nextToken();

                    System.out.printf("|\t%4s  ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%s   ", stringToken.nextToken());
                    System.out.print("\n");
                } else {
                    break;
                }
            }

            data = bufferInput.readLine();
        }

        if (isDisplay){
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }

        return isExist;
    }

    private static boolean getYesorNo(String message){
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n"+message+" (y/n)? ");
        String pilihanUser = terminalInput.next();

        while(!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.err.println("Your choice is not y or n");
            System.out.print("\n"+message+" (y/n)? ");
            pilihanUser = terminalInput.next();
        }

        return pilihanUser.equalsIgnoreCase("y");

    }

}