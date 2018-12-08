package groovy

import com.sun.corba.se.spi.orbutil.closure.Closure


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


