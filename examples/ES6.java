/* -*- Mode: java; tab-width: 8; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

/**
 * Example of controlling the JavaScript execution engine.
 *
 * We evaluate a script and then manipulate the result.
 *
 */
public class ES6 {

    /**
     * Main entry point.
     *
     * Process arguments as would a normal Java program. Also
     * create a new Context and associate it with the current thread.
     * Then set up the execution environment and begin to
     * execute scripts.
     */
    public static void main(String[] args)
    {
        Context cx = Context.enter();
        try {
            // Set version to JavaScript1.2 so that we get object-literal style
            // printing instead of "[object Object]"
//            cx.setLanguageVersion(Context.VERSION_1_2);
            cx.setLanguageVersion(Context.VERSION_ES6);

            // Initialize the standard objects (Object, Function, etc.)
            // This must be done before scripts can be executed.
            Scriptable scope = cx.initStandardObjects();

            // Now we can evaluate a script. Let's create a new object
            // using the object literal notation.
            String templateES6="let p1=2222222;let b=`There are <b>${p1}</b> !`;function f(){return b;};f();";

            //let p1=2222222;let b=`There are <b>${p1}</b> !`;function f(){return b;};f();

            Object result = cx.evaluateString(scope, templateES6,
                                              "MySource", 1, null);
            System.out.println("=========="+result);

        } finally {
            Context.exit();
        }
    }

}

