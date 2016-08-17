# Caesar-Cipher
Java implementation of the [Caesar cipher](https://en.wikipedia.org/wiki/Caesar_cipher).

The idea behind the Caesar Cipher is to replace each character in any given input by a fixed number of positions from their location within the alphabet. For instance, if we were to encrypt the plain text "abc" by an offset of 3, the resulting cipher text would be "def".

![Caesar Cipher](https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Caesar_cipher_left_shift_of_3.svg/320px-Caesar_cipher_left_shift_of_3.svg.png)

Here's an example from the wikipedia article. Note that the cipher being used here is a left rotation of 3 places (or right rotation of 23 places):
```
Plain:    ABCDEFGHIJKLMNOPQRSTUVWXYZ
Cipher:   XYZABCDEFGHIJKLMNOPQRSTUVW

Plaintext:  THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG
Ciphertext: QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD
```

## Usage

```
Usage: -e (encrypt) | -d (decrypt) [INPUT FILE] [OUTPUT FILE] [OFFSET]

Example: -e important.txt secret.txt 5
```
