# selenium-jquery-layout-issue

This module contains one unit test which tries to click a button in the center pane of a JQuery-layout based HTML page. You can find the page here: https://olibutzki.github.io/selenium-jquery-layout-issue/sample.html

The test runs multiple times with different Firefox window heights (from 650px up to 800px). There are two tests which fail on my machine: 698px and 699px. On another machine (Debian) it fails with a window height of 677px and 690px. Maybe on other environment the test fails at other heights, so I added an option to specify the minimum and maximum height which is tested.


## Example
Just execute with Maven:
```
mvn clean test
```

This runs the test 151 times, starting with a browser window height of 650px and ending up in browser window height of 800px. You can adjust the minimum and maximum height by passing the system properties *minheight* and *maxheight*.
```
mvn clean test -Dminheight=600 -Dmaxheight=900
```
This runs the test 301 times, starting with a browser window height of 600px and ending up in browser window height of 900px.
