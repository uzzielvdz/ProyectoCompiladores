# Java Compiler

## Description

This project is a simple compiler developed in Java. Its purpose is to analyze and compile source code written in a C#-like programming language. The compiler uses tools like JFlex for the lexer and a Swing-based graphical user interface (GUI) for user interaction.

The compiler features lexical, syntactical, and semantic analysis and is designed to help users understand how different stages of a compiler work in a simple and educational context.

## Features

- **Lexical Analysis**: Uses JFlex to generate the lexer that turns the source code into tokens.
- **Graphical User Interface**: Built with Swing, allowing users to interact with the compiler through a GUI.
- **Syntax Highlighting**: Uses the lexical analysis to display the source code with color highlighting for keywords, operators, comments, etc.
- **Error Detection**: Displays lexical and syntactical errors in the GUI.
- **C# Compatibility**: The compiler is tailored to handle a subset of C# syntax.

## Requirements

- **Java 8 or higher**: The project is developed in Java and requires JDK version 8 or above.
- **JFlex**: Used for generating the lexer.
- **Swing**: For the GUI.
- **Additional Libraries**:
  - `compilerTools`: Contains the necessary classes to handle tokens, errors, grammars, etc.

## Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/your_user/compiler-java.git
    ```

2. **Build the project**:

    Make sure you have the JDK installed on your machine, then compile the project using your preferred IDE (e.g., IntelliJ IDEA or Eclipse) or via the command line:

    ```bash
    javac -d bin src/*.java
    ```

3. **Run the compiler**:

    Navigate to the `bin` folder (or wherever you compiled the files) and run the main class `Compiler`:

    ```bash
    java Compiler
    ```

## Usage

1. Upon running the compiler, a GUI will open where you can load a source file in text format.
2. You can write or paste the source code into the text area.
3. Clicking the "Compile" button will trigger the lexical analysis and display the results, including any errors found, in the output window.


## Contributing

If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Make your changes and commit them.
4. Open a pull request explaining the changes.

## License

This project is taked under the recomendation by ROADMAP.ai . For more details, see the [roadmap.ai website](https://roadmap.sh/projects/github-user-activity)

## Author

Developed by [Uzziel Valdéz](https://github.com/your_user).


