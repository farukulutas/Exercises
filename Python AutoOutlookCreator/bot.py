import pyautogui as auto
import time, keyboard, random, win32api, win32con, webbrowser, names

# to get the positions x,y
# X:  884 Y:  891 RGB: ( 25,  35,  45)
# X:  774 Y:  895 RGB: (255, 255, 255)
#X:  881 Y:  853 RGB: (255, 159,  67)
#auto.displayMousePosition()

def click(x,y):
    time.sleep(5)
    win32api.SetCursorPos((x,y))
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN,0,0)
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP,0,0)
    
def rightClick(x,y):
    time.sleep(5)
    win32api.SetCursorPos((x,y))
    win32api.mouse_event(win32con.MOUSEEVENTF_RIGHTDOWN,0,0)
    win32api.mouse_event(win32con.MOUSEEVENTF_RIGHTUP,0,0)
    
def doubleClick(x,y):
    win32api.SetCursorPos((x,y))
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN,0,0)
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP,0,0)
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN,0,0)
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP,0,0)
    
def saveEmail(fileName, textToAppend):
    """Append given text as a new line at the end of file"""
    # Open the file in append & read mode ('a+')
    with open(fileName, "a+") as fileObject:
    # Move read cursor to the start of file.
        fileObject.seek(0)
        # If file is not empty then append '\n'
        data = fileObject.read(100)
        if len(data) > 0:
            fileObject.write("\n")
        # Append text at the end of file
        fileObject.write(textToAppend)

def createEmail():
    while keyboard.is_pressed('q') == False:
        webbrowser.open("https://outlook.live.com/owa/")
        #Ücretsiz Hesap Oluşturun X: 1268 Y:  910 RGB: (231, 255, 255)
        click(1268, 910)
        #Yeni e-posta X:  768 Y:  537 RGB: (255, 255, 200)
        click(768, 537)
        name = names.get_full_name()
        name = name.lower()
        first, last = name.split()
        name = name.replace(" ", "") + str(random.randint(10000,100000))
        #Yeni e-posta pyautogui.typewrite(name)
        auto.typewrite(name)
        #İleri X: 1098 Y:  696 RGB: (  0,  93, 215)
        click(1098, 696)
        #Parola Oluşturun X:  770 Y:  527 RGB: (102, 147, 200)
        click(770, 527)
        password = "password"
        #Parola oluşturun pyautogui.typewrite(password)
        auto.typewrite(password)
        #İleri X: 1092 Y:  801 RGB: (  0,  93, 166)
        click(1092, 801)
        #Ad X:  770 Y:  609 RGB: (255, 255, 255)
        click(770, 609)
        #Ad pyautogui.typewrite(first)
        auto.typewrite(first)
        #Soyadı X:  769 Y:  678 RGB: ( 58,  66,  74)
        click(769, 678)
        #Soyadı pyautogui.typewrite(last)
        auto.typewrite(last)
        #İleri X: 1103 Y:  741 RGB: (  0, 153, 227)
        click(1103, 741)
        #Gün X:  786 Y:  713 RGB: (238, 238, 238)
        click(786, 713)
        #Gün seç X:  786 Y:  664 RGB: (255, 255, 255)
        click(786, 664)
        #Ay X:  931 Y:  712 RGB: (255, 255, 255)
        click(931, 712)
        #Ay seç X:  939 Y:  663 RGB: (224, 185, 121)
        click(939, 663)
        #Yıl X: 1050 Y:  709 RGB: (255, 255, 255)
        click(1050, 709)
        auto.typewrite("1990")
        #İleri X: 1101 Y:  777 RGB: ( 95,  93, 166)
        click(1101, 777)
        
        # RECAPTCHA CASE
        #Sonraki X: 1059 Y:  719 RGB: (  0,  93, 166)
        #click(1059, 719)
        
        # PHONE NUMBER CASE
        #Telefon Numarası X:  771 Y:  726 RGB: (255, 255, 255)
        click(771, 726)
        no = "555555555"
        #Telefon Numarası pyautogui.typewrite(no)
        auto.typewrite(no)
        #Kodu Gönder X:  906 Y:  781 RGB: (  0,  93, 166)
        click(906, 781)
        
        # GETTING CODE FROM USER CASE
        #Time for enter the code
        #time.sleep(60)
        #code = input("Enter the code:" )
        #Erişim kodunu girin X:  774 Y:  825 RGB: (255, 255, 255)
        #click(774, 825)
        #Erişim kodunu girin pyautogui.typewrite(code)
        #pyautogui.typewrite(code)
        
        # GETTING CODE FROM GOOGLE MESSAGES APP
        #open messages tab X:  113 Y:   25 RGB: (255, 255, 255)
        click(113, 25)
        #pick the MICROSOFT X:  243 Y:  357 RGB: (241, 243, 244)
        click(243, 357)
        #select the code X:  882 Y:  870 RGB: (242, 242, 242)
        doubleClick(882, 870)
        #options RIGHT CLK X:  880 Y:  861 RGB: (182, 203, 238)
        rightClick(880,861)
        #copy the text X:  925 Y:  555 RGB: (224, 224, 230)
        click(925, 555)
        #open mail tab X:  399 Y:   23 RGB: (120, 120, 120)
        click(399, 23)
        #click area X:  774 Y:  825 RGB: (255, 255, 255)
        click(774, 825)
        #settings RIGHT CLK
        rightClick(774,825)
        #paste the code X:  827 Y:  599 RGB: (224, 224, 230)
        click(827, 599)
        #İleri X: 1095 Y:  897 RGB: (  0,  93, 166)
        click(1095,897)
        
        #Hayır X:  955 Y:  710 RGB: (178, 178, 178)
        click(955, 710)
        click(955, 710)
        click(955, 710)
        #Profile X: 1887 Y:  162 RGB: (  0,  90, 158)
        click(1887, 162)
        #Oturumu Kapat X: 1817 Y:  229 RGB: ( 16,  16,  16)
        click(1817, 229)
        # save the created email to emails.txt
        name = name + "@outlook.com"
        saveEmail( "emails.txt", name)
        
#createEmail()
while (True):
    click(721,941)
    click(859,953)
    
#click(1912,175)