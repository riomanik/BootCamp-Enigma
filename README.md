# riomanik-academy

# Servlet & JSP

## Apa itu Servlet ?
>  Servlet = Server Applet = Server Java Applet = Server Java Application.

> Servlet adalah File Java yang berjalan di server supaya bisa menyisipkan HTML untuk response. 

> Bisa kasih fungsi di html.
> Dinami


## Apa itu JSP ?
> Java Server Page, html dibungkus java 

## Generate Project

Generate Project melalui Command Prompt

    mvn archetype:generate -DartifactId=tutorial-javaweb-app -DgroupId=software.webb.app -DarchetypeCatalog="internal"

## Build di Terminal
    mvn clean package
* di folder target ada WAR
> masuk ke C:\xampp\tomcat\bin> 

## Klik 2x Startup

> tunggu sampai ada tulisan "Server Startup"

## Buka Google Chrome
##  masuk ke localhost:8080
## baca dulu pelan - pelan
## cari Manager App
    username : tomcat, password : s3cret
> masuk ke C:\xampp\tomcat\conf\ pakai Windows+E

> buka tomcat-users.xml menggunakan text editor

## find "tomcat-users"

    masukkan script berikut
    <role rolename="manager-gui"/>
    <user username="tomcat" password="s3cret" roles="manager-gui"/>

# restart tomcat, tunggu sampai "Server Startup"

> *reload page, masuk ke manager app*


    Pilih file .war yang tadi dibuat di dalam target

> # deploy


## Applications, under /manager is your project

> Klik kanan, open link in new tab

    mvn clean package lagi di editor

kembali ke browser, 

masuk ke manager

deploy ulang project barusan

    sudah berubah ?

> tambahkan tulisannya

## Deploy Ulang - Melalui Command Prompt

    mvn clean package tomcat:run
> tunggu hingga ada respon seperti ini, itu adalah alamat yang harus dimasukkan ke browser

> [INFO] Running war on http://localhost:8080/tutorial-javaweb-app

## error

    HTTP STATUS 500- Unable to compile class for JSP:
## note
> note The full stack trace of the root cause is 

## error
    available in the Apache Tomcat/6.0.29 logs.

## Googling
    search di google maven-plugin-tomcat7

> baca pelan - pelan

    cari Usage Page dari tomcat.apache.org

> Using a different Tomcat manager URL

## End 
> buka editor

> buat plugins  tanpa configuration
https://tomcat.apache.org/maven-plugin-2.0/tomcat7-maven-plugin/usage.html

>## mvn clean package tomcat7:







