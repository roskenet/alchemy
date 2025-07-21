#!/usr/bin/env python3
"""
Module for handling secrets with PGP encryption.
"""

import os
import subprocess
import tempfile
import logging

class SecretHandler:
    """
    Class for handling secrets with PGP encryption.
    
    This class reads encrypted files from a directory, decrypts them using
    a PGP key, and writes the decrypted content to a YAML file.
    """
    
    def __init__(self, secret_dir, pgp_key, key_password):
        """
        Initialize the SecretHandler.
        
        Args:
            secret_dir (str): Directory containing encrypted secret files.
            pgp_key (str): Path to the PGP key file.
            key_password (str): Password for the PGP key.
        """
        self.secret_dir = secret_dir
        self.pgp_key = pgp_key
        self.key_password = key_password
        
        # Set up logging
        self.logger = logging.getLogger(__name__)
    
    def import_key(self):
        """
        Import the PGP key using the gpg command line tool.
        
        Returns:
            bool: True if the key was imported successfully, False otherwise.
        """
        try:
            # Run gpg command to import the key
            result = subprocess.run(
                ["gpg", "--batch", "--import", self.pgp_key],
                capture_output=True,
                text=True,
                check=False
            )
            
            if result.returncode != 0:
                self.logger.error(f"Failed to import PGP key: {result.stderr}")
                return False
            
            self.logger.info("Successfully imported PGP key")
            return True
        except Exception as e:
            self.logger.error(f"Error importing PGP key: {str(e)}")
            return False
    
    def decrypt_file(self, file_path):
        """
        Decrypt a file using the PGP key with the gpg command line tool.
        
        Args:
            file_path (str): Path to the encrypted file.
            
        Returns:
            str: Decrypted content of the file, or None if decryption failed.
        """
        try:
            # Create a temporary file for the password
            with tempfile.NamedTemporaryFile(mode='w+', delete=False) as password_file:
                password_file.write(self.key_password)
                password_file_path = password_file.name
            
            # Create a temporary file for the output
            with tempfile.NamedTemporaryFile(delete=False) as output_file:
                output_file_path = output_file.name
            
            try:
                # Run gpg command to decrypt the file
                result = subprocess.run(
                    [
                        "gpg",
                        "--batch",
                        "--yes",
                        "--passphrase-file", password_file_path,
                        "--output", output_file_path,
                        "--decrypt", file_path
                    ],
                    capture_output=True,
                    text=True,
                    check=False
                )
                
                # Remove the password file immediately after use
                os.unlink(password_file_path)
                
                if result.returncode != 0:
                    self.logger.error(f"Failed to decrypt file {file_path}: {result.stderr}")
                    os.unlink(output_file_path)
                    return None
                
                # Read the decrypted content
                with open(output_file_path, 'r') as f:
                    decrypted_content = f.read()
                
                # Remove the output file
                os.unlink(output_file_path)
                
                return decrypted_content
            
            finally:
                # Ensure temporary files are removed even if an exception occurs
                if os.path.exists(password_file_path):
                    os.unlink(password_file_path)
                if os.path.exists(output_file_path):
                    os.unlink(output_file_path)
                
        except Exception as e:
            self.logger.error(f"Error decrypting file {file_path}: {str(e)}")
            return None
    
    def process_secrets(self):
        """
        Process all secret files in the secret directory.
        
        This method reads all files in the secret directory, decrypts them,
        and writes the decrypted content to secret.yaml.
        
        Returns:
            bool: True if all secrets were processed successfully, False otherwise.
        """
        if not os.path.isdir(self.secret_dir):
            self.logger.error(f"Secret directory {self.secret_dir} does not exist")
            return False
        
        if not self.import_key():
            return False
        
        # Dictionary to store decrypted secrets
        secrets = {}
        
        # Process each file in the secret directory
        for filename in os.listdir(self.secret_dir):
            file_path = os.path.join(self.secret_dir, filename)
            
            # Skip directories
            if os.path.isdir(file_path):
                continue
            
            # Derive key name from filename (remove extension)
            key_name = os.path.splitext(filename)[0]
            
            # Decrypt the file
            decrypted_content = self.decrypt_file(file_path)
            if decrypted_content is not None:
                secrets[key_name] = decrypted_content
        
        # Write secrets to secret.yaml
        return self.write_secrets_to_yaml(secrets)
    
    def write_secrets_to_yaml(self, secrets):
        """
        Append secrets to secret.yaml.
        
        Args:
            secrets (dict): Dictionary of secrets, where keys are derived from filenames
                           and values are decrypted content.
                           
        Returns:
            bool: True if secrets were written successfully, False otherwise.
        """
        try:
            # Open file in append mode to add content at the end of the file
            with open("secret.yaml", "a") as f:
                for key, value in secrets.items():
                    f.write(f"  {key}: {value}\n")
            
            self.logger.info("Successfully appended secrets to secret.yaml")
            return True
        except Exception as e:
            self.logger.error(f"Error writing secrets to secret.yaml: {str(e)}")
            return False