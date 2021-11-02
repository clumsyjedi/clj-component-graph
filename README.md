# clj-component-graph

Generate graphviz dependency diagrams from com.stuartsierra.component system objects.

This library is very simple, but has proved enormously useful to me the short term, so may be useful to others. It will generate an image file on disk, based on an input object that satisfies? com.stuartsierra.component/Lifecycle

## Installation

[org.clojars.clumsyjedi/clj-component-graph "0.1.3"]

## Usage

```
(require 'component-graph.core)
(component-graph.core/graph reloaded.repl/system
                            "graph.png"
                            {:blacklist [:nrepl]})
```

Dig around in the source for some other supported options that can be passed.

## License

Copyright © 2021

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
