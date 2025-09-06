package org.jdbc_1;

class forName {
    public static void main(String[] args) throws Exception {
        // ----------------------------------------------------------
        // Creating an object of Pqr:
        // -> Loads Pqr class (runs static block once).
        // -> Creates an instance (runs instance block).
        // ----------------------------------------------------------
        Pqr obj = new Pqr();

        // ----------------------------------------------------------
        // Only load a class (no object created):
        // -> Class.forName("FQN") loads the class into JVM.
        // -> Triggers the static block (if any).
        // -> Does NOT run instance blocks since no object created.
        // ----------------------------------------------------------
        Class.forName("org.jdbc_1.Xyz");

        // ----------------------------------------------------------
        // Load class + create object (modern way):
        // -> Class.forName("FQN"): loads the class (static block runs).
        // -> getDeclaredConstructor(): fetches the no-arg constructor explicitly.
        // -> newInstance(): invokes that constructor.
        // -> This triggers instance block + constructor body,
        //    and returns a new object.
        //
        // Why better than deprecated Class.newInstance()?
        // -> Explicitly states which constructor is used.
        // -> Handles exceptions more safely (InvocationTargetException).
        // ----------------------------------------------------------
        Class.forName("org.jdbc_1.Abc").getDeclaredConstructor().newInstance();
    }
}


class Pqr {
    // 👉 This block is executed only once when the class is loaded.
    static {
        System.out.println("in static block of Pqr");
    }

    // 👉 This block is executed every time an object is created.
    {
        System.out.println("in instance block of Pqr");
    }
}

class Xyz {
    // 👉 Only has a static block.
    // Will run when the class is loaded (Class.forName).
    static {
        System.out.println("in static block of Xyz");
    }
}

class Abc {
    // 👉 Only has an instance block.
    // Will run only when an object is created (via newInstance).
    {
        System.out.println("in instance block of Abc");
    }
}
