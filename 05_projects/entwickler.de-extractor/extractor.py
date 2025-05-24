import requests
from bs4 import BeautifulSoup
import os
import re
import urllib.parse

# You'll need to add your session cookies here after logging in
headers = {
    'User-Agent': 'Mozilla/5.0',
    'Cookie': 'YOUR_SESSION_COOKIE_HERE'
}

def download_article(url, output_dir):
    # Create output directory
    os.makedirs(output_dir, exist_ok=True)
    
    # Get the article page
    response = requests.get(url, headers=headers)
    soup = BeautifulSoup(response.text, 'html.parser')
    
    # Extract article content - adjust selectors based on entwickler.de's structure
    title = soup.select_one('h1.article-title').text.strip()
    content = soup.select_one('div.article-content')
    
    # Download images
    for img in content.find_all('img'):
        if img.get('src'):
            img_url = img['src']
            if not img_url.startswith('http'):
                img_url = urllib.parse.urljoin(url, img_url)
            
            img_filename = os.path.basename(img_url).split('?')[0]
            img_path = os.path.join(output_dir, img_filename)
            
            with open(img_path, 'wb') as img_file:
                img_response = requests.get(img_url, headers=headers)
                img_file.write(img_response.content)
            
            # Update image src to local path
            img['src'] = img_filename
    
    # Save as HTML
    html_path = os.path.join(output_dir, 'article.html')
    with open(html_path, 'w', encoding='utf-8') as f:
        f.write(f"<html><head><title>{title}</title></head><body>")
        f.write(f"<h1>{title}</h1>")
        f.write(str(content))
        f.write("</body></html>")
    
    return html_path

# Example usage
article_url = "https://entwickler.de/your-article-url"
output_path = download_article(article_url, "./downloaded_article")
print(f"Article saved to {output_path}")
