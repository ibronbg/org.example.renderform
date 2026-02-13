Steps to reproduce the JavaScript error in Mojarra:
* Click on the 'Click Me' link -> Log output in server 'BUTTON: Click Me'
* Enter something in 'Field A' and leave the field
* Then click on the 'Click Me' link and the error message will be displayed in the browser console

If you then click on one of the navigation links, myMenuForm is re-rendered (commandLinks in navigation have a render="myMenuForm") and the commandLink works again.

