<<<<<<< HEAD:src/main/groovy/second.groovy
class Child {

    def name = 2
=======
package main.groovy

class Child{
	
	def name = 2
>>>>>>> f621b29f30389358b7c0628c31e0950a5078b0e7:Java/src/main/groovy/second.groovy

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


