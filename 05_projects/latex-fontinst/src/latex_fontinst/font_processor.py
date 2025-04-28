"""
Module for processing OTF font files and converting them to TeX-compatible formats.
"""
import os
import shutil
import subprocess
from pathlib import Path
from typing import Dict, List, Optional, Tuple

try:
    import fontTools.ttLib as ttLib
except ImportError:
    print("Warning: fontTools not installed. Some functionality may be limited.")
    ttLib = None


class FontProcessor:
    """
    Class for processing OTF font files and generating TeX-compatible files.
    """
    
    def __init__(self, verbose: bool = False):
        """
        Initialize the font processor.
        
        Args:
            verbose: Whether to print verbose output
        """
        self.verbose = verbose
    
    def process_font(self, font_path: str, output_dir: str) -> bool:
        """
        Process a single OTF font file and generate TeX-compatible files.
        
        Args:
            font_path: Path to the OTF font file
            output_dir: Directory where generated files will be saved
            
        Returns:
            True if processing was successful, False otherwise
        """
        try:
            # Extract font information
            font_info = self._extract_font_info(font_path)
            if not font_info:
                return False
            
            # Create output directories
            font_name = font_info['family_name'].replace(' ', '')
            texmf_dir = os.path.join(output_dir, 'texmf')
            
            # Create TeX Live directory structure
            tfm_dir = os.path.join(texmf_dir, 'fonts', 'tfm', font_name)
            map_dir = os.path.join(texmf_dir, 'fonts', 'map', 'dvips', font_name)
            type1_dir = os.path.join(texmf_dir, 'fonts', 'type1', font_name)
            enc_dir = os.path.join(texmf_dir, 'fonts', 'enc', font_name)
            sty_dir = os.path.join(texmf_dir, 'tex', 'latex', font_name)
            
            os.makedirs(tfm_dir, exist_ok=True)
            os.makedirs(map_dir, exist_ok=True)
            os.makedirs(type1_dir, exist_ok=True)
            os.makedirs(enc_dir, exist_ok=True)
            os.makedirs(sty_dir, exist_ok=True)
            
            # Generate TFM, MAP, and TEX files
            self._generate_tfm_file(font_path, tfm_dir, font_info)
            self._generate_map_file(font_path, map_dir, font_info)
            self._generate_sty_file(sty_dir, font_info)
            
            # Copy the original font file to the output directory
            font_file_name = os.path.basename(font_path)
            shutil.copy2(font_path, os.path.join(type1_dir, font_file_name))
            
            return True
        except Exception as e:
            if self.verbose:
                print(f"Error processing font {font_path}: {str(e)}")
            return False
    
    def _extract_font_info(self, font_path: str) -> Optional[Dict]:
        """
        Extract information from an OTF font file.
        
        Args:
            font_path: Path to the OTF font file
            
        Returns:
            Dictionary containing font information, or None if extraction failed
        """
        if ttLib is None:
            # Fallback to basic information if fontTools is not available
            font_name = os.path.basename(font_path).replace('.otf', '')
            return {
                'family_name': font_name,
                'full_name': font_name,
                'postscript_name': font_name,
                'weight': 'Regular',
                'italic': False,
                'bold': False
            }
        
        try:
            font = ttLib.TTFont(font_path)
            
            # Extract name information
            name_table = font['name']
            family_name = None
            full_name = None
            postscript_name = None
            
            for record in name_table.names:
                if record.nameID == 1 and not family_name:  # Family name
                    family_name = record.toUnicode()
                elif record.nameID == 4 and not full_name:  # Full name
                    full_name = record.toUnicode()
                elif record.nameID == 6 and not postscript_name:  # PostScript name
                    postscript_name = record.toUnicode()
            
            # Determine weight and style
            weight = 'Regular'
            italic = False
            bold = False
            
            if 'OS/2' in font:
                os2 = font['OS/2']
                if hasattr(os2, 'usWeightClass'):
                    if os2.usWeightClass >= 700:
                        weight = 'Bold'
                        bold = True
                    elif os2.usWeightClass <= 300:
                        weight = 'Light'
                
                if hasattr(os2, 'fsSelection'):
                    italic = bool(os2.fsSelection & 1)
            
            if not family_name:
                family_name = os.path.basename(font_path).replace('.otf', '')
            
            if not full_name:
                full_name = family_name
            
            if not postscript_name:
                postscript_name = family_name.replace(' ', '')
            
            return {
                'family_name': family_name,
                'full_name': full_name,
                'postscript_name': postscript_name,
                'weight': weight,
                'italic': italic,
                'bold': bold
            }
        
        except Exception as e:
            if self.verbose:
                print(f"Error extracting font information: {str(e)}")
            return None
    
    def _generate_tfm_file(self, font_path: str, tfm_dir: str, font_info: Dict) -> bool:
        """
        Generate a TFM file for the font.
        
        Args:
            font_path: Path to the OTF font file
            tfm_dir: Directory where the TFM file will be saved
            font_info: Dictionary containing font information
            
        Returns:
            True if generation was successful, False otherwise
        """
        # In a real implementation, we would use tools like ttf2tfm or otftotfm
        # For now, we'll create a placeholder file
        font_name = font_info['postscript_name']
        tfm_path = os.path.join(tfm_dir, f"{font_name}.tfm")
        
        try:
            # This is a placeholder. In a real implementation, you would run:
            # subprocess.run(['otftotfm', font_path, '-o', tfm_path], check=True)
            
            with open(tfm_path, 'w') as f:
                f.write(f"# TFM file for {font_info['full_name']}\n")
                f.write("# This is a placeholder. In a real implementation, this would be a binary TFM file.\n")
            
            return True
        except Exception as e:
            if self.verbose:
                print(f"Error generating TFM file: {str(e)}")
            return False
    
    def _generate_map_file(self, font_path: str, map_dir: str, font_info: Dict) -> bool:
        """
        Generate a MAP file for the font.
        
        Args:
            font_path: Path to the OTF font file
            map_dir: Directory where the MAP file will be saved
            font_info: Dictionary containing font information
            
        Returns:
            True if generation was successful, False otherwise
        """
        font_name = font_info['postscript_name']
        map_path = os.path.join(map_dir, f"{font_name}.map")
        
        try:
            with open(map_path, 'w') as f:
                f.write(f"% MAP file for {font_info['full_name']}\n")
                f.write(f"{font_name} {font_name} <{font_name}.otf\n")
            
            return True
        except Exception as e:
            if self.verbose:
                print(f"Error generating MAP file: {str(e)}")
            return False
    
    def _generate_sty_file(self, sty_dir: str, font_info: Dict) -> bool:
        """
        Generate a LaTeX style file for the font.
        
        Args:
            sty_dir: Directory where the STY file will be saved
            font_info: Dictionary containing font information
            
        Returns:
            True if generation was successful, False otherwise
        """
        font_name = font_info['family_name'].replace(' ', '')
        package_name = font_name.lower()
        sty_path = os.path.join(sty_dir, f"{package_name}.sty")
        
        try:
            with open(sty_path, 'w') as f:
                f.write(f"% LaTeX package for {font_info['full_name']}\n")
                f.write("\\NeedsTeXFormat{LaTeX2e}\n")
                f.write(f"\\ProvidesPackage{{{package_name}}}[Font package for {font_info['full_name']}]\n\n")
                
                f.write("% Font declarations\n")
                f.write(f"\\DeclareRobustCommand{{\\{font_name}}}{{%\n")
                f.write(f"  \\fontfamily{{{package_name}}}\\selectfont\n")
                f.write("}\n\n")
                
                f.write("% Font family declaration\n")
                f.write(f"\\DeclareFontFamily{{T1}}{{{package_name}}}{{}}\n\n")
                
                # Declare font shapes
                shapes = [('n', 'Regular', 'normal')]
                if font_info.get('bold', False):
                    shapes.append(('b', 'Bold', 'bold'))
                if font_info.get('italic', False):
                    shapes.append(('it', 'Italic', 'italic'))
                if font_info.get('bold', False) and font_info.get('italic', False):
                    shapes.append(('bi', 'BoldItalic', 'bold italic'))
                
                for shape_code, shape_name, shape_desc in shapes:
                    f.write(f"% {shape_desc} shape\n")
                    f.write(f"\\DeclareFontShape{{T1}}{{{package_name}}}{{m}}{{{shape_code}}}{{%\n")
                    f.write(f"  <-> {package_name}{shape_name}%\n")
                    f.write("}{}\\n\n")
                
                f.write("% Text command\n")
                f.write(f"\\DeclareTextFontCommand{{\\text{font_name}}}{{\\{font_name}}}\n\n")
                
                f.write("% End of package\n")
                f.write("\\endinput\n")
            
            return True
        except Exception as e:
            if self.verbose:
                print(f"Error generating STY file: {str(e)}")
            return False