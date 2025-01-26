# Paint Application

A feature-rich Paint application built using JavaFX. This tool allows users to create, move, resize, and rotate shapes, draw freehand with various tools like pencil, highlighter, and spray, and save or load files for later use.

---

## Features

### Drawing Tools
- **Pencil**: Freehand drawing with precision.
- **Highlighter**: Transparent strokes for a highlighting effect.
- **Spray**: Spray paint effect for creative designs.

### Shape Manipulation
- **Create Shapes**: Draw basic shapes like rectangles, circles, and triangles.
- **Move Shapes**: Drag and reposition shapes on the canvas.
- **Resize Shapes**: Scroll while a shape is active to resize it.
- **Rotate Shapes**: Hold down your right mouse button and drag mouse across the screen to rotate the shape.
- **Recolor shapes**: Hold down left ctrl and click on active shape with right mouse button to recolor.

### File Operations
- **Save Files**: Save your drawings to a file for future editing.
- **Load Files**: Open previously saved files to continue your work.

---

## Prerequisites

Before running the application, ensure you have the following installed:

- **Java Development Kit (JDK)** (version 21 or higher)
- **JavaFX SDK**

---

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone <repository_url>
   cd paint-application
   ```

2. **Download JavaFX SDK**:
   - Visit the [JavaFX official website](https://openjfx.io) and download the appropriate SDK for your system.
   - Extract the SDK to a directory on your system.

3. **Set JavaFX Path**:
   - Add the JavaFX SDK to your project's `--module-path`.

4. **Run the Application**:
   - Use your IDE (e.g., IntelliJ IDEA, Eclipse) to set up the project.
   - Configure the VM options for JavaFX (example for IntelliJ):
     ```
     --module-path "<path_to_javafx_sdk>" --add-modules javafx.controls,javafx.fxml
     ```
   - Build and run the project.

---

## Usage

1. Launch the application.
2. Select a drawing tool (Pencil, Highlighter, Spray) from the toolbar.
3. Use the shape tools to create rectangles, circles, or other shapes.
4. Manipulate shapes by selecting them and using the move, resize, or rotate options.
5. Save your artwork using the save option or load an existing file to edit.

---

## Future Enhancements

- Add support for additional shape types.
- fix undo/redo functionality.
- Add color palettes and gradient fills for shapes.
- Enhance the spray tool (currently can't save or read it from file)
- Include support for exporting drawings to image formats (e.g., PNG, JPEG).

---

## Contributing

Contributions are welcome! If you'd like to contribute, please:

1. Fork the repository.
2. Create a new branch for your feature (`git checkout -b feature-name`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Create a Pull Request.

---
