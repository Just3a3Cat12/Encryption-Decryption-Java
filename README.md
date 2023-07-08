# Encryption Decryption

This project provides encryption and decryption functionality using two algorithms: **Shift** and **Unicode**. It is implemented in Java 17.

## Algorithms

1. Shift Algorithm:
   - This algorithm shifts the letters of the given data using a specified key.
   - It cycles only within the alphabets.

2. Unicode Algorithm:
   - This algorithm shifts the Unicode values of the given data using a specified key.

## Usage

To use this Java program, you need to pass the following arguments:

```
java Main -mode <mode> -key <key> [-data <data> | -in <input_file>] -alg <algorithm> [-out <output_file>]
```

Arguments:
- `-mode`: Specifies the mode of operation.
  - `enc`: Used for encryption.
  - `dec`: Used for decryption.

- `-key`: An integer key used to encrypt or decrypt the data.

- `-data`: (Optional) Use this option if you want to directly pass the data as a string. Do not use this if you're using the `-in` option.

- `-in`: (Optional) If you want to provide the data as a text file, use this argument followed by the file path. Do not use this if you're using the `-data` option.

- `-alg`: Specifies the algorithm to use.
  - `shift`: Choose the shift algorithm.
  - `unicode`: Choose the Unicode algorithm.

Optional arguments:
- `-out`: If you want to save the encrypted or decrypted data to a text file, use this argument followed by the file path.

## Examples

Here are some example commands to demonstrate how to use the program:

1. Encrypt using the shift algorithm with data as a string:
   ```
   java Main -mode enc -key 32 -data "Welcome to EncyptionDecryption Project!" -alg shift
   ```

2. Decrypt using the shift algorithm with data as a string:
   ```
   java Main -mode dec -key 32 -data "Ckriusk zu KtievzoutJkixevzout Vxupkiz!" -alg shift
   ```

3. Encrypt using the Unicode algorithm with data as a string:
   ```
   java Main -mode enc -key 45 -data "Welcome to hyperskill!" -alg unicode
   ```

4. Encrypt using the shift algorithm with data from a file:
   ```
   java Main -mode enc -key 32 -in "C:/work/secure.txt" -alg shift
   ```

5. Encrypt using the shift algorithm with data from a file and save encrypted data to file:
   ```
   java Main -mode enc -key 32 -in "C:/work/secure.txt" -out "C:/work/secured.txt" -alg shift
   ```

Feel free to explore and use this program for encryption and decryption tasks.

## Developer
This project was developed by PANKAJ AMBEKAR.

- Email: ambekarpankaj@outlook.com

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

## Contact
If you have any questions or suggestions regarding this project, feel free to contact the maintainer at ambekarpankaj@outlook.com.
