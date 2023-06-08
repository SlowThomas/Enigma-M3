# Enigma-M3

A mimic of the WWII Enigma Machine

<br><br><br>

## Usage

First, create a terminal/cmd window at the folder

<br>

Then, run the program simply by calling the Java Virtual Machine:<br>
Type the following to the terminal/cmd:<br>
`java Enigma`

<br>Afterward, the program will ask you the text to encrypt/decrypt.<br>
Type in your text to encryot/decrypt in a single line (upper case only!) and hit enter.

```
Enter text to encrypt/decrypt:
...Enter some text...
```

The program will then display the encrypted/decrypted text as a response.

<br><br>

Here is an example of the execution:

![Example.gif](https://i.imgur.com/XZSUYKh.gif)

---

<br><br><br>

## Configuration

In Setup.java, write down the configuration you want to make for the machine:

![Code - Setup.java](https://i.imgur.com/mFGpaeW.png)

`plugboard` - a space separated list of paired upper case letters, each indicating a wired connection on the plugboard between the two letters of the pair.

`rotor_set` - a space separated list of 4 Names, indicating the rotor/reflector setups. 
<br>From left to right indicate the name of: rotor 1, rotor 2, rotor 3, reflector.

Available names for the rotors:
- `I`
- `II`
- `III`
- `IV`
- `V`

Available names for the reflector:
- `UKW-A`
- `UKW-B`
- `UKW-C`

`rotor_pos` - a space separated list of 3 upper case letters, indicating the initial position of the rotors
<br>From left to right indicate the initial position of: rotor 1, rotor 2, rotor 3.

Finally, after you saved the new setup file, open your terminal/cmd and compile the new setup:<br>
```javac Setup.java```

---

<br><br><br>

## About

What is a Enigma machine?

> The Enigma machine is a cipher device developed and used in the early- to mid-20th century to protect commercial, diplomatic, and military communication. It was employed extensively by Nazi Germany during World War II, in all branches of the German military.

Here is an image of the real world Enigma M3 machine used by Nazis Germany in WWII

![Enigma machine](https://doyle.com/sites/default/files/styles/auction_slider/public/images/stories/2017-10/ENIGMA.JPG?itok=npkBZOQ8)
