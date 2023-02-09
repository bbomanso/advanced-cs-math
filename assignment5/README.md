# Assignment 5
Using JavaFX tools, write a program that plots the graphs of the following parametic equations:
1. Daisy: 𝑥 = 𝑟cos(6𝑡) cos(𝑡) , 𝑦 = 𝑟 cos(6𝑡) sin⁡(𝑡)
2. Clover: 𝑥 = 𝑟 cos(2𝑡) cos(𝑡) , 𝑦 = 𝑟 cos(2𝑡) sin⁡(𝑡)
3. Cardioid: 𝑥 = 𝑟(1 − sin(𝑡)) cos(𝑡) , 𝑦 = 𝑟(1 − sin(𝑡))sin⁡(𝑡)
4. Lissajous: 𝑥 = 4𝑟sin⁡(3𝑡 + 1), 𝑦 = 3𝑟sin⁡(𝑡)
5. Tricuspoid: 𝑥 = 𝑟(2 cos(𝑡) + cos(2𝑡)), 𝑦 = 𝑟(2 sin(𝑡) − sin⁡(2𝑡))

The GUI shoule have a ComboBox. When the user selects the name of a curve from
the ComboBox, the program should display the corresponding curve. Each curve should be drawn for 0 ≤ 𝑡 ≤ 2𝜋. Make sure that each curve is custom scaled so that the full curve fits in the window. Use the same scale factor for both x and y to preserve the shape of the curve.

## Program Requirements
- The program should contain a method (drawCurve) that draws the graph of any parametric curve.
- **Input parameters**: GraphicsContext object; two DoubleUnaryOperator types (for the functions for x and y); two doubles for beginning and end values of the parameter t; a double for the scale factor (using same for both x and y directions); and an integer for the number of straight line pieces stroked to produce the curve.