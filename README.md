# hw305
Clock Shop

Assignment Overview:
This assignment is about creating two classes, Clock and ClockShop, to practice object-oriented programming and things like handling errors, managing time, and sorting objects.
The Clock class represents a digital clock that tracks hours, minutes, and seconds. You'll write two constructors—one that sets the clock to 23:58:00 by default, and another that lets you pass in specific hour, minute, and second values. You'll also need to add methods to get and set each part of the time, but you have to ensure the values are within the proper ranges (hours from 0 to 23, for example). If they're not, you throw an error. There's also functionality to advance the time, and you'll override toString() to display the time in a "hh:mm:ss"format. Finally, you'll add equals() and compareTo() methods so that clock objects can be compared and checked for equality.
The ClockShop class is all about managing a list of clocks. It uses an ArrayList to store multiple Clock objects and has methods to load clocks from a file, search for specific clocks, sort them by time, and access or replace clocks by their index in the list. Also we need to write the clock data to a file and return a string that shows all the clocks in the shop.
This assignment involves working with classes and objects, handling files, and ensuring you can compare and sort custom objects. It's a good way to practice organizing your code and using object-oriented principles like encapsulation and modular design.
