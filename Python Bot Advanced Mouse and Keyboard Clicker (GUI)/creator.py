import tkinter as tk
import pyautogui as auto
import names, random, win32api, win32con, json, time

root = tk.Tk()
root.title('Creator Bot')
root.geometry("400x750")

#Create frame and scrollbar
my_frame = tk.Frame(root)
my_scrollbar = tk.Scrollbar(my_frame, orient=tk.VERTICAL)

#Listbox!
#Single, Browse, Multiple, Extended can set it for, when deleting making a list
my_listbox = tk.Listbox(my_frame, width = 50, yscrollcommand=my_scrollbar.set, selectmode=tk.MULTIPLE)

#configure scrollbar
my_scrollbar.config(command=my_listbox.yview)
my_scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
my_frame.pack()
my_listbox.pack(pady=15)

#Add list of items
pos = 0
fullName = ""
name = ""
my_list = []
pos_list = []

def saveNick(fileName, textToAppend):
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

def delete_all():
    my_list.clear()
    pos_list.clear()
    global pos
    pos = 0
    update()

def add_left_click():
    get_position()
    update()
    
def get_position():
    auto.sleep(5)
    tuple1 = auto.position()
    my_list.append(tuple1.x)
    my_list.append(tuple1.y)
    global pos
    pos_list.append(pos)
    pos = pos + 2

def add_username():
    global fullName
    global name
    name = names.get_full_name()
    fullName = name
    name = name.lower()
    name = name.replace(" ", "") + str(random.randint(10000,100000))
    my_list.append(name)
    global pos
    pos_list.append(pos)
    pos = pos + 1
    update()
    
def add_password():
    my_list.append("password")
    global pos
    pos_list.append(pos)
    pos = pos + 1
    update()

def add_answer():
    getTextInput()
    update()
    
def getTextInput():
    result=inputtxt.get("1.0","end")
    my_list.append(result)
    global pos
    pos_list.append(pos)
    pos = pos + 1
    
def update():
    my_listbox.delete(0, tk.END)
    for item in my_list:
        my_listbox.insert(tk.END, item)
        
def add_full_name():
    my_list.append(fullName)
    global pos
    pos_list.append(pos)
    pos = pos + 1
    update()

def click(x,y):
    auto.sleep(3)
    win32api.SetCursorPos((x,y))
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN,0,0)
    auto.sleep(0.1)
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP,0,0)
    
def updateNick():
    longest = ""
    index = 0
    global name, fullName
    for i in my_list:
        if ( type(i) is str ):
            if ( len(longest) < len(i) and i == i.lower() ):
                longest = i
                index = my_list.index(i)
    name = names.get_full_name()
    fullName = name
    name = name.lower()
    name = name.replace(" ", "") + str(random.randint(10000,100000))
    my_list[index] = name
    
def run():
    flag = False
    global name
    while True:
        for i in my_list:
            if (flag):
                flag = False
                continue
            
            if ( type(i) is int ):
                index = my_list.index(i)
                click( i, my_list[index+1])
                flag = True
            else:
                if ( i == "ctrlv"):
                    auto.hotkey('ctrl', 'v')
                elif (i == "scroll"):
                    time.sleep(5)
                    auto.scroll(1000000000)
                else:  
                    auto.typewrite(i)
        saveNick( "nicks.txt", name)
        updateNick()
        auto.sleep(10)
        
def add_ctrl_v():
    my_list.append("ctrlv")
    global pos
    pos_list.append(pos)
    pos = pos + 1
    update()
    
def save_script():     
    with open('script.txt', 'w') as filehandle:
        json.dump(my_list, filehandle)
    
def read_from_script():
    global my_list
    with open('script.txt', 'r') as filehandle:
        my_list = json.load(filehandle)
    updateNick()
    update()

my_button2 = tk.Button(root, text="Delete All", command=delete_all)
my_button2.pack(pady=5)

my_button3 = tk.Button(root, text="Add Left Click", command=add_left_click)
my_button3.pack(pady=5)

my_button11 = tk.Button(root, text="Add Username", command=add_username)
my_button11.pack(pady=5)

my_button10 = tk.Button(root, text="Add Full Name", command=add_full_name)
my_button10.pack(pady=5)

my_button5 = tk.Button(root, text="Add Password", command=add_password)
my_button5.pack(pady=5)

# TextBox Creation
inputtxt = tk.Text(root, height = 1, width = 30)
inputtxt.pack()

my_button6 = tk.Button(root, text="Add Answer", command=add_answer)
my_button6.pack(pady=5)

my_button12 = tk.Button(root, text="Add CTRL+V", command=add_ctrl_v)
my_button12.pack(pady=5)

my_button6 = tk.Button(root, text="RUN", command=run)
my_button6.pack(pady=5)

my_button13 = tk.Button(root, text="SAVE SCRIPT", command=save_script)
my_button13.pack(pady=5)

my_button14 = tk.Button(root, text="READ FROM SCRIPT", command=read_from_script)
my_button14.pack(pady=5)

root.mainloop()