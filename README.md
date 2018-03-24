# Calculator

A simple calculator application with a GUI and basic arithmetic capabilities. The application takes into account the order of operations. 

As numbers and operators are entered in the interface, each term in the expression is stored sequentially in an array. This array is essentially the expression, and each element of the array is assigned either a term of the expression or an operator symbol. The terms of the expression are added to the array until the equals button is pressed.

Once the equals button is pressed, two loops are set in motion. In order to account for order of operations, the first loop iterates through the expression and finds instances of multiplication or division. When it finds one of those operators, it either multiplies or divides the terms on either side of it. These two terms get "simplified" into one term (the result), which is stored in the index of the left term. The remainder of the array to the right is then moved to the left, effectively eraing the two terms and leaving behind only the result. Once all multiplication and division is simplified, this leaves the array containing only addition and subtraction. The second loop then iterates over the simplified array and evaluates the operations sequentially, storing the results in an accumulator- "result". The result is then printed. Since the expression is fully evaluated, every element of the expression array is reset to null to prepare it for the next use.

There is a negative sign (-) button on the interface that allows the user to change a number to negative. This must be entered at the beginning of the number or else it will result in an error.

There is a sqrt(x) button. This, along with the subsequent number, should be entered as if they were a single term or else an error will result.

On the left side of the GUI are the trig. buttons. sin, cos, and tan all evaluate doubles in degree form.

There are two different clear buttons: a CE and a C. CE is a clear all button which wipes clean the expression array and clears the calculator's console. C only clears the previously entered term of the expression, be it an operator or a number.

