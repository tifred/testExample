#!/usr/bin/python
# -*- coding: UTF-8 -*-

import unittest 
import os #to read enviroment variables
from selenium import webdriver

class PythonTest(unittest.TestCase):
    def setUp(self):
# Setting the desired_capabilities as indicated in https://saucelabs.com/platforms
        self.desired_capabilities = webdriver.DesiredCapabilities.IPHONE
        self.desired_capabilities['platform'] = 'OS X 10.9'
        self.desired_capabilities['version'] = '7.0'
        self.desired_capabilities['deviceName'] = 'iPhone'
        self.desired_capabilities['device-orientation'] = 'portrait'
        self.desired_capabilities['name'] = 'Mobile iOS Test with device iPhone 7.0'

#Retreiving enviroment variables
        SAUCE_USERNAME = os.environ.get('SAUCE_USERNAME')
        SAUCE_ACCESS_KEY = os.environ.get('SAUCE_ACCESS_KEY')

#Accessing the Sauce Labs Cloud
        self.driver = webdriver.Remote(command_executor = ('http://' + SAUCE_USERNAME + ':' + SAUCE_ACCESS_KEY + '@ondemand.saucelabs.com:80/wd/hub'), desired_capabilities = self.desired_capabilities)
        self.driver.implicitly_wait(30)    

    def test_sauce(self):
        self.driver.get('http://www.google.com')
        title = self.driver.title
        self.assertEquals("Google", title)

    def tearDown(self):
        print("Link to your job: https://saucelabs.com/jobs/%s" % self.driver.session_id)
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()

