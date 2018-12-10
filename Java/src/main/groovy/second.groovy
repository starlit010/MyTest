package groovy

import com.sun.corba.se.spi.orbutil.closure.Closure
<<<<<<< HEAD

=======
>>>>>>> 6a15cda51e1578d0a6e84bb05fa0d74cc61286e9

class Child{
	
	def name = 2

}

class Parent {

    Child child = new Child()

    void setChildName(Closure c) {
        c.delegate = child
        c.setResolveStrategy Closure.DELEGATE_FIRST
        c()
    }

}


def parent = new Parent()
parent.setChildName {
    name = "child name"
}


println parent.child.name


