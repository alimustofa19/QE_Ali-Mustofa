# **ITERABLE & MAP DATA STRUCTURE**
# Rangkuman Ini Berisi:
1. Pengertian Iterable
2. Java Iterable Hirarchy Interface 
3. Pengertian Map
4. Implementasi Map
# Pengertian Iterable
Iterable merupakan sekumpulan data atau structure data yang dapat dilakukan itersi atau perulangan kepadanya.
# Java Iterable Hirarchy Interface 
Interface iterable menjadi interface tertinggi dari interface lainnya. Dibawah interface iterable ada interface collection, kemudian dibawah interface collection ada interface set, list dan queue. DIbawah interface set ada sortedset, navigableset. Kemudian dibawah queue ada deuqe, blockingqueue, blockingdeque dan transferqueue. Semua interface tersebut merupakan structure data yang dapat dilakukan perulangan terhadap masing-masing data yang disimpan.
## Iterator 
Iterator merupakan class yang memenage iterasi dari sebuah iterable, irerator mengelola pada bagian nama kita sudah melakukan iterasi pada data iterable dan mengetahui data apa yang berikutnya dapat diambil dan bagaimana cara mengambilnya.
## Collection 
Collection merupakan kumpulan dari object atau data yang diletakan dalam atu tempat yang sama dan ini dekanal sebagai collection of the object.
## List 
List merupakan sebuah interface yang menyediakan cara untuk menyimpan data secara linear. List merupakan tururnan dari interface collection, kemudain list juga dapat menerima nilai yang sama, urutan data pada list tergantung kapan data dimasukan didalam list.
## Array List
Array list menyediakan penyimpanan data yang dinamis (tidak terikat kapasitas data yang disimpan oleh array list tersebut).
## Linked List
Linked list merupakan stucture data yang menyimpan setiap elemennya saling terhubung satu sama lain. Cara linked list menghubungkan satu elemen ke elemen yang lainnya adalah dengan menyimpan alamat memori dari masing - masing elemen baik elemen sebelum atau setelahnya.
## Immutable List
Immutable list merupakan bagia dari list tetapi immutable list tidak dapat diubah datanya.
## Stack
Stack dapat menyimpan data secara linear tetapi dalam proses penambahan dan pengambilan datanya menggunakan LIFO (Last In First Out).
## Set
Set merupakan sebuah strukture data yang dapat menyimpan sekumpulan data secara linear tetapi set tidak dapat menerima data yang duplikat.
## HashSet
* HashSet hanya berisi element yang unik 
* HashSet mengizinkan nilai yang null.
* Hasheset adalah alat terbaik untuk mencari data
## LinkedHasSet
* Menyimpan insertion order
* LinkedHasSet hanya berisi elemen yang unik
## EnumSet
* EnumSet digunakan untuk menyimpan nilai enum
* Tidak mengizinkan untuk menambah null value
## SortedSet
SortedSet dapat melola urutan dari data.
## Queue
Queue mengimpementasi mekanisme FIFO (First In First Out).
## Deque
Deque merupakan sebuah queue tetapi memiliki 2 ujung.
# Pengertian Map
Map merupakan stucuture data yang ada di java yang dapat digunakan untuk menyimpan banyak data didalamnya. Data-data yang tersimpan didalam map diidentifikasi menggunakan key dan setiap key mempunyai datanya sendiri yang disebut value.
# Implementasi Map
1. HashMap merupakan implementasi dari map yang menggunakan algoritma structure data hashtable.
2. WeaksHashMap masih menggunakan hashtable tetapi bedanya pada bagian WeakHashMap key dapat dihilangkan jika sudah tidak lagi digunakan.
3. IdentityHashMap menggunakan hashtable tetapi jika key memiliki referensi pada memori yang berbeda maka akan dianggap sebagai data yang berbeda.
4. LinkedHashMap. Pada LinkedHashMap tidak ada perbedaan yang signifikan dengan hashmap biasa, tetapi secara internal LinkedHashMap menerapkan doublylinklist dan juga hashtable sebagai stucture data didalam mapnya.
5. Immutable Map. Map dalam bentuk ini tidak dapat diubah isinya.
6. Sorted Map. Map ini dapat mengurutkan secara asscanding maupun descanding.
7. Navigable Map. Navigable map masih termasuk dalam sorted map tetapi dengan method-method untuk menavigasi yang lebih lengkap mulai dari key yang paling rendah hingga key yang paling tinggi, lalu key paling dan juga key paling akhir.
