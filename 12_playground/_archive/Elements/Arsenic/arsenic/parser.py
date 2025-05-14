'''
Created on Nov 12, 2019

@author: froske
'''
from bs4 import BeautifulSoup
import sys

def parse_file():
    try:    
        filename = sys.argv[1]
    except: 
        filename = '/home/froske/Workspaces/SafariBooks/DownloadTests/script/library/view/kanban-in-action/9781617291050/kindle_split_017.html'

    file = open(filename) 
    soup = BeautifulSoup(file, 'html.parser')

    print(soup.prettify())

if __name__ == '__main__':
    parse_file()