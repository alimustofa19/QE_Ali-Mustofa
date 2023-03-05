# **Agile Testing**
# Rangkuman Ini Berisi:
1. Definisi SDLC
2. Fase SDLC
3. Agile Testing Manifesto
4. Testing Pyramid
# Definisi SDLC
SDLC (Software Development Life Cycle) Merupakan proses yang digunakan untuk merancang, mengembangakan dan menguji software berkualitas tinggi. Tujuannya untuk menyediakan alur terstruktur dalam membantu oragnisasi menghasilkan software berkualitas tinggi yang diselesaikan dengan perkiraan waktu yang singkat dan biaya yang lebih rendah, namun tetap memenuhi harapan pelanggan.
# Fase SDLC
1. Requirements Gathering. Pada tahap ini sistem akan dianalis bagaimana akan dijalankan nantinya, hasil analisis berupa kelebihan dan kekurangan sistem, hingga pembaharuan yang dapat dterapkan. Bagian ini termasuk bagian perencanaan.
2. Design
Tahap design pada SDLC adalah tahap membuat model cara kerja aplikasi/software.
3. Development. Pada fase ini program mulai dikerjakan oleh developer, biasanya kalau program/projecnya kecil bisa dikerjakan oleh 1 developer, jika program/projectnya besar bisa dipecah dikerjakan oleh beberapa tim.
4. Testing. Pada fase testing sistem harus dijalankan untuk mencoba apakah sistem yang telah dikembangkan/dibuat dapat berkerja optimal atau tidak.
5. Deployment. Pada fase ini aplikasi sudah tersedia pada user untuk digunakan
6. Maintenance. Pada fase ini aplikasi sudah selesai dan sudah bisa digunakan dilapangan, namun tahapan ini pengguna bisa jadi menemukan bug selama pengujian sehingga permasalahan perlu diatasi.
# Agile Testing Manifesto
Beberapa hal yang jauh dari agile testing manifesto:
* Testing always behind
* Automation is even further behnd that
tester can't work until development is done
* There is pressure at the end of a sprint
* There is blame arround bug (it's his fault etc.)
## 5 Kunci Dalam Agile Testing Manifesto
1. Testing is an Activity, no a Phase. Software Tester disarankan untuk melakukan testing secara beriringan dengan proses development.
2. Prevent bugs rather than finding bug. Lebih fokus mecegah munculnya bug daripada menemukan bugs.
3. Don't be checker, be a tester. Sebagai seorang tester jangan cuma melakukan testing tapi juga harus memberikan improvment/masukan yang di tes.
4. Dont' try to break the system, instead help build the best possible sysem. Seorang QE harus memposisikan dirinya sebagai user dan menilai product dari sudut pandang pengguna sehingga dapat memberikan masukan kepada developer.
5. The whole team is responsible for quality, not just the tester. Semua anggota tim bertanggung jawab berlandaskan product yang dibangun.
# Testing Pyramid
* Unit Test adalah level yang paling bawah dalam testing pyramid. Unit test merupakan pengujian pengkat lunak yang menguji setiap unit atau komponen dari sebuah perngkat lunak saat sedang dalam pengembangan tim developer.
* Integration Testing adalah pengujian dari hasil pengujian unit-unit yang ada didalam software.
* UI adalah yang paling dekat dengan interaksi pengguna di device apapun, user input harus memicu tindakan yang tepat, status UI harus berubah seperti yang diharapkan. Ini adalah testing tingkat tertinggi dengan menggunakan framework/tools.