#!/bin/sh
echo "Selamat Datang"
read -p "Tambahkan pilihan buku: " pilihan
echo "$pilihan" >> pilihan.txt
clear
echo "$pilihan telah ditambahkan kedalam list"
echo "=========="
cat pilihan.txt
echo "=========="
echo "Kembali lagi ya"
sleep 5
