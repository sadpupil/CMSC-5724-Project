# Project Report

After the linear classifier $$ \vec{w}$$ is acquired, our program carries out the method to calculate the margin of the classifier. 

By using the equation: $$ D_{p} = \frac{|\vec{p} \cdot \vec{w}|}{|\vec{w}|} $$ , the method calculates the distance of each of the points to the separation plane, and takes the minimum among all.

### DataSet 1: 

With dataset 1 as input, the result of my program is shown as below:

![1](D:\CUHK MSc Computer Science\Term1\CMSC 5724\project report\img\1.png)

The margin of classifier $$\vec{w}$$ is $$2.630504567982789$$. 

From the screen shot above, we can also see that the final round of margin Perceptron received an input of $$ \gamma_{guess} = 4.0$$, which is less than twice the margin of the classifier, indicating that our result is in accordance with the theorem taught in lecture 5<sup><a href="#ref1">[1]</a></sup>.

### DataSet 2

With dataset 2 as input, the result of my program is shown as below:

![2](D:\CUHK MSc Computer Science\Term1\CMSC 5724\project report\img\2.png)

The margin of classifier $$\vec{w}$$ is $$6.007701533717606$$. 

From the screen shot above, we can also see that the final round of margin Perceptron received an input of $$ \gamma_{guess} = 12.0$$, which is less than twice the margin of the classifier, indicating that our result is in accordance with the theorem taught in lecture 5.

### DataSet 3

With dataset 3 as input, the result of my program is shown as below:

![3](D:\CUHK MSc Computer Science\Term1\CMSC 5724\project report\img\3.png)

The margin of classifier $$\vec{w}$$ is $$3.031740039940767$$.

From the screen shot above, we can also see that the final round of margin Perceptron received an input of $$ \gamma_{guess} = 6.0$$, which is less than twice the margin of the classifier, indicating that our result is in accordance with the theorem taught in lecture 5.



### Reference:

<span name = "ref1">[1] Theorem: if $\gamma_{guess} \le \gamma_{opt}$, margin Perceptron terminates in at most $\frac{12R^2}{\gamma_{opt}^2}$ iterations and returns a separation plane with margin at least $\frac{\gamma_{guess}}{2}$.</span>
