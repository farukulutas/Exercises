#!/usr/bin/env python
# coding: utf-8

# In[1]:


import requests
import validators
from bs4 import BeautifulSoup as bs
from urllib.parse import urljoin
from pprint import pprint


# In[2]:


# HTTP oturumu oluşturma ve tarayıcı ayarlama
session = requests.Session()
session.headers["User-Agent"] = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:91.0) Gecko/20100101 Firefox/91.0"


# In[3]:


# Sitedeki bütün formları toplamak için
def getAllForms(url):
    """Verilen url'deki HTML'den formlar getirildi."""
    soup = bs(session.get(url).content, "html.parser")
    return soup.find_all("form")


# In[4]:


# Formlardaki sql tespiti için faydalı bilgileri toplamak için
def getFormDetails(form):
    """Formlardaki sql tespiti için faydalı bilgiler toplandı."""
    details = {}
    # Formları toplama
    try:
        action = form.attrs.get("action").lower()
    except:
        action = None
    # Formdaki get metodlarını toplama
    method = form.attrs.get("method", "get").lower()
    # Metodlardaki type ve value değeri olan bütün satırları toplama
    inputs = []
    for input_tag in form.findAll("input"):
        input_type = input_tag.attrs.get("type", "text")
        input_name = input_tag.attrs.get("name")
        input_value = input_tag.attrs.get("value", "")
        inputs.append({"type": input_type, "name": input_name, "value": input_value})
    # Sonuçlar details dictionary'sine eklenir
    details["action"] = action
    details["method"] = method
    details["inputs"] = inputs
    return details


# In[5]:


def isVulnerable(response):
    """Basit bir boolean fonksiyonu ile response'daki hataya göre zafiyeti belirleme"""
    errors = {
        # MySQL
        "you have an error in your sql syntax;",
        "SQL syntax.*MySQL",
        "Warning.*mysql_.*",
        "MySQL Query fail.*",
        "SQL syntax.*MariaDB server",
        "warning: mysql",
        # Microsoft SQL Server
        "OLE DB.* SQL Server",
        "(\W|\A)SQL Server.*Driver",
        "Warning.*odbc_.*",
        "Warning.*mssql_",
        "Msg \d+, Level \d+, State \d+",
        "Unclosed quotation mark after the character string",
        "Microsoft OLE DB Provider for ODBC Drivers",
        # Oracle
        "quoted string not properly terminated",
        "\bORA-[0-9][0-9][0-9][0-9]",
        "Oracle error",
        "Warning.*oci_.*",
        "Microsoft OLE DB Provider for Oracle",
        # PostgreSQL
        "PostgreSQL.*ERROR",
        "Warning.*\Wpg_.*",
        "Warning.*PostgreSQL",
        # Microsoft Access
        "Microsoft Access Driver",
        "Access Database Engine",
        "Microsoft JET Database Engine",
        ".*Syntax error.*query expression",
        # IBM DB2
        "CLI Driver.*DB2",
        "DB2 SQL error",
        # SQLite
        "SQLite/JDBCDriver",
        "System.Data.SQLite.SQLiteException",
        # Informix
        "Warning.*ibase_.*",
        "com.informix.jdbc",
        # Sybase
        "Warning.*sybase.*",
        "Sybase message",
    }
    for error in errors:
        # Bu hatalardan birini bulduysan return True
        if error in response.content.decode().lower():
            return True
    # Hata bulunamadıysa return False
    return False


# In[6]:


def scanSqlInjection(url):
    # test on URL
    for c in "\"'":
        # URL'ye tırnak işareti ekleme
        newUrl = f"{url}{c}"
        print("[!] İnceleniyor...", newUrl)
        # HTTP isteiğini gönderme
        res = session.get(newUrl)
        if isVulnerable(res):
            # SQL bulundu, raporla
            print("[+] SQL Enjeksiyonu Zafiyeti Bulundu, link:", newUrl)
            return
    # HTML formlarını test et
    forms = getAllForms(url)
    print(f"[+] Bulundu {len(forms)} formları üzerinde {url}.")
    for form in forms:
        formDetails = getFormDetails(form)
        for c in "\"'":
            # eklemek istediğimiz data
            data = {}
            for input_tag in formDetails["inputs"]:
                if input_tag["type"] == "hidden" or input_tag["value"]:
                    # formları body'de kullan
                    try:
                        data[input_tag["name"]] = input_tag["value"] + c
                    except:
                        pass
                elif input_tag["type"] != "submit":
                    # submit dışındakilere çöp veri ata
                    data[input_tag["name"]] = f"test{c}"
            # url'ye ekle
            url = urljoin(url, form_details["action"])
            if formDetails["method"] == "post":
                res = s.post(url, data=data)
            elif formDetails["method"] == "get":
                res = s.get(url, params=data)
            # sitede zafiyet olup olmadığını test et
            if isVulnerable(res):
                print("[+] SQL Enjeksiyonu Zafiyeti Bulundu, link:", url)
                print("[+] Form:")
                pprint(formDetails)
                break


# In[ ]:


if __name__ == "__main__":
    # Örnek URL: http://testphp.vulnweb.com/artists.php?artist=1
    # Örnek Dosya: C:\Users\Faruk\Desktop\test.txt
    inp = 0
    while inp != 4:
        print("1-Sitede SQL Açığı Ara\n2-Toplu SQL Açığı Ara\n3-SQL Açığı Nasıl Önlenir\n4-Çıkış")
        inp = int(input ("Seçenek numarasını giriniz:"))
        if ( inp == 1 ):
            url = input ("Geçerli bir url giriniz:")
            if ( validators.url(url) ):
                scanSqlInjection(url)
            else:
                print("Lütfen geçerli bir url giriniz!\n")
        elif ( inp == 2 ):
            pathToFile = input("Geçerli bir dosya yolu giriniz:")
            with open(pathToFile) as f:
                for line in f:
                    scanSqlInjection(line)
        elif ( inp == 3 ):
            print("\nEnjeksiyonun önlenmesi için verilerin komutlardan ve sorgulardan ayrı tutulması gerekir.\nTercih edilen seçenek, yorumlayıcı kullanımını tamamen önleyen veya parametreli bir arabirim sağlayan güvenli bir API kullanmak veya Nesne İlişkisel Eşleme Araçlarını (ORM'ler) kullanmaya geçiş yapmaktır.\nPozitif veya beyaz liste sunucu tarafı giriş doğrulaması kullanın.\nPek çok uygulama, metin alanları veya mobil uygulamalar için API'ler gibi özel karakterler gerektirdiğinden, bu tam bir savunma değildir. Herhangi bir artık dinamik sorgu için, o yorumlayıcıya özel kaçış sözdizimini kullanarak özel karakterlerden kaçın.\nSQL enjeksiyonu durumunda kayıtların toplu olarak ifşa edilmesini önlemek için sorgularda LIMIT ve diğer SQL kontrollerini kullanın.\n")

